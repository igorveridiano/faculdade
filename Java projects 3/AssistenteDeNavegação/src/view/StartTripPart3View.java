package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.MainControl;
import controller.StartTripControl;
import genericTernaryTree.Side;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class StartTripPart3View extends javax.swing.JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblTurningTheRight, lblTurningTheLeft, lblGoingStraight, lblCityRight, lblCityLeft, lblCityStraight;
	JComboBox<String> comboBoxSide;
	private JLabel lblWhereDoYou, lblGoingBack;
	private JLabel lblCityBack;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartTripPart3View frame = new StartTripPart3View();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public StartTripPart3View() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 360);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		lblTurningTheRight = new JLabel("TURNING THE RIGTH YOU CANGO TO:");
		lblTurningTheRight.setFont(new Font("Times New Roman", Font.BOLD, 18));

		lblTurningTheLeft = new JLabel("TURNING THE LEFT YOU CAN GO TO:");
		lblTurningTheLeft.setFont(new Font("Times New Roman", Font.BOLD, 18));

		lblGoingStraight = new JLabel("GOING STRAIGHT YOU CAN GO TO:");
		lblGoingStraight.setFont(new Font("Times New Roman", Font.BOLD, 18));

		lblGoingBack = new JLabel("GOING BACK YOU CAN GO TO:");
		lblGoingBack.setFont(new Font("Times New Roman", Font.BOLD, 18));

		JButton btnCancel = new JButton("CANCEL");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				MainControl.AccessMain();
			}
		});
		btnCancel.setFont(new Font("Times New Roman", Font.BOLD, 18));

		JButton btnNext = new JButton("NEXT");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (getComboBoxSide().getSelectedItem().toString().equals("Selecionar")) {
					JOptionPane.showMessageDialog(getParent(), "Choose a city to go");
				} else {
					if (getComboBoxSide().getSelectedItem().toString().equals("Left")) {
						dispose();
						MainControl.StartTrip3(
								StartTripControl.GetNextNode(StartTripPart2View.getCurrentCity().getKey(), Side.Left));
					} else if (getComboBoxSide().getSelectedItem().toString().equals("Straight")) {
						dispose();
						MainControl.StartTrip3(StartTripControl
								.GetNextNode(StartTripPart2View.getCurrentCity().getKey(), Side.Middle));
					} else if (getComboBoxSide().getSelectedItem().toString().equals("Right")) {
						dispose();
						MainControl.StartTrip3(
								StartTripControl.GetNextNode(StartTripPart2View.getCurrentCity().getKey(), Side.Right));
					} else if (getComboBoxSide().getSelectedItem().toString().equals("Back")) {
						if (StartTripPart2View.getCurrentCity().getFather() != null) {
							dispose();
							MainControl.StartTrip3(StartTripPart2View.getCurrentCity().getFather());
						} else {
							JOptionPane.showMessageDialog(getParent(), "There is no city to return");
						}
					}
				}
			}
		});
		btnNext.setFont(new Font("Times New Roman", Font.BOLD, 18));

		lblCityRight = new JLabel("CITY");
		lblCityRight.setFont(new Font("Times New Roman", Font.BOLD, 18));

		lblCityLeft = new JLabel("CITY");
		lblCityLeft.setFont(new Font("Times New Roman", Font.BOLD, 18));

		lblCityStraight = new JLabel("CITY");
		lblCityStraight.setFont(new Font("Times New Roman", Font.BOLD, 18));

		comboBoxSide = new JComboBox<String>();
		comboBoxSide.setFont(new Font("Times New Roman", Font.BOLD, 18));
		comboBoxSide.setToolTipText("");

		lblWhereDoYou = new JLabel("WHERE DO YOU WANT TO GO?");
		lblWhereDoYou.setFont(new Font("Times New Roman", Font.BOLD, 18));

		lblCityBack = new JLabel("CITY");
		lblCityBack.setFont(new Font("Times New Roman", Font.BOLD, 18));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane
				.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblTurningTheRight, GroupLayout.DEFAULT_SIZE, 414,
												Short.MAX_VALUE)
										.addComponent(lblCityRight, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
										.addComponent(lblTurningTheLeft, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
										.addComponent(lblCityLeft, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
										.addComponent(lblGoingStraight, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
										.addComponent(lblCityStraight, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
										.addComponent(lblGoingBack, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
										.addGroup(gl_contentPane.createSequentialGroup().addGap(68)
												.addComponent(btnNext, GroupLayout.PREFERRED_SIZE, 124,
														GroupLayout.PREFERRED_SIZE)
												.addGap(18).addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 124,
														GroupLayout.PREFERRED_SIZE))
										.addComponent(comboBoxSide, GroupLayout.PREFERRED_SIZE, 172,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblWhereDoYou, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 424,
												Short.MAX_VALUE)
										.addComponent(lblCityBack, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 414,
												Short.MAX_VALUE))
								.addContainerGap()));
		gl_contentPane
				.setVerticalGroup(
						gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(lblTurningTheRight, GroupLayout.PREFERRED_SIZE, 22,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(lblCityRight, GroupLayout.PREFERRED_SIZE, 22,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(lblTurningTheLeft, GroupLayout.PREFERRED_SIZE, 22,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(lblCityLeft, GroupLayout.PREFERRED_SIZE, 22,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(lblGoingStraight, GroupLayout.PREFERRED_SIZE, 22,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(lblCityStraight, GroupLayout.PREFERRED_SIZE, 22,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(lblGoingBack, GroupLayout.PREFERRED_SIZE, 22,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(lblCityBack, GroupLayout.PREFERRED_SIZE, 22,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(lblWhereDoYou, GroupLayout.PREFERRED_SIZE, 22,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(comboBoxSide, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
												.addComponent(btnNext, GroupLayout.PREFERRED_SIZE, 31,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 31,
														GroupLayout.PREFERRED_SIZE))));
		contentPane.setLayout(gl_contentPane);
	}

	public JLabel getLblCityRight() {
		return lblCityRight;
	}

	public void setLblCityRight(JLabel lblCityRight) {
		this.lblCityRight = lblCityRight;
	}

	public JLabel getLblCityLeft() {
		return lblCityLeft;
	}

	public void setLblCityLeft(JLabel string) {
		this.lblCityLeft = string;
	}

	public JLabel getLblCityStraight() {
		return lblCityStraight;
	}

	public void setLblCityStraight(JLabel lblCityStraight) {
		this.lblCityStraight = lblCityStraight;
	}

	public JComboBox<String> getComboBoxSide() {
		return comboBoxSide;
	}

	public void setComboBoxSide(JComboBox<String> comboBoxSide) {
		this.comboBoxSide = comboBoxSide;
	}

	public JLabel getLblGoingBack() {
		return lblGoingBack;
	}

	public void setLblGoingBack(JLabel lblGoingBack) {
		this.lblGoingBack = lblGoingBack;
	}

	public JLabel getLblCityBack() {
		return lblCityBack;
	}

	public void setLblCityBack(JLabel lblCityBack) {
		this.lblCityBack = lblCityBack;
	}

	public JLabel getLblTurningTheRight() {
		return lblTurningTheRight;
	}

	public void setLblTurningTheRight(JLabel lblTurningTheRight) {
		this.lblTurningTheRight = lblTurningTheRight;
	}

	public JLabel getLblTurningTheLeft() {
		return lblTurningTheLeft;
	}

	public void setLblTurningTheLeft(JLabel lblTurningTheLeft) {
		this.lblTurningTheLeft = lblTurningTheLeft;
	}

	public JLabel getLblGoingStraight() {
		return lblGoingStraight;
	}

	public void setLblGoingStraight(JLabel lblGoingStraight) {
		this.lblGoingStraight = lblGoingStraight;
	}
	
}
