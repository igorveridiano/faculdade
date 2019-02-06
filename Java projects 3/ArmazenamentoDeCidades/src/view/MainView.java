package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.MainControl;
import genericBinaryTree.BinaryTree;
import modelVo.CityVo;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainView extends javax.swing.JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static BinaryTree<Integer, CityVo> treeCitys = new BinaryTree<>();

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
		setBounds(100, 100, 360, 190);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("REGISTER CITY");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainControl.RegisterView();
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		JButton btnRemoveCity = new JButton("REMOVE CITY");
		btnRemoveCity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainControl.RemoveView();
				dispose();
			}
		});
		btnRemoveCity.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		JButton btnConsultCitys = new JButton("CONSULT CITYS");
		btnConsultCitys.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainControl.ConsultView();
				dispose();
			}
		});
		btnConsultCitys.setFont(new Font("Times New Roman", Font.BOLD, 18));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
						.addComponent(btnRemoveCity, GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
						.addComponent(btnConsultCitys, GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnNewButton)
					.addGap(17)
					.addComponent(btnRemoveCity, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnConsultCitys, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}

}
