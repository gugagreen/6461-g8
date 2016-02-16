package ca.concordia.soen6461.analysis.ui;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class AnalysisWindow {

	private JFrame frame;

	/**
	 * Create the application.
	 */
	public AnalysisWindow() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0, 0, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new MainPanel();
		panel.setBounds(0, 0, 800, 580);
		frame.getContentPane().add(panel);
	}
}
