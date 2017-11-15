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
import br.com.ClassesInternas.Solicitação;
import br.com.Conexão.BancoDeDados;

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
		
		JPanel panel = new JPanel();
		panel.setBounds(296, 2, 135, 40);
		panel_1.add(panel);
		panel.setLayout(null);
		
		JLabel lblDisciplina = new JLabel("Disciplinas");
		lblDisciplina.setFont(new Font("Traditional Arabic", Font.PLAIN, 16));
		lblDisciplina.setHorizontalAlignment(SwingConstants.CENTER);
		lblDisciplina.setBounds(10, 11, 91, 25);
		panel_1.add(lblDisciplina);
		
		JLabel lblFiltro = new JLabel("Filtro");
		lblFiltro.setHorizontalAlignment(SwingConstants.CENTER);
		lblFiltro.setBounds(111, 16, 46, 14);
		panel_1.add(lblFiltro);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 54, 414, 201);
		contentPane.add(scrollPane);
		
		DefaultTableModel modelo = new DefaultTableModel();
		table = new JTable(modelo);
		scrollPane.setColumnHeaderView(table);
			
		ArrayList<Curso> listaCursos = BancoDeDados.getCursos();		
		String[] cursos = new String[1+listaCursos.size()];
		cursos[0] = "Curso";
		int i = 1;
		for (Curso c : listaCursos) {
			cursos[i] = c.getNome();
			i++;
		}
		
		JComboBox comboBox_1 = new JComboBox(cursos);
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (Curso curso : listaCursos) {
					if( comboBox_1.getSelectedItem().equals(curso.getNome())){
						panel.removeAll();
						
						String[] sem = new String[1+curso.getQtdSemestres()];
						sem[0] = "Semestre";
						for(int i = 1; i<sem.length; i++){
							sem[i] = "" + (i) +"º Semestre";
						}
						JComboBox comboBox = new JComboBox(sem);
						comboBox.setSelectedIndex(0);
						comboBox.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								for(int i = 1; i<sem.length; i++){
									if(comboBox.getSelectedItem().equals(sem[i])){
										DefaultTableModel modelo = new DefaultTableModel();
										table = new JTable(modelo);
										scrollPane.setViewportView(table);
										
										ArrayList<Disciplina> lista = BancoDeDados.getDisciplinas(curso.getNome(),i);
										modelo.addColumn("Código");
										modelo.addColumn("Nome");
										modelo.addColumn("Professor");
										for(Disciplina d:lista){
											modelo.addRow(new Object[]{d.getCodigo(),d.getNome(),d.getProfessor().getNome()});
										}
									}
								}
							}
						});
						comboBox.setBounds(2, 12, 130, 23);
						panel.add(comboBox);
					break;
					}
				}
				
				
			}
		});
		comboBox_1.setSelectedIndex(0);
		comboBox_1.setBounds(150, 15, 141, 20);
		panel_1.add(comboBox_1);
	}
}
