package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.MainControl;
import genericTernaryTree.Node;

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

public class StartView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblQuestion;
	private Node<String, String> node;
	private JComboBox<String> comboBox;
	private JButton btnConfirm, btnReturn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartView frame = new StartView();
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
	public StartView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 560, 170);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
	    lblQuestion = new JLabel("Pergunta");
		lblQuestion.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
	    btnConfirm = new JButton("CONFIRM");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (getComboBox().getSelectedItem().toString().equals("Selecionar")){
					JOptionPane.showMessageDialog(getParent(), "Escolha uma resposta!");
				} else {
					MainControl.StartView(MainView.tree.Get(getComboBox().getSelectedItem().toString()));
					dispose();
				}
			}
		});
		btnConfirm.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		btnReturn = new JButton("RETURN");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (getLblQuestion().getText().equals(MainView.tree.Get("Idade").getValue())){
					MainControl.AccessMain();
					dispose();
				} else {
					MainControl.StartView(node.getFather());
					dispose();
				}
			}
		});
		btnReturn.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		comboBox = new JComboBox<String>();
		comboBox.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblQuestion, GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE)
								.addComponent(comboBox, 0, 514, Short.MAX_VALUE)))
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addGap(103)
							.addComponent(btnConfirm, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
							.addGap(40)
							.addComponent(btnReturn, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblQuestion)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnConfirm)
						.addComponent(btnReturn, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}

	public JLabel getLblQuestion() {
		return lblQuestion;
	}

	public void setLblQuestion(JLabel lblQuestion) {
		this.lblQuestion = lblQuestion;
	}
	
	public Node<String, String> getNode() {
		return node;
	}

	public void setNode(Node<String, String> node) {
		this.node = node;
	}

	public JComboBox<String> getComboBox() {
		return comboBox;
	}

	public void setComboBox(JComboBox<String> comboBox) {
		this.comboBox = comboBox;
	}

	public JButton getBtnConfirm() {
		return btnConfirm;
	}

	public void setBtnConfirm(JButton btnConfirm) {
		this.btnConfirm = btnConfirm;
	}

	public JButton getBtnReturn() {
		return btnReturn;
	}

	public void setBtnReturn(JButton btnReturn) {
		this.btnReturn = btnReturn;
	}
}
