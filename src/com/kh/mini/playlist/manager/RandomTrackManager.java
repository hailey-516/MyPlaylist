package com.kh.mini.playlist.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kh.mini.playlist.common.JDBCTemplate;
import com.kh.mini.playlist.model.vo.Music;

public class RandomTrackManager {
	
	private List<Music> predefinedTracks = new ArrayList<>();

    public RandomTrackManager() {
        
        predefinedTracks.add(new Music("Supernatural", "뉴진스", "K-pop"));
        predefinedTracks.add(new Music("Hot Sweet", "뉴진스", "K-pop"));
        predefinedTracks.add(new Music("Sticky", "KISS OF LIFE", "K-pop"));
        predefinedTracks.add(new Music("Supernova", "aespa", "K-pop"));
        predefinedTracks.add(new Music("Small girl (feat. D.O.)", "이영지", "K-pop"));
        predefinedTracks.add(new Music("Armageddon", "aespa", "K-pop"));
        predefinedTracks.add(new Music("Bubble Gum", "뉴진스", "K-pop"));
        predefinedTracks.add(new Music("Boom Boom Bass", "RIIZE", "K-pop"));
        predefinedTracks.add(new Music("삐그덕", "NCT 127", "K-pop"));
        predefinedTracks.add(new Music("Right Now", "뉴진", "K-pop"));
        
        predefinedTracks.add(new Music("踊り子", "Vaundy", "J-pop"));
        predefinedTracks.add(new Music("Magnetic", "아일릿", "K-pop"));
        predefinedTracks.add(new Music("青い珊瑚礁", "마츠다 세이코", "J-pop"));
        predefinedTracks.add(new Music("클락션", "(여자)아이들", "K-pop"));
        predefinedTracks.add(new Music("Welcome to the Show", "데이식스", "K-pop"));
        predefinedTracks.add(new Music("내가 S면 넌 나의 N이 되어줘", "투어스", "K-pop"));
        predefinedTracks.add(new Music("소나기", "이클립스", "발라드"));
        predefinedTracks.add(new Music("Attention", "뉴진스", "K-pop"));
        predefinedTracks.add(new Music("Hype Boy", "뉴진스", "K-pop"));
        predefinedTracks.add(new Music("고민중독", "QWER", "K-pop"));
        
        predefinedTracks.add(new Music("Cosmic", "레드벨벳", "K-pop"));
        predefinedTracks.add(new Music("ETA", "뉴진스", "K-pop"));
        predefinedTracks.add(new Music("예뻤어", "데이식스", "K-pop"));
        predefinedTracks.add(new Music("한 페이지가 될 수 있게", "데이식스", "K-pop"));
        predefinedTracks.add(new Music("Cruel Summer", "Taylor Swift", "Pop"));
        predefinedTracks.add(new Music("MILLION DOLLAR BABY", "Tommy Richman", "Pop"));
        predefinedTracks.add(new Music("Girls Never Die", "트리플에스", "K-pop"));
        predefinedTracks.add(new Music("OMG(Apple Music Edition)", "뉴진스", "K-pop"));
        predefinedTracks.add(new Music("Ditto", "뉴진스", "K-pop"));
        predefinedTracks.add(new Music("해야", "아이브", "K-pop"));
        
        predefinedTracks.add(new Music("Drama", "aespa", "K-pop"));
        predefinedTracks.add(new Music("Midas Touch", "KISS OF LIFE", "K-pop"));
        predefinedTracks.add(new Music("Live My Life", "aespa", "K-pop"));
        predefinedTracks.add(new Music("FOREVER", "BABYMONSTER", "K-pop"));
        predefinedTracks.add(new Music("TOMBOY", "혁오", "Rock"));
        predefinedTracks.add(new Music("첫 만남은 계획대로 되지 않아", "투어스", "K-pop"));
        predefinedTracks.add(new Music("SPOT! (feat. JENNIE", "ZICO", "K-pop"));
        predefinedTracks.add(new Music("SHEESH", "BABYMONSTER", "K-pop"));
        predefinedTracks.add(new Music("Super Shy", "뉴진스", "K-pop"));
        predefinedTracks.add(new Music("미안해 미워해 사랑해", "크러쉬", "발라드"));
        
        predefinedTracks.add(new Music("XO (Only If You Say Yes", "엔하이픈", "K-pop"));
        predefinedTracks.add(new Music("사랑한다는 말의 뜻을 알아가자", "NCT 127", "K-pop"));
        predefinedTracks.add(new Music("Congratulations", "데이식스", "K-pop"));
        predefinedTracks.add(new Music("Who", "지민", "K-pop"));
        predefinedTracks.add(new Music("Chk Chk Boom", "Stray Kids", "K-pop"));
        predefinedTracks.add(new Music("Espresso", "Sabrina Carpenter", "Pop"));
        predefinedTracks.add(new Music("Impossible", "RIIZE", "K-pop"));
        predefinedTracks.add(new Music("Earth, Wind & Fire", "보이넥스트도어", "K-pop"));
        predefinedTracks.add(new Music("Cool With You", "뉴진스", "K-pop"));
        predefinedTracks.add(new Music("그대만 있다면 (영화 '여름날 우리'", "Nerd Connection", "K-pop"));
        
        predefinedTracks.add(new Music("ABCD", "NAYEON", "K-pop"));
        predefinedTracks.add(new Music("New Jeans", "뉴진스", "K-pop"));
        predefinedTracks.add(new Music("Sugarcoat (NATTY Solo", "KISS OF LIFE", "K-pop"));
        predefinedTracks.add(new Music("Lucky Girl Syndrome", "아일릿", "K-pop"));
        predefinedTracks.add(new Music("Siren", "RIIZE", "K-pop"));
        predefinedTracks.add(new Music("나는 아픈 건 딱 질색이니까", "(여자)아이들", "K-pop"));
        predefinedTracks.add(new Music("Love wins all", "아이유", "K-pop"));
        predefinedTracks.add(new Music("Cookie", "뉴진스", "K-pop"));
        predefinedTracks.add(new Music("Hurt", "뉴진스", "K-pop"));
        predefinedTracks.add(new Music("에피소드", "이무진", "K-pop"));
        
        predefinedTracks.add(new Music("좋은 밤 좋은 꿈", "Nerd Connection", "락발라드"));
        predefinedTracks.add(new Music("Love 119", "RIIZE", "K-pop"));
        predefinedTracks.add(new Music("Vancouver", "BIG Naughty", "Hip-hop"));
        predefinedTracks.add(new Music("주저하는 연인들을 위해", "잔나비", "발라드"));
        predefinedTracks.add(new Music("I AM", "아이브", "K-pop"));
        predefinedTracks.add(new Music("천상연", "이창섭", "발라드"));
        predefinedTracks.add(new Music("EVERYTHING", "검정치마", "모던 락"));
        predefinedTracks.add(new Music("Trip (feat. Hannah)", "릴러말즈", "Hip-hop"));
        predefinedTracks.add(new Music("Yours", "데이먼스 이어", "발라드"));
        predefinedTracks.add(new Music("봄눈", "10cm", "발라드"));
        
        predefinedTracks.add(new Music("Bye Bye My Blue", "백예린", "R&B"));
        predefinedTracks.add(new Music("Love me or Leave me", "데이식스", "K-pop"));
        predefinedTracks.add(new Music("거리에서", "성시경", "발라드"));
        predefinedTracks.add(new Music("인사", "범진", "발라드"));
        predefinedTracks.add(new Music("Accendio", "아이브", "K-pop"));
        predefinedTracks.add(new Music("Antifreeze", "백예린", "발라드"));
        predefinedTracks.add(new Music("Next Level", "aespa", "K-pop"));
        predefinedTracks.add(new Music("Seven (Explicit Ver.)", "정국 & Latto", "K-pop"));
        predefinedTracks.add(new Music("ベテルギウス", "Yuuri", "J-pop"));
        predefinedTracks.add(new Music("Songbird (Korean Version)", "NCT WISH", "K-pop"));
        
        predefinedTracks.add(new Music("Young Man", "혁오 & Sunset Rollercoaster", "Rock"));
        predefinedTracks.add(new Music("Spicy", "aespa", "K-pop"));
        predefinedTracks.add(new Music("Not Like Us", "Kendrick Lamar", "Hip-hop"));
        predefinedTracks.add(new Music("Talk Saxy", "RIIZE", "K-pop"));
        predefinedTracks.add(new Music("BIRDS OF A FEATHER", "Billie Eilish", "Pop"));
        predefinedTracks.add(new Music("숲", "최유리", "인디"));
        predefinedTracks.add(new Music("어떻게 이별까지 사랑하겠어, 널 사랑하는 거지", "악뮤", "발라드"));
        predefinedTracks.add(new Music("LOVE DIVE", "아이브", "K-pop"));
        predefinedTracks.add(new Music("OST (feat. Chanmina)", "ASH ISLAND", "Rock"));
        predefinedTracks.add(new Music("Balloon in Love", "선미", "K-pop"));
        
        predefinedTracks.add(new Music("Please Please Please", "Sabrina Carpenter", "Pop"));
        predefinedTracks.add(new Music("Be Mine", "지민", "K-pop"));
        predefinedTracks.add(new Music("Pricey", "NCT 127", "K-pop"));
        predefinedTracks.add(new Music("네가 내 마음에 자리 잡았다", "엔플라잉", "Rock"));
        predefinedTracks.add(new Music("Blue Moon", "엔플라잉", "Rock"));
        predefinedTracks.add(new Music("Smeraldo Garden Marching Band (feat. Loco)", "지민", "K-pop"));
        predefinedTracks.add(new Music("Heaven", "태연", "K-pop"));
        predefinedTracks.add(new Music("오렌지색 물감", "NCT 127", "K-pop"));
        predefinedTracks.add(new Music("Memories", "RIIZE", "K-pop"));
        predefinedTracks.add(new Music("도깨비불", "aespa", "K-pop"));
        
    }

    public Music getRandomTrack() {
        /*Random random = new Random();
        return predefinedTracks.get(random.nextInt(predefinedTracks.size()));*/
    	
    	Music m = null;
    	
    	Connection conn = JDBCTemplate.getConnection();
    	PreparedStatement pstmt = null;
    	ResultSet rset = null;
    	
    	int random = (int) (Math.random() * 100) + 1;
    	System.out.println("Random MUSIC_NO: " + random); // 디버깅을 위해 추가
    	
    	String sql = "SELECT * FROM MUSIC WHERE MUSIC_NO = ?";
    	
    	try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, random);
			rset = pstmt.executeQuery();
			
			if (rset.next()) {
				m = new Music(
						rset.getString("TITLE"),
						rset.getString("ARTIST"),
						rset.getString("GENRE")
						);
			} /*else {
				System.out.println("No record found for MUSIC_NO: " + random); // 디버깅을 위해 추가
			}*/
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(conn);
		}
    	
    	return m;
    	
    }

}
