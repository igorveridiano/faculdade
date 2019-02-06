package modelBo;

import genericTernaryTree.Node;
import view.StartView;

public class ListDataBo {

	public static void LoadDataCity(StartView screen, Node<String, String> node) {
		screen.getComboBox().addItem("Selecionar");
		if (node.getLeftSon() != null) {
			screen.getComboBox().addItem(node.getLeftSon().getKey());
		}
		if (node.getMiddleSon() != null) {
			screen.getComboBox().addItem(node.getMiddleSon().getKey());
		}
		if (node.getRightSon() != null) {
			screen.getComboBox().addItem(node.getRightSon().getKey());
		}
	}
}
