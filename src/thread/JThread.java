package thread;

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
	
	
}
