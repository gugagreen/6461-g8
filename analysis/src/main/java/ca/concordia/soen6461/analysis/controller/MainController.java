package ca.concordia.soen6461.analysis.controller;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ca.concordia.soen6461.analysis.service.AnalysisService;
import ca.concordia.soen6461.analysis.service.impl.DefaultAnalysisService;
import ca.concordia.soen6461.entities.constants.DataPoint;
import ca.concordia.soen6461.entities.constants.Strategy;
import ca.concordia.soen6461.entities.entity.GoogleAppList;
import ca.concordia.soen6461.entities.service.MarshallerService;
import ca.concordia.soen6461.entities.service.impl.JaxbMarshallerService;

public class MainController extends HttpServlet {

	private static final long serialVersionUID = -4509056376668337832L;
	
	private MarshallerService<GoogleAppList> marshallerService = new JaxbMarshallerService<>(); // FIXME - use singleton
	private AnalysisService analysisService = new DefaultAnalysisService(); // FIXME - use singleton

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("main.jsp");
		rd.forward(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String filePath = "/" + (String) request.getSession().getAttribute("fileName"); // FIXME - add to constant
		System.out.println(">> session file = " + filePath);
		
		String[] selectedPoints = request.getParameterValues("dataPoint"); // FIXME - add to constant
		System.out.println(">> selectedPoints: " + Arrays.toString(selectedPoints));
		
		Strategy strategy = Strategy.GRAPH; // FIXME - read from params
		
		if (filePath != null && !filePath.trim().isEmpty()) {
			File testFile = new File(getClass().getResource(filePath).getFile()); // TODO - file not found
			if (testFile != null && testFile.isFile()) {
				FileReader reader = new FileReader(testFile);
				GoogleAppList apps = marshallerService.unmarshall(GoogleAppList.class, reader);
				analysisService.performAnalysis(apps, DataPoint.toDataPoints(selectedPoints), strategy);
			}
			
			RequestDispatcher rd = request.getRequestDispatcher("main.jsp");
			rd.forward(request, response);
		}
	}

}
