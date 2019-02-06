package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.MainControl;
import genericTernaryTree.Side;
import genericTernaryTree.TernaryTree;

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
	public static TernaryTree<String, String> tree = new TernaryTree<>();

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
		setBounds(100, 100, 350, 170);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("START ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tree.Insert("Idade", "Qual sua idade?");
				tree.Insert("Idade", "Jovem", "Possui alguma lesão?", Side.Left);
				tree.Insert("Idade", "Adulto", "Possui alguma lesão?", Side.Middle);
				tree.Insert("Idade", "Senior", "Possui alguma lesão?", Side.Right);
				tree.Insert("Jovem", "Não", "Possui algum problema médico?", Side.Left);
				tree.Insert("Jovem", "Sim", "Qual o grau da lesão?", Side.Right);
				tree.Insert("Não", "Não, possuo problemas médicos", "Já pratico atividade física?", Side.Left);
				tree.Insert("Não", "Sim, possuo problemas médicos", "Qual o grau do problema?", Side.Right);
				tree.Insert("Não, possuo problemas médicos", "Não pratiquei", "Pode correr, começamdo levemente e depois de umas duas semanas aumenta para um ritmo moderado!", Side.Left);
				tree.Insert("Não, possuo problemas médicos", "Sim ja pratiquei", "A quanto tempo?", Side.Right);
				tree.Insert("Sim, possuo problemas médicos", "Grau baixo", "Pode correr levemente, mas mantendo um acompanhamento médico!", Side.Left);
				tree.Insert("Sim, possuo problemas médicos", "Grau moderado", "Não pode correr deve procurar um médico!", Side.Middle);
				tree.Insert("Sim, possuo problemas médicos", "Grau Alto", "Não pode correr deve procurar um médico!", Side.Right);
				tree.Insert("Sim ja pratiquei", "Recentemente", "Pode correr, começamdo moderadamente e depois aumentar o ritmo de acordo com seu corpo!", Side.Left);
				tree.Insert("Sim ja pratiquei", "A algum tempo", "Pode correr, começamdo levemente e depois aumentar o ritmo de acordo com seu corpo!", Side.Right);
				tree.Insert("Sim", "Baixo", "Pode correr, desde que sejá moderadamente e tomando cuidado!", Side.Left);
				tree.Insert("Sim", "Médio", "Pode correr, desde que sejá levemente e tomando cuidado!", Side.Middle);
				tree.Insert("Sim", "Alto", "Não, pode correr, procure cuidar de sua lesão!", Side.Right);
				
				tree.Insert("Adulto", "Não, possuo", "Possui algum problema médico?", Side.Left);
				tree.Insert("Adulto", "Sim, possuo", "Qual o grau da lesão?", Side.Right);
				tree.Insert("Não, possuo", "Não, tenho problema médico", "Já pratico atividade física?", Side.Left);
				tree.Insert("Não, possuo", "Sim, tenho problema médico", "Qual o grau do problema?", Side.Right);
				tree.Insert("Não, tenho problema médico", "Nunca pratiquei atividade física", "Pode correr, começamdo levemente e depois de umas duas semanas aumenta para um ritmo moderado!", Side.Left);
				tree.Insert("Não, tenho problema médico", "Sim, já pratiquei atividade física", "A quanto tempo?", Side.Right);
				tree.Insert("Sim, tenho problema médico", "Leve", "Pode correr levemente, mas mantendo um acompanhamento médico!", Side.Left);
				tree.Insert("Sim, tenho problema médico", "Moderado", "Não pode correr deve procurar um médico!", Side.Middle);
				tree.Insert("Sim, tenho problema médico", "Grave", "Não pode correr deve procurar um médico!", Side.Right);
				tree.Insert("Sim, já pratiquei atividade física", "A não muito tempo", "Pode correr, começamdo moderadamente e depois aumentar o ritmo de acordo com seu corpo!", Side.Left);
				tree.Insert("Sim, já pratiquei atividade física", "Já tem algum tempo", "Pode correr, começamdo levemente e depois aumentar o ritmo de acordo com seu corpo!", Side.Right);
				tree.Insert("Sim, possuo", "Baixa", "Pode correr, desde que sejá moderadamente e tomando cuidado!", Side.Left);
				tree.Insert("Sim, possuo", "Médiana", "Pode correr, desde que sejá levemente e tomando cuidado!", Side.Middle);
				tree.Insert("Sim, possuo", "Alta", "Não, pode correr, procure cuidar de sua lesão!", Side.Right);
				
	
				tree.Insert("Senior", "Não, tenho", "Possui algum problema médico?", Side.Left);
				tree.Insert("Senior", "Sim, tenho", "Qual o grau da lesão?", Side.Right);
				tree.Insert("Não, tenho", "Não, possuo problema", "Já pratico atividade física?", Side.Left);
				tree.Insert("Não, tenho", "Sim, possuo problema", "Não pode correr, deve ir a um médico!", Side.Right);
				tree.Insert("Não, possuo problema", "Nunca pratiquei", "Pode correr, começamdo levemente e depois de umas duas semanas aumenta para um ritmo moderado!", Side.Left);
				tree.Insert("Não, possuo problema", "Sim, já pratiquei alguma atividade física", "A quanto tempo?", Side.Right);
				tree.Insert("Sim, já pratiquei alguma atividade física", "A pouco tempo", "Pode correr, começamdo moderadamente e depois aumentar o ritmo de acordo com seu corpo, e se possivel com acompanhamento médico!", Side.Left);
				tree.Insert("Sim, já pratiquei alguma atividade física", "Já faz algum tempo", "Pode correr, começamdo levemente e depois aumentar o ritmo de acordo com seu corpo, e se possivel com acompanhamento médico!!", Side.Right);
				tree.Insert("Sim, tenho", "Lesão leve", "Pode correr, desde que sejá moderadamente e tomando cuidado!", Side.Left);
				tree.Insert("Sim, tenho", "Lesão mediana", "Pode correr, desde que sejá levemente e com acompanhamento médico!", Side.Middle);
				tree.Insert("Sim, tenho", "lesão grave", "Não, pode correr, procure cuidar de sua lesão!", Side.Right);
				
				MainControl.StartView(tree.Get("Idade"));
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnExit.setFont(new Font("Times New Roman", Font.BOLD, 18));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnNewButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
						.addComponent(btnExit, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(30)
					.addComponent(btnNewButton)
					.addGap(18)
					.addComponent(btnExit, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(141, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
