package ca.concordia.soen6461.analysis.controller;

import java.io.IOException;
import java.io.PrintWriter;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// FIXME - delete later. Just a controller to test server-events.
public class TestServerEventController extends HttpServlet {
     
    private static final long serialVersionUID = -1588924338571768299L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		System.out.println("server event called");
     
        //content type must be set to text/event-stream
        response.setContentType("text/event-stream");   
 
        //encoding must be set to UTF-8
        response.setCharacterEncoding("UTF-8");
 
        PrintWriter writer = response.getWriter();
 
        for(int i=0; i<5; i++) {
 
            writer.write("data: "+ System.currentTimeMillis() +"\n\n");
            writer.flush();
 
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        writer.close();
        System.out.println("server event done");
    }
}