package br.com.Space;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

import br.com.Conexão.BancoDeDados;
import br.com.Login.Selection;
import br.com.ClassesInternas.*;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.border.BevelBorder;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.event.ActionEvent;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.GridLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.CardLayout;
import net.miginfocom.swing.MigLayout;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Dimension;
import javax.swing.JTable;
import javax.swing.JTabbedPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JToolBar;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.BoxLayout;
import javax.swing.JSeparator;
import javax.swing.JSplitPane;
import javax.swing.JInternalFrame;
import javax.swing.JTextPane;
import java.awt.FlowLayout;
import javax.swing.JTextArea;
@SuppressWarnings("all")
public class SpaceAluno extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SpaceAluno frame = new SpaceAluno(new Aluno(null));
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
	public SpaceAluno(Aluno aluno){
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 554, 345);
		setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("Arquivo");
		menuBar.add(menu);
		
		JMenuItem mntmLogout = new JMenuItem("Logout");
		mntmLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Selection frame = new Selection();
				frame.setVisible(true);
				dispose();
			}
		});
		menu.add(mntmLogout);
		
		JMenuItem menuItem = new JMenuItem("Sair");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		menu.add(menuItem);
		
		JMenu mnDisciplina = new JMenu("Disciplina");
		menuBar.add(mnDisciplina);
		
		JMenuItem mntmCadastro = new JMenuItem("Cadastro");
		mntmCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CadDisc frame = new CadDisc(aluno);
				frame.setVisible(true);
			}
		});
		mnDisciplina.add(mntmCadastro);
		
		JMenuItem mntmTracamento = new JMenuItem("Tracamento");
		mntmTracamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TrancDisc frame = new TrancDisc(aluno);
				frame.setVisible(true);
			}
		});
		mnDisciplina.add(mntmTracamento);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblEspaoDoAluno = new JLabel("Espa\u00E7o do Aluno");
		contentPane.add(lblEspaoDoAluno, BorderLayout.NORTH);
		lblEspaoDoAluno.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblEspaoDoAluno.setHorizontalAlignment(SwingConstants.CENTER);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		JPanel panel_1 = new JPanel();
		scrollPane.setViewportView(panel_1);
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JLabel lblDisciplina = new JLabel(" ");
		panel_1.add(lblDisciplina, BorderLayout.NORTH);
		lblDisciplina.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblDisciplina.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 0, 445, 214);
		panel.add(scrollPane_1);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBounds(20, 11, 415, 191);
//		panel.add(panel_7);
		panel_7.setLayout(null);
		
		JButton btnSenha = new JButton("Senha");
		btnSenha.setBounds(10, 11, 106, 23);
		panel_7.add(btnSenha);
		
		JButton btnInformao = new JButton("Informa\u00E7\u00E3o");
		btnInformao.setBounds(10, 45, 106, 23);
		panel_7.add(btnInformao);
		
		JPanel panel_2 = new JPanel();
		scrollPane.setRowHeaderView(panel_2);
		panel_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{75, 0};
		gbl_panel_2.rowHeights = new int[]{45, 45, 45, 45, 40, 0, 0};
		gbl_panel_2.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		JButton btnDisciplina = new JButton("Disciplinas");
		btnDisciplina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblDisciplina.setText("Disciplinas");
				DefaultTableModel modelo = new DefaultTableModel();
				table = new JTable(modelo);
				scrollPane_1.setViewportView(table);
				modelo.addColumn("Código");
				modelo.addColumn("Nome");
				modelo.addColumn("Professor");
				modelo.addColumn("Semestre");
				modelo.addColumn("Situação");
				for(int i = aluno.getCurso().getQtdSemestres();	i>0; i--){
					ArrayList<Disciplina> lista = BancoDeDados.getDisciplinas(aluno.getCurso().getNome(),i);
					for(Disciplina d:lista){
						String situacao = BancoDeDados.getSituacao(d.getCodigo(), aluno.getCpf());
						modelo.addRow(new Object[]{d.getCodigo(),d.getNome(),d.getProfessor().getNome(),d.getSemestre(),situacao});
					}
				}
			}
		});
		GridBagConstraints gbc_btnDisciplina = new GridBagConstraints();
		gbc_btnDisciplina.fill = GridBagConstraints.BOTH;
		gbc_btnDisciplina.insets = new Insets(0, 0, 5, 0);
		gbc_btnDisciplina.gridx = 0;
		gbc_btnDisciplina.gridy = 0;
		panel_2.add(btnDisciplina, gbc_btnDisciplina);
		
		JButton btnRecados = new JButton("Recados");
		btnRecados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblDisciplina.setText("Recados");
				DefaultTableModel modelo = new DefaultTableModel();
				table = new JTable(modelo);
				scrollPane_1.setViewportView(table);
				
				//TODO retirar a parte de teste e descomentar esta parte
