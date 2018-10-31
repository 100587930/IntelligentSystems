import java.awt.EventQueue;
import controllers.MainController;
import Gui.View;
import Gui.Controller;

public class Main {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new MainController();
	
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//new Controller();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}	
}

