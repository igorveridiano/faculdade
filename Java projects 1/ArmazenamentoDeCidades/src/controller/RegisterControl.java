package controller;

import genericBinaryTree.Side;
import modelBo.ClearDataBo;
import modelBo.ListDataBo;
import modelVo.CityVo;
import view.MainView;
import view.RegisterView;

public class RegisterControl {

	public static void SaveCity(int fatherkey, int nodekey, String value, Side side) {
		CityVo city = new CityVo(nodekey, value);
		MainView.treeCitys.Insert(fatherkey, nodekey, city, side);
	}

	public static void SaveCity(int nodekey, String value) {
		CityVo city = new CityVo(nodekey, value);
		MainView.treeCitys.Insert(nodekey, city);
	}

	public static void ClearCombobox(RegisterView screen) {
		ClearDataBo.ClearComboBox(screen);
	}

	public static void LoadDataCity(RegisterView screen) {
		ListDataBo.LoadDataCity(screen);
	}
}
