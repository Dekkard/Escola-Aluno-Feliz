package br.com.ClassesInternas;

import java.util.ArrayList;

public class Aluno extends Pessoa{
	private String usuario;
	private String senha;
	private Curso curso;
	private ArrayList<Disciplina> disciplinas;
	
	public Aluno(String nome, String cpf, String telefone, String endereço, String usuario, String senha) {
		super(nome, cpf, telefone, endereço);
		this.usuario = usuario;
		this.senha = senha;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
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
