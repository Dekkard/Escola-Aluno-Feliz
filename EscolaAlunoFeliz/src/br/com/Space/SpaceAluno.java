package br.com.Space;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

import br.com.Conexao.BancoDeDados;
import br.com.Login.Selection;
import br.com.ClassesInternas.*;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
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
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;


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
		
		JLabel lblEspaoDoAluno = new JLabel("Espaco do Aluno");
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
		
		JPanel panel_3 = new JPanel();
		
		JButton btnSenha = new JButton("Senha");
		btnSenha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel_7.repaint();
				panel_7.add(panel_3);
			}
		});
		btnSenha.setBounds(10, 11, 106, 23);
		panel_7.add(btnSenha);
		
//		JPanel panel_3 = new JPanel();
		panel_3.setBounds(126, 11, 279, 169);
//		panel_7.add(panel_3);
		panel_3.setLayout(null);
		
		
		JLabel lblSenhaNova = new JLabel("Senha Nova");
		lblSenhaNova.setHorizontalAlignment(SwingConstants.CENTER);
		lblSenhaNova.setBounds(24, 45, 102, 14);
		panel_3.add(lblSenhaNova);

		JLabel lblConfirmarSenha = new JLabel("Confirmar Senha");
		lblConfirmarSenha.setHorizontalAlignment(SwingConstants.CENTER);
		lblConfirmarSenha.setBounds(24, 68, 102, 14);
		panel_3.add(lblConfirmarSenha);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(136, 42, 121, 20);
		panel_3.add(passwordField);

		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(136, 65, 121, 20);
		panel_3.add(passwordField_1);

		JButton btnTrocarSenha = new JButton("Trocar Senha");
		btnTrocarSenha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (passwordField.getText().equals(passwordField_1.getText())) {
					JOptionPane.showConfirmDialog(null, BancoDeDados.alunoTrocaSenha(passwordField.getText(), aluno.getUsuario(), aluno.getSenha()),
							"Resultado", 2);
				} else {
					JOptionPane.showConfirmDialog(null, "A senha digitada deve ser igual!",
							"N�o foi poss�vel trocar a senha", 2);
				}
			}
		});
		btnTrocarSenha.setBounds(99, 93, 105, 23);
		panel_3.add(btnTrocarSenha);
		
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
				modelo.addColumn("Codigo");
				modelo.addColumn("Nome");
				modelo.addColumn("Professor");
				modelo.addColumn("Semestre");
				modelo.addColumn("Situacao");
				for(int i = BancoDeDados.getCurso(aluno.getNomeCurso()).getQtdSemestres();	i>0; i--){
					ArrayList<Disciplina> lista = BancoDeDados.getDisciplinas(aluno.getNomeCurso(),i);
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
				
				ArrayList<Recado> lista = BancoDeDados.getRecados(aluno);
				modelo.addColumn("Recado");
				modelo.addColumn("Data");
				modelo.addColumn("Professor");
				if (lista!= null){
					for(Recado c:lista){
						modelo.addRow(new Object[]{c.getRecado(),c.getData(),BancoDeDados.getProfessor(c.getCodigoProfessor()).getNome()});
					}
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
		
		JButton btnHistrico = new JButton("Historico");
		btnHistrico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblDisciplina.setText("Historico");
				DefaultTableModel modelo = new DefaultTableModel();
				table = new JTable(modelo);
				scrollPane_1.setViewportView(table);
				
				ArrayList<Nota> lista = BancoDeDados.getNotas(aluno);
				modelo.addColumn("Disciplina");
				modelo.addColumn("Nota");
				if( lista != null){
					for(Nota n:lista){
						modelo.addRow(new Object[]{n.getDisciplina().getNome(),n.getNota()});
					}
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
