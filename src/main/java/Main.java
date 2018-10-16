import java.awt.EventQueue;

import javax.swing.JFrame;

import controllers.MainController;
import javax.swing.JTable;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import javax.swing.JComponent;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import javax.swing.JScrollBar;

public class Main {

	private JFrame frame;
	private JTable table;
	private JTextField txtPendingGraph;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new MainController();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 847, 430);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		table = new JTable();
		table.setBounds(102, 304, 719, 76);
		frame.getContentPane().add(table);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(102, 276, 719, 27);
		frame.getContentPane().add(tabbedPane);

		//tabbedPane.addTab("Agent 1", tabbedPane);
		
		JButton btnRun = new JButton("Run");
		btnRun.setBounds(10, 49, 89, 23);
		frame.getContentPane().add(btnRun);
		
		JButton btnPause = new JButton("Pause");
		btnPause.setBounds(10, 83, 89, 23);
		frame.getContentPane().add(btnPause);
		
		JLabel lblHomeAgentPower = new JLabel("Home Agent Power usage tracker");
		lblHomeAgentPower.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHomeAgentPower.setBounds(10, 11, 216, 27);
		frame.getContentPane().add(lblHomeAgentPower);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(804, 304, 17, 76);
		frame.getContentPane().add(scrollBar);
		
		txtPendingGraph = new JTextField();
		txtPendingGraph.setText("Pending Graph");
		txtPendingGraph.setBounds(102, 49, 719, 216);
		frame.getContentPane().add(txtPendingGraph);
		txtPendingGraph.setColumns(10);
	}
}
