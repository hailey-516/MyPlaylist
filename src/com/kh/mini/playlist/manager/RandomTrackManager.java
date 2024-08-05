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

    public Music getRandomTrack() {
    	
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
			}
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
