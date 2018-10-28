package Gui;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;

public class View extends JFrame{
	public JFrame frame;
	private JTable table;
	private JTextField txtPendingGraph;
	private JButton btnNewButton;
	private JButton UpdateButton;
	private JLabel lblNewLabel;
	private JTextField RetilerMax;
	private JTextField RetailerMin;
	private JTextField BaseMax;
	private JTextField BaseMin;
	private JTextField Agent1New;
	private JTextField Agent1Old;
	private JTextField Agent2Old;
	private JTextField Agent2New;
	private JTextField Agent4Old;
	private JTextField Agent4New;
	private JTextField Agent3Old;
	private JTextField Agent3New;
	private JTextField Agent6New;
	private JTextField Agent6Old;
	private JTextField Agent5Old;
	private JTextField Agent5New;
	private JTextField Agent7Old;
	private JTextField Agent7New;
	
	public View() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 847, 430);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setLayout(null);  
		frame.setVisible(true);  

		JLabel lblHomeAgentPower = new JLabel("Home Agent Power usage tracker");
		lblHomeAgentPower.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHomeAgentPower.setBounds(10, 11, 216, 27);
		frame.getContentPane().add(lblHomeAgentPower);
		
		
		lblNewLabel = new JLabel("PlaceHolder");
		lblNewLabel.setBounds(102, 49, 719, 216);
		frame.getContentPane().add(lblNewLabel);
		
		btnNewButton  = new JButton("Start");
		btnNewButton.setBounds(10, 49, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(102, 276, 719, 104);
		frame.getContentPane().add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Live Data", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblAgent1 = new JLabel("Agent 1");
		lblAgent1.setBounds(12, 6, 46, 14);
		panel.add(lblAgent1);
		
		Agent1New = new JTextField();
		Agent1New.setBounds(10, 21, 86, 20);
		panel.add(Agent1New);
		Agent1New.setColumns(10);
		
		Agent1Old = new JTextField();
		Agent1Old.setBounds(10, 40, 86, 20);
		panel.add(Agent1Old);
		Agent1Old.setColumns(10);
		
		JLabel lblAgent2 = new JLabel("Agent 2");
		lblAgent2.setBounds(108, 6, 46, 14);
		panel.add(lblAgent2);
		
		Agent2New = new JTextField();
		Agent2New.setColumns(10);
		Agent2New.setBounds(106, 21, 86, 20);
		panel.add(Agent2New);
		
		Agent2Old = new JTextField();
		Agent2Old.setColumns(10);
		Agent2Old.setBounds(106, 40, 86, 20);
		panel.add(Agent2Old);
		
		JLabel lblAgent3 = new JLabel("Agent 3");
		lblAgent3.setBounds(204, 6, 46, 14);
		panel.add(lblAgent3);
		
		Agent3New = new JTextField();
		Agent3New.setColumns(10);
		Agent3New.setBounds(202, 21, 86, 20);
		panel.add(Agent3New);
		
		Agent3Old = new JTextField();
		Agent3Old.setColumns(10);
		Agent3Old.setBounds(202, 40, 86, 20);
		panel.add(Agent3Old);
		
		JLabel lblAgent4 = new JLabel("Agent 4");
		lblAgent4.setBounds(300, 6, 46, 14);
		panel.add(lblAgent4);
		
		Agent4New = new JTextField();
		Agent4New.setColumns(10);
		Agent4New.setBounds(298, 21, 86, 20);
		panel.add(Agent4New);
		
		Agent4Old = new JTextField();
		Agent4Old.setColumns(10);
		Agent4Old.setBounds(298, 40, 86, 20);
		panel.add(Agent4Old);
		
		JLabel lblAgent5 = new JLabel("Agent 5");
		lblAgent5.setBounds(396, 6, 46, 14);
		panel.add(lblAgent5);
		
		Agent5New = new JTextField();
		Agent5New.setColumns(10);
		Agent5New.setBounds(394, 21, 86, 20);
		panel.add(Agent5New);
		
		Agent5Old = new JTextField();
		Agent5Old.setColumns(10);
		Agent5Old.setBounds(394, 40, 86, 20);
		panel.add(Agent5Old);
		
		JLabel lblAgent6 = new JLabel("Agent 6");
		lblAgent6.setBounds(492, 6, 46, 14);
		panel.add(lblAgent6);
		
		Agent6New = new JTextField();
		Agent6New.setColumns(10);
		Agent6New.setBounds(490, 21, 86, 20);
		panel.add(Agent6New);
		
		Agent6Old = new JTextField();
		Agent6Old.setColumns(10);
		Agent6Old.setBounds(490, 40, 86, 20);
		panel.add(Agent6Old);
		
		JLabel lblAgent7 = new JLabel("Agent 7");
		lblAgent7.setBounds(588, 6, 46, 14);
		panel.add(lblAgent7);
		
		Agent7New = new JTextField();
		Agent7New.setColumns(10);
		Agent7New.setBounds(586, 21, 86, 20);
		panel.add(Agent7New);
		
		Agent7Old = new JTextField();
		Agent7Old.setColumns(10);
		Agent7Old.setBounds(586, 40, 86, 20);
		panel.add(Agent7Old);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Settings", null, panel_1, null);
		
		JLabel lblRetailer = new JLabel("Retailer");
		panel_1.add(lblRetailer);
		
		JLabel lblMax = new JLabel("Max");
		panel_1.add(lblMax);
		
		RetilerMax = new JTextField();
		panel_1.add(RetilerMax);
		RetilerMax.setColumns(10);
		
		JLabel lblMin = new JLabel("Min");
		panel_1.add(lblMin);
		
		RetailerMin = new JTextField();
		panel_1.add(RetailerMin);
		RetailerMin.setColumns(10);
		
		JLabel lblRetailerBase = new JLabel("Retailer Base");
		panel_1.add(lblRetailerBase);
		
		JLabel lblMax_1 = new JLabel("Max");
		panel_1.add(lblMax_1);
		
		BaseMax = new JTextField();
		panel_1.add(BaseMax);
		BaseMax.setColumns(10);
		
		JLabel lblMin_1 = new JLabel("Min");
		panel_1.add(lblMin_1);
		
		BaseMin = new JTextField();
		panel_1.add(BaseMin);
		BaseMin.setColumns(10);
		
		UpdateButton = new JButton("Update Values");
		panel_1.add(UpdateButton);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Place Holder", null, panel_2, null);
		
		

	}
		public JButton getBtnNewButton() {
		    return btnNewButton;
		}
		
		public JButton UpdateValuesButton() {
		    return UpdateButton;
		}

		public JLabel getLblNewLabel() {
		    return lblNewLabel;
		}
		
		public JTextField RetilerMax() {
		    return RetilerMax;
		}
		
		public JTextField RetailerMin() {
		    return RetailerMin;
		}
		public JTextField BaseMax() {
		    return BaseMax;
		}
		public JTextField BaseMin() {
		    return BaseMin;
		}
		public JTextField Agent1New() {
		    return Agent1New;
		}
		public JTextField Agent1Old() {
		    return Agent1Old;
		}
		public JTextField Agent2Old() {
		    return Agent2Old;
		}
		public JTextField Agent2New() {
		    return Agent2New;
		}
		public JTextField Agent4Old() {
		    return Agent4Old;
		}
		public JTextField Agent4New() {
		    return Agent4New;
		}
		public JTextField Agent3Old() {
		    return Agent3Old;
		}
		public JTextField Agent3New() {
		    return Agent3New;
		}
		public JTextField Agent6New() {
		    return Agent6New;
		}
		public JTextField Agent6Old() {
		    return Agent6Old;
		}

		public JTextField Agent5Old() {
		    return Agent5Old;
		}

		public JTextField Agent5New() {
		    return Agent5New;
		}

		public JTextField Agent7Old() {
		    return Agent7Old;
		}

		public JTextField Agent7New() {
		    return Agent7New;
		}
}
