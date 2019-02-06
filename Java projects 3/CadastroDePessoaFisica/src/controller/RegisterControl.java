package controller;

import modelVo.PersonVo;
import view.MainView;

public class RegisterControl {

	public static void register(int cpf, String name) {
		PersonVo pessoa = new PersonVo(cpf, name);
		MainView.tree.insert(cpf, pessoa);
	}

}
