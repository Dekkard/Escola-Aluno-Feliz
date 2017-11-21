package br.com.ServidorCliente;

import java.io.*;
import java.net.*;
import java.util.*;

import br.com.ClassesInternas.Aluno;
import br.com.ClassesInternas.Curso;
import br.com.Conexão.BancoDeDados;
import br.com.Conexão.BancoDeDadosServer;

public class Servidor {

    public static void main(String[] args) throws IOException {
        // inicia o servidor
        new Servidor(12345).executa();
    }

    private int porta;
    private List<PrintStream> clientes;
	private ServerSocket servidor;

    public Servidor (int porta) {
        this.porta = porta;
        this.clientes = new ArrayList<PrintStream>();
    }

    public void executa () throws IOException {
        servidor = new ServerSocket(this.porta);
        System.out.println("Porta 12345 aberta!");

        while (true) {
            // aceita um cliente
            Socket cliente = servidor.accept();
            System.out.println("Nova conexão, cliente: " +
                cliente.getInetAddress().getHostAddress()
            );

            // adiciona saida do cliente à lista
            PrintStream ps = new PrintStream(cliente.getOutputStream());
            this.clientes.add(ps);

            // cria tratador de cliente numa nova thread
            TrataCliente tc =
                    new TrataCliente(cliente.getInputStream(), cliente.getOutputStream(), this);
            new Thread(tc).start();
        }
    }
    
    synchronized void executarSql(Scanner s, PrintStream e){
    	try{
	    	Integer opcao =Integer.parseInt(s.nextLine()); 
	    	switch (opcao){
	    		case 2250:
	    			System.out.println("2250");
	    			//TODO talvez retirar esse getCurso se ele for acessar o servidor de novo
	    			e.println(BancoDeDadosServer.inserir(new Aluno(s.nextLine(), s.nextLine(), s.nextLine(), s.nextLine(), s.nextLine(), s.nextLine(), BancoDeDados.getCurso(s.nextLine()), null)));
	    			break;
	    		case 2251:
	    			e.println(BancoDeDadosServer.inserir(new Curso(s.nextLine(), Integer.parseInt(s.nextLine()))));
	    			break;
	    		case 3000:
	    			System.out.println("3000");
	    			e.println(BancoDeDadosServer.loginAdm(s.nextLine(), s.nextLine()).toString());
	    			break;
	    		case 3001:
	    			System.out.println("3001");
	    			String[] as = BancoDeDadosServer.loginProfessor(s.nextLine(), s.nextLine());
	    			for (String string : as) {
	    				e.println(string);
					}
	    			break;
	    	};
    	}
    	finally{
    		notifyAll();
    	}
    }
}