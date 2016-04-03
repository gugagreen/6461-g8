package ca.concordia.soen6461.analysis.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ca.concordia.soen6461.analysis.service.impl.XmlFileService;
import ca.concordia.soen6461.analysis.util.Key;
import ca.concordia.soen6461.analysis.util.PropsMng;
import ca.concordia.soen6461.entities.entity.GoogleAppList;
import ca.concordia.soen6461.entities.service.MarshallerService;
import ca.concordia.soen6461.entities.service.impl.JaxbMarshallerService;

// FIXME - delete later. Just a controller to test server-events.
public class TestXmlController extends HttpServlet {
     
    private static final long serialVersionUID = -1588924338571768299L;
    private MarshallerService<GoogleAppList> marshallerService = new JaxbMarshallerService<GoogleAppList>();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		response.setContentType("text/xml");
		GoogleAppList appList = XmlFileService.getInstance().loadApps(PropsMng.get(Key.FILE_PATH));
		Writer writer = response.getWriter();
		marshallerService.marshall(appList, writer);
		writer.close();
    }
}