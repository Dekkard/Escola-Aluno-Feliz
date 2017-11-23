package br.com.Login;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import br.com.ClassesInternas.Aluno;
import br.com.ClassesInternas.Professor;
import br.com.Conexao.BancoDeDados;
import br.com.Space.SpaceProf;
@SuppressWarnings("all")
public class LoginProf extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginProf frame = new LoginProf();
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
	public LoginProf() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 250, 320);
		setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("Arquivo");
		menuBar.add(menu);
		
		JMenuItem menuItem = new JMenuItem("Sair");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		menu.add(menuItem);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setBounds(34, 11, 159, 75);
		panel.add(panel_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(107, 110, 86, 20);
		panel.add(textField);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(107, 141, 86, 20);
		panel.add(passwordField);
		
		JLabel label = new JLabel("Senha");
		label.setBounds(34, 144, 63, 14);
		panel.add(label);
		
		JLabel label_1 = new JLabel("Usu\u00E1rio");
		label_1.setBounds(34, 113, 63, 14);
		panel.add(label_1);
		
		JButton button = new JButton("Entrar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Professor prof = BancoDeDados.loginProfessor(textField.getText(),passwordField.getText());
				if( prof != null ){
					SpaceProf frame = new SpaceProf(prof);
					frame.setVisible(true);
					dispose();
				}
				else
					JOptionPane.showConfirmDialog(null, "Usuario ou Senha incorretos!", "Nao foi possivel fazer login", 2);
			}
		});
		button.setBounds(67, 181, 89, 23);
		panel.add(button);
		
		JButton button_1 = new JButton("Voltar");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Selection frame = new Selection();
				frame.setVisible(true);
				dispose();
			}
		});
		button_1.setBounds(67, 215, 89, 23);
		panel.add(button_1);
	}

}
