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
		
		JLabel lblAgentNames = new JLabel("Agent Names");
		lblAgentNames.setBounds(30, 134, 82, 14);
		frame.getContentPane().add(lblAgentNames);
		
		JLabel lblRetail = new JLabel("Retail");
		lblRetail.setBounds(122, 134, 82, 24);
		frame.getContentPane().add(lblRetail);
		
		JLabel lblAppliance = new JLabel("Appliance");
		lblAppliance.setBounds(225, 134, 86, 24);
		frame.getContentPane().add(lblAppliance);
		
		RetailName1 = new JTextField();
		RetailName1.setBounds(122, 169, 86, 20);
		frame.getContentPane().add(RetailName1);
		RetailName1.setColumns(10);
		
		RetailName2 = new JTextField();
		RetailName2.setColumns(10);
		RetailName2.setBounds(122, 200, 86, 20);
		frame.getContentPane().add(RetailName2);
		
		RetailName3 = new JTextField();
		RetailName3.setColumns(10);
		RetailName3.setBounds(122, 231, 86, 20);
		frame.getContentPane().add(RetailName3);
		
		RetailName4 = new JTextField();
		RetailName4.setColumns(10);
		RetailName4.setBounds(122, 262, 86, 20);
		frame.getContentPane().add(RetailName4);
		
		RetailName5 = new JTextField();
		RetailName5.setColumns(10);
		RetailName5.setBounds(122, 293, 86, 20);
		frame.getContentPane().add(RetailName5);
		
		AppName5 = new JTextField();
		AppName5.setColumns(10);
		AppName5.setBounds(225, 293, 86, 20);
		frame.getContentPane().add(AppName5);
		
		AppName4 = new JTextField();
		AppName4.setColumns(10);
		AppName4.setBounds(225, 262, 86, 20);
		frame.getContentPane().add(AppName4);
		
		AppName3 = new JTextField();
		AppName3.setColumns(10);
		AppName3.setBounds(225, 231, 86, 20);
		frame.getContentPane().add(AppName3);
		
		AppName2 = new JTextField();
		AppName2.setColumns(10);
		AppName2.setBounds(225, 200, 86, 20);
		frame.getContentPane().add(AppName2);
		
		AppName1 = new JTextField();
		AppName1.setColumns(10);
		AppName1.setBounds(225, 169, 86, 20);
		frame.getContentPane().add(AppName1);
		
		JLabel label = new JLabel("1");
		label.setBounds(111, 172, 46, 14);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("2");
		label_1.setBounds(111, 203, 46, 14);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("3");
		label_2.setBounds(111, 234, 46, 14);
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("4");
		label_3.setBounds(111, 265, 46, 14);
		frame.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("5");
		label_4.setBounds(111, 296, 46, 14);
		frame.getContentPane().add(label_4);
		
		AppName7 = new JTextField();
		AppName7.setColumns(10);
		AppName7.setBounds(225, 355, 86, 20);
		frame.getContentPane().add(AppName7);
		
		RetailName7 = new JTextField();
		RetailName7.setColumns(10);
		RetailName7.setBounds(122, 355, 86, 20);
		frame.getContentPane().add(RetailName7);
		
		RetailName6 = new JTextField();
		RetailName6.setColumns(10);
		RetailName6.setBounds(122, 324, 86, 20);
		frame.getContentPane().add(RetailName6);
		
		AppName6 = new JTextField();
		AppName6.setColumns(10);
		AppName6.setBounds(225, 324, 86, 20);
		frame.getContentPane().add(AppName6);
		
		JLabel label_5 = new JLabel("7");
		label_5.setBounds(111, 358, 46, 14);
		frame.getContentPane().add(label_5);
		
		JLabel label_6 = new JLabel("6");
		label_6.setBounds(111, 327, 46, 14);
		frame.getContentPane().add(label_6);
		
		

	}
		public JTextField RetailAgents() {
		    return RetilerMax;
		}
		
		public JTextField AplianceAgents() {
		    return RetilerMax;
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
