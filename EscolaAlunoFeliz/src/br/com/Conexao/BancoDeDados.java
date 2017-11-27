package br.com.Conexao;

import java.io.PrintStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

import br.com.ClassesInternas.*;

public class BancoDeDados {

	private static PrintStream saida;
	private static Scanner entrada;

	public static void setSaida(PrintStream saida) {
		BancoDeDados.saida = saida;
	}

	public static void setEntrada(Scanner entrada) {
		BancoDeDados.entrada = entrada;
	}

	public static String inserir(Aluno a, String usuario, String senha) {
		try {
			if (BancoDeDados.loginAdm(usuario, senha)) {
				saida.println("2250");
				saida.println(a.getNome());
				saida.println(a.getCpf());
				saida.println(a.getTelefone());
				saida.println(a.getEndereco());
				saida.println(a.getUsuario());
				saida.println(a.getSenha());
				saida.println(a.getNomeCurso());
				while (!entrada.hasNextLine())
					;
				return entrada.nextLine();
			} else
				return "Erro de Login";
		} catch (NullPointerException e) {
			JOptionPane.showConfirmDialog(null, "Erro na conexao com o servidor", "Erro", 2);
			System.exit(-1);
			return "";
		}
	}

	public static String inserir(Curso c, String usuario, String senha){
		try {
			if (BancoDeDados.loginAdm(usuario, senha)) {
//				new Curso(nome, qtdSemestres)
				saida.println("2251");
				saida.println(c.getNome());
				saida.println(c.getQtdSemestres());
				while (!entrada.hasNextLine());
				return entrada.nextLine();
			} else
				return "Erro de Login";
		} catch (NullPointerException e) {
			JOptionPane.showConfirmDialog(null, "Erro na conexao com o servidor", "Erro", 2);
			System.exit(-1);
			return "";
		}
	}

	public static String inserir(Disciplina d, String usuario, String senha) {
		try {
			if (BancoDeDados.loginAdm(usuario, senha)) {
//				new Disciplina(codigo, nome, professor, curso, semestre)
				saida.println("2252");
				saida.println(d.getCodigo());
				saida.println(d.getNome());
				saida.println(d.getProfessor().getCodigo());
				saida.println(d.getCurso().getNome());
				saida.println(d.getSemestre());
				while (!entrada.hasNextLine());
				return entrada.nextLine();
			} else
				return "Erro de Login";
		} catch (NullPointerException e) {
			JOptionPane.showConfirmDialog(null, "Erro na conexao com o servidor", "Erro", 2);
			System.exit(-1);
			return "";
		}
	}

	public static String inserir(Recado r, String usuario, String senha) {
		try {
			if (BancoDeDados.loginAdm(usuario, senha)) {
//				new Recado(codigo, recado, data, aluno, professor)
				saida.println("2253");
				saida.println(r.getCodigo());
				saida.println(r.getRecado());
				saida.println(r.getData());
				saida.println(r.getCpfAluno());
				saida.println(r.getCodigoProfessor());
				while (!entrada.hasNextLine());
				return entrada.nextLine();
			} else
				return "Erro de Login";
		} catch (NullPointerException e) {
			JOptionPane.showConfirmDialog(null, "Erro na conexao com o servidor", "Erro", 2);
			System.exit(-1);
			return "";
		}
	}

	public static String inserir(Professor p, String usuario, String senha){
		try {
			if (BancoDeDados.loginAdm(usuario, senha)) {
//    			new Professor(nome, cpf, telefone, endereco, valorHora, codigo, formacao, usuario, senha)
				saida.println("2254");
				saida.println(p.getNome());
				saida.println(p.getCpf());
				saida.println(p.getTelefone());
				saida.println(p.getEndereco());
				saida.println(p.getValorHora());
				saida.println(p.getCodigo());
				saida.println(p.getFormacao());
				saida.println(p.getUsuario());
				saida.println(p.getSenha());
				while (!entrada.hasNextLine());
				return entrada.nextLine();
			} else
				return "Erro de Login";
		} catch (NullPointerException e) {
			JOptionPane.showConfirmDialog(null, "Erro na conexao com o servidor", "Erro", 2);
			System.exit(-1);
			return "";
		}
	}

