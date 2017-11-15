package br.com.Space;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import br.com.ClassesInternas.Curso;
import br.com.ClassesInternas.Disciplina;
import br.com.ClassesInternas.Nota;
import br.com.ClassesInternas.Professor;
import br.com.ClassesInternas.Recado;
import br.com.Conexão.BancoDeDados;
import br.com.Login.Selection;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;

@SuppressWarnings("all")
public class SpaceProf extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SpaceProf frame = new SpaceProf(new Professor("Prof 1","cpf","tel","endereço","CodigoProf"));
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param prof 
	 */
	public SpaceProf(Professor prof) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 554, 345);
		setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("Arquivo");
		menuBar.add(menu);
		
		JMenuItem menuItem = new JMenuItem("Logout");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					Selection frame = new Selection();
					frame.setVisible(true);
					dispose();
			}
		});
		menu.add(menuItem);
		
		JMenuItem menuItem_1 = new JMenuItem("Sair");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		menu.add(menuItem_1);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JLabel lblEspaoDoProfessor = new JLabel("Espa\u00E7o do Professor");
		lblEspaoDoProfessor.setHorizontalAlignment(SwingConstants.CENTER);
		lblEspaoDoProfessor.setFont(new Font("Tahoma", Font.PLAIN, 30));
		contentPane.add(lblEspaoDoProfessor, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		contentPane.add(panel, BorderLayout.WEST);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{75, 0};
		gbl_panel.rowHeights = new int[]{45, 45, 45, 45, 40, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		JLabel label = new JLabel(" ");
		label.setBounds(2, 2, 449, 29);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_1.add(label);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_2.setBounds(2, 31, 441, 54);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBounds(0, 0, 441, 54);
		panel_2.add(panel_6);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBounds(0, 0, 441, 54);
//		panel_2.add(panel_3);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(2, 86, 449, 163);
		panel_1.add(scrollPane);
		
		table = new JTable();
		scrollPane.setColumnHeaderView(table);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(0, 0, 441, 54);
//		panel_2.add(panel_4);
		panel_4.setLayout(null);

		JLabel label_2 = new JLabel("Filtro");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setBounds(80, 15, 46, 14);
		panel_4.add(label_2);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBounds(0, 0, 441, 54);
//		panel_2.add(panel_5);
		
		JLabel lblDigiteOCdigo = new JLabel("C\u00F3digo do recado para apagar:");
		lblDigiteOCdigo.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblDigiteOCdigo.setBounds(180, 2, 158, 14);
		panel_5.add(lblDigiteOCdigo);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(340, 0, 89, 17);
		panel_5.add(textField_2);
		
		JButton btnEscreverNovo = new JButton("Escrever novo");
		btnEscreverNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO Criar novo panel para criar recado
			}
		});
		btnEscreverNovo.setBounds(10, 19, 115, 23);
		panel_5.add(btnEscreverNovo);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBounds(10, 11, 427, 193);
//		panel_2.add(panel_7);
		panel_7.setLayout(null);
		
		JButton btnSenha = new JButton("Senha");
		btnSenha.setBounds(10, 11, 106, 23);
		panel_7.add(btnSenha);
		
		JButton btnInformao = new JButton("Informa\u00E7\u00E3o");
		btnInformao.setBounds(10, 45, 106, 23);
		panel_7.add(btnInformao);

		
		
		JButton btnDisciplinas = new JButton("Disciplinas");
		btnDisciplinas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				label.setText("Disciplina");
				panel_2.removeAll();
				panel_2.repaint();
				panel_2.add(panel_3);
				
				DefaultTableModel modelo = new DefaultTableModel();
				table = new JTable(modelo);
				scrollPane.setViewportView(table);
				//TODO retirar a parte de teste e descomentar esta parte
//				ArrayList<Disciplina> lista = BancoDeDados.getDisciplinas(prof);
//				modelo.addColumn("Código");
//				modelo.addColumn("Nome");
//				modelo.addColumn("Professor");
//				modelo.addColumn("Semestre");
//				for(Disciplina d:lista){
//					modelo.addRow(new Object[]{d.getCodigo(),d.getNome(),d.getProfessor().getNome(),d.getSemestre()});
//				}
				///teste
				modelo.addColumn("Código");
				modelo.addColumn("Nome");
				modelo.addColumn("Professor");
				modelo.addColumn("Semestre");
				for(int j = 0; j<20; j++){
					modelo.addRow(new Object[]{"1234"+j,"Bando De Dados" +j,"José",2});
					modelo.addRow(new Object[]{"2333"+j,"Programas" +j,"Paulo",3});
				}
			}
		});
		GridBagConstraints gbc_btnDisciplinas = new GridBagConstraints();
		gbc_btnDisciplinas.fill = GridBagConstraints.VERTICAL;
		gbc_btnDisciplinas.insets = new Insets(0, 0, 5, 0);
		gbc_btnDisciplinas.gridx = 0;
		gbc_btnDisciplinas.gridy = 0;
		panel.add(btnDisciplinas, gbc_btnDisciplinas);
		
		//TODO retirar a parte de teste e descomentar esta parte
