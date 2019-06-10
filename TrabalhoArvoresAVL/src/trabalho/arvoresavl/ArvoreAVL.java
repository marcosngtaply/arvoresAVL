package trabalho.arvoresavl;


public class ArvoreAVL {
	
    
    private NoAvl raiz = null;
    
    public ArvoreAVL( ) {
        raiz = null;
    }
    
    public void clear() {
        raiz = null;
    }
    
    public boolean isEmpty() {
        return raiz == null;
    }
    
    public NoAvl getraizNode (){
        return raiz;
    }
    /** Retorna a altura da Ã¡rvore */
    
    private int altura( NoAvl t ) {
        return t == null ? -1 : t.altura;
    }
     /**
     * Retorna o maior valor ente lhs e rhs.
     */
   
    private  int max( int lhs, int rhs ) {
        return lhs > rhs ? lhs : rhs;
    }
    /** Retorna o fator de balanceamento da Ã¡rvore com raiz t */ 
   
    private int getFactor (NoAvl t) {
        return altura( t.esquerda ) - altura( t.direita );
    }
   
    public boolean insert (int x) {
        raiz = insert (x, raiz);
        return true;
    }
   
    private NoAvl insert (int x, NoAvl t) {
        if( t == null )
            t = new NoAvl( x, null, null );
        else if( x<t.key ) t.esquerda = insert( x, t.esquerda );
        else if( x>t.key) t.direita = insert( x, t.direita );
        t = balance (t);
        return t;
    }
    
    public NoAvl balance (NoAvl t) {
        if ( getFactor(t) == 2 ) {
                if (getFactor (t.esquerda)>0) t = dodireitaRotation( t );
                else t = doDoubledireitaRotation( t );
        }
        else if ( getFactor(t) == -2 ) {
                if ( getFactor(t.direita)<0 ) t = doesquerdaRotation( t );
                else t = doDoubleesquerdaRotation( t );
        }
        t.altura = max( altura( t.esquerda ), altura( t.direita ) ) + 1;
        return t;
    }
    /** Faz RotaÃ§Ã£o simples a direita */
    
    private  NoAvl dodireitaRotation( NoAvl k2 ) {
        NoAvl k1 = k2.esquerda;
        k2.esquerda = k1.direita;
        k1.direita = k2;
        k2.altura = max( altura( k2.esquerda ), altura( k2.direita ) ) + 1;
        k1.altura = max( altura( k1.esquerda ), k2.altura ) + 1;
        return k1;
    }
    /** RotaÃ§Ã£o simples Ã  esquerda */
   
    private  NoAvl doesquerdaRotation( NoAvl k1 ) {
        NoAvl k2 = k1.direita;
        k1.direita = k2.esquerda;
        k2.esquerda = k1;
        k1.altura = max( altura( k1.esquerda ), altura( k1.direita ) ) + 1;
        k2.altura = max( altura( k2.direita ), k1.altura ) + 1;
        return k2;
    }
    /** RotaÃ§Ã£o dupla Ã  direita */
    
    private  NoAvl doDoubledireitaRotation( NoAvl k3 ) {
        k3.esquerda = doesquerdaRotation( k3.esquerda );
        return dodireitaRotation( k3 );
   }
    /** RotaÃ§Ã£o dupla Ã  esquerda */
   
    private  NoAvl doDoubleesquerdaRotation( NoAvl k1 ) {
        k1.direita = dodireitaRotation( k1.direita );
        return doesquerdaRotation( k1 );
    }
    
    public NoAvl search(int el) {
        return search(raiz,el);
    }
    
    protected NoAvl search(NoAvl p, int el) {
        
    	while (p != null) {
            /* se valor procuradp == chave do nÃ³ retorna referÃªncia ao nÃ³ */ 
            if (el==p.key) return p;
            /* se valor procurado < chave do nÃ³, procurar na sub-Ã¡rvore esquerda deste nÃ³ */
            else if (el<p.key) p = p.esquerda;
            /* se valor procurado > chave do nÃ³, procurar na sub-Ã¡rvore direita deste nÃ³ */
            else p = p.direita;
        }
        // caso chave nÃ£o foi achada, retorna null
        return null;
    }
    
    public void inorder() {
        inorder(raiz);
    }
   
    protected void inorder(NoAvl p) {
         if (p != null) {
             inorder(p.esquerda);
             System.out.print(p.key+" - ");
             inorder(p.direita);
        }
    }
    public void preorder() {
        preorder(raiz);
    }
    protected void preorder(NoAvl p) {
        if (p != null) {
             System.out.print(p.key + " ");
             preorder(p.esquerda);
             preorder(p.direita);
        }
    }
    public void postorder() {
        postorder(raiz);
    }
    protected void postorder(NoAvl p) {
        if (p != null) {
             postorder(p.esquerda);
             postorder(p.direita);
             System.out.print(p.key + " ");
        }
    }
    protected NoAvl searchFather (int el) {
    
    	NoAvl p = raiz;
    	NoAvl prev = null;
   
    while (p != null && !(p.key==el)) {  // acha o nÃ³ p com a chave el
        prev = p;                           
        if (p.key<el)
              p = p.direita;
        else p = p.esquerda;
    }
         if (p!=null && p.key==el) return prev;
       return null;
}
    public void displayTree() {
	   if (isEmpty()){
		System.out.println("Ã�rvore vazia!");
		return;
	}    		
	String separator = String.valueOf("  |__");
	System.out.println(this.raiz.key+"("+raiz.altura+")");
	displaySubTree(raiz.esquerda,  separator);
	displaySubTree(raiz.direita, separator);
}
    private void displaySubTree(NoAvl node, String separator) {
	    if (node != null) {
		NoAvl father = this.searchFather(node.key);
		if (node.equals(father.esquerda) == true) {
			System.out.println(separator+node.key+"("+node.altura+")"+" (ESQ)");
		}else{
			System.out.println(separator+node.key+"("+node.altura+")"+" (DIR)");
		}			
		displaySubTree(node.esquerda,  "     "+separator);
		displaySubTree(node.direita, "     "+separator);
	}
}

}
