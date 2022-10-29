package model;

import java.util.ArrayList;

public class ListaDeThreads {
	private static ListaDeThreads instancia;
	private ArrayList<JThread> threads;
	
	private ListaDeThreads() {
		threads = new ArrayList<>();
	}
	    
	synchronized public static ListaDeThreads obterInstancia() {
        if(instancia == null)
            instancia = new ListaDeThreads();
        return instancia;
    }
    
    public void adicionarThread(JThread item) {
        threads.add(item);
    }

	public ArrayList<JThread> getThreads() {
		return threads;
	}

	public void setThreads(ArrayList<JThread> threads) {
		this.threads = threads;
	}
}
