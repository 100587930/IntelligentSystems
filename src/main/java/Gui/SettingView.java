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

public class SettingView extends JFrame{
	public JFrame frame;
	private JTable table;
	private JTextField txtPendingGraph;
	private JButton UpdateButton;
	private JTextField RetilerMax;
	private JTextField RetailerMin;
	private JTextField BaseMax;
	private JTextField BaseMin;
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
		SettingTab.add(UpdateButton);
		
		JLabel lblRetailer = new JLabel("Retailer");
		SettingTab.add(lblRetailer);
		
		JLabel lblMax = new JLabel("Max");
		SettingTab.add(lblMax);
		
		RetilerMax = new JTextField();
		SettingTab.add(RetilerMax);
		RetilerMax.setColumns(10);
		
		JLabel lblMin = new JLabel("Min");
		SettingTab.add(lblMin);
		
		RetailerMin = new JTextField();
		SettingTab.add(RetailerMin);
		RetailerMin.setColumns(10);
		
		JLabel lblRetailerBase = new JLabel("Retailer Base");
		SettingTab.add(lblRetailerBase);
		
		JLabel lblMax_1 = new JLabel("Max");
		SettingTab.add(lblMax_1);
		
		BaseMax = new JTextField();
		SettingTab.add(BaseMax);
		BaseMax.setColumns(10);
		
		JLabel lblMin_1 = new JLabel("Min");
		SettingTab.add(lblMin_1);
		
		BaseMin = new JTextField();
		SettingTab.add(BaseMin);
		BaseMin.setColumns(10);
		
		JLabel lblNumberOfApliances = new JLabel("Number of Appliances");
		SettingTab.add(lblNumberOfApliances);
		
		Apliances = new JTextField();
		SettingTab.add(Apliances);
		Apliances.setColumns(10);
		
		JLabel lblNumberOfRetail = new JLabel("Number of Retail Agents");
		SettingTab.add(lblNumberOfRetail);
		
		Retailers = new JTextField();
		SettingTab.add(Retailers);
		Retailers.setColumns(10);
		
		panel = new JPanel();
		panel.setBounds(10, 136, 784, 279);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblAgentNames = new JLabel("Agent Names");
		lblAgentNames.setBounds(0, 0, 196, 30);
		panel.add(lblAgentNames);
		
		JLabel lblAppliance = new JLabel("Appliance");
		lblAppliance.setBounds(196, 3, 196, 30);
		panel.add(lblAppliance);
		
		JLabel lblRetail = new JLabel("Retail");
		lblRetail.setBounds(392, 3, 196, 30);
		panel.add(lblRetail);
		
		label_7 = new JLabel("");
		label_7.setBounds(588, 3, 196, 39);
		panel.add(label_7);
		
		JLabel label = new JLabel("1");
		label.setBounds(0, 30, 196, 30);
		panel.add(label);
		
		RetailName2 = new JTextField();
		RetailName2.setBounds(392, 60, 196, 30);
		RetailName2.setColumns(10);
		panel.add(RetailName2);
		
		RetailName3 = new JTextField();
		RetailName3.setBounds(392, 90, 196, 30);
		RetailName3.setColumns(10);
		panel.add(RetailName3);
		
		RetailName1 = new JTextField();
		RetailName1.setBounds(392, 30, 196, 30);
		RetailName1.setColumns(10);
		panel.add(RetailName1);
		
		JLabel label_1 = new JLabel("2");
		label_1.setBounds(0, 60, 196, 30);
		panel.add(label_1);
		
		AppName3 = new JTextField();
		AppName3.setBounds(196, 90, 196, 30);
		AppName3.setColumns(10);
		panel.add(AppName3);
		
		RetailName4 = new JTextField();
		RetailName4.setBounds(392, 120, 196, 30);
		RetailName4.setColumns(10);
		panel.add(RetailName4);
		
		JLabel label_2 = new JLabel("3");
		label_2.setBounds(0, 90, 196, 30);
		panel.add(label_2);
		
		JLabel label_4 = new JLabel("5");
		label_4.setBounds(0, 150, 196, 30);
		panel.add(label_4);
		
		RetailName5 = new JTextField();
		RetailName5.setBounds(392, 150, 196, 30);
		RetailName5.setColumns(10);
		panel.add(RetailName5);
		
		JLabel label_6 = new JLabel("6");
		label_6.setBounds(0, 180, 196, 30);
		panel.add(label_6);
		
		AppName5 = new JTextField();
		AppName5.setBounds(196, 150, 196, 30);
		AppName5.setColumns(10);
		panel.add(AppName5);
		
		JLabel label_3 = new JLabel("4");
		label_3.setBounds(0, 120, 196, 30);
		panel.add(label_3);
		
		AppName4 = new JTextField();
		AppName4.setBounds(196, 120, 196, 30);
		AppName4.setColumns(10);
		panel.add(AppName4);
		
		JLabel label_5 = new JLabel("7");
		label_5.setBounds(0, 210, 196, 30);
		panel.add(label_5);
		
		AppName2 = new JTextField();
		AppName2.setBounds(196, 60, 196, 30);
		AppName2.setColumns(10);
		panel.add(AppName2);
		
		AppName1 = new JTextField();
		AppName1.setBounds(196, 30, 196, 31);
		AppName1.setColumns(10);
		panel.add(AppName1);
		
		AppName7 = new JTextField();
		AppName7.setBounds(196, 210, 196, 30);
		AppName7.setColumns(10);
		panel.add(AppName7);
		
		RetailName7 = new JTextField();
		RetailName7.setBounds(392, 210, 196, 30);
		RetailName7.setColumns(10);
		panel.add(RetailName7);
		
		RetailName6 = new JTextField();
		RetailName6.setBounds(392, 180, 196, 30);
		RetailName6.setColumns(10);
		panel.add(RetailName6);
		
		AppName6 = new JTextField();
		AppName6.setBounds(196, 180, 196, 31);
		AppName6.setColumns(10);
		panel.add(AppName6);
		
		

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
		public JTextField BaseMax() {
		    return BaseMax;
		}
		public JTextField BaseMin() {
		    return BaseMin;
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
