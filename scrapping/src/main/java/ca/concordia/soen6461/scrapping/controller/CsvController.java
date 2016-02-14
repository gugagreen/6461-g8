package ca.concordia.soen6461.scrapping.controller;

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

import ca.concordia.soen6461.scrapping.services.CSVService;

public class CsvController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	// FIXME - make it a singleton
	private final CSVService service = new CSVService();

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			URL url = CSVService.class.getResource("/csv");
			File file = new File(url.toURI());
			
			File[] csvFiles = service.listAllCsv(file.getPath());
			
			HttpSession session = request.getSession();
			session.setAttribute("csvFiles", csvFiles);
			
			RequestDispatcher rd = request.getRequestDispatcher("openCsv.jsp");
			rd.forward(request, response);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String selectedCsv = request.getParameter("selectedCsv");
		service.openInDefaultApp("/csv/" + selectedCsv);
	}
}
