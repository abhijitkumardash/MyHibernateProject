package com.caps.dev.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.caps.dev.beans.Movie;
import com.caps.dev.util.DBUtils;

public class MovieJDBCImple implements MovieDAO {

	public boolean createMovie(Movie m) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deleteMovie(int movieId) {
		// TODO Auto-generated method stub
		return false;
	}


	public Movie searchById(int id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from movies_info where movie_id = ?";
		Movie m = null;
		try {
			Class.forName(DBUtils.DRIVERCLASS);
			con = DriverManager.getConnection(DBUtils.DBURL, DBUtils.USER, DBUtils.PASSWORD);
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				m = new Movie();
				m.setMovieId(id);
				m.setName(rs.getString("movie_name"));
				m.setRating(rs.getInt("movie_rating"));
				m.setDescription(rs.getString("movie_desc"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return m;
	}

	public boolean updateRatings(int movieId, int rating) {
		// TODO Auto-generated method stub
		return false;
	}

}
