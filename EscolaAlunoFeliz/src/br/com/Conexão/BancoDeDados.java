package br.com.Conexão;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import br.com.ClassesInternas.*;

public class BancoDeDados {
	public static String inserir(Aluno a){
		String sql = "insert into aluno(nome,cpf,telefone,endereco,curso_nome,usuario,senha) values (?,?,?,?,?,?,?)";
		Connection con = ConnectionFactory.getConnection();
		
		try{
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, a.getNome());
			pst.setString(2, a.getCpf());
			pst.setString(3, a.getTelefone());
			pst.setString(4, a.getEndereço());
			pst.setString(5, a.getCurso().getNome());
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
	
	public static String inserir(Professor p){
		String sql = "insert into professor (nome,cpf,telefone,endereco,valor_hora,codigo,formacao,usuario,senha) values (?,?,?,?,?,?,?,?,?)";
		Connection con = ConnectionFactory.getConnection();
		
		try{
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, p.getCpf());
			pst.setString(2, p.getNome());
			pst.setString(3, p.getCodigo());
			pst.setString(4, p.getEndereço());
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
		String sql = "insert into alunoDisciplina (aluno_cpf,disciplina_codigo,nota) values (?,?,?)";
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
	
	public static String inserir(Solicitação s){
		String sql = "insert into solicitações (tipo,data,aluno_cpf,disciplina_codigo,codigo) values (?,?,?,?,?)";
		Connection con = ConnectionFactory.getConnection();
		
		try{
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, s.getTipo());
			pst.setString(2, s.getData());
			pst.setString(3, s.getAluno().getCpf());
			pst.setString(4, s.getDisciplina().getCodigo());
			pst.setString(5, s.getCodigo());
			int res = pst.executeUpdate();
			if(res > 0){
				return "Foi enviado uma solicitação ao administrador do sistema para que ele te cadastre na disciplina!";
			}else{
				return "Erro ao criar solicitação!";
			}
		}catch(SQLException e){
			return e.getMessage();
		}finally {
			ConnectionFactory.close(con);
		}
	}
	
	public static String matricular(Solicitação s){
		String sql = "insert into matriculaDisciplina (disciplina_codigo,aluno_cpf,situacao) values (?,?,?)";
		Connection con = ConnectionFactory.getConnection();
		
		try{
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, s.getDisciplina().getCodigo());
			pst.setString(2, s.getAluno().getCpf());
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
	
	//Muda situacao da matricula: Em curso, Trancado, Aprovado
	public static String mudarSituacaoMatricula(Solicitação solicitação, String situacao){
		//TODO: inserir sql para atualizar (update)
		//TODO: pesquisar por chave composta
		String sql = "????? into matriculaDisciplina () were id = ? values (?)";
		Connection con = ConnectionFactory.getConnection();
		
		try{
			PreparedStatement pst = con.prepareStatement(sql);
			//pst.setString(1, codigoMatricula);
			pst.setString(2, situacao);
			int res = pst.executeUpdate();
			if(res > 0){
				return "Situação da matrícula mudada para"+ situacao+ "!";
			}else{
				return "Erro ao mudar a situacao da matricula!";
			}
		}catch(SQLException e){
			return e.getMessage();
		}finally {
			ConnectionFactory.close(con);
		}
	}
	
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

	public static boolean existeSolicitacao(String codigo) {
		String sql = "select * from solicitacao where codigo=?";
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, codigo);
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
	
	//TODO: fazer metodochave 
	public static boolean existeMatricula(Solicitação s) {

		String sql = "select * from matriculaDisciplina where ??????????";
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, s.getDisciplina().getCodigo());
			pst.setString(2, s.getAluno().getCpf());
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
	
	public static void atualizar(Aluno a) {
		
		JOptionPane.showConfirmDialog(null, "Usuário atualizado.\nO usuario e a senha foram mudados para o padrão(nome da pessoa)!", "Usuário e senha modificados", 3);
	}
	
	public static void atualizar(Professor p) {
		
		JOptionPane.showConfirmDialog(null, "Usuário atualizado.\nO usuario e a senha foram mudados para o padrão(nome da pessoa)!", "Usuário e senha modificados", 3);
	}

	public static String excluir(Aluno a) {
		String sql = "delete from aluno where cpf =?";
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, a.getCpf());
			ResultSet rs = pst.executeQuery();
			if (rs.next()) 
				return "Excluído com sucesso!";
		} catch (SQLException e) {
			System.exit(-1);
		} finally {
			ConnectionFactory.close(con);
		}
		return "Falha na exclusão!";
	}

