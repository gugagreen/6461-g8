package ca.concordia.soen6461.analysis.ui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainPanel extends JPanel {

	private static final long serialVersionUID = 8784008692013885893L;

	/**
	 * Create the panel.
	 */
	public MainPanel() {
		setLayout(null);
		
		add(getGraphTableScroll());
		add(getDataSelectionScroll());
		
		add(getExportButton());
		add(getGraphButton());
		add(getTableButton());
		add(getHelpButton());
		add(getExitButton());

	}

	public JButton getExportButton() {
		JButton button = new JButton("Export RDF");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button.setBounds(190, 545, 117, 29);
		return button;
	}

	public JButton getGraphButton() {
		JButton button = new JButton("Graph");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button.setBounds(520, 545, 117, 29);
		return button;
	}
	
	public JButton getTableButton() {
		JButton button = new JButton("Table");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button.setBounds(673, 545, 117, 29);
		return button;
	}
	
	public JButton getHelpButton() {
		JButton button = new JButton("Help");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button.setBounds(520, 6, 117, 29);
		return button;
	}
	
	public JButton getExitButton() {
		JButton button = new JButton("Exit");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button.setBounds(673, 6, 117, 29);
		return button;
	}
	
	private JScrollPane getGraphTableScroll() {
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 40, 500, 500);
		scrollPane.add(new GraphTablePanel());
		return scrollPane;
	}
	
	private JScrollPane getDataSelectionScroll() {
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(520, 40, 270, 500);
		scrollPane.add(new DataSelectionPanel());
		return scrollPane;
	}
}
