package br.com.ServidorCliente;

import java.io.*;
import java.util.*;

public class TrataCliente implements Runnable {

    private InputStream saidaCliente;
	private OutputStream entradaCliente;
	private Servidor servidor;
	private String endereco;

    public TrataCliente(InputStream saidaCliente, OutputStream entradaCliente, Servidor servidor, String endereco) {
        this.saidaCliente = saidaCliente;
        this.entradaCliente = entradaCliente;
        this.endereco = endereco;
        this.servidor = servidor;
    }

    public void run() {
        Scanner s = new Scanner(this.saidaCliente);
        PrintStream e = new PrintStream(this.entradaCliente);
        try{
        	while (s.hasNextLine()) {
        		System.out.print("Cliente "+endereco+" solicitou operacao ");
        		servidor.executarSql(s, e);
        		Thread.sleep(1000);
        	}
        }
        catch(NullPointerException e1){
        	System.out.println(e1.getMessage());
        } catch (InterruptedException e1) {
			System.out.println(e1.getMessage());
		}
        finally{
        	s.close();
        }
    }
}