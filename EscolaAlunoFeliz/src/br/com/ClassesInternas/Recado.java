package br.com.ClassesInternas;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Recado {
	private String codigo;
	private String recado;
	private String data;
	private String cpfAluno;
	private String codigoProfessor;
	
	public Recado(String codigo, String recado, String cpfAluno, String codigoProfessor) {
		this.codigo = codigo;
		this.recado = recado;
		this.cpfAluno = cpfAluno;
		this.codigoProfessor = codigoProfessor;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date data=new Date();
		this.data = sdf.format(data);
	}

	public Recado(String codigo, String recado, String data, String cpfAluno, String codigoProfessor) {
		this.codigo = codigo;
		this.recado = recado;
		this.data = data;
		this.cpfAluno = cpfAluno;
		this.codigoProfessor = codigoProfessor;
	}

	public Recado(String codigo) {
		this.codigo = codigo;
	}

	public String getCodigo() {
		return codigo;
	}
	
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public String getRecado() {
		return recado;
	}
	public void setRecado(String recado) {
		this.recado = recado;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}

	public String getCpfAluno() {
		return cpfAluno;
	}

	public void setCpfAluno(String cpfAluno) {
		this.cpfAluno = cpfAluno;
	}

	public String getCodigoProfessor() {
		return codigoProfessor;
	}

	public void setCodigoProfessor(String codigoProfessor) {
		this.codigoProfessor = codigoProfessor;
	}
}
