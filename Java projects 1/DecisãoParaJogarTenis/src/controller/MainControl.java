package controller;

import genericTernaryTree.Node;
import view.MainView;
import view.StartView;
import view.AnswerView;

public class MainControl {
	
	public static void StartView(Node<String, String> node){
		StartView screen = new StartView();
		if (node.getLeftSon() != null || node.getMiddleSon() != null || node.getRightSon() != null){
			StartContrlol.LoadDataCity(screen, node);
			screen.getLblQuestion().setText(node.getValue());
			screen.setNode(node);
			screen.setVisible(true);
		} else {
			AnswerView(node);
			screen.dispose();
		}
	}
	
	public static void AccessMain() {
		MainView screen = new MainView();
		screen.setVisible(true);
	}
	
	public static void AnswerView(Node<String, String> node) {
		AnswerView screen = new AnswerView();
		screen.getLblAnswer().setText(node.getValue());
		screen.setNode(node);
		screen.setVisible(true);
	}
}
