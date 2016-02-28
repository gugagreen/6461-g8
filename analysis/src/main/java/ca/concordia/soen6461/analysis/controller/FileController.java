package ca.concordia.soen6461.analysis.controller;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ca.concordia.soen6461.analysis.service.FileService;
import ca.concordia.soen6461.analysis.service.impl.XmlFileService;

public class FileController extends HttpServlet {

	private static final long serialVersionUID = -3463645976689877242L;
	private FileService service = new XmlFileService(); // FIXME - call singleton

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			URL url = FileController.class.getResource("/");
			File file = new File(url.toURI());
			
			File[] files = service.listFilesInFolder(file.getPath());
			
			HttpSession session = request.getSession();
			session.setAttribute("files", files);
			
			RequestDispatcher rd = request.getRequestDispatcher("files.jsp");
			rd.forward(request, response);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fileName = request.getParameter("fileName");
		request.getSession().setAttribute("fileName", fileName);
		response.sendRedirect("/main");
	}
}
