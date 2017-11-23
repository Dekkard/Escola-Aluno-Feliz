package br.com.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.ClassesInternas.*;

public class BancoDeDadosServer {
	
	/**
	 * codigo 2250
	 */
	public static String inserir(Aluno a){
		String sql = "insert into aluno(nome,cpf,telefone,endereco,curso_nome,usuario,senha) values (?,?,?,?,?,?,?)";
		Connection con = ConnectionFactory.getConnection();
		
		try{
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, a.getNome());
			pst.setString(2, a.getCpf());
			pst.setString(3, a.getTelefone());
			pst.setString(4, a.getEndereco());
			pst.setString(5, a.getNomeCurso());
			pst.setString(6, a.getUsuario());
			pst.setString(7, a.getSenha());
			int res = pst.executeUpdate();
			if(res > 0){
				return "Inserido com sucesso.";
			}else{
				return "Erro ao inserir.";
			}
		}catch(SQLException e){
			return e.getMessage();
		}finally {
			ConnectionFactory.close(con);
		}
	}
	

	/**
	 * codigo 2251
	 */
	public static String inserir(Curso c){
		String sql = "insert into curso(nome,qtd_semestres) values (?,?)";
		Connection con = ConnectionFactory.getConnection();
		
		try{
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, c.getNome());
			pst.setInt(2, c.getQtdSemestres());
			int res = pst.executeUpdate();
			if(res > 0){
				return "Inserido com sucesso.";
			}else{
				return "Erro ao inserir.";
			}
		}catch(SQLException e){
			return e.getMessage();
		}finally {
			ConnectionFactory.close(con);
		}
	}
	

	/**
	 * codigo 2252
	 */
	public static String inserir(Disciplina d){
		String sql = "insert into disciplina(codigo,nome,professor_codigo,curso_nome,semestre) values (?,?,?,?,?)";
		Connection con = ConnectionFactory.getConnection();
		
		try{
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, d.getCodigo());
			pst.setString(2, d.getNome());
			pst.setString(3, d.getProfessor().getCodigo());
			pst.setString(4, d.getCurso().getNome());
			pst.setInt(5, d.getSemestre());
			int res = pst.executeUpdate();
			if(res > 0){
				return "Inserido com sucesso.";
			}else{
				return "Erro ao inserir.";
			}
		}catch(SQLException e){
			return e.getMessage();
		}finally {
			ConnectionFactory.close(con);
		}
	}
	

	/**
	 * codigo 2253
	 */
	public static String inserir(Recado r){
		String sql = "insert into Recado(recado,data,professor_codigo,aluno_cpf) values (?,?,?,?)";
		Connection con = ConnectionFactory.getConnection();
		
		try{
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, r.getRecado());
			pst.setString(2, r.getData());
			pst.setString(3, r.getProfessor().getCodigo());
			pst.setString(4, r.getAluno().getCpf());
			int res = pst.executeUpdate();
			if(res > 0){
				return "Inserido com sucesso.";
			}else{
				return "Erro ao inserir.";
			}
		}catch(SQLException e){
			return e.getMessage();
		}finally {
			ConnectionFactory.close(con);
		}
	}
	
	/**
	 * codigo 2254
	 */
	public static String inserir(Professor p){
		String sql = "insert into professor (cpf,nome,telefone,endereco,valor_hora,codigo,formacao,usuario,senha) values (?,?,?,?,?,?,?,?,?)";
		Connection con = ConnectionFactory.getConnection();
		
		try{
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, p.getCpf());
			pst.setString(2, p.getNome());
			pst.setString(3, p.getTelefone());
			pst.setString(4, p.getEndereco());
			pst.setDouble(5, p.getValorHora());
			pst.setString(6, p.getCodigo());
			pst.setString(7, p.getFormacao());
			pst.setString(8, p.getUsuario());
			pst.setString(9, p.getSenha());
			int res = pst.executeUpdate();
			if(res > 0){
				return "Inserido com sucesso.";
			}else{
				return "Erro ao inserir.";
			}
		}catch(SQLException e){
			return e.getMessage();
		}finally {
			ConnectionFactory.close(con);
		}
	}
	
	public static String inserir(Nota nota){
		//verificar se esta correto
		String sql = "insert into matriculaDisciplina (aluno_cpf,disciplina_codigo,nota) values (?,?,?)";
		Connection con = ConnectionFactory.getConnection();
		
		try{
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, nota.getAluno().getCpf());
			pst.setString(2, nota.getDisciplina().getCodigo());
			pst.setDouble(3, nota.getNota());
			int res = pst.executeUpdate();
			if(res > 0){
				return "Inserido com sucesso.";
			}else{
				return "Erro ao inserir.";
			}
		}catch(SQLException e){
			return e.getMessage();
		}finally {
			ConnectionFactory.close(con);
		}
	}
	
	public static String inserir(Solicitacao s){
		String sql = "insert into solicitacao (tipo,data,aluno_cpf,disciplina_codigo) values (?,?,?,?)";
		Connection con = ConnectionFactory.getConnection();
		
		try{
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, s.getTipo());
			pst.setString(2, s.getData());
			pst.setString(3, s.getCpfAluno());
			pst.setString(4, s.getCodigoDisciplina());
			int res = pst.executeUpdate();
			if(res > 0){
				return "Foi enviado uma Solicitacao ao administrador do sistema para que ele te "+ s.getTipo() +" na disciplina!";
			}else{
				return "Erro ao criar Solicitacao!";
			}
		}catch(SQLException e){
			return e.getMessage();
		}finally {
			ConnectionFactory.close(con);
		}
	}
	
	/**
	 * codigo 2261
	 */
	public static String matricular(Solicitacao s){
		String sql = "insert into matriculaDisciplina (disciplina_codigo,aluno_cpf,situacao) values (?,?,?)";
		Connection con = ConnectionFactory.getConnection();
		
		try{
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, s.getCodigoDisciplina());
			pst.setString(2, s.getCpfAluno());
			pst.setString(3, "Em curso");
			int res = pst.executeUpdate();
			if(res > 0){
				return "Aluno matriculado com sucesso!";
			}else{
				return "Erro ao matricular!";
			}
		}catch(SQLException e){
			return e.getMessage();
		}finally {
			ConnectionFactory.close(con);
		}
	}
	
	/**
	 * codigo 2264
	 */
	//Muda situacao da matricula: Em curso, Trancado, Aprovado
	public static String mudarSituacaoMatricula(String disciplina_codigo, String aluno_cpf, String situacao){
		String sql = "update matriculaDisciplina set situacao = ? where disciplina_codigo = ? and aluno_cpf = ?";
		Connection con = ConnectionFactory.getConnection();

		try{
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, situacao);
			pst.setString(2, disciplina_codigo);
			pst.setString(3, aluno_cpf);
			int res = pst.executeUpdate();
			if(res > 0){
				return "Atualizado com sucesso.";
			}else{
				return "Erro ao atualizar.";
			}
		}catch(SQLException e){
			return e.getMessage();
		}finally {
			ConnectionFactory.close(con);
		}
	}
	
	/**
	 * 
	 */
	public static Boolean existeAluno(String cpfAluno) {
		String sql = "select * from aluno where cpf=?";
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, cpfAluno);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) 
				return true;
		} catch (SQLException e) {
			System.exit(-1);
		} finally {
			ConnectionFactory.close(con);
		}
		return false;
	}
	
	/**
	 * 
	 */
	public static Boolean existeProfessor(String codigoProfessor){
		String sql = "select * from professor where codigo=?";
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, codigoProfessor);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) 
				return true;
		} catch (SQLException e) {
			System.exit(-1);
		} finally {
			ConnectionFactory.close(con);
		}
		return false;
	}
	
	/**
	 * 
	 */
	public static Boolean existeCurso(String nomeCurso){
		String sql = "select * from curso where nome=?";
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, nomeCurso);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) 
				return true;
		} catch (SQLException e) {
			System.exit(-1);
		} finally {
			ConnectionFactory.close(con);
		}
		return false;
	}

	/**
	 * codigo 2265
	 */
	public static Boolean existeSolicitacao(String codigo) {
		String sql = "select * from solicitacao where codigo=?";
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, Integer.parseInt(codigo));
			ResultSet rs = pst.executeQuery();
			if (rs.next()) 
				return true;
		} catch (SQLException e) {
			System.exit(-1);
		} finally {
			ConnectionFactory.close(con);
		}
		return false;
	}
	
	/**
	 * 
	 */	
	public static Boolean existeMatricula(Solicitacao s) {
		String sql = "select * from matriculaDisciplina where disciplina_codigo = ? AND aluno_cpf = ?";
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, s.getCodigoDisciplina());
			pst.setString(2, s.getCpfAluno());
			ResultSet rs = pst.executeQuery();
			if (rs.next()) 
				return true;
		} catch (SQLException e) {
			System.exit(-1);
		} finally {
			ConnectionFactory.close(con);
		}
		return false;
	}
	
	/**
	 * codigo 2255
	 */
	public static String atualizar(Aluno a) {
		String sql = "update aluno set nome = ?, telefone = ?, endereco = ?, curso_nome = ? where cpf = ?";
		Connection con = ConnectionFactory.getConnection();

		try{
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, a.getNome());
			pst.setString(2, a.getTelefone());
			pst.setString(3, a.getEndereco());
			pst.setString(4, a.getNomeCurso());
			pst.setString(5, a.getCpf());
			int res = pst.executeUpdate();
			if(res > 0){
				return "Atualizado com sucesso.";
			}else{
				return "Erro ao atualizar.";
			}
		}catch(SQLException e){
			return e.getMessage();
		}finally {
			ConnectionFactory.close(con);
		}
	}

	/**
	 * codigo 2257
	 */
	public static String atualizar(Professor p)  {
		String sql = "update professor set nome = ?, telefone = ?, endereco = ?, valor_hora = ?, cpf = ?, formacao = ? where codigo = ?";
		Connection con = ConnectionFactory.getConnection();

		try{
			PreparedStatement pst = con.prepareStatement(sql);
//			new Professor(nome, cpf, telefone, endereco, valorHora, codigo, formacao, usuario, senha)
			pst.setString(1, p.getNome());
			pst.setString(2, p.getTelefone());
			pst.setString(3, p.getEndereco());
			pst.setDouble(4, p.getValorHora());
			pst.setString(5, p.getCpf());
			pst.setString(6, p.getFormacao());
			pst.setString(7, p.getCodigo());
			int res = pst.executeUpdate();
			if(res > 0){
				return "Atualizado com sucesso.";
			}else{
				return "Erro ao atualizar.";
			}
		}catch(SQLException e){
			return e.getMessage();
		}finally {
			ConnectionFactory.close(con);
		}
	}
	
	/**
	 * codigo 2256
	 */
	public static String excluirAluno(String cpfAluno) {
		String sql = "delete from aluno where cpf = ?";
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, cpfAluno);
			int res = pst.executeUpdate();
			if(res > 0){
				return "Excluido com sucesso.";
			}else{
				return "Erro ao excluir.";
			}
		} catch (SQLException e) {
			System.exit(-1);
		} finally {
			ConnectionFactory.close(con);
		}
		return "Falha na exclusao!";
	}
	
	/**
	 * codigo 2258
	 */
	public static String excluirProfessor(String codigoProfessor) {
		String sql = "delete from professor where codigo = ?";
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, codigoProfessor);
			int res = pst.executeUpdate();
			if(res > 0){
				return "Excluido com sucesso.";
			}else{
				return "Erro ao excluir.";
			}
		} catch (SQLException e) {
			System.exit(-1);
		} finally {
			ConnectionFactory.close(con);
		}
		return "Falha na exclusao!";
	}
	
	/**
	 * codigo 2259
	 */
	public static String excluirRecado(String codigoRecado) {
		String sql = "delete from recado where codigo = ?";
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, codigoRecado);
			int res = pst.executeUpdate();
			if(res > 0){
				return "Excluido com sucesso.";
			}else{
				return "Erro ao excluir.";
			}
		} catch (SQLException e) {
			System.exit(-1);
		} finally {
			ConnectionFactory.close(con);
		}
		return "Falha na exclusao!";
	}
	
	/**
	 * codigo 2262
	 */
	public static String excluirSolicitacao(String codigoSolicitacao) {
		String sql = "delete from solicitacao where codigo = ?";
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, codigoSolicitacao);
			int res = pst.executeUpdate();
			if(res > 0){
				return "Excluido com sucesso.";
			}else{
				return "Erro ao excluir.";
			}
		} catch (SQLException e) {
			System.exit(-1);
		} finally {
			ConnectionFactory.close(con);
		}
		return "Falha na exclusao!";
	}

	public static Disciplina getDisciplina(String codigoDisciplina) {
		String sql = "select * from disciplina where codigo = ? ";
		System.out.println("getDisciplinaaa");
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, codigoDisciplina);
			ResultSet rs = pst.executeQuery();
			if(rs.next()){
				System.out.println("getDisciplina entrou");
				Disciplina d = new Disciplina(
						rs.getString(1),
						rs.getString(2),
						BancoDeDadosServer.getProfessor(rs.getString(3)),
						BancoDeDadosServer.getCurso(rs.getString(4)),
						rs.getInt(5)
						);
				return d;
			}
			else
				return null;
		} catch (SQLException e) {
			return null;
		} finally {
			ConnectionFactory.close(con);
		}
	}

	/**
	 * 
	 */
	public static ArrayList<Disciplina> getDisciplinas(Aluno a){
		ArrayList<Disciplina> disciplinas = new ArrayList<>();
		String sql = "select * from Disciplina inner join matriculaDisciplina on disciplina.codigo = matriculaDisciplina.disciplina_codigo where matriculaDisciplina.aluno_cpf = ? ";
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, a.getCpf());
			ResultSet rs = pst.executeQuery();
			while (rs.next()){
				Disciplina d = new Disciplina(
						rs.getString(1),
						rs.getString(2),
						BancoDeDadosServer.getProfessor(rs.getString(3)),
						BancoDeDadosServer.getCurso(rs.getString(4)),
						rs.getInt(5)
						);
				disciplinas.add(d);
				}
		} catch (SQLException e) {
			return null;
		} finally {
			ConnectionFactory.close(con);
		}
		return disciplinas;
	}

	/**
	 * 
	 */
	public static ArrayList<Disciplina> getDisciplinas(Professor prof) {
		// TODO fazer o m�todo
		return null;
	}

	/**
	 * 
	 */
	public static ArrayList<Disciplina> getDisciplinas(String nomeCurso, int semestre) {
		ArrayList<Disciplina> disciplinas = new ArrayList<>();
		String sql = "select * from Disciplina where curso_nome = ? AND semestre = ?";
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, nomeCurso);
			pst.setInt(2, semestre);
			ResultSet rs = pst.executeQuery();
			while (rs.next()){
				//TODO terminar os gets
				Disciplina d = new Disciplina(
						rs.getString(1),
						rs.getString(2),
						BancoDeDadosServer.getProfessor(rs.getString(3)),
						BancoDeDadosServer.getCurso(rs.getString(4)),
						rs.getInt(5)
						);
				disciplinas.add(d);
				}
		} catch (SQLException e) {
			System.exit(-1);
		} finally {
			ConnectionFactory.close(con);
		}
		return disciplinas;
	}

	/**
	 * Sem codigo, usado como secundario.
	 */
	public static Professor getProfessor(String codigo) {
		String sql = "select * from professor where codigo = ? ";
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, codigo);
			ResultSet rs = pst.executeQuery();
			if(rs.next()){
				Professor p = new Professor(
					rs.getString(2),
					rs.getString(1),
					rs.getString(4),
					rs.getString(3),
					rs.getDouble(5),
					rs.getString(6),
					rs.getString(7),
					rs.getString(8),
					rs.getString(9)
					);
				return p;
			}
			else
				return null;
		} catch (SQLException e) {
			return null;
		} finally {
			ConnectionFactory.close(con);
		}
	}


	/**
	 * Sem codigo, usado como secundario.
	 */
	public static Aluno getAluno(String cpf) {
		String sql = "select * from aluno where cpf = ? ";
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, cpf);
			ResultSet rs = pst.executeQuery();
			if(rs.next()){
				Aluno a = new Aluno(
					rs.getString(2),
					rs.getString(1),
					rs.getString(4),
					rs.getString(3),
					rs.getString(6),
					rs.getString(7),
					rs.getString(5)
					);
				return a;
			}
			else
				return null;
		} catch (SQLException e) {
			return null;
		} finally {
			ConnectionFactory.close(con);
		}
	}

	/**
	 * Sem codigo, usado como secundario.
	 */
	public static Curso getCurso(String nomeCurso) {
		String sql = "select * from curso where nome = ? ";
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, nomeCurso);
			ResultSet rs = pst.executeQuery();
			if(rs.next()){
				Curso c = new Curso(
					rs.getString(1),
					rs.getInt(2)
					);
				return c;
			}
			else
				return null;
		} catch (SQLException e) {
			return null;
		} finally {
			ConnectionFactory.close(con);
		}
	}

	/**
	 * 
	 */
	public static ArrayList<Curso> getCursos() {
		ArrayList<Curso> ac = new ArrayList<>(); 
		String sql = "select * from curso";
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next()){
				ac.add(new Curso(
						rs.getString(1),
						rs.getInt(2)
						));
			}
			return ac;
		} catch (SQLException e) {
			System.exit(-1);
		} finally {
			ConnectionFactory.close(con);
		}
		return ac;
	}

	/**
	 * 
	 */
	public static ArrayList<Recado> getRecados(Aluno aluno) {
		// TODO fazer o m�todo
		return null;
	}

	/**
	 * 
	 */
	public static ArrayList<Recado> getRecados(Professor prof) {
		// TODO Fazer m�todo
		return null;
	}

	/**
	 * 
	 */
	public static ArrayList<Nota> getNotas(Aluno aluno) {
		// TODO fazer o m�todo
		return null;
	}

	/**
	 * 
	 */
	public static ArrayList<Nota> getNotas(ArrayList<Disciplina> disciplinas) {
		// TODO fazer m�todo
		ArrayList<Nota> notas = new ArrayList<>();
		for (Disciplina d : disciplinas) {
			for (Nota nota : d.getNotas()) {
				notas.add(nota);
			}
			
		}
		return null;
	}
	
	/**
	 * codigo 2260
	 */
	public static ArrayList<String[]> getSolicitacoes() {
		String sql = "select * from solicitacao";
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			ArrayList<String[]> ss = new ArrayList<String[]>();
			if(rs.next()){
				do{
	//				new Solicitacao(codigo, tipo, data, cpfAluno, codigoDisciplina)
					String[] s = {
							rs.getInt(1)+"",
							rs.getString(2),
							rs.getString(3),
							rs.getString(5),
							rs.getString(4)					
						};
					ss.add(s);
				}while(rs.next());
				return ss;
			}
			else
				return null;
		} catch (SQLException e) {
			return null;
		} finally {
			ConnectionFactory.close(con);
		}
	}
	
	/**
	 * codigo 2263
	 */
	public static String[] getSolicitacao(String codigo) {
		String sql = "select * from solicitacao where codigo = ? ";
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, Integer.parseInt(codigo));
			ResultSet rs = pst.executeQuery();
			if(rs.next()){
				String[] s = {
					rs.getInt(1)+"",
					rs.getString(2),
					rs.getString(3),
					rs.getString(5),
					rs.getString(4)					
				};
				return s;
			}
			else
				return null;
		} catch (SQLException e) {
			return null;
		} finally {
			ConnectionFactory.close(con);
		}
	}

	/**
	 * 
	 */
	public static String getSituacao(String codigoDisciplina, String cpfAluno) {
		String sql = "select situacao from matriculadisciplina where disciplina_codigo = ? AND aluno_cpf = ?";
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, codigoDisciplina);
			pst.setString(2, cpfAluno);
			ResultSet rs = pst.executeQuery();
			if(rs.next()){
				return rs.getString(1);
			}
			else
				return null;
		} catch (SQLException e) {
			return null;
		} finally {
			ConnectionFactory.close(con);
		}
	}

	/**
	 * codigo 3000
	 */
	public static Boolean loginAdm(String usuario, String senha) {
		String sql = "select senha from administrador where usuario = ? ";
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, usuario);
			ResultSet rs = pst.executeQuery();
			if(rs.next()){
				if(senha.equals(rs.getString(1)))
					return true;
				else
					return false;
			}
			else
				return false;
		} catch (SQLException e) {
			return false;
		} finally {
			ConnectionFactory.close(con);
		}
	}
	

	/**
	 * usado apenas internamente
	 */
	public static Boolean loginProfessor(String usuario, String senha) {
		String sql = "select senha from professor where usuario = ? ";
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, usuario);
			ResultSet rs = pst.executeQuery();
			if(rs.next()){
				if(senha.equals(rs.getString(1)))
					return true;
				else
					return false;
			}
			else
				return false;
		} catch (SQLException e) {
			return false;
		} finally {
			ConnectionFactory.close(con);
		}
	}
	
	/**
	 * codigo 3001
	 */
	public static String[] getProfessor(String usuario, String senha) {
		String sql = "select * from professor where usuario = ? and senha = ?";
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, usuario);
			pst.setString(2, senha);
			ResultSet rs = pst.executeQuery();
			if(rs.next()){
//				new Professor(nome, cpf, telefone, endereco, valorHora, codigo, formacao, usuario, senha)
				String[] s = {
						"true",
						rs.getString(2),
						rs.getString(1),
						rs.getString(4),
						rs.getString(3),
						rs.getDouble(5)+"",
						rs.getString(6),
						rs.getString(7),
						rs.getString(8),
						rs.getString(9)
				};
				return s;
			}
			else
				return null;
		} catch (SQLException e) {
			return null;
		} finally {
			ConnectionFactory.close(con);
		}
	}
	

	/**
	 * usado apenas internamente
	 */
	public static Boolean loginAluno(String usuario, String senha) {
		String sql = "select senha from aluno where usuario = ? ";
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, usuario);
			ResultSet rs = pst.executeQuery();
			if(rs.next()){
				if(senha.equals(rs.getString(1)))
					return true;
				else
					return false;
			}
			else
				return false;
		} catch (SQLException e) {
			return false;
		} finally {
			ConnectionFactory.close(con);
		}
	}
	
	/**
	 * codigo 3002
	 */
	public static String[] getAluno(String usuario, String senha) {
		String sql = "select * from aluno where usuario = ? and senha = ?";
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, usuario);
			pst.setString(2, senha);
			ResultSet rs = pst.executeQuery();
			if(rs.next()){
				String[] s = {
					"true",
					rs.getString(2),
					rs.getString(1),
					rs.getString(4),
					rs.getString(3),
					rs.getString(6),
					rs.getString(7),
					rs.getString(5)
				};
				return s;
			}else return null;
		}
		catch (SQLException e) {
			return null;
		} finally {
			ConnectionFactory.close(con);
		}
	}
}