	public static String excluir(Professor p) {
		return "Excluído com sucesso!";
	}

	public static void excluir(Recado recado) {
		// TODO fazer o método
		
	}
	
	public static ArrayList<Disciplina> getDisciplinas(Aluno a){
		ArrayList<Disciplina> disciplinas = new ArrayList<>();
		String sql = "select * from Disciplina inner join matriculaDisciplina on disciplina.codigo = alunoDisciplina.codigoDisciplina where alunoDisciplina.cpf = ? ";
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, a.getCpf());
			ResultSet rs = pst.executeQuery();
			while (rs.next()){
				//TODO terminar os gets
				Disciplina d = new Disciplina(
						rs.getString(1),
						rs.getString(2),
						BancoDeDados.getProfessor(rs.getString(3)),
						BancoDeDados.getCurso(rs.getString(4)),
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
	
	public static ArrayList<Disciplina> getDisciplinas(Professor prof) {
		// TODO fazer o método
		return null;
	}

	public static Disciplina getDisciplina(String codigoDisciplina) {
		// TODO fazer método
		return null;
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
			while (rs.next()){
				//TODO terminar os gets
				Disciplina d = new Disciplina(
						rs.getString(1),
						rs.getString(2),
						BancoDeDados.getProfessor(rs.getString(3)),
						BancoDeDados.getCurso(rs.getString(4)),
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

	
	public static Aluno getAluno(String cpf) {
		//TODO não está feito
		String sql = "select * from aluno where cpf = ? ";
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, cpf);
			ResultSet rs = pst.executeQuery();
			if(rs.next()){
				Aluno a = new Aluno(
					rs.getString(1),
					rs.getString(2),
					rs.getString(3),
					rs.getString(4),
					rs.getString(5),
					rs.getString(6),
					BancoDeDados.getCurso(rs.getString(7)),
					BancoDeDados.getDisciplinas(new Aluno(cpf))
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
	
	public static ArrayList<Recado> getRecados(Aluno aluno) {
		// TODO fazer o método
		return null;
	}

	public static ArrayList<Recado> getRecados(Professor prof) {
		// TODO Fazer método
		return null;
	}

	public static ArrayList<Nota> getNotas(Aluno aluno) {
		// TODO fazer o método
		return null;
	}

	public static ArrayList<Nota> getNotas(ArrayList<Disciplina> disciplinas) {
		// TODO fazer método
		ArrayList<Nota> notas = new ArrayList<>();
		for (Disciplina d : disciplinas) {
			for (Nota nota : d.getNotas()) {
				notas.add(nota);
			}
			
		}
		return null;
	}
	
	public static ArrayList<Solicitação> getSolicitações() {
		// TODO criar método
		return null;
	}
	
	public static Solicitação getSolicitação(String codigo) {
		String sql = "select * from solicitacao where codigo = ? ";
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, codigo);
			ResultSet rs = pst.executeQuery();
			if(rs.next()){
				Solicitação s = new Solicitação(
					rs.getString(1),
					rs.getString(2),
					rs.getString(3),
					getAluno(rs.getString(5)),
					getDisciplina(rs.getString(4))					
					);
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

	public static boolean loginAdm(String usuario, String senha) {
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
	

	public static Professor loginProfessor(String user, String senha) {
		// TODO fazer o metodo
		return null;
	}
	

	public static Aluno loginAluno(String user, String senha) {
		// TODO fazer o metodo
		return null;
	}
}
