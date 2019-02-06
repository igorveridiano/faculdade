package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.MainControl;
import fila.FilaDupEnc;
import genericBinaryTree.Node;
import modelVo.CityVo;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConsultView extends javax.swing.JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JButton btnClean;

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
		setBounds(100, 100, 450, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("CONSULT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (MainView.treeCitys.getSize() == 0) {
					JOptionPane.showMessageDialog(getParent(), "There are no cities registered!");
				} else {
					FilaDupEnc<Node<Integer, CityVo>> queue = new FilaDupEnc<>();
					Node<Integer, CityVo> currentNode = null;
					queue.enfileirar(MainView.treeCitys.getRoot());
					MainView.treeCitys.getRoot().setVisited(true);
					
					while (!queue.vazia()) {
						currentNode = queue.desenfileirar();
						DefaultTableModel model = (DefaultTableModel) table.getModel();
		                Object[] informacoes = {currentNode.getValue().getId(), currentNode.getValue().getName()};
		                model.addRow(informacoes);
						if (currentNode.getLeftSon() != null && currentNode.getLeftSon().isVisited() == false) {
							currentNode.getLeftSon().setVisited(true);
							queue.enfileirar(currentNode.getLeftSon());
						}

						if (currentNode.getRightSon() != null && currentNode.getRightSon().isVisited() == false) {
							currentNode.getRightSon().setVisited(true);
							queue.enfileirar(currentNode.getRightSon());
						}
					}
				}
				for (Node<Integer, CityVo> node : MainView.treeCitys.ListPreOrder()) {
					if (node != null) {
						node.setVisited(false);
					}
				}
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		table = new JTable();
		table.setFont(new Font("Times New Roman", Font.BOLD, 14));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Code City", "City"
			}
		) {
			
			private static final long serialVersionUID = 1L;
			@SuppressWarnings("rawtypes")
			Class[] columnTypes = new Class[] {
				Integer.class, String.class
			};
			@SuppressWarnings({ "rawtypes", "unchecked" })
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		
		JButton btnReturn = new JButton("RETURN");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainControl.AccessMain();
				dispose();
			}
		});
		btnReturn.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		btnClean = new JButton("CLEAN");
		btnClean.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
		        for (int i = 0; i < table.getRowCount(); i++) {
		            model.removeRow(i);
		        }
		        Object[] informacoes = {"City Id", "City"};
                model.addRow(informacoes);
			}
		});
		btnClean.setFont(new Font("Times New Roman", Font.BOLD, 16));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(table, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(btnNewButton)
					.addGap(35)
					.addComponent(btnClean, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
					.addGap(30)
					.addComponent(btnReturn, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
					.addGap(38))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnNewButton)
							.addComponent(btnReturn, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnClean, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(table, GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}
}
