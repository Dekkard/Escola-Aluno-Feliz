package br.com.Login;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.BadLocationException;

import br.com.ClassesInternas.Aluno;
import br.com.Conexao.BancoDeDados;
import br.com.Space.SpaceAluno;

import javax.swing.border.BevelBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("all")
public class LoginAluno extends JFrame {

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
					LoginAluno frame = new LoginAluno();
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
	public LoginAluno() {
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

		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Aluno aluno = BancoDeDados.loginAluno(textField.getText(),passwordField.getText());
				if( aluno != null ){
					SpaceAluno frame = new SpaceAluno(aluno);
					frame.setVisible(true);
					dispose();
				}
				else
					JOptionPane.showConfirmDialog(null, "Usuario ou Senha incorretos!", "Nao foi possivel fazer login", 2);
			}
		});
		btnEntrar.setBounds(67, 181, 89, 23);
		panel.add(btnEntrar);

		textField = new JTextField("");
		textField.setBounds(107, 110, 86, 20);
		panel.add(textField);
		textField.setColumns(10);

		passwordField = new JPasswordField("");
		passwordField.setBounds(107, 141, 86, 20);
		panel.add(passwordField);

		JLabel lblUsurio = new JLabel("Usu\u00E1rio");
		lblUsurio.setBounds(34, 113, 63, 14);
		panel.add(lblUsurio);

		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(34, 144, 63, 14);
		panel.add(lblSenha);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Selection frame = new Selection();
				frame.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(67, 215, 89, 23);
		panel.add(btnVoltar);

	}
}
