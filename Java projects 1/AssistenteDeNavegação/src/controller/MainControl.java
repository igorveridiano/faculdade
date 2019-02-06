package controller;


import genericTernaryTree.Node;
import modelVo.CityVo;
import view.DestinationView;
import view.MainView;
import view.RegisterTrafficBoardView;
import view.StartTripPart1View;
import view.StartTripPart2View;
import view.StartTripPart3View;

public class MainControl {

	public static void RegisterTrafficBoard() {
		RegisterTrafficBoardView screen = new RegisterTrafficBoardView();
		screen.setVisible(true);
		screen.getLblWhatIsThe().setVisible(false);
		screen.getLblWahtSideThis().setVisible(false);
		screen.getComboBoxPreviousCitys().setVisible(false);
		screen.getRdbtnLeft().setVisible(false);
		screen.getRdbtnMidlle().setVisible(false);
		screen.getRdbtnRight().setVisible(false);
		RegisterTrafficBoardControl.ClearCombobox(screen);
		RegisterTrafficBoardControl.LoadDataCity(screen);
	}

	public static void AccessMain() {
		MainView screen = new MainView();
		screen.setVisible(true);
	}
	
	public static void StartTrip1() {
		StartTripPart1View screen = new StartTripPart1View();
		screen.setVisible(true);
	}
	
	public static void StartTrip2() {
		StartTripPart2View screen = new StartTripPart2View();
		screen.setVisible(true);
	}
	
	public static void StartTrip3() {
		if (StartTripPart2View.getCurrentCity().equals(StartTripPart1View.getDestination())){
			DestinationView screen = new DestinationView();
			screen.setVisible(true);
		} else {
			StartTripPart3View screen = new StartTripPart3View();
			StartTripControl.LoadDataSide(screen);
			if (StartTripPart2View.getCurrentCity().getLeftSon() != null){
				screen.getComboBoxSide().addItem("Left");
				screen.getLblTurningTheLeft().setVisible(true);
				screen.getLblCityLeft().setText(StartTripPart2View.getCurrentCity().getLeftSon().getValue().getName());
				screen.getLblCityLeft().setVisible(true);
			} else {
				screen.getLblTurningTheLeft().setVisible(false);
				screen.getLblCityLeft().setVisible(false);
			}
			
			if (StartTripPart2View.getCurrentCity().getRightSon() != null){
				screen.getComboBoxSide().addItem("Right");
				screen.getLblTurningTheRight().setVisible(true);
				screen.getLblCityRight().setText(StartTripPart2View.getCurrentCity().getRightSon().getValue().getName());
				screen.getLblCityRight().setVisible(true);
			} else {
				screen.getLblTurningTheRight().setVisible(false);
				screen.getLblCityRight().setVisible(false);
			}
			
			if (StartTripPart2View.getCurrentCity().getMiddleSon() != null){
				screen.getComboBoxSide().addItem("Straight");
				screen.getLblGoingStraight().setVisible(true);
				screen.getLblCityStraight().setText(StartTripPart2View.getCurrentCity().getMiddleSon().getValue().getName());
				screen.getLblCityStraight().setVisible(true);
			} else {
				screen.getLblGoingStraight().setVisible(false);
				screen.getLblCityStraight().setVisible(false);
			}
			
			if (StartTripPart2View.getCurrentCity().getFather() != null){
				screen.getComboBoxSide().addItem("Back");
				screen.getLblGoingBack().setVisible(true);
				screen.getLblCityBack().setText(StartTripPart2View.getCurrentCity().getFather().getValue().getName());
				screen.getLblCityBack().setVisible(true);
			} else {
				screen.getLblGoingBack().setVisible(false);
				screen.getLblCityBack().setVisible(false);
			}
			screen.setVisible(true);
		}
	}
	
	public static void StartTrip3(Node<String, CityVo> node) {
		StartTripPart2View.setCurrentCity(node);
		
		if (node.equals(StartTripPart1View.getDestination())){
			DestinationView screen = new DestinationView();
			screen.setVisible(true);
		} else {
			StartTripPart3View screen = new StartTripPart3View();
			StartTripControl.LoadDataSide(screen);

			if (StartTripPart2View.getCurrentCity().getLeftSon() != null){
				screen.getComboBoxSide().addItem("Left");
				screen.getLblTurningTheLeft().setVisible(true);
				screen.getLblCityLeft().setText(StartTripPart2View.getCurrentCity().getLeftSon().getValue().getName());
				screen.getLblCityLeft().setVisible(true);
			} else {
				screen.getLblTurningTheLeft().setVisible(false);
				screen.getLblCityLeft().setVisible(false);
			}
			
			if (StartTripPart2View.getCurrentCity().getRightSon() != null){
				screen.getComboBoxSide().addItem("Right");
				screen.getLblTurningTheRight().setVisible(true);
				screen.getLblCityRight().setText(StartTripPart2View.getCurrentCity().getRightSon().getValue().getName());
				screen.getLblCityRight().setVisible(true);
			} else {
				screen.getLblTurningTheRight().setVisible(false);
				screen.getLblCityRight().setVisible(false);
			}
			
			if (StartTripPart2View.getCurrentCity().getMiddleSon() != null){
				screen.getComboBoxSide().addItem("Straight");
				screen.getLblGoingStraight().setVisible(true);
				screen.getLblCityStraight().setText(StartTripPart2View.getCurrentCity().getMiddleSon().getValue().getName());
				screen.getLblCityStraight().setVisible(true);
			} else {
				screen.getLblGoingStraight().setVisible(false);
				screen.getLblCityStraight().setVisible(false);
			}
			
			if (StartTripPart2View.getCurrentCity().getFather() != null){
				screen.getComboBoxSide().addItem("Back");
				screen.getLblGoingBack().setVisible(true);
				screen.getLblCityBack().setText(StartTripPart2View.getCurrentCity().getFather().getValue().getName());
				screen.getLblCityBack().setVisible(true);
			} else {
				screen.getLblGoingBack().setVisible(false);
				screen.getLblCityBack().setVisible(false);
			}
			
			screen.setVisible(true);
		}
	}
}
