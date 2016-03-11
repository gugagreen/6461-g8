package ca.concordia.soen6461.analysis.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ca.concordia.soen6461.analysis.service.FileService;
import ca.concordia.soen6461.analysis.service.impl.XmlFileService;
import ca.concordia.soen6461.entities.entity.GoogleAppList;

public class ViewScrappedDataController extends HttpServlet {

	private static final long serialVersionUID = -3463645976689877242L;
	private FileService service = new XmlFileService(); // FIXME - call singleton
	
	public static final String PATH = "/scrapResults/jaxbGoogleAppTest.xml"; // FIXME - should not be hardcoded

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GoogleAppList appList = service.loadApps(PATH);
		if (appList != null) {
			request.setAttribute("apps", appList.getApps());
		}

		RequestDispatcher rd = request.getRequestDispatcher("apps.jsp");
		rd.forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fileName = request.getParameter("fileName");
		request.getSession().setAttribute("fileName", fileName);
		response.sendRedirect("/main");
	}
}
