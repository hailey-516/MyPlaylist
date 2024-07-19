package com.kh.mini.playlist.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.kh.mini.chat.ChatClient;
import com.kh.mini.chat.ChatServer;
import com.kh.mini.playlist.controller.PlayController;
import com.kh.mini.playlist.model.vo.Music;

public class PlayMenu {
	private Scanner sc = new Scanner(System.in);
	private PlayController pc = new PlayController();
	private boolean isServerRunning = false;	// 채팅 서버 실행 여부를 나타내는 플래그
    private int serverPort = 3000;	// 기본 포트 번호 설정
	
	public void mainMenu() {
		System.out.print("이름을 입력해 주세요 : ");
		String name = sc.nextLine();
		
		System.out.println(" ===== " + name + "'s Playlist ♪ ===== ");
		System.out.println();
		
		while(true) {
			System.out.println("===== 메인 메뉴 =====");
			System.out.println("1. 새 음악 추가");
			System.out.println("2. 플레이리스트 전체 조회");
			System.out.println("3. 음악 검색 조회");
			System.out.println("4. 음악 삭제");
			System.out.println("5. 제목 오름차순 정렬");
			System.out.println("6. 음악 재생");
			System.out.println("7. 나의 플레이리스트를 파일로 저장");
			System.out.println("8. 나의 플레이리스트 파일에서 불러오기");
			System.out.println("9. 채팅 서버 시작/종료");
			System.out.println("10. 채팅 참여하기");
			System.out.println("0. 종료");
			System.out.print("메뉴 번호 : ");
			
			int menu = sc.nextInt();
			sc.nextLine();
			
			switch(menu) {
			case 1:
				InsertMusic(); break;
			case 2:
				selectList(); break;
			case 3:
				searchMusic(); break;
			case 4:
				deleteMusic(); break;
			case 5:
				ascMusic(); break;
			case 6:
				playMusic(); break;
			case 7:
				fileSave(); break;
			case 8:
				fileOpen(); break;
			case 9:
                toggleChatServer(); break;
            case 10:
                startChat(); break;
			case 0:
				System.out.println("프로그램을 종료합니다.");
				return;
			default:
				System.out.println("잘못 입력했습니다. 다시 입력해 주세요.");
			}
		}
	}
	/**
	 * 새 음악 추가용 메소드
	*/
	public void InsertMusic() {
		
		System.out.println("♬ 새 음악 추가 ♬");
		System.out.println("음악 정보를 입력해 주세요.");
		System.out.print("제목 : ");
		String title = sc.nextLine();
		System.out.print("아티스트명 : ");
		String artist = sc.nextLine();
		System.out.print("장르 : ");
		String genre = sc.nextLine();
		
		Music m = new Music(title, artist, genre);
		pc.insertMusic(m);
		
	}
	/**
	 * 전체 플레이리스트 조회용 메소드
	 */
	public void selectList() {
		ArrayList<Music> playlist = new ArrayList<>(pc.selectList());
		
		if(playlist.isEmpty()) {
			System.out.println("조회할 음악이 없습니다. 음악을 추가해 주세요.");
		} else {
			System.out.println("。..。:+* playlist *+:。.. 。");
			for(int i=0; i<playlist.size(); i++) {
				System.out.println(playlist.get(i));
			}
			System.out.println("───✱*.｡:｡✱*.:｡✧*.｡✰*.:｡✧*.｡:｡*.｡✱ ───");
		}
		
	}
	
	/**
	 * 음악 검색용 메소드
	 */
	public void searchMusic() {
		System.out.print("검색할 키워드를 입력하세요 : ");
		String keyword = sc.nextLine();
		
		ArrayList<Music> searchList = pc.searchMusic(keyword);
		if(searchList.isEmpty()) {
			System.out.println("음악 검색 결과가 없습니다.");
		} else {
			for(int i=0; i<searchList.size(); i++) {
				System.out.println(searchList.get(i));
			}
		}
	}
	
	/**
	 * 음악 삭제용 메소드
	 */
	public void deleteMusic() {
		System.out.print("삭제할 음악의 제목 : ");
		String title = sc.nextLine();
		
		System.out.print("삭제할 음악의 아티스트명 : ");
		String artist = sc.nextLine();
		
		Music remove = pc.deleteMusic(title, artist);
		if (remove != null) {
			System.out.println("음악이 삭제되었습니다.");
		} else {
			System.out.println("삭제할 음악을 찾지 못했습니다.");
		}
	}
	/**
	 * 음악 제목으로 오름차순 정렬 메소드
	 */
	public void ascMusic() {
		int result = pc.ascMusic();
		if (result == 1) {
			System.out.println("성공적으로 정렬되었습니다.");
		} else {
			System.out.println("정렬에 실패하였습니다.");
		}
	}
	
	public void playMusic() {
		System.out.print("재생할 음악의 제목을 입력하세요 : ");
		String keyword = sc.nextLine();
		pc.playMusic(keyword);
	}
	
	public void fileSave() {
		System.out.print("저장할 파일명을 입력하세요 : ");
		String filePath = sc.nextLine();
		pc.fileSave(filePath);
	}
	
	public void fileOpen() {
		System.out.print("불러올 파일명을 입력하세요 : ");
		String filePath = sc.nextLine();
		pc.fileOpen(filePath);
	}
	
	public void toggleChatServer() {
		if (isServerRunning) {
			ChatServer.stopServer(); // 서버가 실행 중이면 서버 종료
		} else {
			System.out.println("채팅 서버 포트를 입력하세요 : ");
			serverPort = sc.nextInt();
			sc.nextLine();
			ChatServer.startServer(serverPort);	// 서버 시작
		}
		isServerRunning = !isServerRunning;	// 서버 실행 상태 토글
    }

    public void startChat() {
        System.out.print("채팅 서버 IP를 입력하세요: ");
        String ip = sc.nextLine();
        System.out.print("채팅 서버 포트를 입력하세요: ");
        int port = sc.nextInt();
        sc.nextLine();
        ChatClient.startChat(ip, port);	// 채팅 클라이언트 시작
    }
	
}
