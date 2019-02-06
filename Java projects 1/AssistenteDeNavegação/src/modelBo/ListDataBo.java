package modelBo;

import genericTernaryTree.Node;
import genericTernaryTree.Side;
import modelVo.CityVo;
import view.MainView;
import view.RegisterTrafficBoardView;
import view.StartTripPart3View;

public class ListDataBo {

	public static void LoadDataCity(RegisterTrafficBoardView screen) {
		screen.getComboBoxPreviousCitys().addItem("Selecionar");
		for (Node<String, CityVo> node : MainView.treeCitys.getNodeList()) {
			screen.getComboBoxPreviousCitys().addItem(node.getValue().getId());
		}
	}

	public static void LoadDataSide(StartTripPart3View screen) {
		screen.getComboBoxSide().addItem("Selecionar");
	}

	public static Node<String, CityVo> GetNextNode(String fahterkey, Side side) {
		Node<String, CityVo> node = MainView.treeCitys.GetSon(fahterkey, side);
		return node;
	}
}
