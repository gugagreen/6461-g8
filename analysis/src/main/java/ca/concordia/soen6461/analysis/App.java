package ca.concordia.soen6461.analysis;

import java.awt.EventQueue;

import ca.concordia.soen6461.analysis.ui.AnalysisWindow;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AnalysisWindow window = new AnalysisWindow();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
    }
}
