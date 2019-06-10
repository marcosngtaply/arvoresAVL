package trabalho.arvoresavl;

public class PrincipalTeste {

	public static void main(String[] args) {
		
		LerArquivo prof = new LerArquivo();
		prof.leitura();
		String[] vetorLista = new String[prof.getVetorLista().length];
		vetorLista = prof.getVetorLista();
		vetorLista.toString();
		
		Lista listaLigada = new Lista("Lista de Professores");
		
		/*for(int i = 0; i < vetorLista.length; i++) {
			listaLigada.insereNoFim(vetorLista[i]);
		}
		listaLigada.print();*/
		for(int i = 0; i < vetorLista.length; i++) {
			listaLigada.insereNoInicio((vetorLista[i]));
		}
		listaLigada.print();
		
	}
}
