package br.com.ServidorCliente;

import java.io.*;
import java.net.*;
import java.util.*;

import javax.swing.UIManager;

import br.com.Conexao.BancoDeDados;
import br.com.Login.Selection;

public class Cliente {
    public static void main(String[] args) throws UnknownHostException, IOException {
		UIManager.put("OptionPane.cancelButtonText", "Voltar");
		UIManager.put("OptionPane.noButtonText", "Excluir");
		UIManager.put("OptionPane.yesButtonText", "Atualizar");
		Selection frame = new Selection();
		frame.setVisible(true);

        // dispara cliente
		new Cliente(InetAddress.getLocalHost().getHostAddress(), 12345).executa(frame);
    }

    private String host;
    private int porta;

    public Cliente (String host, int porta) {
        this.host = host;
        this.porta = porta;
    }

    public void executa(Selection frame) throws UnknownHostException, IOException {
        Socket cliente = new Socket(this.host, this.porta);
        System.out.println("O cliente se conectou ao servidor!");

        Scanner entrada = new Scanner (cliente.getInputStream()); 
        // O banco de dados � respons�vel por mandar os c�digos para o servidor.
        BancoDeDados.setEntrada(entrada);
        BancoDeDados.setSaida(new PrintStream(cliente.getOutputStream()));
        
        while(frame.isEnabled());

        cliente.close();
    }
}