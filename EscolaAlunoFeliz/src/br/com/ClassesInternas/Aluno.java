package br.com.ClassesInternas;

import java.util.ArrayList;

public class Aluno extends Pessoa{
	private String usuario;
	private String senha;
	private String nomeCurso;
	private ArrayList<Disciplina> disciplinas;
	
	public Aluno(String nome, String cpf, String telefone, String endereco, String usuario, String senha, String codigoCurso, ArrayList<Disciplina> disciplinas) {
		super(nome, cpf, telefone, endereco);
		this.usuario = usuario;
		this.senha = senha;
		this.nomeCurso = codigoCurso;
		this.disciplinas = disciplinas;
	}
	
	public Aluno(String nome, String cpf, String telefone, String endereco, String usuario, String senha, String codigoCurso) {
		super(nome, cpf, telefone, endereco);
		this.usuario = usuario;
		this.senha = senha;
		this.nomeCurso = codigoCurso;
	}

	public String getNomeCurso() {
		return nomeCurso;
	}

	public void setNomeCurso(String curso) {
		this.nomeCurso = curso;
	}

	public ArrayList<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(ArrayList<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
}
