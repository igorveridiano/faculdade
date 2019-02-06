package controller;

import binarySearchTree.Node;
import modelVo.PersonVo;
import view.MainView;

public class ConsultControl {

	public static Node<Integer, PersonVo> search(int cpf) {
		return MainView.tree.get(cpf);
	}

}
