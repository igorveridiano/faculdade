package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.MainControl;
import controller.RegisterControl;
import genericBinaryTree.Side;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RegisterView extends javax.swing.JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCodeCity;
	private JTextField txtNameCity;
	private JLabel lblWhatIsThe, lblWahtSideThis;
	JComboBox<String> comboBoxPreviousCitys;
	JRadioButton rdbtnRight, rdbtnLeft;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterView frame = new RegisterView();
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
	public RegisterView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 465, 330);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblNameCity = new JLabel("NAME CITY:");
		lblNameCity.setFont(new Font("Times New Roman", Font.BOLD, 16));

		JLabel lblFirstCity = new JLabel("FIRST CITY:");
		lblFirstCity.setFont(new Font("Times New Roman", Font.BOLD, 16));

		JLabel lblCodeCity = new JLabel("CODE CITY:");
		lblCodeCity.setFont(new Font("Times New Roman", Font.BOLD, 16));

		txtCodeCity = new JTextField();
		txtCodeCity.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtCodeCity.setColumns(10);

		txtNameCity = new JTextField();
		txtNameCity.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtNameCity.setColumns(10);

		JRadioButton rdbtnYes = new JRadioButton("YES");
		rdbtnYes.setFont(new Font("Times New Roman", Font.BOLD, 16));

		JRadioButton rdbtnNo = new JRadioButton("NO");
		rdbtnNo.setFont(new Font("Times New Roman", Font.BOLD, 16));

		lblWhatIsThe = new JLabel("WHAT IS THE PREVIOUS CITY?");
		lblWhatIsThe.setFont(new Font("Times New Roman", Font.BOLD, 16));

		comboBoxPreviousCitys = new JComboBox<String>();

		lblWahtSideThis = new JLabel("FOR WHICH SIDE OF THE PREVIOUS CITY THIS CITY IS?");
		lblWahtSideThis.setFont(new Font("Times New Roman", Font.BOLD, 16));

		rdbtnRight = new JRadioButton("RIGHT");
		rdbtnRight.setFont(new Font("Times New Roman", Font.BOLD, 16));

		rdbtnLeft = new JRadioButton("LEFT");
		rdbtnLeft.setFont(new Font("Times New Roman", Font.BOLD, 16));

		getRdbtnRight().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				getRdbtnLeft().setSelected(false);
			}
		});

		getRdbtnLeft().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				getRdbtnRight().setSelected(false);
			}
		});

		rdbtnYes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				rdbtnNo.setSelected(false);
				getLblWhatIsThe().setVisible(false);
				getLblWahtSideThis().setVisible(false);
				getComboBoxPreviousCitys().setVisible(false);
				getRdbtnLeft().setVisible(false);
				getRdbtnRight().setVisible(false);
			}
		});

		rdbtnNo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				rdbtnYes.setSelected(false);
				getLblWhatIsThe().setVisible(true);
				getLblWahtSideThis().setVisible(true);
				getComboBoxPreviousCitys().setVisible(true);
				getRdbtnLeft().setVisible(true);
				getRdbtnRight().setVisible(true);
			}
		});

		JButton btnRegister = new JButton("REGISTER");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnYes.isSelected()) {
					RegisterControl.SaveCity(Integer.parseInt(txtCodeCity.getText()), txtNameCity.getText());
					dispose();
					JOptionPane.showMessageDialog(getParent(), "City saved successfuly");
					MainControl.RegisterView();
				} else if (rdbtnNo.isSelected()) {
					if (getRdbtnLeft().isSelected()) {
						RegisterControl.SaveCity(Integer.parseInt(getComboBoxPreviousCitys().getSelectedItem().toString()),
								Integer.parseInt(getTxtCodeCity().getText()), getTxtNameCity().getText(), Side.Left);
						dispose();
						JOptionPane.showMessageDialog(getParent(), "City saved successfuly");
						MainControl.RegisterView();
					}  else if (getRdbtnRight().isSelected()) {
						RegisterControl.SaveCity(Integer.parseInt(getComboBoxPreviousCitys().getSelectedItem().toString()),
								Integer.parseInt(getTxtCodeCity().getText()), getTxtNameCity().getText(), Side.Right);
						dispose();
						JOptionPane.showMessageDialog(getParent(), "City saved successfuly");
						MainControl.RegisterView();
					}

				}
			}
		});
		btnRegister.setFont(new Font("Times New Roman", Font.BOLD, 16));

		JButton btnCancel = new JButton("CANCEL");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				MainControl.AccessMain();
			}
		});
		btnCancel.setFont(new Font("Times New Roman", Font.BOLD, 16));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblCodeCity, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtCodeCity, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNameCity)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtNameCity, GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
							.addComponent(lblWhatIsThe, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(lblFirstCity, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
								.addGap(28)
								.addComponent(rdbtnYes)
								.addGap(37)
								.addComponent(rdbtnNo, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)))
						.addComponent(comboBoxPreviousCitys, GroupLayout.PREFERRED_SIZE, 328, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblWahtSideThis, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGap(92)
								.addComponent(rdbtnRight, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(rdbtnLeft, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE))
							.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
								.addGap(83)
								.addComponent(btnRegister)
								.addGap(18)
								.addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCodeCity, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtCodeCity, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(24)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNameCity)
						.addComponent(txtNameCity, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFirstCity, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(rdbtnYes)
						.addComponent(rdbtnNo, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblWhatIsThe, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(comboBoxPreviousCitys, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblWahtSideThis, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(rdbtnRight, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(rdbtnLeft, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnRegister)))
		);
		contentPane.setLayout(gl_contentPane);

	}

	public JComboBox<String> getComboBoxPreviousCitys() {
		return comboBoxPreviousCitys;
	}

	public void setComboBoxPreviousCitys(JComboBox<String> comboBoxPreviousCitys) {
		this.comboBoxPreviousCitys = comboBoxPreviousCitys;
	}

	public JTextField getTxtCodeCity() {
		return txtCodeCity;
	}

	public void setTxtCodeCity(JTextField txtCodeCity) {
		this.txtCodeCity = txtCodeCity;
	}

	public JTextField getTxtNameCity() {
		return txtNameCity;
	}

	public void setTxtNameCity(JTextField txtNameCity) {
		this.txtNameCity = txtNameCity;
	}

	public JLabel getLblWhatIsThe() {
		return lblWhatIsThe;
	}

	public void setLblWhatIsThe(JLabel lblWhatIsThe) {
		this.lblWhatIsThe = lblWhatIsThe;
	}

	public JLabel getLblWahtSideThis() {
		return lblWahtSideThis;
	}

	public void setLblWahtSideThis(JLabel lblWahtSideThis) {
		this.lblWahtSideThis = lblWahtSideThis;
	}

	public JRadioButton getRdbtnRight() {
		return rdbtnRight;
	}

	public void setRdbtnRight(JRadioButton rdbtnRight) {
		this.rdbtnRight = rdbtnRight;
	}

	public JRadioButton getRdbtnLeft() {
		return rdbtnLeft;
	}

	public void setRdbtnLeft(JRadioButton rdbtnLeft) {
		this.rdbtnLeft = rdbtnLeft;
	}

}
