package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import binarySearchTree.Node;
import controller.ConsultControl;
import controller.MainControl;
import modelVo.PersonVo;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConsultView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCpf;
	private JLabel lblName1, lblName2, lblCpf1, lblCpf2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultView frame = new ConsultView();
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
	public ConsultView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 260);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("CPF:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		txtCpf = new JTextField();
		txtCpf.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtCpf.setColumns(10);
		
		JButton btnSearch = new JButton("SEARCH");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Node<Integer, PersonVo> node = ConsultControl.search(Integer.parseInt(txtCpf.getText()));
				if (node != null){
					getLblName2().setText(node.getValue().getName());
					getLblCpf2().setText(String.valueOf(node.getValue().getCpf()));
					getLblName1().setVisible(true);
					getLblName2().setVisible(true);
					getLblCpf1().setVisible(true);
					getLblCpf2().setVisible(true);
				} else {
					JOptionPane.showMessageDialog(getParent(), "Person not found!");
				}
				
			}
		});
		btnSearch.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		JButton btnCancel = new JButton("CANCEL");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainControl.acessMain();
				dispose();
			}
		});
		btnCancel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		lblName1 = new JLabel("NAME:");
		lblName1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		lblCpf1 = new JLabel("CPF:");
		lblCpf1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		lblName2 = new JLabel("XXXXXXXXXXXX");
		lblName2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		lblCpf2 = new JLabel("XXXXXXXXXXXXX");
		lblCpf2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		JLabel lblD = new JLabel("DATE OF THE PERSON: ");
		lblD.setFont(new Font("Times New Roman", Font.BOLD, 18));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txtCpf, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnSearch, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)
							.addGap(66)
							.addComponent(btnCancel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(12))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblCpf1, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblCpf2, GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblName1)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblName2, GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE))
						.addComponent(lblD))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(txtCpf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSearch))
					.addGap(27)
					.addComponent(lblD, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblName1)
						.addComponent(lblName2, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblCpf1, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCpf2, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
					.addGap(16))
		);
		contentPane.setLayout(gl_contentPane);
	}

	public JLabel getLblName1() {
		return lblName1;
	}

	public void setLblName1(JLabel lblName1) {
		this.lblName1 = lblName1;
	}

	public JLabel getLblName2() {
		return lblName2;
	}

	public void setLblName2(JLabel lblName2) {
		this.lblName2 = lblName2;
	}

	public JLabel getLblCpf1() {
		return lblCpf1;
	}

	public void setLblCpf1(JLabel lblCpf1) {
		this.lblCpf1 = lblCpf1;
	}

	public JLabel getLblCpf2() {
		return lblCpf2;
	}

	public void setLblCpf2(JLabel lblCpf2) {
		this.lblCpf2 = lblCpf2;
	}

}
