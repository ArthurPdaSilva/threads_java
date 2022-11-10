package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.JThread;
import model.ListaDeThreads;

public class HandleEditar implements ActionListener{

	private ListaDeThreads lt = ListaDeThreads.obterInstancia();
	private JPanel cor;
	private Tela tela;
	
	public HandleEditar(JPanel c, Tela t) {
		this.cor = c;
		this.tela = t;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		for (int i = 0; i < lt.getThreads().size(); i++) {
			String[] options = { "WAITING", "RUNNABLE", "RUN", "TIMED_WAITING", "TERMINATED" };
			int estado = JOptionPane.showOptionDialog(null, "Informe para qual estado deseja alterar:",
					"Escolha uma das opções a seguir: ", JOptionPane.DEFAULT_OPTION,
					JOptionPane.WARNING_MESSAGE, null, options, options[0]);
					JThread thread = lt.getThreads().get(i);
			switch (estado) {
			case 0:
				
				thread.esperar();
				System.out.println(thread.getState());
				cor = tela.status(thread);
				
				break;
			case 1:
				if(String.valueOf(thread.getState()).equals("NEW")) {
					thread.start();
					cor = tela.status(thread);
				}else {
					thread.notify();
				}
				break;
			case 2:
				thread.run();
				cor = tela.status(thread);
				break;
			case 3:
				try {
					int tempo = Integer.parseInt(JOptionPane.showInputDialog("Digite o tempo para ela ficar adormecida"));
					
					thread.join();
					cor = tela.status(thread);
					tela.dispose();
					tela = new Tela();
					
					Thread.sleep(tempo);
					
					
				} catch (InterruptedException e1) {e1.printStackTrace();}
				break;
			case 4:
				thread.interrupt();
				cor = tela.status(thread);
				break;
			}
			tela.dispose();
			new Tela();
			System.out.println(thread.getState());
		}
	}
}


