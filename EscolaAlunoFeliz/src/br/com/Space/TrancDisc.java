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
public class TrancDisc extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	/**
	 * TODO Retirar main
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TrancDisc frame = new TrancDisc(new Aluno("NomeAluno", "cpf", "telefone", "Endere�o", "usuario", "senha", new Curso("NomeCurso",8), null));
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
	public TrancDisc(Aluno aluno) {
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

		JLabel lblDisciplina = new JLabel("Disciplinas");
		lblDisciplina.setFont(new Font("Traditional Arabic", Font.PLAIN, 16));
		lblDisciplina.setHorizontalAlignment(SwingConstants.CENTER);
		lblDisciplina.setBounds(10, 11, 91, 25);
		panel_1.add(lblDisciplina);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 54, 414, 169);
		contentPane.add(scrollPane);
		
		DefaultTableModel modelo = new DefaultTableModel();
		table = new JTable(modelo);
		scrollPane.setColumnHeaderView(table);
		
		ArrayList<Disciplina> lista = BancoDeDados.getDisciplinas(aluno);
		modelo.addColumn("C�digo");
		modelo.addColumn("Nome");
		modelo.addColumn("Professor");
		modelo.addColumn("Semestre");
		for(Disciplina d:lista){
			modelo.addRow(new Object[]{d.getCodigo(),d.getNome(),d.getProfessor().getNome(),d.getSemestre()});
		}
		
		JLabel lblDigiteOCdigo = new JLabel("Digite o codigo da disciplina que deseja trancar:");
		lblDigiteOCdigo.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblDigiteOCdigo.setBounds(10, 234, 286, 14);
		contentPane.add(lblDigiteOCdigo);
		
		textField = new JTextField();
		textField.setBounds(290, 234, 72, 14);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Disciplina d = BancoDeDados.getDisciplina(textField.getText());
				if(d!=null){
					JOptionPane.showConfirmDialog(null,
							BancoDeDados.inserir(new Solicitacao("Trancamento",aluno,d)),
							null,2);
				}
				else
					JOptionPane.showConfirmDialog(null, "C�digo incorreto!",null,2);
			}
		});
		btnNewButton.setBounds(372, 230, 52, 23);
		contentPane.add(btnNewButton);
		
		
	}
}
