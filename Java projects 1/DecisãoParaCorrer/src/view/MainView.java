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
				tree.Insert("Idade", "Jovem", "Possui alguma les�o?", Side.Left);
				tree.Insert("Idade", "Adulto", "Possui alguma les�o?", Side.Middle);
				tree.Insert("Idade", "Senior", "Possui alguma les�o?", Side.Right);
				tree.Insert("Jovem", "N�o", "Possui algum problema m�dico?", Side.Left);
				tree.Insert("Jovem", "Sim", "Qual o grau da les�o?", Side.Right);
				tree.Insert("N�o", "N�o, possuo problemas m�dicos", "J� pratico atividade f�sica?", Side.Left);
				tree.Insert("N�o", "Sim, possuo problemas m�dicos", "Qual o grau do problema?", Side.Right);
				tree.Insert("N�o, possuo problemas m�dicos", "N�o pratiquei", "Pode correr, come�amdo levemente e depois de umas duas semanas aumenta para um ritmo moderado!", Side.Left);
				tree.Insert("N�o, possuo problemas m�dicos", "Sim ja pratiquei", "A quanto tempo?", Side.Right);
				tree.Insert("Sim, possuo problemas m�dicos", "Grau baixo", "Pode correr levemente, mas mantendo um acompanhamento m�dico!", Side.Left);
				tree.Insert("Sim, possuo problemas m�dicos", "Grau moderado", "N�o pode correr deve procurar um m�dico!", Side.Middle);
				tree.Insert("Sim, possuo problemas m�dicos", "Grau Alto", "N�o pode correr deve procurar um m�dico!", Side.Right);
				tree.Insert("Sim ja pratiquei", "Recentemente", "Pode correr, come�amdo moderadamente e depois aumentar o ritmo de acordo com seu corpo!", Side.Left);
				tree.Insert("Sim ja pratiquei", "A algum tempo", "Pode correr, come�amdo levemente e depois aumentar o ritmo de acordo com seu corpo!", Side.Right);
				tree.Insert("Sim", "Baixo", "Pode correr, desde que sej� moderadamente e tomando cuidado!", Side.Left);
				tree.Insert("Sim", "M�dio", "Pode correr, desde que sej� levemente e tomando cuidado!", Side.Middle);
				tree.Insert("Sim", "Alto", "N�o, pode correr, procure cuidar de sua les�o!", Side.Right);
				
				tree.Insert("Adulto", "N�o, possuo", "Possui algum problema m�dico?", Side.Left);
				tree.Insert("Adulto", "Sim, possuo", "Qual o grau da les�o?", Side.Right);
				tree.Insert("N�o, possuo", "N�o, tenho problema m�dico", "J� pratico atividade f�sica?", Side.Left);
				tree.Insert("N�o, possuo", "Sim, tenho problema m�dico", "Qual o grau do problema?", Side.Right);
				tree.Insert("N�o, tenho problema m�dico", "Nunca pratiquei atividade f�sica", "Pode correr, come�amdo levemente e depois de umas duas semanas aumenta para um ritmo moderado!", Side.Left);
				tree.Insert("N�o, tenho problema m�dico", "Sim, j� pratiquei atividade f�sica", "A quanto tempo?", Side.Right);
				tree.Insert("Sim, tenho problema m�dico", "Leve", "Pode correr levemente, mas mantendo um acompanhamento m�dico!", Side.Left);
				tree.Insert("Sim, tenho problema m�dico", "Moderado", "N�o pode correr deve procurar um m�dico!", Side.Middle);
				tree.Insert("Sim, tenho problema m�dico", "Grave", "N�o pode correr deve procurar um m�dico!", Side.Right);
				tree.Insert("Sim, j� pratiquei atividade f�sica", "A n�o muito tempo", "Pode correr, come�amdo moderadamente e depois aumentar o ritmo de acordo com seu corpo!", Side.Left);
				tree.Insert("Sim, j� pratiquei atividade f�sica", "J� tem algum tempo", "Pode correr, come�amdo levemente e depois aumentar o ritmo de acordo com seu corpo!", Side.Right);
				tree.Insert("Sim, possuo", "Baixa", "Pode correr, desde que sej� moderadamente e tomando cuidado!", Side.Left);
				tree.Insert("Sim, possuo", "M�diana", "Pode correr, desde que sej� levemente e tomando cuidado!", Side.Middle);
				tree.Insert("Sim, possuo", "Alta", "N�o, pode correr, procure cuidar de sua les�o!", Side.Right);
				
	
				tree.Insert("Senior", "N�o, tenho", "Possui algum problema m�dico?", Side.Left);
				tree.Insert("Senior", "Sim, tenho", "Qual o grau da les�o?", Side.Right);
				tree.Insert("N�o, tenho", "N�o, possuo problema", "J� pratico atividade f�sica?", Side.Left);
				tree.Insert("N�o, tenho", "Sim, possuo problema", "N�o pode correr, deve ir a um m�dico!", Side.Right);
				tree.Insert("N�o, possuo problema", "Nunca pratiquei", "Pode correr, come�amdo levemente e depois de umas duas semanas aumenta para um ritmo moderado!", Side.Left);
				tree.Insert("N�o, possuo problema", "Sim, j� pratiquei alguma atividade f�sica", "A quanto tempo?", Side.Right);
				tree.Insert("Sim, j� pratiquei alguma atividade f�sica", "A pouco tempo", "Pode correr, come�amdo moderadamente e depois aumentar o ritmo de acordo com seu corpo, e se possivel com acompanhamento m�dico!", Side.Left);
				tree.Insert("Sim, j� pratiquei alguma atividade f�sica", "J� faz algum tempo", "Pode correr, come�amdo levemente e depois aumentar o ritmo de acordo com seu corpo, e se possivel com acompanhamento m�dico!!", Side.Right);
				tree.Insert("Sim, tenho", "Les�o leve", "Pode correr, desde que sej� moderadamente e tomando cuidado!", Side.Left);
				tree.Insert("Sim, tenho", "Les�o mediana", "Pode correr, desde que sej� levemente e com acompanhamento m�dico!", Side.Middle);
				tree.Insert("Sim, tenho", "les�o grave", "N�o, pode correr, procure cuidar de sua les�o!", Side.Right);
				
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
