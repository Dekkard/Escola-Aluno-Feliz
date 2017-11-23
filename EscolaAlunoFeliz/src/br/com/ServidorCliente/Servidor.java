package br.com.ServidorCliente;

import java.io.*;
import java.net.*;
import java.util.*;

import br.com.ClassesInternas.Aluno;
import br.com.ClassesInternas.Curso;
import br.com.ClassesInternas.Disciplina;
import br.com.ClassesInternas.Professor;
import br.com.ClassesInternas.Recado;
import br.com.ClassesInternas.Solicitacao;
import br.com.Conexao.BancoDeDadosServer;

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
            System.out.println("Nova conexao, cliente: " +
                cliente.getInetAddress().getHostAddress()
            );

            // adiciona saida do cliente na lista
            PrintStream ps = new PrintStream(cliente.getOutputStream());
            this.clientes.add(ps);

            // cria tratador de cliente numa nova thread
            TrataCliente tc =
                    new TrataCliente(cliente.getInputStream(), cliente.getOutputStream(), this, cliente.getInetAddress().getHostAddress());
            new Thread(tc).start();
        }
    }
    
    public synchronized void executarSql(Scanner s, PrintStream e){
    	String sst = s.nextLine();
		System.out.println(sst);
    	Integer opcao =Integer.parseInt(sst); 
    	switch (opcao){
    		case 2250:
    			System.out.println("2250");
    			//new Aluno(nome, cpf, telefone, endereco, usuario, senha, codigoCurso, disciplinas)
    			e.println(BancoDeDadosServer.inserir(new Aluno(s.nextLine(), s.nextLine(), s.nextLine(), s.nextLine(), s.nextLine(), s.nextLine(), s.nextLine(), null)));
    			break;
    		case 2251:
    			System.out.println("2251");
    			//new Curso(nome, qtdSemestres)
    			e.println(BancoDeDadosServer.inserir(new Curso(s.nextLine(), Integer.parseInt(s.nextLine()))));
    			break;
    		case 2252:
    			System.out.println("2252");
    			//new Disciplina(codigo, nome, professor, curso, semestre)
    			e.println(BancoDeDadosServer.inserir(new Disciplina(s.nextLine(), s.nextLine(), BancoDeDadosServer.getProfessor(s.nextLine()), BancoDeDadosServer.getCurso(s.nextLine()), Integer.parseInt(s.nextLine()) )));
    			break;
    		case 2253:
    			System.out.println("2253");
//	    			new Recado(codigo, recado, data, aluno, professor)
    			e.println(BancoDeDadosServer.inserir(new Recado(s.nextLine(), s.nextLine(), s.nextLine(),  BancoDeDadosServer.getAluno(s.nextLine()), BancoDeDadosServer.getProfessor(s.nextLine()) )));
    			break;
    		case 2254:
    			System.out.println("2254");
//	    			new Professor(nome, cpf, telefone, endereco, valorHora, codigo, formacao, usuario, senha)
    			e.println(BancoDeDadosServer.inserir(new Professor(s.nextLine(), s.nextLine(), s.nextLine(), s.nextLine(), Double.parseDouble(s.nextLine()), s.nextLine(), s.nextLine(), s.nextLine(), s.nextLine() )));
    			break;
    		case 2255:
    			System.out.println("2255");
//	    			new Aluno(nome, cpf, telefone, endereco, usuario, senha, coigoCurso)
    			e.println(BancoDeDadosServer.atualizar(new Aluno(s.nextLine(), s.nextLine(), s.nextLine(), s.nextLine(), s.nextLine(), s.nextLine(), s.nextLine() )));
    			break;
    		case 2256:
    			System.out.println("2256");
    			e.println(BancoDeDadosServer.excluirAluno(s.nextLine()));
    			break;
    		case 2257:
    			System.out.println("2257");
//	    			new Professor(nome, cpf, telefone, endereco, valorHora, codigo, formacao, usuario, senha)
    			e.println(BancoDeDadosServer.atualizar(new Professor(s.nextLine(), s.nextLine(), s.nextLine(), s.nextLine(), Double.parseDouble(s.nextLine()), s.nextLine(), s.nextLine(), s.nextLine(), s.nextLine() )));
    			break;
    		case 2258:
    			System.out.println("2258");
    			e.println(BancoDeDadosServer.excluirProfessor(s.nextLine()));
    			break;
    		case 2259:
    			System.out.println("2259");
    			e.println(BancoDeDadosServer.excluirRecado(s.nextLine()));
    			break;
    		case 2260:
    			System.out.println("2260");
    			ArrayList<String[]> arrays = BancoDeDadosServer.getSolicitacoes();
    			if(arrays != null){
    				e.println(arrays.size());
	    			for (String[] strings : arrays) {
	    				for (String st : strings) {
		    				e.println(st);
						}
					}
    			}
    			else
    				e.println("false");
    			break;
    		case 2261:
    			System.out.println("2261");
//    			new Solicitacao(codigo, tipo, data, cpfAluno, codigoDisciplina)
    			e.println(BancoDeDadosServer.matricular(new Solicitacao(s.nextLine(),s.nextLine(),s.nextLine(),s.nextLine(),s.nextLine())));
    			break;
    		case 2262:
    			System.out.println("2262");
    			e.println(BancoDeDadosServer.excluirSolicitacao(s.nextLine()));
    			break;
    		case 2263:
    			System.out.println("2263");
    			String[] aas = BancoDeDadosServer.getSolicitacao(s.nextLine());
    			for (String string : aas) {
    				e.println(string);
				}
    			break;
    		case 2264:
    			System.out.println("2264");
    			e.println(BancoDeDadosServer.mudarSituacaoMatricula(s.nextLine(),s.nextLine(),s.nextLine()));
    			break;
    		case 2265:
    			System.out.println("2265");
    			e.println(BancoDeDadosServer.existeSolicitacao(s.nextLine()).toString());
    			break;
    		case 3000:
    			System.out.println("3000");
    			e.println(BancoDeDadosServer.loginAdm(s.nextLine(), s.nextLine()).toString());
    			break;
    		case 3001:
    			System.out.println("3001");
    			String[] p =BancoDeDadosServer.getProfessor(s.nextLine(),s.nextLine());
    			if (p != null)
	    			for (String string : p) {
	    				e.println(string);
					}
    			else e.println("false");
    			break;
    		case 3002:
    			System.out.println("3002");
    			String[] a = BancoDeDadosServer.getAluno(s.nextLine(), s.nextLine());
    			if (a != null)
	    			for (String string : a) {
	    				e.println(string);
					}
    			else e.println("false");
    			break;
    	}
    }
}