package controller;

import view.RegisterView;
import view.RemoveView;
import javax.swing.table.DefaultTableModel;
import view.ConsultView;
import view.MainView;

public class MainControl {
	
	public static void RegisterView(){
		RegisterView screen = new view.RegisterView();
		screen.setVisible(true);
		screen.getLblWhatIsThe().setVisible(false);
		screen.getLblWahtSideThis().setVisible(false);
		screen.getComboBoxPreviousCitys().setVisible(false);
		screen.getRdbtnLeft().setVisible(false);
		screen.getRdbtnRight().setVisible(false);
		RegisterControl.ClearCombobox(screen);
		RegisterControl.LoadDataCity(screen);
	}
	
	public static void RemoveView(){
		RemoveView screen = new RemoveView();
		screen.setVisible(true);
	}
	
	public static void ConsultView(){
		ConsultView screen = new ConsultView();
		DefaultTableModel model = (DefaultTableModel) screen.getTable().getModel();
        Object[] informacoes = {"City ID", "City"};
        model.addRow(informacoes);
		screen.setVisible(true);
	}
	
	public static void AccessMain() {
		MainView screen = new MainView();
		screen.setVisible(true);
	}
}