	public static String inserir(Nota nota) {
		// verificar se esta correto
		String sql = "insert into matriculaDisciplina (aluno_cpf,disciplina_codigo,nota) values (?,?,?)";
		Connection con = ConnectionFactory.getConnection();

		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, nota.getAluno().getCpf());
			pst.setString(2, nota.getDisciplina().getCodigo());
			pst.setDouble(3, nota.getNota());
			int res = pst.executeUpdate();
			if (res > 0) {
				return "Inserido com sucesso.";
			} else {
				return "Erro ao inserir.";
			}
		} catch (SQLException e) {
			return e.getMessage();
		} finally {
			ConnectionFactory.close(con);
		}
	}

	public static String inserir(Solicitacao s) {
		String sql = "insert into solicitacao (tipo,data,aluno_cpf,disciplina_codigo) values (?,?,?,?)";
		Connection con = ConnectionFactory.getConnection();

		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, s.getTipo());
			pst.setString(2, s.getData());
			pst.setString(3, s.getCpfAluno());
			pst.setString(4, s.getCodigoDisciplina());
			int res = pst.executeUpdate();
			if (res > 0) {
				return "Foi enviado uma solicitacao ao administrador do sistema para que ele te " + s.getTipo()
						+ " na disciplina!";
			} else {
				return "Erro ao criar solicitacao!";
			}
		} catch (SQLException e) {
			return e.getMessage();
		} finally {
			ConnectionFactory.close(con);
		}
	}

	public static String matricular(Solicitacao s, String usuario, String senha) {
		try {
			if (BancoDeDados.loginAdm(usuario, senha)) {
//				new Solicitacao(codigo, tipo, data, cpfAluno, codigoDisciplina)
				saida.println("2261");
				saida.println(s.getCodigo());
				saida.println(s.getTipo());
				saida.println(s.getData());
				saida.println(s.getCpfAluno());
				saida.println(s.getCodigoDisciplina());
				while (!entrada.hasNextLine());
				return entrada.nextLine();
			} else
				return "Erro de Login";
		} catch (NullPointerException e) {
			JOptionPane.showConfirmDialog(null, "Erro na conexao com o servidor", "Erro", 2);
			System.exit(-1);
			return "";
		}
	}

	// Muda situacao da matricula: Em curso, Trancado, Aprovado
	public static String mudarSituacaoMatricula(Solicitacao solicitacao, String situacao, String usuario, String senha) {
		try {
			if (BancoDeDados.loginAdm(usuario, senha)) {
				saida.println("2264");
				saida.println(solicitacao.getCodigoDisciplina());
				saida.println(solicitacao.getCpfAluno());
				saida.println(situacao);
				while (!entrada.hasNextLine())
					;
				return entrada.nextLine();
			} else
				return "Erro de Login";
		} catch (NullPointerException e) {
			JOptionPane.showConfirmDialog(null, "Erro na conexao com o servidor", "Erro", 2);
			System.exit(-1);
			return "";
		}
	}

	public static Boolean existeAluno(String cpfAluno, String usuario, String senha) {
		try {
			if (BancoDeDados.loginAdm(usuario, senha)) {
				saida.println("2267");
				saida.println(cpfAluno);
				while (!entrada.hasNextLine())
					;
				if (entrada.nextLine().equals("true"))
					return true;
			} else
				JOptionPane.showConfirmDialog(null, "Erro de login", "Erro", 2);
		} catch (NullPointerException e) {
			JOptionPane.showConfirmDialog(null, "Erro na conexao com o servidor", "Erro", 2);
			System.exit(-1);
		}

		return false;
	}

	public static Boolean existeProfessor(String codigoProfessor, String usuario, String senha) {
		try {
			if (BancoDeDados.loginAdm(usuario, senha)) {
				saida.println("2268");
				saida.println(codigoProfessor);
				while (!entrada.hasNextLine())
					;
				if (entrada.nextLine().equals("true"))
					return true;
			} else
				JOptionPane.showConfirmDialog(null, "Erro de login", "Erro", 2);
		} catch (NullPointerException e) {
			JOptionPane.showConfirmDialog(null, "Erro na conexao com o servidor", "Erro", 2);
			System.exit(-1);
		}

		return false;
	}

	public static Boolean existeCurso(String nomeCurso, String usuario, String senha) {
		try {
			if (BancoDeDados.loginAdm(usuario, senha)) {
				saida.println("2266");
				saida.println(nomeCurso);
				while (!entrada.hasNextLine())
					;
				if (entrada.nextLine().equals("true"))
					return true;
			} else
				JOptionPane.showConfirmDialog(null, "Erro de login", "Erro", 2);
		} catch (NullPointerException e) {
			JOptionPane.showConfirmDialog(null, "Erro na conexao com o servidor", "Erro", 2);
			System.exit(-1);
		}

		return false;
	}

	public static Boolean existeSolicitacao(String codigo, String usuario, String senha) {
		try {
			if (BancoDeDados.loginAdm(usuario, senha)) {
				saida.println("2265");
				saida.println(codigo);
				while (!entrada.hasNextLine())
					;
				if (entrada.nextLine().equals("true"))
					return true;
			} else
				JOptionPane.showConfirmDialog(null, "Erro de login", "Erro", 2);
		} catch (NullPointerException e) {
			JOptionPane.showConfirmDialog(null, "Erro na conexao com o servidor", "Erro", 2);
			System.exit(-1);
		}

		return false;
	}

	public static Boolean existeMatricula(Solicitacao s, String usuario, String senha) {
		try {
			if (BancoDeDados.loginAdm(usuario, senha)) {
				saida.println("2269");
				saida.println(s.getCodigoDisciplina());
				saida.println(s.getCpfAluno());
				while (!entrada.hasNextLine())
					;
				if (entrada.nextLine().equals("true"))
					return true;
			} else
				JOptionPane.showConfirmDialog(null, "Erro de login", "Erro", 2);
		} catch (NullPointerException e) {
			JOptionPane.showConfirmDialog(null, "Erro na conexao com o servidor", "Erro", 2);
			System.exit(-1);
		}

		return false;
	}

	public static String atualizar(Aluno a, String usuario, String senha) {
		try {
			if (BancoDeDados.loginAdm(usuario, senha)) {
				saida.println("2255");
				saida.println(a.getNome());
				saida.println(a.getCpf());
				saida.println(a.getTelefone());
				saida.println(a.getEndereco());
				saida.println(a.getUsuario());
				saida.println(a.getSenha());
				saida.println(a.getNomeCurso());
				while (!entrada.hasNextLine())
					;
				return entrada.nextLine();
			} else
				return "Erro de Login";
		} catch (NullPointerException e) {
			JOptionPane.showConfirmDialog(null, "Erro na conexao com o servidor", "Erro", 2);
			System.exit(-1);
			return "";
		}
	}

	public static String atualizar(Professor p, String usuario, String senha) {
		try {
			if (BancoDeDados.loginAdm(usuario, senha)) {
				saida.println("2257");
//				new Professor(nome, cpf, telefone, endereco, valorHora, codigo, formacao, usuario, senha)
				saida.println(p.getNome());
				saida.println(p.getCpf());
				saida.println(p.getTelefone());
				saida.println(p.getEndereco());
				saida.println(p.getValorHora());
				saida.println(p.getCodigo());
				saida.println(p.getFormacao());
				saida.println(p.getUsuario());
				saida.println(p.getSenha());
				while (!entrada.hasNextLine())
					;
				return entrada.nextLine();
			} else
				return "Erro de Login";
		} catch (NullPointerException e) {
			JOptionPane.showConfirmDialog(null, "Erro na conexao com o servidor", "Erro", 2);
			System.exit(-1);
			return "";
		}
	}

	public static String excluir(Aluno a, String usuario, String senha) {
		try {
			if (BancoDeDados.loginAdm(usuario, senha)) {
				saida.println("2256");
				saida.println(a.getCpf());
				while (!entrada.hasNextLine())
					;
				return entrada.nextLine();
			} else
				return "Erro de Login";
		} catch (NullPointerException e) {
			JOptionPane.showConfirmDialog(null, "Erro na conexao com o servidor", "Erro", 2);
			System.exit(-1);
			return "";
		}
	}

	public static String excluir(Professor p, String usuario, String senha) {
		try {
			if (BancoDeDados.loginAdm(usuario, senha)) {
				saida.println("2258");
				saida.println(p.getCodigo());
				while (!entrada.hasNextLine())
					;
				return entrada.nextLine();
			} else
				return "Erro de Login";
		} catch (NullPointerException e) {
			JOptionPane.showConfirmDialog(null, "Erro na conexao com o servidor", "Erro", 2);
			System.exit(-1);
			return "";
		}
	}

	public static String excluir(Recado recado, String usuario, String senha) {
		try {
			if (BancoDeDados.loginAdm(usuario, senha)) {
				saida.println("2258");
				saida.println(recado.getCodigo());
				while (!entrada.hasNextLine());
				return entrada.nextLine();
			} else
				return "Erro de Login";
		} catch (NullPointerException e) {
			JOptionPane.showConfirmDialog(null, "Erro na conexao com o servidor", "Erro", 2);
			System.exit(-1);
			return "";
		}
	}
	
	public static String excluir(String codigoSolicitacao, String usuario, String senha) {
		try {
			if (BancoDeDados.loginAdm(usuario, senha)) {
				saida.println("2262");
				saida.println(codigoSolicitacao);
				while (!entrada.hasNextLine());
				return entrada.nextLine();
			} else
				return "Erro de Login";
		} catch (NullPointerException e) {
			JOptionPane.showConfirmDialog(null, "Erro na conexao com o servidor", "Erro", 2);
			System.exit(-1);
			return "";
		}
	}

	public static Disciplina getDisciplina(String codigoDisciplina) {
		String sql = "select * from disciplina where codigo = ? ";
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, codigoDisciplina);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				Disciplina d = new Disciplina(rs.getString(1), rs.getString(2),
						BancoDeDados.getProfessor(rs.getString(3)), BancoDeDados.getCurso(rs.getString(4)),
						rs.getInt(5));
				return d;
			} else
				return null;
		} catch (SQLException e) {
			return null;
		} finally {
			ConnectionFactory.close(con);
		}
	}

	public static ArrayList<Disciplina> getDisciplinas(Aluno a) {
		ArrayList<Disciplina> disciplinas = new ArrayList<>();
		String sql = "select * from Disciplina inner join matriculaDisciplina on disciplina.codigo = matriculaDisciplina.disciplina_codigo where matriculaDisciplina.aluno_cpf = ? ";
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, a.getCpf());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				Disciplina d = new Disciplina(rs.getString(1), rs.getString(2),
						BancoDeDados.getProfessor(rs.getString(3)), BancoDeDados.getCurso(rs.getString(4)),
						rs.getInt(5));
				disciplinas.add(d);
			}
		} catch (SQLException e) {
			return null;
		} finally {
			ConnectionFactory.close(con);
		}
		return disciplinas;
	}

	public static ArrayList<Disciplina> getDisciplinas(Professor prof) {
		ArrayList<Disciplina> ad = new ArrayList<>();
		return ad;
	}

	public static ArrayList<Disciplina> getDisciplinas(String nomeCurso, int semestre) {
		ArrayList<Disciplina> disciplinas = new ArrayList<>();
		String sql = "select * from Disciplina where curso_nome = ? AND semestre = ?";
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, nomeCurso);
			pst.setInt(2, semestre);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				// TODO terminar os gets
				Disciplina d = new Disciplina(rs.getString(1), rs.getString(2),
						BancoDeDados.getProfessor(rs.getString(3)), BancoDeDados.getCurso(rs.getString(4)),
						rs.getInt(5));
				disciplinas.add(d);
			}
		} catch (SQLException e) {
			System.exit(-1);
		} finally {
			ConnectionFactory.close(con);
		}
		return disciplinas;
	}

	//Nao precisa de senha
	public static Professor getProfessor(String codigo) {
		String sql = "select * from professor where codigo = ? ";
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, codigo);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				Professor p = new Professor(rs.getString(2), rs.getString(1), rs.getString(4), rs.getString(3),
						rs.getDouble(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));
				return p;
			} else
				return null;
		} catch (SQLException e) {
			return null;
		} finally {
			ConnectionFactory.close(con);
		}
	}

	//TODO nao usado mais
	public static Aluno getAluno(String cpf) {
		String sql = "select * from aluno where cpf = ? ";
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, cpf);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				Aluno a = new Aluno(rs.getString(2), rs.getString(1), rs.getString(4), rs.getString(3), rs.getString(6),
						rs.getString(7), rs.getString(5));
				return a;
			} else
				return null;
		} catch (SQLException e) {
			return null;
		} finally {
			ConnectionFactory.close(con);
		}
	}

	//TODO nao usado mais
	public static Curso getCurso(String nomeCurso) {
		String sql = "select * from curso where nome = ? ";
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, nomeCurso);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				Curso c = new Curso(rs.getString(1), rs.getInt(2));
				return c;
			} else
				return null;
		} catch (SQLException e) {
			return null;
		} finally {
			ConnectionFactory.close(con);
		}
	}

	public static ArrayList<Curso> getCursos() {
		ArrayList<Curso> ac = new ArrayList<>();
		String sql = "select * from curso";
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				ac.add(new Curso(rs.getString(1), rs.getInt(2)));
			}
			return ac;
		} catch (SQLException e) {
			System.exit(-1);
		} finally {
			ConnectionFactory.close(con);
		}
		return ac;
	}

	public static ArrayList<Recado> getRecados(Aluno aluno) {
		ArrayList<Recado> recados = new ArrayList<>();
		try {
			if (BancoDeDados.existeAluno(aluno.getUsuario(), aluno.getSenha())) {
				saida.println("2270");
				saida.println(aluno.getCpf());
				while (!entrada.hasNextLine());
				if(entrada.nextLine().equals("true")){
					System.out.println("BancoideDados.getRecados");
					Integer repeticoes = Integer.parseInt(entrada.nextLine());
					for(int i = 0; i < repeticoes; i++){
//							new Recado(codigo, recado, data, aluno, codigoProfessor)
						recados.add( new Recado(entrada.nextLine(),entrada.nextLine(),entrada.nextLine(),entrada.nextLine(),entrada.nextLine()));	
					}
				}
			} 
		} catch (NullPointerException e) {
			JOptionPane.showConfirmDialog(null, "Erro na conexao com o servidor", "Erro", 2);
			System.exit(-1);
			return null;
		}
		return recados;
	}

	public static ArrayList<Recado> getRecados(Professor prof) {
		// TODO Fazer metodo
		return null;
	}

	public static ArrayList<Nota> getNotas(Aluno aluno) {
		// TODO fazer o metodo
		return null;
	}

	public static ArrayList<Nota> getNotas(ArrayList<Disciplina> disciplinas) {
		// TODO fazer metodo
		ArrayList<Nota> notas = new ArrayList<>();
		for (Disciplina d : disciplinas) {
			for (Nota nota : d.getNotas()) {
				notas.add(nota);
			}

		}
		return notas;
	}

	public static ArrayList<Solicitacao> getSolicitacoes(String usuario, String senha) {
		ArrayList<Solicitacao> ss = new ArrayList<>();
		try {
			if (BancoDeDados.loginAdm(usuario, senha)) {
				saida.println("2260");
				while (!entrada.hasNextLine());
				if(entrada.nextLine().equals("true")){
					Integer repeticoes = Integer.parseInt(entrada.nextLine());
					for(int i = 0; i < repeticoes; i++){
	//						new Solicitacao(codigo, tipo, data, cpfAluno, codigoDisciplina)
						ss.add( new Solicitacao(entrada.nextLine(),entrada.nextLine(),entrada.nextLine(),entrada.nextLine(),entrada.nextLine()));	
					}
				}
			} 
		} catch (NullPointerException e) {
			JOptionPane.showConfirmDialog(null, "Erro na conexao com o servidor", "Erro", 2);
			System.exit(-1);
			return null;
		}
		return ss;
	}

	public static Solicitacao getSolicitacao(String codigo, String usuario, String senha) {
		try {
			if (BancoDeDados.loginAdm(usuario, senha)) {
				saida.println("2263");
				saida.println(codigo);
				while (!entrada.hasNextLine());
				if (entrada.nextLine().equals("true")) {
					//new Solicitacao(codigo, tipo, data, cpfAluno, codigoDisciplina)
					return new Solicitacao(entrada.nextLine(),entrada.nextLine(),entrada.nextLine(),entrada.nextLine(),entrada.nextLine());
				}
			}
		} catch (NullPointerException e) {
			JOptionPane.showConfirmDialog(null, "Erro na conexao com o servidor", "Erro", 2);
			System.exit(-1);
			return null;
		}
		return null;
	}

	public static String getSituacao(String codigoDisciplina, String cpfAluno) {
		String sql = "select situacao from matriculadisciplina where disciplina_codigo = ? AND aluno_cpf = ?";
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, codigoDisciplina);
			pst.setString(2, cpfAluno);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				return rs.getString(1);
			} else
				return null;
		} catch (SQLException e) {
			return null;
		} finally {
			ConnectionFactory.close(con);
		}
	}

	public static boolean loginAdm(String usuario, String senha) {
		try {
			saida.println("3000");
			saida.println(usuario);
			saida.println(senha);
			while (!entrada.hasNextLine())
				;
			if (entrada.nextLine().equals("true"))
				return true;
			else
				return false;
		} catch (NullPointerException e) {
			JOptionPane.showConfirmDialog(null, "Erro na conexao com o servidor", "Erro", 2);
			System.exit(-1);
			return false;
		}
	}

	public static Professor loginProfessor(String usuario, String senha) {
		try {
			saida.println("3001");
			saida.println(usuario);
			saida.println(senha);
			while (!entrada.hasNextLine())
				;
			if (entrada.nextLine().equals("true")) {
				// new Professor(nome, cpf, telefone, endereco, valorHora,
				// codigo, formacao, usuario, senha);
				return new Professor(entrada.nextLine(), entrada.nextLine(), entrada.nextLine(), entrada.nextLine(),
						Double.parseDouble(entrada.nextLine()), entrada.nextLine(), entrada.nextLine(),
						entrada.nextLine(), entrada.nextLine());
			} else
				return null;
		} catch (NullPointerException e) {
			JOptionPane.showConfirmDialog(null, "Erro na conexao com o servidor", "Erro", 2);
			System.exit(-1);
			return null;
		}
	}

	public static Aluno loginAluno(String usuario, String senha) {
		try {
			saida.println("3002");
			saida.println(usuario);
			saida.println(senha);
			while (!entrada.hasNextLine());
			if (entrada.nextLine().equals("true")) {
//				new Aluno(nome, cpf, telefone, endereco, usuario, senha, codigoCurso)
				return new Aluno (entrada.nextLine(), entrada.nextLine(), entrada.nextLine(), entrada.nextLine(), entrada.nextLine(), entrada.nextLine(), entrada.nextLine());
			} else
				return null;
		} catch (NullPointerException e) {
			JOptionPane.showConfirmDialog(null, "Erro na conexao com o servidor", "Erro", 2);
			System.exit(-1);
			return null;
		}
	}
	
	public static Boolean existeProfessor(String usuario, String senha) {
		try {
			saida.println("3003");
			saida.println(usuario);
			saida.println(senha);
			while (!entrada.hasNextLine());
			if (entrada.nextLine().equals("true"))
				return true;
			else
				return false;
		} catch (NullPointerException e) {
			JOptionPane.showConfirmDialog(null, "Erro na conexao com o servidor", "Erro", 2);
			System.exit(-1);
			return false;
		}
	}
	
	public static Boolean existeAluno(String usuario, String senha) {
		try {
			saida.println("3004");
			saida.println(usuario);
			saida.println(senha);
			while (!entrada.hasNextLine())
				;
			if (entrada.nextLine().equals("true"))
				return true;
			else
				return false;
		} catch (NullPointerException e) {
			JOptionPane.showConfirmDialog(null, "Erro na conexao com o servidor", "Erro", 2);
			System.exit(-1);
			return false;
		}
	}
	
	public static String professorTrocaSenha(String password, String usuario, String senha) {
		try {
			if (BancoDeDados.existeProfessor(usuario, senha)) {
				saida.println("3005");
				saida.println(password);
				saida.println(usuario);
				while (!entrada.hasNextLine());
				return entrada.nextLine();
			} else
				return "Erro de Login";
		} catch (NullPointerException e) {
			JOptionPane.showConfirmDialog(null, "Erro na conexao com o servidor", "Erro", 2);
			System.exit(-1);
			return "";
		}
	}

	public static String alunoTrocaSenha(String password, String usuario, String senha) {
		try {
			if (BancoDeDados.existeAluno(usuario, senha)) {
				saida.println("3006");
				saida.println(password);
				saida.println(usuario);
				while (!entrada.hasNextLine());
				return entrada.nextLine();
			} else
				return "Erro de Login";
		} catch (NullPointerException e) {
			JOptionPane.showConfirmDialog(null, "Erro na conexao com o servidor", "Erro", 2);
			System.exit(-1);
			return "";
		}
	}

	public static String admTrocaSenha(String password, String usuario, String senha) {
		try {
			if (BancoDeDados.loginAdm(usuario, senha)) {
				saida.println("3007");
				saida.println(password);
				saida.println(usuario);
				while (!entrada.hasNextLine());
				return entrada.nextLine();
			} else
				return "Erro de Login";
		} catch (NullPointerException e) {
			JOptionPane.showConfirmDialog(null, "Erro na conexao com o servidor", "Erro", 2);
			System.exit(-1);
			return "";
		}
	}

}
