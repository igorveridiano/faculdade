package controller;

import view.ConsultView;
import view.ListView;
import view.MainView;
import view.RegisterView;
import view.RemoveView;

public class MainControl {

	public static void registerView() {
		RegisterView screen = new RegisterView();
		screen.setVisible(true);
	}

	public static void consultView() {
		ConsultView screen = new ConsultView();
		screen.getLblName1().setVisible(false);
		screen.getLblName2().setVisible(false);
		screen.getLblCpf1().setVisible(false);
		screen.getLblCpf2().setVisible(false);
		screen.setVisible(true);
	}

	public static void listView() {
		ListView screen = new ListView();
		screen.setVisible(true);
	}

	public static void removeView() {
		RemoveView screen = new RemoveView();
		screen.setVisible(true);
	}
	
	public static void acessMain() {
		MainView screen = new MainView();
		screen.setVisible(true);
	}
}
