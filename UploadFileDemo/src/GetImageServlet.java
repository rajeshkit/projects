

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.upload.bo.UploadBO;
@WebServlet("/GetImageServlet")
public class GetImageServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UploadBO ubo=new UploadBO();
		List<String> imagesList=ubo.getAllFiles();
		RequestDispatcher rd=request.getRequestDispatcher("show.jsp");
		request.setAttribute("myImages", imagesList);
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
