package br.com.ClassesInternas;

import java.util.ArrayList;

public class Disciplina {
	private Professor professor;
	private ArrayList<Aluno> alunos;
	private ArrayList<Nota> notas;
	
	public Disciplina(Professor professor) {
		super();
		this.professor = professor;
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
