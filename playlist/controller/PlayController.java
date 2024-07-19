package com.kh.mini.playlist.controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;

import com.kh.mini.playlist.model.vo.Music;

public class PlayController {
	
	private ArrayList<Music> playlist = new ArrayList();
	
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
			if(title.contains(keyword) || artist.contains(keyword)) {
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
;		}
		return remove;
	}
	
	public int ascMusic() {
		Collections.sort(playlist);
		
		return 1;
	}
	
	public void playMusic(String keyword) {
        // URL 생성 (예: 유튜브에서 검색)
        String url = "https://www.youtube.com/results?search_query=" + keyword;

        // URL을 콘솔에 출력
        System.out.println(url);

        // URL을 기본 브라우저에서 열기
        try {
            java.awt.Desktop.getDesktop().browse(new URI(url));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
	public void fileSave(String filePath) {
		try ( ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
			oos.writeObject(playlist);
			System.out.print("파일 저장 완료 : " + filePath);
			System.out.println();
		} catch (IOException e) {
			System.out.println("[ERROR] 입출력 오류입니다.");
			e.printStackTrace();
		}
	}
	
	public void fileOpen(String filePath) {
		try ( ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
			playlist = (ArrayList<Music>)ois.readObject();
			System.out.print("파일 불러오기 완료 : " + filePath);
			System.out.println();
		} catch(IOException | ClassNotFoundException e) {
			System.out.println("[ERROR] 불러올 파일을 찾지 못했습니다.");
			e.printStackTrace();
		}
	}

}
