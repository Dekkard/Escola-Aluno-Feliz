package br.com.ClassesInternas;

import java.util.ArrayList;

public class Disciplina {
	//Codigo disciplina comeca com 615
	private String codigo;
	private String nome;
	private Integer semestre;
	private Curso curso;
	private Professor professor;
	private ArrayList<Aluno> alunos;
	private ArrayList<Nota> notas;
	
	public Disciplina(String codigo, String nome, Professor professor, Curso curso, Integer semestre) {
		this.codigo = codigo;
		this.nome = nome;
		this.professor = professor;
		this.curso = curso;
		this.semestre = semestre;
	}	

	public Disciplina(String codigo, String nome, Integer semestre, Curso curso, Professor professor,
			ArrayList<Aluno> alunos, ArrayList<Nota> notas) {
		this.codigo = codigo;
		this.nome = nome;
		this.semestre = semestre;
		this.curso = curso;
		this.professor = professor;
		this.alunos = alunos;
		this.notas = notas;
	}

	public Integer getSemestre() {
		return semestre;
	}

	public void setSemestre(Integer semestre) {
		this.semestre = semestre;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public ArrayList<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(ArrayList<Aluno> alunos) {
		this.alunos = alunos;
	}

	public ArrayList<Nota> getNotas() {
		return notas;
	}

	public void setNotas(ArrayList<Nota> notas) {
		this.notas = notas;
	}
}
