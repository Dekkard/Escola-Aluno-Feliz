package br.com.ServidorCliente;

import java.io.*;
import java.util.*;

public class TrataCliente implements Runnable {

    private InputStream saidaCliente;
    private Servidor servidor;
	private OutputStream entradaCliente;

    public TrataCliente(InputStream saidaCliente, OutputStream entradaCliente, Servidor servidor) {
        this.saidaCliente = saidaCliente;
        this.servidor = servidor;
        this.entradaCliente = entradaCliente;
    }

    public void run() {
        Scanner s = new Scanner(this.saidaCliente);
        PrintStream e = new PrintStream(this.entradaCliente);
        while (s.hasNextLine()) {
        	System.out.print("nova operacao: ");
        	servidor.executarSql(s,e);
        	try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        }
        s.close();
    }
}