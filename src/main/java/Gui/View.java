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

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.DefaultXYDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BoxLayout;

public class View extends JFrame{
	public JFrame frame;
	private JLabel lblNewLabel;
	private JTextField Agent1New;
	private JTextField Agent1Old;
	private JTextField Agent2Old;
	private JTextField Agent2New;
	private JTextField Agent4Old;
	private JTextField Agent4New;
	private JTextField Agent3Old;
	private JTextField Agent3New;
	private JTextField Agent5Old;
	private JTextField Agent5New;
	private JTextField Agent6New;
	private JTextField Agent6Old;
	private JTextField Agent7Old;
	private JTextField Agent7New;
	private JLabel lblAppAgent1;
	private JLabel lblAppAgent2;
	private JLabel lblAppAgent3;
	private JLabel lblAppAgent4;
	private JLabel lblAppAgent5;
	private JLabel lblAppAgent6;
	private JLabel lblAppAgent7;
	private JPanel RetailTab;
	private JLabel lblRetailAgent1;
	private JTextField Retail1Prop;
	private JTextField Retail1Accept;
	private JLabel lblRetailAgent2;
	private JTextField Retail2Prop;
	private JTextField Retail2Accept;
	private JLabel lblRetailAgent3;
	private JTextField Retail3Prop;
	private JTextField Retail3Accept;
	private JPanel PowerSupply;
	
	private XYSeries[] Lineindevidual = new XYSeries[7];
	private XYSeries[] LineUsage = new XYSeries[7];
	private XYSeries[] LineCumlitive = new XYSeries[7];
	private XYSeriesCollection dataset;
	private XYSeriesCollection Usagedataset;
	private XYSeriesCollection Cumlativedataset;
	private float[] UsageArray = {0,0,0,0,0,0,0};
	private JLabel PowerMissing;
	private JTextField PowerOffer1;
	private JTextField PowerOffer2;
	private JTextField PowerOffer3;
	