//		ArrayList<Disciplina> disciplinas = prof.getDisciplinas();
			//teste
			ArrayList<Disciplina> disciplinas = new ArrayList<>();
			disciplinas.add(new Disciplina("123", "Cálculo 1", prof,null, 1));
			disciplinas.add(new Disciplina("124", "Cálculo 1", prof,null, 1));
			disciplinas.add(new Disciplina("125", "Bando de dados", prof,null, 2));
			disciplinas.add(new Disciplina("126", "Cálculo 2", prof,null, 2));
			disciplinas.add(new Disciplina("127", "Cálculo 3", prof,null, 3));
			disciplinas.add(new Disciplina("128", "Fiscica 3", prof,null, 3));
			disciplinas.add(new Disciplina("129", "Fisica 2", prof,null, 2));
			disciplinas.add(new Disciplina("130", "Fisica 1", prof,null, 1));
			disciplinas.add(new Disciplina("131", "Fisica 3", prof,null, 3));
		
		String[] disc = new String[1+disciplinas.size()];
		disc[0] = "Disciplinas";
		int i = 1;
		for (Disciplina d : disciplinas) {
			disc[i] = d.getNome();
			i++;
		}
		
		JButton btnNotas = new JButton("Notas");
		btnNotas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				label.setText("Notas");
				panel_2.removeAll();
				panel_2.repaint();
				panel_2.add(panel_4);
				table = new JTable();
				scrollPane.setViewportView(table);
				
				JComboBox comboBox = new JComboBox(disc);
				comboBox.setSelectedIndex(0);
				comboBox.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						for(int i = 1; i<disc.length; i++){
							if(comboBox.getSelectedItem().equals(disc[i])){
								DefaultTableModel modelo = new DefaultTableModel();
								table = new JTable(modelo);
								scrollPane.setViewportView(table);
								
								//TODO retirar a parte de teste e descomentar esta parte
//								ArrayList<Nota> lista = BancoDeDados.getNotas(disciplinas);
//								modelo.addColumn("Disciplina");
//								modelo.addColumn("Nota");
//								for(Nota n:lista){
//									modelo.addRow(new Object[]{n.getDisciplina().getNome(),n.getNota()});
//								}
									///teste
									modelo.addColumn("Disciplina");
									modelo.addColumn("Nota");
									for(int j = 0; j<20; j++){
										modelo.addRow(new Object[]{"cs",9.99});
										modelo.addRow(new Object[]{"modelagem",8.25});
									}
							}
						}
					}
				});
				comboBox.setBounds(148, 15, 141, 20);
				panel_4.add(comboBox);
			}
		});
		GridBagConstraints gbc_btnNotas = new GridBagConstraints();
		gbc_btnNotas.fill = GridBagConstraints.BOTH;
		gbc_btnNotas.insets = new Insets(0, 0, 5, 0);
		gbc_btnNotas.gridx = 0;
		gbc_btnNotas.gridy = 1;
		panel.add(btnNotas, gbc_btnNotas);
		
		JButton btnRecados = new JButton("Recados");
		btnRecados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				label.setText("Recados");
				panel_2.removeAll();
				panel_2.repaint();
				panel_2.add(panel_5);
				
				DefaultTableModel modelo = new DefaultTableModel();
				table = new JTable(modelo);
				scrollPane.setViewportView(table);
				
				//TODO retirar a parte de teste e descomentar esta parte
//				ArrayList<Recado> lista = BancoDeDados.getRecados(prof);
//				modelo.addColumn("Recado");
//				modelo.addColumn("Data");
//				modelo.addColumn("Aluno");
//				for(Recado c:lista){
//					modelo.addRow(new Object[]{c.getRecado(),c.getData(),c.getAluno().getNome()});
//				}
				
					///teste
					modelo.addColumn("Recado");
					modelo.addColumn("Data");
					modelo.addColumn("Aluno");
					for(int i = 0; i<20; i++){
						modelo.addRow(new Object[]{"Olar","12 do 03 de 2004", "Joãozinho"});
						modelo.addRow(new Object[]{"Tudo bem","04 do 05 de 1967", "Mariazinha"});
					}
			}
		});
		GridBagConstraints gbc_btnRecados = new GridBagConstraints();
		gbc_btnRecados.fill = GridBagConstraints.BOTH;
		gbc_btnRecados.insets = new Insets(0, 0, 5, 0);
		gbc_btnRecados.gridx = 0;
		gbc_btnRecados.gridy = 2;
		panel.add(btnRecados, gbc_btnRecados);
		
		JButton btnApagar = new JButton("Apagar");
		btnApagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BancoDeDados.excluir(new Recado(textField_2.getText()));
				table = new JTable();
				scrollPane.setViewportView(table);
			}
		});
		btnApagar.setBounds(340, 19, 89, 23);
		panel_5.add(btnApagar);
		
		JButton btnConta = new JButton("Conta");
		btnConta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				label.setText("Conta");
				panel_2.removeAll();
				panel_2.repaint();
				panel_2.add(panel_7);
			}
		});
		GridBagConstraints gbc_btnConta = new GridBagConstraints();
		gbc_btnConta.fill = GridBagConstraints.BOTH;
		gbc_btnConta.gridx = 0;
		gbc_btnConta.gridy = 5;
		panel.add(btnConta, gbc_btnConta);
	}
}
