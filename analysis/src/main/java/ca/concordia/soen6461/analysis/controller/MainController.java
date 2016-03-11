package ca.concordia.soen6461.analysis.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ca.concordia.soen6461.analysis.service.AnalysisService;
import ca.concordia.soen6461.analysis.service.FileService;
import ca.concordia.soen6461.analysis.service.impl.DefaultAnalysisService;
import ca.concordia.soen6461.analysis.service.impl.XmlFileService;
import ca.concordia.soen6461.entities.constants.DataPoint;
import ca.concordia.soen6461.entities.constants.Strategy;
import ca.concordia.soen6461.entities.entity.AnalysisResult;
import ca.concordia.soen6461.entities.entity.GoogleAppList;

public class MainController extends HttpServlet {

	private static final long serialVersionUID = -4509056376668337832L;

	private FileService fileService = new XmlFileService(); // FIXME - use singleton
	private AnalysisService analysisService = new DefaultAnalysisService(); // FIXME - use singleton

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("main.jsp");
		rd.forward(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String selectedPoint = request.getParameter("dataPoint"); // FIXME - add to constant
		
		Strategy strategy = Strategy.GRAPH; // FIXME - read from params

		GoogleAppList appList = fileService.loadApps(ViewScrappedDataController.PATH); // FIXME - get path from props
		if (appList != null) {
			AnalysisResult result = analysisService.performAnalysis(appList, DataPoint.getByValue(selectedPoint), strategy);
			request.setAttribute("result", result);
			
			// FIXME - dummy test
			request.setAttribute("apps", appList.getApps());

			RequestDispatcher rd = request.getRequestDispatcher("main.jsp");
			rd.forward(request, response);
		} else {
			System.out.println("error");
			// FIXME - send to error page
		}
	}

}
