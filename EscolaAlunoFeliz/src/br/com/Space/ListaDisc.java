package br.com.Space;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import br.com.ClassesInternas.Aluno;
import br.com.ClassesInternas.Curso;
import br.com.ClassesInternas.Disciplina;
import br.com.ClassesInternas.Professor;
import br.com.ClassesInternas.Solicitacao;
import br.com.Conexao.BancoDeDados;

import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JTextArea;
import java.awt.Window.Type;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
@SuppressWarnings("all")
public class ListaDisc extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField txtEntrada;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListaDisc frame = new ListaDisc();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ListaDisc() {
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setBounds(0, 0, 434, 43);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 54, 414, 201);
		contentPane.add(scrollPane);
		
		JPanel panel = new JPanel();
		panel.setBounds(164, 3, 270, 33);
		panel_1.add(panel);
		panel.setLayout(null);
		
		JLabel lblFiltro = new JLabel("CPF do aluno: ");
		lblFiltro.setBounds(0, 14, 108, 14);
//		panel.add(lblFiltro);
		lblFiltro.setHorizontalAlignment(SwingConstants.CENTER);
		
		txtEntrada = new JTextField();
		txtEntrada.setBounds(118, 11, 90, 20);
//		panel.add(txtEntrada);
		txtEntrada.setColumns(10);
		
		JButton btnCPF = new JButton("OK");
		btnCPF.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnCPF.setBounds(210, 10, 50, 23);
//		panel.add(btnCPF);
		
		JLabel lblCodigo = new JLabel("Codigo da disciplina: ");
		lblCodigo.setBounds(0, 14, 120, 14);
//		panel.add(lblCodigo);
		lblCodigo.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton btnCodigo = new JButton("OK");
		btnCodigo.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnCodigo.setBounds(210, 10, 50, 23);
//		panel.add(btnCodigo);
		
		String[] s = {"Buscar Disciplinas","Por aluno", "Por c�digo"};
		JComboBox comboBox = new JComboBox(s);
		comboBox.setBounds(10, 3, 147, 33);
		panel_1.add(comboBox);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedIndex() == 1){
					panel.removeAll();
					panel.add(txtEntrada);
					panel.add(btnCPF);
					panel.add(lblFiltro);
					panel.repaint();
				}
				else if(comboBox.getSelectedIndex() == 2){
					panel.removeAll();
					panel.add(txtEntrada);
					panel.add(btnCodigo);
					panel.add(lblCodigo);
					panel.repaint();
				}
			};
		});
		
		btnCPF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Aluno a = BancoDeDados.getAluno(txtEntrada.getText());
				if(a!=null){
					ArrayList<Disciplina> lista = BancoDeDados.getDisciplinas(a);
					DefaultTableModel modelo = new DefaultTableModel();
					table = new JTable(modelo);
					scrollPane.setViewportView(table);
					modelo.addColumn("C�digo");
					modelo.addColumn("Nome");
					modelo.addColumn("Professor");
					for(Disciplina d:lista){
						modelo.addRow(new Object[]{d.getCodigo(),d.getNome(),d.getProfessor().getNome()});
					}
				}
				else
					JOptionPane.showConfirmDialog(null, "CPF incorreto!",null,2);
			}
		});
		
		btnCodigo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Disciplina d = BancoDeDados.getDisciplina(txtEntrada.getText());
				if(d!=null){
					DefaultTableModel modelo = new DefaultTableModel();
					table = new JTable(modelo);
					scrollPane.setViewportView(table);
					modelo.addColumn("C�digo");
					modelo.addColumn("Nome");
					modelo.addColumn("Professor");
					modelo.addRow(new Object[]{d.getCodigo(),d.getNome(),d.getProfessor().getNome()});
				}
				else
					JOptionPane.showConfirmDialog(null, "C�digo incorreto!",null,2);
			}
		});
	}
}
