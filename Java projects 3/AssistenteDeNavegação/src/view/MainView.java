package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import controller.MainControl;
import genericTernaryTree.TernaryTree;
import modelVo.CityVo;

public class MainView extends javax.swing.JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static TernaryTree<String, CityVo> treeCitys = new TernaryTree<>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainView frame = new MainView();
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
	public MainView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 476, 160);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JButton btnStartTrip = new JButton("START TRIP");
		btnStartTrip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainControl.StartTrip1();
				dispose();
			}
		});
		btnStartTrip.setFont(new Font("Times New Roman", Font.BOLD, 18));

		JButton btnRegisterTrafficBoard = new JButton("REGISTER TRAFFIC BOARD");
		btnRegisterTrafficBoard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainControl.RegisterTrafficBoard();
				dispose();
			}
		});
		btnRegisterTrafficBoard.setFont(new Font("Times New Roman", Font.BOLD, 18));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnStartTrip, GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
						.addComponent(btnRegisterTrafficBoard, GroupLayout.PREFERRED_SIZE, 430, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(16)
					.addComponent(btnStartTrip, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnRegisterTrafficBoard, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(71, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
