package model;

public class JThread extends Thread{

	private String nome;
	
	public JThread(String n) {
		this.nome = n;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String name) {
		this.nome = name;
	}
	
	@Override
	public void run() {
		System.out.println("Thread " + this.getNome() + " Rodadando");

		try {
			this.wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void esperar() {
		try {
			this.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
