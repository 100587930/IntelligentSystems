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
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class SettingView extends JFrame{
	public JFrame frame;
	private JTable table;
	private JTextField txtPendingGraph;
	private JButton UpdateButton;
	private JTextField RetilerMax;
	private JTextField RetailerMin;
	private JTextField Apliances;
	private JTextField Retailers;
	private JTextField RetailName1;
	private JTextField RetailName2;
	private JTextField RetailName3;
	private JTextField RetailName4;
	private JTextField RetailName5;
	private JTextField AppName5;
	private JTextField AppName4;
	private JTextField AppName3;
	private JTextField AppName2;
	private JTextField AppName1;
	private JTextField AppName7;
	private JTextField RetailName7;
	private JTextField RetailName6;
	private JTextField AppName6;
	private JPanel panel;
	private JLabel label_7;
	
	public SettingView() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 820, 465);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setLayout(null);  
		frame.setVisible(true);  

		JLabel lblHomeAgentPower = new JLabel("Home Agent Power usage tracker");
		lblHomeAgentPower.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHomeAgentPower.setBounds(10, 11, 216, 27);
		frame.getContentPane().add(lblHomeAgentPower);
		
		JPanel SettingTab = new JPanel();
		SettingTab.setBounds(10, 49, 784, 76);
		frame.getContentPane().add(SettingTab);
		
		UpdateButton = new JButton("Start");
		
		JLabel lblMax = new JLabel("Retailers Cap");
		
		RetilerMax = new JTextField();
		RetilerMax.setText("25");
		RetilerMax.setColumns(10);
		
		JLabel lblMin = new JLabel("Retailer Base Price");
		
		RetailerMin = new JTextField();
		RetailerMin.setText("18");
		RetailerMin.setColumns(10);
		
		JLabel lblNumberOfApliances = new JLabel("Number of Appliances");
		
		Apliances = new JTextField();
		Apliances.setText("5");
		Apliances.setColumns(10);
		
		JLabel lblNumberOfRetail = new JLabel("Number of Retail Agents");
		
		Retailers = new JTextField();
		Retailers.setText("3");
		Retailers.setColumns(10);
		GroupLayout gl_SettingTab = new GroupLayout(SettingTab);
		gl_SettingTab.setHorizontalGroup(
			gl_SettingTab.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_SettingTab.createSequentialGroup()
					.addGap(22)
					.addComponent(UpdateButton)
					.addGap(5)
					.addGroup(gl_SettingTab.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_SettingTab.createSequentialGroup()
							.addComponent(lblNumberOfApliances)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(Apliances, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.TRAILING, gl_SettingTab.createSequentialGroup()
							.addComponent(lblMax)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(RetilerMax, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGroup(gl_SettingTab.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_SettingTab.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblNumberOfRetail))
						.addComponent(lblMin, Alignment.TRAILING))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_SettingTab.createParallelGroup(Alignment.LEADING)
						.addComponent(RetailerMin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(Retailers, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(283))
		);
		gl_SettingTab.setVerticalGroup(
			gl_SettingTab.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_SettingTab.createSequentialGroup()
					.addGroup(gl_SettingTab.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_SettingTab.createSequentialGroup()
							.addGap(5)
							.addComponent(UpdateButton))
						.addGroup(gl_SettingTab.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_SettingTab.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_SettingTab.createSequentialGroup()
									.addGap(9)
									.addGroup(gl_SettingTab.createParallelGroup(Alignment.BASELINE)
										.addComponent(RetilerMax, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblMax)))
								.addGroup(gl_SettingTab.createParallelGroup(Alignment.BASELINE)
									.addComponent(RetailerMin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblMin)))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_SettingTab.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNumberOfApliances)
								.addComponent(Apliances, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNumberOfRetail)
								.addComponent(Retailers, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(25, Short.MAX_VALUE))
		);
		SettingTab.setLayout(gl_SettingTab);
		
		panel = new JPanel();
		panel.setBounds(10, 136, 784, 279);
		frame.getContentPane().add(panel);
		
		JLabel lblAgentNames = new JLabel("Agent Names");
		
		JLabel lblAppliance = new JLabel("Appliance");
		
		JLabel lblRetail = new JLabel("Retail");
		
		label_7 = new JLabel("");
		
		JLabel label = new JLabel("1");
		
		RetailName2 = new JTextField();
		RetailName2.setText("4");
		RetailName2.setColumns(10);
		
		RetailName3 = new JTextField();
		RetailName3.setText("6");
		RetailName3.setColumns(10);
		
		RetailName1 = new JTextField();
		RetailName1.setText("2");
		RetailName1.setColumns(10);
		
		JLabel label_1 = new JLabel("2");
		
		AppName3 = new JTextField();
		AppName3.setText("5");
		AppName3.setColumns(10);
		
		RetailName4 = new JTextField();
		RetailName4.setText("8");
		RetailName4.setColumns(10);
		
		JLabel label_2 = new JLabel("3");
		
		JLabel label_4 = new JLabel("5");
		
		RetailName5 = new JTextField();
		RetailName5.setText("10");
		RetailName5.setColumns(10);
		
		JLabel label_6 = new JLabel("6");
		
		AppName5 = new JTextField();
		AppName5.setText("9");
		AppName5.setColumns(10);
		
		JLabel label_3 = new JLabel("4");
		
		AppName4 = new JTextField();
		AppName4.setText("7");
		AppName4.setColumns(10);
		
		JLabel label_5 = new JLabel("7");
		
		AppName2 = new JTextField();
		AppName2.setText("3");
		AppName2.setColumns(10);
		
		AppName1 = new JTextField();
		AppName1.setText("1");
		AppName1.setColumns(10);
		
		AppName7 = new JTextField();
		AppName7.setText("13");
		AppName7.setColumns(10);
		
		RetailName7 = new JTextField();
		RetailName7.setText("14");
		RetailName7.setColumns(10);
		
		RetailName6 = new JTextField();
		RetailName6.setText("12");
		RetailName6.setColumns(10);
		
		AppName6 = new JTextField();
		AppName6.setText("11");
		AppName6.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblAgentNames, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblAppliance, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE)
						.addComponent(AppName2, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE)
						.addComponent(AppName1, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblRetail, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE)
						.addComponent(RetailName1, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE)
						.addComponent(RetailName2, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE))
					.addComponent(label_7, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE)
					.addComponent(AppName3, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE)
					.addComponent(RetailName3, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE)
					.addComponent(AppName4, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE)
					.addComponent(RetailName4, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE)
					.addComponent(AppName5, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE)
					.addComponent(RetailName5, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(label_6, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_5, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(AppName7, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE)
						.addComponent(AppName6, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(RetailName6, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE)
						.addComponent(RetailName7, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE)))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblAgentNames, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
							.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(3)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblAppliance, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(57)
									.addComponent(AppName2, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(27)
									.addComponent(AppName1, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(3)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblRetail, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(27)
									.addComponent(RetailName1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
							.addComponent(RetailName2, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(3)
							.addComponent(label_7, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)))
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(AppName3, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(RetailName3, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(AppName4, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(RetailName4, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(AppName5, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(RetailName5, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(label_6, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
							.addComponent(label_5, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(30)
							.addComponent(AppName7, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
						.addComponent(AppName6, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(RetailName6, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
							.addComponent(RetailName7, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))))
		);
		panel.setLayout(gl_panel);
		
		

	}
		public JTextField RetailAgents() {
		    return Retailers;
		}
		
		public JTextField AplianceAgents() {
		    return Apliances;
		}

		
		public JButton UpdateValuesButton() {
		    return UpdateButton;
		}

		
		public JTextField RetilerMax() {
		    return RetilerMax;
		}
		
		public JTextField RetailerMin() {
		    return RetailerMin;
		}

		
		public String[] GetAppNames() {
			String[] array = {
					AppName1.getText(),
					AppName2.getText(),
					AppName3.getText(),
					AppName4.getText(),
					AppName5.getText(),
					AppName6.getText(),
					AppName7.getText()
			};
			
			return array;
		}
		
		public String[] GetRetailNames() {
			String[] array = {
					RetailName1.getText(),
					RetailName2.getText(),
					RetailName3.getText(),
					RetailName4.getText(),
					RetailName5.getText(),
					RetailName6.getText(),
					RetailName7.getText()
			};
			return array;
		}
}
