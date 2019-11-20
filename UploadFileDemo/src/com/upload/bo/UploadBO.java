package com.upload.bo;

import java.util.List;

import com.upload.dao.FileUploadDAO;

public class UploadBO {

	public int fileUpload(String fname,String completePath) {
		FileUploadDAO fudao=new FileUploadDAO();
		
		return fudao.fileUpload(fname,completePath);
	}

	public List<String> getAllFiles() {
		FileUploadDAO fudao=new FileUploadDAO();
		
		return fudao.getAllImages();
	}

}
