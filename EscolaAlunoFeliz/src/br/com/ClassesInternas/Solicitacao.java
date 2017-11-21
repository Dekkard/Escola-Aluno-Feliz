package br.com.ClassesInternas;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Solicitacao {
	private String codigo;
	private String tipo;
	private String data;
	private Aluno aluno;
	private Disciplina disciplina;
	
	public Solicitacao(String codigo, String tipo, String data, Aluno aluno, Disciplina disciplina) {
		this.codigo = codigo;
		this.tipo = tipo;
		this.data = data;
		this.aluno = aluno;
		this.disciplina = disciplina;
	}

	public Solicitacao(String tipo, Aluno aluno, Disciplina disciplina) {
		this.tipo = tipo;
		this.aluno = aluno;
		this.disciplina = disciplina;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date data=new Date();
		this.data = sdf.format(data);
	}
	
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}
	
	
}
