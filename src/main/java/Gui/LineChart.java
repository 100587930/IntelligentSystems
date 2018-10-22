package Gui;
import java.awt.EventQueue;
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
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class LineChart{

   public LineChart(String applicationTitle, String chartTitle) {

        gui();

        // based on the dataset we create the chart
        JFreeChart pieChart = ChartFactory.createXYLineChart(chartTitle, "Category", "Score", createDataset(),PlotOrientation.VERTICAL, true, true, false);

        // Adding chart into a chart panel
        ChartPanel chartPanel = new ChartPanel(pieChart);
      
        // settind default size
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
      
        // add to contentPane
        setContentPane(chartPanel);
    }
  
   private XYDataset createDataset() {
     
      final XYSeries firefox = new XYSeries("Firefox");
      firefox.add(1.0, 1.0);
      firefox.add(2.0, 3.0);
      firefox.add(3.0, 4.0);
     
      final XYSeries chrome = new XYSeries("Chrome");
      chrome.add(1.0, 4.0);
      chrome.add(2.0, 6.0);
      chrome.add(3.0, 5.0);
    
     
      final XYSeries iexplorer = new XYSeries("InternetExplorer");
      iexplorer.add(3.0, 4.0);
      iexplorer.add(4.0, 5.0);
      iexplorer.add(5.0, 4.0);
     
     
      final XYSeriesCollection dataset = new XYSeriesCollection();
      dataset.addSeries(firefox);
      dataset.addSeries(chrome);
      dataset.addSeries(iexplorer);
     
      return dataset;
     
  }

   public static void main(String[] args) {
      LineChart chart = new LineChart("Browser Usage Statistics", "Which Browser are you using?");
      chart.pack();
      chart.setVisible(true);
   }
  
	private JFrame frame;
	private JTable table;
	private JTextField txtPendingGraph;
	private JTable table_1;
	private JTable table_2;
	private JTable table_3;
   
	private void gui() {
		
        /*
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
        */
		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 847, 430);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
	    JPanel p1=new JPanel();
	    JPanel p2=new JPanel();  
	    JPanel p3=new JPanel();  
	    JTabbedPane tp=new JTabbedPane(); 
		tp.setBounds(102, 276, 696, 27);
		tp.add("main",p1);
		
		table_1 = new JTable();
		p1.add(table_1);
		tp.add("visit",p2);  
		
		table_2 = new JTable();
		p2.add(table_2);
		tp.add("help",p3);    
		
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