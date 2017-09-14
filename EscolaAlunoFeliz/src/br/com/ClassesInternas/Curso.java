package br.com.ClassesInternas;

import java.util.ArrayList;

public class Curso {
	private ArrayList<Disciplina> disciplinas;
	private ArrayList<Aluno> alunos;
	
	public Curso(ArrayList<Disciplina> disciplinas) {
		super();
		this.disciplinas = disciplinas;
	}

	public ArrayList<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(ArrayList<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

	public ArrayList<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(ArrayList<Aluno> alunos) {
		this.alunos = alunos;
	}
	
}
