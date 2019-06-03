package trabalho.arvoresavl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;

public class LerArquivo {
	
	private String nomeArq;//Endereço do arquivo no computador
	
	public LerArquivo() {
		this.nomeArq = "./Arquivos/Professores.csv";
	}

	public LerArquivo(String local) {
		this.nomeArq = local;
	}
	
	public void leitura() {
		
			
			try {
				FileReader localArq = new FileReader(nomeArq);
				BufferedReader leitorDeLinhas = new BufferedReader(localArq);
				
				String linha = " "; 

				linha = leitorDeLinhas.readLine();
				
				String[] professores = new String[100];
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
			
			
			
	}
}
	