//				ArrayList<Recado> lista = BancoDeDados.getRecados(aluno);
//				modelo.addColumn("Recado");
//				modelo.addColumn("Data");
//				modelo.addColumn("Professor");
//				for(Recado c:lista){
//					modelo.addRow(new Object[]{c.getRecado(),c.getData(),c.getProfessor().getNome()});
//				}
				
					///teste
					modelo.addColumn("Recado");
					modelo.addColumn("Data");
					modelo.addColumn("Professor");
					for(int i = 0; i<20; i++){
						modelo.addRow(new Object[]{"Olar","12 do 03 de 2004", "João"});
						modelo.addRow(new Object[]{"Tudo bem","04 do 05 de 1967", "Maria"});
					}
			}
		});
		GridBagConstraints gbc_btnRecados = new GridBagConstraints();
		gbc_btnRecados.fill = GridBagConstraints.BOTH;
		gbc_btnRecados.insets = new Insets(0, 0, 5, 0);
		gbc_btnRecados.gridx = 0;
		gbc_btnRecados.gridy = 1;
		panel_2.add(btnRecados, gbc_btnRecados);
		
		JButton btnConta = new JButton("Conta");
		btnConta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblDisciplina.setText("Conta");
				panel.removeAll();
				panel.repaint();
				panel.add(panel_7);
			}
		});
		
		JButton btnHistrico = new JButton("Hist\u00F3rico");
		btnHistrico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblDisciplina.setText("Histórico");
				DefaultTableModel modelo = new DefaultTableModel();
				table = new JTable(modelo);
				scrollPane_1.setViewportView(table);
				
				//TODO retirar a parte de teste e descomentar esta parte
//				ArrayList<Nota> lista = BancoDeDados.getNotas(aluno);
//				modelo.addColumn("Disciplina");
//				modelo.addColumn("Nota");
//				for(Nota n:lista){
//					modelo.addRow(new Object[]{n.getDisciplina().getNome(),n.getNota()});
//				}
					///teste
					modelo.addColumn("Disciplina");
					modelo.addColumn("Nota");
					for(int i = 0; i<20; i++){
						modelo.addRow(new Object[]{"cs",9.99});
						modelo.addRow(new Object[]{"modelagem",8.25});
					}
			}
		});
		GridBagConstraints gbc_btnHistrico = new GridBagConstraints();
		gbc_btnHistrico.fill = GridBagConstraints.BOTH;
		gbc_btnHistrico.insets = new Insets(0, 0, 5, 0);
		gbc_btnHistrico.gridx = 0;
		gbc_btnHistrico.gridy = 2;
		panel_2.add(btnHistrico, gbc_btnHistrico);
		GridBagConstraints gbc_btnConta = new GridBagConstraints();
		gbc_btnConta.fill = GridBagConstraints.BOTH;
		gbc_btnConta.gridx = 0;
		gbc_btnConta.gridy = 5;
		panel_2.add(btnConta, gbc_btnConta);
	}
}
