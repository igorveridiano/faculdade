package controller;

import genericTernaryTree.Side;
import modelBo.ClearDataBo;
import modelBo.ListDataBo;
import modelVo.CityVo;
import view.MainView;
import view.RegisterTrafficBoardView;

public class RegisterTrafficBoardControl {

	public static void SaveCity(String fatherkey, String nodekey, String value, Side side) {
		CityVo city = new CityVo(nodekey, value);
		MainView.treeCitys.Insert(fatherkey, nodekey, city, side);
	}

	public static void SaveCity(String nodekey, String value) {
		CityVo city = new CityVo(nodekey, value);
		MainView.treeCitys.Insert(nodekey, city);
	}

	public static void ClearCombobox(RegisterTrafficBoardView screen) {
		ClearDataBo.ClearComboBox(screen);
	}

	public static void LoadDataCity(RegisterTrafficBoardView screen) {
		ListDataBo.LoadDataCity(screen);
	}
}
