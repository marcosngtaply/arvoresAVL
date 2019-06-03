package trabalho.arvoresavl;

public class Lista {
	
	private ListaNo primeiroNo;// Declara variavel de instancia com o nome de
	// PrimeiroNó
	private ListaNo ultimoNo;// Declara variavel de instancia com o nome de
	// UltimoNó
	private String nome; // String como 'lista' usada na impressao

	private int tamanhoLista;

	// construtor cria List vazia com 'list' como o nome
	public Lista() {
		this("Lista");
		this.tamanhoLista = 0;
	}// fim do construtor sem argumentos List

	// construtor cria uma List vazia com um nome
	public Lista(String nomeDaLista) {
		nome = nomeDaLista;
		primeiroNo = ultimoNo = null;
		this.tamanhoLista = 0;
	}// fim do construtor de um argumento List
	// Insere Object na frente de List
	public void insereNoInicio(String insertItem) {
		
		if (estaVazia()) {	// primeiro e ultimo nó referenciam o mesmo objeto
			primeiroNo = ultimoNo = new ListaNo(insertItem);
		} 
		else {
			primeiroNo = new ListaNo(insertItem, primeiroNo);
		}	// fim do método insereNoInicio
		
		this.tamanhoLista++;
	}// fim do método insereNoInicio
		
	// insere Object no fim de Lista
	public void insereNoFim(String insertItem) {
		if (estaVazia()) {
			primeiroNo = ultimoNo = new ListaNo(insertItem);
		} else {
			ultimoNo = ultimoNo.proximoNo = new ListaNo(insertItem);
		}
		this.tamanhoLista++;
	}// fim do método insereNoFim
	
	//Insere na posição informada
		/*public void insertAtPosicao(int posicao, Object elemento) {
			
			
		}*/
		
		// remove o primeiro nó de List
		public String removeNoInicio() throws EmptyListException {
			if (estaVazia()) {
				throw new EmptyListException(nome);
			}
			String removedItem = primeiroNo.palavraNo; // recupera dados sendo removidos
			// atualiza referências primeiroNo e ultimoNo
			if (primeiroNo == ultimoNo) {
				primeiroNo = ultimoNo = null;
			} else {
				primeiroNo = primeiroNo.proximoNo;
			}
			this.tamanhoLista--;
			return removedItem;// retorna dados de nó removidas
		}// fim do método removeNoFim
		public Object removeNoFim() throws EmptyListException{
			if (estaVazia()){
				throw new EmptyListException(nome); //lança excessão se List estiver vazia
			} 
			
			String removedItem = ultimoNo.palavraNo; //recupera dados sendo removidos
			
			//atualiza referências primeiroNo e ultimoNo
			
			if(primeiroNo == ultimoNo){
				primeiroNo = ultimoNo = null;
			}
			
			else{ //localiza o novo último nó
				ListaNo current = primeiroNo;
			
				//faz loop enquanto nó atual não referencia lastNode
				while(current.proximoNo != ultimoNo){
					current = current.proximoNo;
				} 
				
				ultimoNo =	current; //atual é	novo lastNode
				current.proximoNo = null;
			}//fim do else
			
			this.tamanhoLista--;
			return removedItem; //retorna dados de nó removidos
		}//fim do método removeNoFim
	/*public Object removeFromPosicao(int posicao) throws EmptyListException {
		
		
			return null;
		}*/
	
	
		/*public boolean buscaElemento(Object elemento) {
		  
	}*/
	
	
	// Determina se a lista estiver vazia
	public boolean estaVazia() {
		return primeiroNo == null; // retorna true se List estiver vazia
	}// fim do método estaVazia
		// gera saída do conteúdo de List
		
	public void print() {
		if (estaVazia()) {
			System.out.printf("Lista Vazia %s\n", nome);
			System.out.println(imprimeTamanho());
			return;
		}// fim do if
		
		System.out.printf("A lista %s é: ", nome);
		ListaNo current = primeiroNo;
		// enquanto não estiver no fim da lista, gera saída dos dados do nó
		// atual
		while (current != null) {
			System.out.printf("%s -> ", current.palavraNo);
			current = current.proximoNo;
		}// fim do While
		System.out.printf("\n");
		System.out.println(imprimeTamanho());
	} // fim do método print
	
	public String imprimeTamanho(){
		return "Tamanho da Lista: " + this.tamanhoLista;
	}
}// fim da classe List

