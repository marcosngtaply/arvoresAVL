package trabalho.arvoresavl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;

public class LerArquivo {
	
	private String nomeArq;//Endereço do arquivo no computador
	private String[] vetorLista;
	public LerArquivo() {
		this.nomeArq = "./Arquivos/Professores.csv";
	}

	public LerArquivo(String local, String[] vetorLista) {
		this.nomeArq = local;
		this.vetorLista = vetorLista;
	}
	
	public String[] leitura() {
		
		int tam = 100;
		String[] professores = new String[tam];
			
		try {
				FileReader localArq = new FileReader(nomeArq);
				BufferedReader leitorDeLinhas = new BufferedReader(localArq);
				
				String linha = " "; 

				linha = leitorDeLinhas.readLine();
					
				int i = 0;
				
				while(linha != null) {
						professores[i] = linha;
						linha = leitorDeLinhas.readLine();
						System.out.println(professores[i]);
						i++;
						
				}
					
			localArq.close();
			JOptionPane.showMessageDialog(null,"Arquivo lido com sucesso!");
			
			}
			catch (IOException e) {
				JOptionPane.showMessageDialog(null,"Erro na leitura do arquivo: " + 
		                e.getMessage());
		    }
			this.vetorLista = professores;
		return vetorLista;	
			
	}

	public String getNomeArq() {
		return nomeArq;
	}

	public void setNomeArq(String nomeArq) {
		this.nomeArq = nomeArq;
	}

	public String[] getVetorLista() {
		return vetorLista;
	}

	public void setVetorLista(String[] vetorLista) {
		this.vetorLista = vetorLista;
	}
	
}
	

