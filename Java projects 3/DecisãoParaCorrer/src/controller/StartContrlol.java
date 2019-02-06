package controller;

import genericTernaryTree.Node;
import modelBo.ListDataBo;
import view.StartView;

public class StartContrlol {
	
	public static void LoadDataCity(StartView screen, Node<String, String> node) {
		ListDataBo.LoadDataCity(screen, node);
	}
}
