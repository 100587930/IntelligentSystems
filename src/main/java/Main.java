package main.java;

import java.awt.EventQueue;

import main.java.Gui.gui;
import main.java.controllers.MainController;

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
