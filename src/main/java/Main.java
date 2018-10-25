import java.awt.EventQueue;
import controllers.MainController;
import Gui.gui;

public class Main {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new MainController();

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gui window = new gui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}
}
