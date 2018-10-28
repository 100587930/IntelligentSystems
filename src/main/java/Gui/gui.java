package main.java.Gui;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class gui {
	public JFrame frame;
	private JTable table;
	private JTextField txtPendingGraph;
	private JTable table_1;
	private JTable table_2;
	private JTable table_3;

	public gui() {

		frame = new JFrame();
		frame.setBounds(100, 100, 847, 430);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();
		JTabbedPane tp = new JTabbedPane();
		tp.setBounds(102, 276, 696, 27);
		tp.add("main", p1);

		table_1 = new JTable();
		p1.add(table_1);
		tp.add("visit", p2);

		table_2 = new JTable();
		p2.add(table_2);
		tp.add("help", p3);

		table_3 = new JTable();
		p3.add(table_3);
		frame.getContentPane().add(tp);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);

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
