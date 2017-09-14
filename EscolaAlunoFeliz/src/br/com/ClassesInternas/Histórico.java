package br.com.ClassesInternas;

import java.util.ArrayList;

public class Histórico {
	private Curso curso;
	private ArrayList<Disciplina> disciplinas;
	
	public Histórico(Curso curso, ArrayList<Disciplina> disciplinas) {
		super();
		this.curso = curso;
		this.disciplinas = disciplinas;
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
	
}
