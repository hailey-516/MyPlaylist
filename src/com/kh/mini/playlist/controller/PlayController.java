package com.kh.mini.playlist.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;

import com.kh.mini.playlist.manager.RandomTrackManager;
import com.kh.mini.playlist.model.vo.Music;

public class PlayController {
	
	private ArrayList<Music> playlist = new ArrayList();
	private RandomTrackManager randomTrackManager = new RandomTrackManager(); // 랜덤 트랙 매니저 인스턴스
	
	public PlayController() {}
	
	public void insertMusic(Music m) {
		playlist.add(m);
	}
	
	public ArrayList<Music> selectList() {
		return playlist;
	}
	
	public ArrayList<Music> searchMusic(String keyword) {
		ArrayList<Music> searchList = new ArrayList<>();
		
		for(int i=0; i<playlist.size(); i++) {
			Music m = playlist.get(i);
			String title = m.getTitle();
			String artist = m.getArtist();
			String genre = m.getGenre();
			if(title.contains(keyword) || artist.contains(keyword) || genre.contains(keyword)) {
				searchList.add(m);
			}
		}
		return searchList;
}
	
	public Music deleteMusic(String title, String artist) {
		Music remove = null;
		for(int i=0; i<playlist.size(); i++) {
			if(playlist.get(i).getTitle().equals(title) &&
					playlist.get(i).getArtist().equals(artist)) {
				remove = playlist.remove(i);
				break;
			}
		}
		return remove;
	}
	
	public int ascMusic() {
		Collections.sort(playlist);
		
		return 1;
	}
	
	public void playMusic(String keyword) {
        // URL 생성
		keyword = keyword.replace(" ", "+");
        String url = "https://www.youtube.com/results?search_query=" + keyword;

        // URL을 기본 브라우저에서 열기
        try {
            java.awt.Desktop.getDesktop().browse(new URI(url));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
    public void fileSave(String filePath) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (Music m : playlist) {
                bw.write(m.getTitle() + "," + m.getArtist() + "," + m.getGenre());
                bw.newLine();
            }
            System.out.print("파일 저장 완료 : " + filePath);
            System.out.println();
        } catch (IOException e) {
            System.out.println("[ERROR] 입출력 오류입니다.");
            e.printStackTrace();
        }
    }
    
    public void fileOpen(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            playlist.clear();
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 3) {
                    Music m = new Music(data[0], data[1], data[2]);
                    playlist.add(m);
                    System.out.println("♪ " + data[0] + " | " + data[1] + " | " + data[2] + " ♪");
                }
            }
            System.out.print("파일 불러오기 완료 : " + filePath);
            System.out.println();
        } catch (IOException e) {
            System.out.println("[ERROR] 불러올 파일을 찾지 못했습니다.");
            e.printStackTrace();
        }
    }
    
    public void addRandomTrack() {
        Music randomTrack = randomTrackManager.getRandomTrack();
        playlist.add(randomTrack);
        System.out.println("랜덤으로 추가된 곡: " + randomTrack);
    }

}
