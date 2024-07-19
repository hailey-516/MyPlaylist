package com.kh.mini.chat;

import java.io.*;
import java.net.*;
import java.util.*;

public class ChatServer {
    private static List<ClientHandler> clients = new ArrayList<>(); // 연결된 클라이언트들을 저장할 리스트
    private static ServerSocket serverSocket; // 서버 소켓
    private static boolean running = false; // 서버 실행 여부를 나타내는 플래그

    // 서버 시작 메소드
    public static void startServer(int port) {
        running = true; // 서버 실행 상태로 설정
        new Thread(() -> { // 서버 실행을 위한 새로운 스레드 생성
            try {
                serverSocket = new ServerSocket(port); // 주어진 포트로 서버 소켓 생성
                System.out.println("채팅 서버가 시작되었습니다. 클라이언트의 연결을 기다립니다...");

                // 클라이언트 연결을 기다리는 루프
                while (running) {
                    Socket socket = serverSocket.accept(); // 클라이언트 연결 수락
                    System.out.println("클라이언트가 연결되었습니다: " + socket.getInetAddress().getHostAddress());

                    ClientHandler clientHandler = new ClientHandler(socket); // 새로운 클라이언트 핸들러 생성
                    clients.add(clientHandler); // 클라이언트 핸들러를 리스트에 추가
                    new Thread(clientHandler).start(); // 클라이언트 핸들러 실행을 위한 스레드 시작
                }
            } catch (IOException e) {
                if (running) { // 서버가 실행 중일 때만 예외 처리
                    e.printStackTrace();
                }
            }
        }).start();
    }

    // 서버 종료 메소드
    public static void stopServer() {
        running = false; // 서버 실행 상태를 false로 설정
        try {
            if (serverSocket != null && !serverSocket.isClosed()) {
                serverSocket.close(); // 서버 소켓 닫기
            }
            System.out.println("채팅 서버가 종료되었습니다.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 메시지를 모든 클라이언트에게 브로드캐스트하는 메소드
    public static void broadcast(String message, ClientHandler excludeClient) {
        for (ClientHandler client : clients) {
            if (client != excludeClient) { // 발신자를 제외한 모든 클라이언트에게 메시지 전송
                client.sendMessage(message);
            }
        }
    }

    // 클라이언트를 리스트에서 제거하는 메소드
    public static void removeClient(ClientHandler clientHandler) {
        clients.remove(clientHandler);
    }
}

class ClientHandler implements Runnable {
    private Socket socket;
    private BufferedReader br;
    private PrintWriter pr;
    private String nickname;

    public ClientHandler(Socket socket) {
        this.socket = socket;

        try {
            br = new BufferedReader(new InputStreamReader(socket.getInputStream())); // 클라이언트로부터 입력을 받기 위한 BufferedReader 생성
            pr = new PrintWriter(socket.getOutputStream(), true); // 클라이언트로 출력하기 위한 PrintWriter 생성
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(String message) {
        pr.println(message); // 클라이언트에게 메시지 전송
    }

    @Override
    public void run() {
        try {
            pr.println("닉네임을 입력하세요:"); // 클라이언트에게 닉네임 요청
            nickname = br.readLine(); // 클라이언트로부터 닉네임 입력 받기
            System.out.println("닉네임 설정됨: " + nickname);
            ChatServer.broadcast(nickname + "님이 채팅에 참여하였습니다.", this); // 모든 클라이언트에게 참여 알림

            String message;
            while ((message = br.readLine()) != null) { // 클라이언트로부터 메시지 읽기
                System.out.println(nickname + ": " + message);
                ChatServer.broadcast(nickname + ": " + message, this); // 모든 클라이언트에게 메시지 브로드캐스트
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close(); // 소켓 닫기
            } catch (IOException e) {
                e.printStackTrace();
            }
            ChatServer.removeClient(this); // 클라이언트 리스트에서 제거
            System.out.println("클라이언트 연결이 종료되었습니다: " + nickname);
            ChatServer.broadcast(nickname + "님이 채팅을 종료하였습니다.", this); // 모든 클라이언트에게 종료 알림
        }
    }
}
