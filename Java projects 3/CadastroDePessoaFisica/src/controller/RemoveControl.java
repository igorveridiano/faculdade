package controller;

import view.MainView;

public class RemoveControl {

	public static boolean remove(int cpf) {
		return MainView.tree.remove(cpf);
	}
}
