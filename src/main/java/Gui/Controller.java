package Gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {

	private Model model;
	
public Controller() {
    View view = new View();
    model = new Model(view);
    view.frame.setVisible(true);
    
    
    view.getBtnNewButton().addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            
            if(view.getBtnNewButton().getText() == "Start") {
            	model.UpdateButtonCLick("Pause");
            								//Code to start cyclic behavior
            }else {
            	model.UpdateButtonCLick("Start");
            								//Code to stop cyclic behavior
            }
         
            model.AssignOldValues(model.getCurrentNew(), 7); //sample passing new to old
        }

    });
    
    SampleAssignNew();
    SampleAssignOld();

    view.UpdateValuesButton().addActionListener(new ActionListener() {//actions to do when update button is pressed
    	 @Override
         public void actionPerformed(ActionEvent e) {
             System.out.println(model.getRetailerMax());	//example of how to get data that will be passed
             System.out.println(model.getRetailerMin());
             System.out.println(model.getBaseMax());
             System.out.println(model.getBaseMin());  
    	 }
    	}
    		);

	}

private void SampleAssignNew() {
	int[] intArray = new int[] {1,2,3,4,5,6,7};
	int length = 7;
	model.AssignNewValues(intArray, length);		//assigning new values to the gui
}

private void SampleAssignOld() {					//assigning old values to the gui
	int[] intArray = new int[] {7,6,5,4,3,2,1};
	int length = 7;
	model.AssignOldValues(intArray, length);
}
}