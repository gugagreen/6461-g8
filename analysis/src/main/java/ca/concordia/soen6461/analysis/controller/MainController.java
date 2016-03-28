package ca.concordia.soen6461.analysis.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ca.concordia.soen6461.analysis.service.impl.DefaultAnalysisService;
import ca.concordia.soen6461.analysis.service.impl.XmlFileService;
import ca.concordia.soen6461.analysis.util.Key;
import ca.concordia.soen6461.analysis.util.PropsMng;
import ca.concordia.soen6461.entities.constants.DataPoint;
import ca.concordia.soen6461.entities.constants.Strategy;
import ca.concordia.soen6461.entities.entity.AnalysisResult;
import ca.concordia.soen6461.entities.entity.GoogleAppList;

public class MainController extends HttpServlet {

	private static final long serialVersionUID = -4509056376668337832L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("main.jsp");
		rd.forward(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String selectedPoint = request.getParameter((PropsMng.get(Key.PARAM_DATA_POINT)));
		
		Strategy strategy = Strategy.GRAPH; // FIXME - read from params

		GoogleAppList appList = XmlFileService.getInstance().loadApps(PropsMng.get(Key.FILE_PATH));
		if (appList != null) {
			AnalysisResult result = DefaultAnalysisService.getInstance().performAnalysis(DataPoint.getByValue(selectedPoint));
			
			// FIXME - call DisplayService
			
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
