package Gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {

public Controller() {
    View view = new View();
    Model model = new Model(view);
    view.frame.setVisible(true);
    
    
    view.getBtnNewButton().addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            model.changeText();
        }

    });
}
}