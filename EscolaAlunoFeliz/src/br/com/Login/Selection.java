package br.com.Login;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import br.com.Conexao.BancoDeDados;
import br.com.ServidorCliente.Cliente;
@SuppressWarnings("all")
public class Selection extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	public static void main(String[] args) throws UnknownHostException, IOException {
		UIManager.put("OptionPane.cancelButtonText", "Voltar");
		UIManager.put("OptionPane.noButtonText", "Excluir");
		UIManager.put("OptionPane.yesButtonText", "Atualizar");
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Selection frame = new Selection();
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
	public Selection() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 250, 320);
		setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnArquivo = new JMenu("Arquivo");
		menuBar.add(mnArquivo);
		
		JMenuItem mntmSair = new JMenuItem("Sair");
		mntmSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		mnArquivo.add(mntmSair);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton btnAluno = new JButton("Aluno");
		btnAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginAluno frame = new LoginAluno();
				frame.setVisible(true);
				dispose();
			}
		});
		btnAluno.setBounds(53, 123, 120, 23);
		panel.add(btnAluno);
		
		JButton btnProfessor = new JButton("Professor");
		btnProfessor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginProf frame = new LoginProf();
				frame.setVisible(true);
				dispose();
			}
		});
		btnProfessor.setBounds(53, 157, 119, 23);
		panel.add(btnProfessor);
		
		JButton btnAdministrador = new JButton("Administrador");
		btnAdministrador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginAdm frame = new LoginAdm();
				frame.setVisible(true);
				dispose();
			}
		});
		btnAdministrador.setBounds(53, 191, 119, 23);
		panel.add(btnAdministrador);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setBounds(34, 11, 159, 75);
		panel.add(panel_1);
		
	}
}
