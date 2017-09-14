package br.com.ClassesInternas;

import java.util.Date;

public class Nota {
	private String nota;
	private Date data;
	
	public Nota(String nota, Date data) {
		super();
		this.nota = nota;
		this.data = data;
	}
	public String getNota() {
		return nota;
	}
	public void setNota(String nota) {
		this.nota = nota;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	
}
