package com.kh.mini.chat;

import java.io.*;
import java.net.*;
import java.util.*;

public class ChatClient {

    // 채팅 시작 메소드
    public static void startChat(String ip, int port) {
        try (Socket socket = new Socket(ip, port); // 서버에 연결할 소켓 생성
             PrintWriter pw = new PrintWriter(socket.getOutputStream(), true); // 서버로 출력할 PrintWriter 생성
             BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()))) { // 서버로부터 입력을 받을 BufferedReader 생성

            System.out.println("채팅 서버에 연결되었습니다.");

            // 서버로부터 메시지를 읽는 스레드 시작
            new Thread(new ReadThread(br)).start();

            Scanner scanner = new Scanner(System.in);
            String message;

            // 서버로부터 닉네임 요청 메시지 수신 및 닉네임 전송
            System.out.print("닉네임을 입력하세요: ");
            String nickname = scanner.nextLine();
            pw.println(nickname);

            while (true) {
                message = scanner.nextLine(); // 사용자로부터 메시지 입력 받기
                pw.println(message); // 서버로 메시지 전송
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 서버로부터 메시지를 읽는 스레드 클래스
    static class ReadThread implements Runnable {
        private BufferedReader in;

        public ReadThread(BufferedReader in) {
            this.in = in;
        }

        @Override
        public void run() {
            try {
                String message;
                while ((message = in.readLine()) != null) { // 서버로부터 메시지 읽기
                    System.out.println(message); // 메시지 출력
                }
            } catch (NoRouteToHostException e) { // 네트워크 경로를 찾지 못했을 때 예외 처리
                System.out.println("연결할 수 없습니다: 네트워크 경로를 찾지 못했습니다. IP와 포트를 확인하세요.");
            } catch (UnknownHostException e) { // 호스트를 찾지 못했을 때 예외 처리
                System.out.println("연결할 수 없습니다: 호스트를 찾지 못했습니다. IP를 확인하세요.");
            } catch (ConnectException e) { // 연결 실패 예외 처리
                System.out.println("연결할 수 없습니다: 서버에 연결할 수 없습니다. 서버가 실행 중인지 확인하세요.");
            } catch (IOException e) { // 기타 입출력 예외 처리
                e.printStackTrace();
            }
        }
    }
}
