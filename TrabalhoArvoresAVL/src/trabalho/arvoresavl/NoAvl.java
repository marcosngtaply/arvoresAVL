package trabalho.arvoresavl;

public class NoAvl {
	
	protected int altura;      
	protected int key;
    protected NoAvl esquerda, direita;
   
    public NoAvl ( int theElement ) {
        this( theElement, null, null );
    }
   
    public NoAvl (int theElement, NoAvl lt, NoAvl rt ) {
        key = theElement;
        esquerda = lt;
        direita = rt;
        altura   = 0;
    }
	@Override
	
	public String toString() {
		return "NoAvl [altura=" + altura + ", key=" + key + ", esquerda=" + esquerda + ", direita=" + direita + "]";
	}
	
	public int getaltura() {
		return altura;
	}
	
	public void setaltura(int altura) {
		this.altura = altura;
	}
	
	public int getKey() {
		return key;
	}
	
	public void setKey(int key) {
		this.key = key;
	}
	
	public NoAvl getesquerda() {
		return esquerda;
	}
	
	public void setesquerda(NoAvl esquerda) {
		this.esquerda = esquerda;
	}
	
	public NoAvl getdireita() {
		return direita;
	}
	
	public void setdireita(NoAvl direita) {
		this.direita = direita;
	}
}