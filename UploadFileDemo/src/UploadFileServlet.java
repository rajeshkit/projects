
import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.upload.bo.UploadBO;
@WebServlet("/UploadFileServlet")
@MultipartConfig
public class UploadFileServlet extends HttpServlet {
	String fname=null;
	private static final long serialVersionUID = 1L;
	public static final String save_dir="myfiles";
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			System.out.println(request.getServletContext().getRealPath(""));
			String fullPath=request.getServletContext().getRealPath("")+
					File.separator+save_dir;
			File f=new File(fullPath);
			if(!f.exists()) {
				f.mkdir();
			}
			String completePath=null;
			for(Part part:request.getParts()) {
				fname = extractFile(part);
				completePath = fullPath+File.separator+fname;
				part.write(fullPath+File.separator+fname);
			}
			System.out.println(completePath);
			UploadBO ubo=new UploadBO();
			int status=ubo.fileUpload(fname,completePath);
			response.getWriter().println("File Uploaded Successfully");
	}
	private String extractFile(Part part) {
		String conDisp = part.getHeader("content-disposition");	
		String[] items = conDisp.split(";");
		for(String item:items) {
			if(item.trim().startsWith("filename")) {
				return item.substring(item.indexOf("=")+2, item.length()-1);
			}
		}
		return "";
	}

}
		






