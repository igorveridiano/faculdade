package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import binarySearchTree.BinarySearchTree;
import controller.MainControl;
import modelVo.PersonVo;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static BinarySearchTree<Integer, PersonVo> tree = new BinarySearchTree<>();

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
		setBounds(100, 100, 390, 265);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JButton btnrRegister = new JButton("REGISTER");
		btnrRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainControl.registerView();
				dispose();
			}
		});
		btnrRegister.setFont(new Font("Times New Roman", Font.BOLD, 18));

		JButton btnRemove = new JButton("REMOVE");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainControl.removeView();
				dispose();
			}
		});
		btnRemove.setFont(new Font("Times New Roman", Font.BOLD, 18));

		JButton btnSearch = new JButton("SEARCH");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainControl.consultView();
				dispose();
			}
		});
		btnSearch.setFont(new Font("Times New Roman", Font.BOLD, 18));

		JButton btnList = new JButton("LIST");
		btnList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainControl.listView();
				dispose();
			}
		});
		btnList.setFont(new Font("Times New Roman", Font.BOLD, 18));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnRemove, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 344,
										Short.MAX_VALUE)
								.addComponent(btnrRegister, GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE)
								.addComponent(btnSearch, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 344,
										Short.MAX_VALUE)
								.addComponent(btnList, GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE))
						.addContainerGap()));
		gl_contentPane
				.setVerticalGroup(
						gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup().addGap(24).addComponent(btnrRegister)
										.addGap(18)
										.addComponent(btnRemove, GroupLayout.PREFERRED_SIZE, 31,
												GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addComponent(btnSearch, GroupLayout.PREFERRED_SIZE, 31,
												GroupLayout.PREFERRED_SIZE)
										.addGap(18).addComponent(btnList, GroupLayout.PREFERRED_SIZE, 31,
												GroupLayout.PREFERRED_SIZE)
										.addContainerGap(14, Short.MAX_VALUE)));
		contentPane.setLayout(gl_contentPane);
	}
}
