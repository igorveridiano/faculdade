package controller;

import genericTernaryTree.Node;
import genericTernaryTree.Side;
import modelBo.ListDataBo;
import modelVo.CityVo;
import view.MainView;
import view.StartTripPart3View;

public class StartTripControl {

	public static Node<String, CityVo> GetCity(String key) {
		Node<String, CityVo> node = MainView.treeCitys.Get(key);
		return node;
	}
	
	public static void LoadDataSide(StartTripPart3View screen) {
		ListDataBo.LoadDataSide(screen);
	}
	
	public static Node<String, CityVo> GetNextNode (String fahterkey, Side side){
		return ListDataBo.GetNextNode(fahterkey, side);
	}
	
	public static void ClearComboBox(StartTripPart3View screen) {
		ClearComboBox(screen);
	}
}
