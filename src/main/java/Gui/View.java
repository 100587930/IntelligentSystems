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
	private JTextField Agent6New;
	private JTextField Agent6Old;
	private JTextField Agent5Old;
	private JTextField Agent5New;
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
	private JLabel lblRetailAgent4;
	private JTextField Retail4Prop;
	private JTextField Retail4Accept;
	private JLabel lblRetailAgent5;
	private JTextField Retail5Prop;
	private JTextField Retail5Accept;
	private JLabel lblRetailAgent6;
	private JTextField Retail6Prop;
	private JTextField Retail6Accept;
	private JLabel lblRetailAgent7;
	private JTextField Retail7Prop;
	private JTextField Retail7Accept;
	
	private XYSeries[] Lineindevidual = new XYSeries[14];
	private XYSeriesCollection dataset;
	
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
		
		 XYDataset ds = createDataset();
         JFreeChart chart = ChartFactory.createXYLineChart("Power Usage Data",
                 "Time", "Cost", ds, PlotOrientation.VERTICAL, true, true,
                 false);
         
         ChartPanel cp = new ChartPanel(chart);
         cp.setBounds(102, 49, 719, 216);
         frame.getContentPane().add(cp);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(102, 276, 719, 104);
		frame.getContentPane().add(tabbedPane);
		
		JPanel ApplianceTab = new JPanel();
		tabbedPane.addTab("Appliance Agents", null, ApplianceTab, null);
		ApplianceTab.setLayout(null);
		
		lblAppAgent1 = new JLabel("Agent 1");
		lblAppAgent1.setBounds(12, 6, 46, 14);
		ApplianceTab.add(lblAppAgent1);
		
		Agent1New = new JTextField();
		Agent1New.setBounds(10, 21, 86, 20);
		ApplianceTab.add(Agent1New);
		Agent1New.setColumns(10);
		
		Agent1Old = new JTextField();
		Agent1Old.setBounds(10, 40, 86, 20);
		ApplianceTab.add(Agent1Old);
		Agent1Old.setColumns(10);
		
		lblAppAgent2 = new JLabel("Agent 2");
		lblAppAgent2.setBounds(108, 6, 46, 14);
		ApplianceTab.add(lblAppAgent2);
		
		Agent2New = new JTextField();
		Agent2New.setColumns(10);
		Agent2New.setBounds(106, 21, 86, 20);
		ApplianceTab.add(Agent2New);
		
		Agent2Old = new JTextField();
		Agent2Old.setColumns(10);
		Agent2Old.setBounds(106, 40, 86, 20);
		ApplianceTab.add(Agent2Old);
		
		lblAppAgent3 = new JLabel("Agent 3");
		lblAppAgent3.setBounds(204, 6, 46, 14);
		ApplianceTab.add(lblAppAgent3);
		
		Agent3New = new JTextField();
		Agent3New.setColumns(10);
		Agent3New.setBounds(202, 21, 86, 20);
		ApplianceTab.add(Agent3New);
		
		Agent3Old = new JTextField();
		Agent3Old.setColumns(10);
		Agent3Old.setBounds(202, 40, 86, 20);
		ApplianceTab.add(Agent3Old);
		
		lblAppAgent4 = new JLabel("Agent 4");
		lblAppAgent4.setBounds(300, 6, 46, 14);
		ApplianceTab.add(lblAppAgent4);
		
		Agent4New = new JTextField();
		Agent4New.setColumns(10);
		Agent4New.setBounds(298, 21, 86, 20);
		ApplianceTab.add(Agent4New);
		
		Agent4Old = new JTextField();
		Agent4Old.setColumns(10);
		Agent4Old.setBounds(298, 40, 86, 20);
		ApplianceTab.add(Agent4Old);
		
		lblAppAgent5 = new JLabel("Agent 5");
		lblAppAgent5.setBounds(396, 6, 46, 14);
		ApplianceTab.add(lblAppAgent5);
		
		Agent5New = new JTextField();
		Agent5New.setColumns(10);
		Agent5New.setBounds(394, 21, 86, 20);
		ApplianceTab.add(Agent5New);
		
		Agent5Old = new JTextField();
		Agent5Old.setColumns(10);
		Agent5Old.setBounds(394, 40, 86, 20);
		ApplianceTab.add(Agent5Old);
		
		lblAppAgent6 = new JLabel("Agent 6");
		lblAppAgent6.setBounds(492, 6, 46, 14);
		ApplianceTab.add(lblAppAgent6);
		
		Agent6New = new JTextField();
		Agent6New.setColumns(10);
		Agent6New.setBounds(490, 21, 86, 20);
		ApplianceTab.add(Agent6New);
		
		Agent6Old = new JTextField();
		Agent6Old.setColumns(10);
		Agent6Old.setBounds(490, 40, 86, 20);
		ApplianceTab.add(Agent6Old);
		
		lblAppAgent7 = new JLabel("Agent 7");
		lblAppAgent7.setBounds(588, 6, 46, 14);
		ApplianceTab.add(lblAppAgent7);
		
		Agent7New = new JTextField();
		Agent7New.setColumns(10);
		Agent7New.setBounds(586, 21, 86, 20);
		ApplianceTab.add(Agent7New);
		
		Agent7Old = new JTextField();
		Agent7Old.setColumns(10);
		Agent7Old.setBounds(586, 40, 86, 20);
		ApplianceTab.add(Agent7Old);
		
		RetailTab = new JPanel();
		RetailTab.setLayout(null);
		tabbedPane.addTab("Retail Tab", null, RetailTab, null);
		
		lblRetailAgent1 = new JLabel("Agent 1");
		lblRetailAgent1.setBounds(12, 6, 46, 14);
		RetailTab.add(lblRetailAgent1);
		
		Retail1Prop = new JTextField();
		Retail1Prop.setColumns(10);
		Retail1Prop.setBounds(10, 21, 86, 20);
		RetailTab.add(Retail1Prop);
		
		Retail1Accept = new JTextField();
		Retail1Accept.setColumns(10);
		Retail1Accept.setBounds(10, 40, 86, 20);
		RetailTab.add(Retail1Accept);
		
		lblRetailAgent2 = new JLabel("Agent 2");
		lblRetailAgent2.setBounds(108, 6, 46, 14);
		RetailTab.add(lblRetailAgent2);
		
		Retail2Prop = new JTextField();
		Retail2Prop.setColumns(10);
		Retail2Prop.setBounds(106, 21, 86, 20);
		RetailTab.add(Retail2Prop);
		
		Retail2Accept = new JTextField();
		Retail2Accept.setColumns(10);
		Retail2Accept.setBounds(106, 40, 86, 20);
		RetailTab.add(Retail2Accept);
		
		lblRetailAgent3 = new JLabel("Agent 3");
		lblRetailAgent3.setBounds(204, 6, 46, 14);
		RetailTab.add(lblRetailAgent3);
		
		Retail3Prop = new JTextField();
		Retail3Prop.setColumns(10);
		Retail3Prop.setBounds(202, 21, 86, 20);
		RetailTab.add(Retail3Prop);
		
		Retail3Accept = new JTextField();
		Retail3Accept.setColumns(10);
		Retail3Accept.setBounds(202, 40, 86, 20);
		RetailTab.add(Retail3Accept);
		
		lblRetailAgent4 = new JLabel("Agent 4");
		lblRetailAgent4.setBounds(300, 6, 46, 14);
		RetailTab.add(lblRetailAgent4);
		
		Retail4Prop = new JTextField();
		Retail4Prop.setColumns(10);
		Retail4Prop.setBounds(298, 21, 86, 20);
		RetailTab.add(Retail4Prop);
		
		Retail4Accept = new JTextField();
		Retail4Accept.setColumns(10);
		Retail4Accept.setBounds(298, 40, 86, 20);
		RetailTab.add(Retail4Accept);
		
		lblRetailAgent5 = new JLabel("Agent 5");
		lblRetailAgent5.setBounds(396, 6, 46, 14);
		RetailTab.add(lblRetailAgent5);
		
		Retail5Prop = new JTextField();
		Retail5Prop.setColumns(10);
		Retail5Prop.setBounds(394, 21, 86, 20);
		RetailTab.add(Retail5Prop);
		
		Retail5Accept = new JTextField();
		Retail5Accept.setColumns(10);
		Retail5Accept.setBounds(394, 40, 86, 20);
		RetailTab.add(Retail5Accept);
		
		lblRetailAgent6 = new JLabel("Agent 6");
		lblRetailAgent6.setBounds(492, 6, 46, 14);
		RetailTab.add(lblRetailAgent6);
		
		Retail6Prop = new JTextField();
		Retail6Prop.setColumns(10);
		Retail6Prop.setBounds(490, 21, 86, 20);
		RetailTab.add(Retail6Prop);
		
		Retail6Accept = new JTextField();
		Retail6Accept.setColumns(10);
		Retail6Accept.setBounds(490, 40, 86, 20);
		RetailTab.add(Retail6Accept);
		
		lblRetailAgent7 = new JLabel("Agent 7");
		lblRetailAgent7.setBounds(588, 6, 46, 14);
		RetailTab.add(lblRetailAgent7);
		
		Retail7Prop = new JTextField();
		Retail7Prop.setColumns(10);
		Retail7Prop.setBounds(586, 21, 86, 20);
		RetailTab.add(Retail7Prop);
		
		Retail7Accept = new JTextField();
		Retail7Accept.setColumns(10);
		Retail7Accept.setBounds(586, 40, 86, 20);
		RetailTab.add(Retail7Accept);
		
		JPanel HomeTab = new JPanel();
		tabbedPane.addTab("Home Agent", null, HomeTab, null);
		
		

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
				lblRetailAgent3,
				lblRetailAgent4,
				lblRetailAgent5,
				lblRetailAgent6,
				lblRetailAgent7
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

		public JTextField Retail1Prop() {
		    return Retail1Prop;
		}
		public JTextField Retail2Prop() {
		    return Retail2Prop;
		}
		public JTextField Retail3Prop() {
		    return Retail3Prop;
		}
		public JTextField Retail4Prop() {
		    return Retail4Prop;
		}
		public JTextField Retail5Prop() {
		    return Retail5Prop;
		}
		public JTextField Retail6Prop() {
		    return Retail6Prop;
		}
		public JTextField Retail7Prop() {
		    return Retail7Prop;
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
		public JTextField Retail4Accept() {
		    return Retail4Accept;
		}
		public JTextField Retail5Accept() {
		    return Retail5Accept;
		}
		public JTextField Retail6Accept() {
		    return Retail6Accept;
		}
		public JTextField Retail7Accept() {
		    return Retail7Accept;
		}

		    public void ChartTest() {
		        XYSeries Goals = new XYSeries("Goals Scored");
		        Goals.add(1, 1.0);
		        Goals.add(2, 3.0);
		        Goals.add(3, 2.0);
		        Goals.add(4, 0.0);
		        Goals.add(5, 3.0);
		        XYDataset xyDataset = new XYSeriesCollection(Goals);
		        JFreeChart chart = ChartFactory.createXYLineChart(
		            "Goals Scored Over Time", "Fixture Number", "Goals",
		            xyDataset, PlotOrientation.VERTICAL, true, true, false);
		        ChartPanel cp = new ChartPanel(chart) {

		            @Override
		            public Dimension getPreferredSize() {
		                return new Dimension(320, 240);
		            }
		        };
		        cp.setMouseWheelEnabled(true);
		        getContentPane().add(cp);
		        setDefaultCloseOperation(EXIT_ON_CLOSE);
		        pack();
		    }
		    public XYDataset createDataset() {
		    	dataset = new XYSeriesCollection();
		    	return dataset;

		    }
		    
		    public void setupLinesindevidual(String Name, int i) {
		    	System.out.println("adding line to graph");
		    	switch (i) {
		    		case 0: Lineindevidual[0] = new XYSeries("Appliance " + Name);dataset.addSeries(Lineindevidual[0]);break;
		    		case 1: Lineindevidual[1] = new XYSeries("Appliance " + Name);dataset.addSeries(Lineindevidual[1]);break;
		    		case 2: Lineindevidual[2] = new XYSeries("Appliance " + Name);dataset.addSeries(Lineindevidual[2]);break;
		    		case 3: Lineindevidual[3] = new XYSeries("Appliance " + Name);dataset.addSeries(Lineindevidual[3]);break;
		    		case 4: Lineindevidual[4] = new XYSeries("Appliance " + Name);dataset.addSeries(Lineindevidual[4]);break;
		    		case 5: Lineindevidual[5] = new XYSeries("Appliance " + Name);dataset.addSeries(Lineindevidual[5]);break;
		    		case 6: Lineindevidual[6] = new XYSeries("Appliance " + Name);dataset.addSeries(Lineindevidual[6]);break;
		    		case 7: Lineindevidual[7] = new XYSeries("Retailer " + Name);dataset.addSeries(Lineindevidual[7]);break;
		    		case 8: Lineindevidual[8] = new XYSeries("Retailer " + Name);dataset.addSeries(Lineindevidual[8]);break;
		    		case 9: Lineindevidual[9] = new XYSeries("Retailer " + Name);dataset.addSeries(Lineindevidual[9]);break;
		    		case 10: Lineindevidual[10] = new XYSeries("Retailer " + Name);dataset.addSeries(Lineindevidual[10]);break;
		    		case 11: Lineindevidual[11] = new XYSeries("Retailer " + Name);dataset.addSeries(Lineindevidual[11]);break;
		    		case 12: Lineindevidual[12] = new XYSeries("Retailer " + Name);dataset.addSeries(Lineindevidual[12]);break;
		    		case 13: Lineindevidual[13] = new XYSeries("Retailer " + Name);dataset.addSeries(Lineindevidual[13]);break;
		    	}	
		    }
		    
		    public void addDataIndevidual(float x, float y, int i) {
		    	switch (i) {
	    		case 0: Lineindevidual[0].add(x,y);break;
	    		case 1: Lineindevidual[1].add(x,y);break;
	    		case 2: Lineindevidual[2].add(x,y);break;
	    		case 3: Lineindevidual[3].add(x,y);break;
	    		case 4: Lineindevidual[4].add(x,y);break;
	    		case 5: Lineindevidual[5].add(x,y);break;
	    		case 6: Lineindevidual[6].add(x,y);break;
	    		case 7: Lineindevidual[7].add(x,y);break;
	    		case 8: Lineindevidual[8].add(x,y);break;
	    		case 9: Lineindevidual[9].add(x,y);break;
	    		case 10: Lineindevidual[10].add(x,y);break;
	    		case 11: Lineindevidual[11].add(x,y);break;
	    		case 12: Lineindevidual[12].add(x,y);break;
	    		case 13: Lineindevidual[13].add(x,y);break;	    		
	    	}
		    }

}
