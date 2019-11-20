package com.upload.dao;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FileUploadDAO {
	String url="jdbc:mysql://localhost:3306/virtusa";
	String username="root";
	String password="root";
	public int fileUpload(String fname, String completePath) {
		System.out.println("DB my file Name:"+fname);
		File f=new File(completePath);
		FileInputStream fis=null;
		int status=0;
		try {
			fis = new FileInputStream(f);
	 		Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url, username, password);
			PreparedStatement pstmt=con.prepareStatement
					("insert into profile123 values(?,?)");
			pstmt.setString(1, fname);
			//pstmt.setBinaryStream(2, fis, (int)f.length());
			pstmt.setString(2, completePath);
			status = pstmt.executeUpdate();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}

	public List<String> getAllImages() {
		List<String> list = new ArrayList<String>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url, username, password);
			PreparedStatement pstmt=con.prepareStatement
					("select * from  profile123");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
			    list.add(rs.getString(1)); 
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
