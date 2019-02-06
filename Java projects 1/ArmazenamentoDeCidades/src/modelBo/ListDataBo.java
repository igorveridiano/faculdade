package modelBo;

import genericBinaryTree.Node;
import modelVo.CityVo;
import view.MainView;
import view.RegisterView;

public class ListDataBo {

	public static void LoadDataCity(RegisterView screen) {
		screen.getComboBoxPreviousCitys().addItem("Selecionar");
		for (Node<Integer, CityVo> node : MainView.treeCitys.ListPreOrder()) {
			screen.getComboBoxPreviousCitys().addItem(Integer.toString(node.getValue().getId()));
		}
	}
}