	public View() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 847, 430);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setLayout(null);  
		frame.setVisible(true);  
		
		PowerSupply = new JPanel();
		PowerSupply.setBounds(654, 24, 131, 27);
		frame.getContentPane().add(PowerSupply);
		
		PowerMissing = new JLabel("");
		PowerSupply.add(PowerMissing);
		
		JLabel lblPowerSupplied = new JLabel("Power Supplied:");
		lblPowerSupplied.setBounds(562, 30, 105, 14);
		frame.getContentPane().add(lblPowerSupplied);

		JLabel lblHomeAgentPower = new JLabel("Home Agent Power usage tracker");
		lblHomeAgentPower.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHomeAgentPower.setBounds(10, 11, 216, 27);
		frame.getContentPane().add(lblHomeAgentPower);	
		
		 XYDataset ds = createDataset();
         JFreeChart chart = ChartFactory.createXYLineChart("Power Usage Data",
                 "Time", "Kw", ds, PlotOrientation.VERTICAL, true, true,
                 false);
		
		XYDataset dsUsage = createUsageDataset();
		
        JFreeChart chartUsage = ChartFactory.createXYLineChart("Retailer Cost",
                "Time", "Cost", dsUsage, PlotOrientation.VERTICAL, true, true,
                false);
		
		XYDataset dsCumlitive = createCumlativedataset();
		
        JFreeChart ChartCumlitive = ChartFactory.createXYLineChart("Cumlitive Power Usage",
                "Time", "Kw", dsCumlitive, PlotOrientation.VERTICAL, true, true,
                false);
		
				JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
				tabbedPane.setBounds(10, 49, 811, 331);
				frame.getContentPane().add(tabbedPane);
				
		JPanel ApplianceTab = new JPanel();
		tabbedPane.addTab("Appliance Agents", null, ApplianceTab, null);
		ApplianceTab.setLayout(null);
		
		lblAppAgent1 = new JLabel("Agent 1");
		lblAppAgent1.setBounds(100, 11, 84, 14);
		ApplianceTab.add(lblAppAgent1);
		
		Agent1New = new JTextField();
		Agent1New.setBounds(98, 26, 86, 20);
		ApplianceTab.add(Agent1New);
		Agent1New.setColumns(10);
		
		Agent1Old = new JTextField();
		Agent1Old.setBounds(98, 45, 86, 20);
		ApplianceTab.add(Agent1Old);
		Agent1Old.setColumns(10);
		
		lblAppAgent2 = new JLabel("Agent 2");
		lblAppAgent2.setBounds(196, 11, 84, 14);
		ApplianceTab.add(lblAppAgent2);
		
		Agent2New = new JTextField();
		Agent2New.setColumns(10);
		Agent2New.setBounds(194, 26, 86, 20);
		ApplianceTab.add(Agent2New);
		
		Agent2Old = new JTextField();
		Agent2Old.setColumns(10);
		Agent2Old.setBounds(194, 45, 86, 20);
		ApplianceTab.add(Agent2Old);
		
		lblAppAgent3 = new JLabel("Agent 3");
		lblAppAgent3.setBounds(292, 11, 84, 14);
		ApplianceTab.add(lblAppAgent3);
		
		Agent3New = new JTextField();
		Agent3New.setColumns(10);
		Agent3New.setBounds(290, 26, 86, 20);
		ApplianceTab.add(Agent3New);
		
		Agent3Old = new JTextField();
		Agent3Old.setColumns(10);
		Agent3Old.setBounds(290, 45, 86, 20);
		ApplianceTab.add(Agent3Old);
		
		lblAppAgent4 = new JLabel("Agent 4");
		lblAppAgent4.setBounds(388, 11, 84, 14);
		ApplianceTab.add(lblAppAgent4);
		
		Agent4New = new JTextField();
		Agent4New.setColumns(10);
		Agent4New.setBounds(386, 26, 86, 20);
		ApplianceTab.add(Agent4New);
		
		Agent4Old = new JTextField();
		Agent4Old.setColumns(10);
		Agent4Old.setBounds(386, 45, 86, 20);
		ApplianceTab.add(Agent4Old);
		
		lblAppAgent5 = new JLabel("Agent 5");
		lblAppAgent5.setBounds(484, 11, 84, 14);
		ApplianceTab.add(lblAppAgent5);
		
		Agent5New = new JTextField();
		Agent5New.setColumns(10);
		Agent5New.setBounds(482, 26, 86, 20);
		ApplianceTab.add(Agent5New);
		
		Agent5Old = new JTextField();
		Agent5Old.setColumns(10);
		Agent5Old.setBounds(482, 45, 86, 20);
		ApplianceTab.add(Agent5Old);
		
		lblAppAgent6 = new JLabel("Agent 6");
		lblAppAgent6.setBounds(580, 11, 84, 14);
		ApplianceTab.add(lblAppAgent6);
		
		Agent6New = new JTextField();
		Agent6New.setColumns(10);
		Agent6New.setBounds(578, 26, 86, 20);
		ApplianceTab.add(Agent6New);
		
		Agent6Old = new JTextField();
		Agent6Old.setColumns(10);
		Agent6Old.setBounds(578, 45, 86, 20);
		ApplianceTab.add(Agent6Old);
		
		lblAppAgent7 = new JLabel("Agent 7");
		lblAppAgent7.setBounds(676, 11, 84, 14);
		ApplianceTab.add(lblAppAgent7);
		
		Agent7New = new JTextField();
		Agent7New.setColumns(10);
		Agent7New.setBounds(674, 26, 86, 20);
		ApplianceTab.add(Agent7New);
		
		Agent7Old = new JTextField();
		Agent7Old.setColumns(10);
		Agent7Old.setBounds(674, 45, 86, 20);
		ApplianceTab.add(Agent7Old);
		
		ChartPanel cp = new ChartPanel(chart);
		cp.setBounds(0, 76, 398, 216);
		ApplianceTab.add(cp);
		
		JLabel lblCurrentValues = new JLabel("Current Usage");
		lblCurrentValues.setBounds(0, 29, 101, 14);
		ApplianceTab.add(lblCurrentValues);
		
		JLabel lblPreviousValues = new JLabel("Previous Usage");
		lblPreviousValues.setBounds(0, 48, 101, 14);
		ApplianceTab.add(lblPreviousValues);
		
		ChartPanel chartPanel = new ChartPanel(chartUsage);
		chartPanel.setBounds(408, 76, 398, 216);
		ApplianceTab.add(chartPanel);
		
		
		RetailTab = new JPanel();
		RetailTab.setLayout(null);
		tabbedPane.addTab("Retail Tab", null, RetailTab, null);
		
		ChartPanel CumlitivechartPanel = new ChartPanel(ChartCumlitive);
		CumlitivechartPanel.setBounds(12, 76, 794, 216);
		RetailTab.add(CumlitivechartPanel);	
		
		lblRetailAgent1 = new JLabel("Agent 1");
		lblRetailAgent1.setBounds(178, 0, 84, 14);
		RetailTab.add(lblRetailAgent1);
		
		Retail1Prop = new JTextField();
		Retail1Prop.setColumns(10);
		Retail1Prop.setBounds(176, 15, 86, 20);
		RetailTab.add(Retail1Prop);
		
		Retail1Accept = new JTextField();
		Retail1Accept.setColumns(10);
		Retail1Accept.setBounds(176, 34, 86, 20);
		RetailTab.add(Retail1Accept);
		
		lblRetailAgent2 = new JLabel("Agent 2");
		lblRetailAgent2.setBounds(274, 0, 84, 14);
		RetailTab.add(lblRetailAgent2);
		
		Retail2Prop = new JTextField();
		Retail2Prop.setColumns(10);
		Retail2Prop.setBounds(272, 15, 86, 20);
		RetailTab.add(Retail2Prop);
		
		Retail2Accept = new JTextField();
		Retail2Accept.setColumns(10);
		Retail2Accept.setBounds(272, 34, 86, 20);
		RetailTab.add(Retail2Accept);
		
		lblRetailAgent3 = new JLabel("Agent 3");
		lblRetailAgent3.setBounds(370, 0, 84, 14);
		RetailTab.add(lblRetailAgent3);
		
		Retail3Prop = new JTextField();
		Retail3Prop.setColumns(10);
		Retail3Prop.setBounds(368, 15, 86, 20);
		RetailTab.add(Retail3Prop);
		
		Retail3Accept = new JTextField();
		Retail3Accept.setColumns(10);
		Retail3Accept.setBounds(368, 34, 86, 20);
		RetailTab.add(Retail3Accept);
		
		PowerOffer1 = new JTextField();
		PowerOffer1.setBounds(176, 55, 86, 20);
		RetailTab.add(PowerOffer1);
		PowerOffer1.setColumns(10);
		
		PowerOffer2 = new JTextField();
		PowerOffer2.setColumns(10);
		PowerOffer2.setBounds(272, 55, 86, 20);
		RetailTab.add(PowerOffer2);
		
		PowerOffer3 = new JTextField();
		PowerOffer3.setColumns(10);
		PowerOffer3.setBounds(368, 55, 86, 20);
		RetailTab.add(PowerOffer3);
		
		JLabel lblCostForPower = new JLabel("Cost for power proposed");
		lblCostForPower.setBounds(12, 18, 154, 14);
		RetailTab.add(lblCostForPower);
		
		JLabel lblOffer = new JLabel("Offer");
		lblOffer.setBounds(12, 37, 154, 14);
		RetailTab.add(lblOffer);
		
		JLabel lblOfferedPower = new JLabel("Offered Power");
		lblOfferedPower.setBounds(12, 58, 154, 14);
		RetailTab.add(lblOfferedPower);
	}
	
	public JLabel[] setAppAgentNames() {
		JLabel[] names = {
				lblAppAgent1,
				lblAppAgent2,
				lblAppAgent3,
				lblAppAgent4,
				lblAppAgent5,
				lblAppAgent6,
				lblAppAgent7
		};
	    return names;
	}

	public JLabel[] setRetailAgentNames() {
		JLabel[] names = {
				lblRetailAgent1,
				lblRetailAgent2,
				lblRetailAgent3
		};
	    return names;
	}	
	
		public JLabel getLblNewLabel() {
		    return lblNewLabel;
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
		public JTextField Agent7Old() {
		    return Agent7Old;
		}
		
		public JTextField Agent7New() {
		    return Agent7New;
		}

		public JTextField Agent5Old() {
		    return Agent5Old;
		}

		public JTextField Agent5New() {
		    return Agent5New;
		}


		public JTextField Retail1Prop() {
		    return Retail1Prop;
		}
		public JTextField Retail2Prop() {
		    return Retail2Prop;
		}
		public JTextField Retail3Prop() {
		    return Retail3Prop;
		}

		
		public JTextField Retail1Accept() {
		    return Retail1Accept;
		}
		public JTextField Retail2Accept() {
		    return Retail2Accept;
		}
		public JTextField Retail3Accept() {
		    return Retail3Accept;
		}



		public XYDataset createDataset() {
			dataset = new XYSeriesCollection();
		    return dataset;
		}
		
		public XYDataset createUsageDataset() {
			Usagedataset = new XYSeriesCollection();
		    return Usagedataset;
		}
		
		public XYDataset createCumlativedataset() {
			Cumlativedataset = new XYSeriesCollection();
			return Cumlativedataset;
		}
		    
		    public void setupLinesindevidual(String Name, int i) {
		    	System.out.println("adding line to graph");
		    	switch (i) {
		    		case 0: Lineindevidual[0] = new XYSeries("Appliance " + Name);dataset.addSeries(Lineindevidual[0]); break;
		    		case 1: Lineindevidual[1] = new XYSeries("Appliance " + Name);dataset.addSeries(Lineindevidual[1]); break;
		    		case 2: Lineindevidual[2] = new XYSeries("Appliance " + Name);dataset.addSeries(Lineindevidual[2]); break;
		    		case 3: Lineindevidual[3] = new XYSeries("Appliance " + Name);dataset.addSeries(Lineindevidual[3]); break;
		    		case 4: Lineindevidual[4] = new XYSeries("Appliance " + Name);dataset.addSeries(Lineindevidual[4]); break;
		    		case 5: Lineindevidual[5] = new XYSeries("Appliance " + Name);dataset.addSeries(Lineindevidual[5]); break;
		    		case 6: Lineindevidual[6] = new XYSeries("Appliance " + Name);dataset.addSeries(Lineindevidual[6]); break;
		    		case 7: LineUsage[0] = new XYSeries("Retailer " + Name);Usagedataset.addSeries(LineUsage[0]);break;
		    		case 8: LineUsage[1] = new XYSeries("Retailer " + Name);Usagedataset.addSeries(LineUsage[1]);break;
		    		case 9: LineUsage[2] = new XYSeries("Retailer " + Name);Usagedataset.addSeries(LineUsage[2]);break;
		    		case 10: LineUsage[3] = new XYSeries("Retailer " + Name);Usagedataset.addSeries(LineUsage[3]);break;
		    		case 11: LineUsage[4] = new XYSeries("Retailer " + Name);Usagedataset.addSeries(LineUsage[4]);break;
		    		case 12: LineUsage[5] = new XYSeries("Retailer " + Name);Usagedataset.addSeries(LineUsage[5]);break;
		    		case 13: LineUsage[6] = new XYSeries("Retailer " + Name);Usagedataset.addSeries(LineUsage[6]);break;
		    	}	
		    	switch (i) {
	    		case 0: LineCumlitive[0] = new XYSeries("Appliance " + Name);Cumlativedataset.addSeries(LineCumlitive[0]); break;
	    		case 1: LineCumlitive[1] = new XYSeries("Appliance " + Name);Cumlativedataset.addSeries(LineCumlitive[1]); break;
	    		case 2: LineCumlitive[2] = new XYSeries("Appliance " + Name);Cumlativedataset.addSeries(LineCumlitive[2]); break;
	    		case 3: LineCumlitive[3] = new XYSeries("Appliance " + Name);Cumlativedataset.addSeries(LineCumlitive[3]); break;
	    		case 4: LineCumlitive[4] = new XYSeries("Appliance " + Name);Cumlativedataset.addSeries(LineCumlitive[4]); break;
	    		case 5: LineCumlitive[5] = new XYSeries("Appliance " + Name);Cumlativedataset.addSeries(LineCumlitive[5]); break;
	    		case 6: LineCumlitive[6] = new XYSeries("Appliance " + Name);Cumlativedataset.addSeries(LineCumlitive[6]); break;
		    	}
		    }
		    
		    public void addDataIndevidual(float x, float y, int i) {
		    	if(i <= 5) {
		    	UsageArray[i] = UsageArray[i] + y;
		    	LineCumlitive[i].add(x, UsageArray[i]);
		    	}
		    	switch (i) {
	    		case 0: Lineindevidual[0].add(x,y);break;
	    		case 1: Lineindevidual[1].add(x,y);break;
	    		case 2: Lineindevidual[2].add(x,y);break;
	    		case 3: Lineindevidual[3].add(x,y);break;
	    		case 4: Lineindevidual[4].add(x,y);break;
	    		case 5: Lineindevidual[5].add(x,y);break;
	    		case 6: Lineindevidual[6].add(x,y);break;
	    		case 7: LineUsage[0].add(x,y);break;
	    		case 8: LineUsage[1].add(x,y);break;
	    		case 9: LineUsage[2].add(x,y);break;
	    		case 10: LineUsage[3].add(x,y);break;
	    		case 11: LineUsage[4].add(x,y);break;
	    		case 12: LineUsage[5].add(x,y);break;
	    		case 13: LineUsage[6].add(x,y);break;
	    		
	    	}
		    }
		    
	public JPanel getPowerSupply() {
		return PowerSupply;
	}
	
	public JLabel getJPowerMissing() {
		return PowerMissing;
	}
	
	public JTextField offeredpower1() {
		return PowerOffer1;
	}
	public JTextField offeredpower2() {
		return PowerOffer2;
	}
	public JTextField offeredpower3() {
		return PowerOffer3;
	}
	
	
}
