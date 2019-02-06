package modelBo;

import view.MainView;

public class RemoveBo {

	public static boolean RemoveCity(int key) {
		return MainView.treeCitys.Remove(key);
	}
}
