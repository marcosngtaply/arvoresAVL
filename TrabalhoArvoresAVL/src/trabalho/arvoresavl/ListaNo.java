package trabalho.arvoresavl;

public class ListaNo {

	String palavraNo;
	ListaNo proximoNo;
	
	public ListaNo(String palavraNo, ListaNo proximoNo) {

		this.palavraNo = palavraNo;
		this.proximoNo = proximoNo;
	}
	
	public ListaNo(String palavraNo) {

		this.palavraNo = palavraNo;
		
	}

	public ListaNo() {

	}

	public String getpalavraNo() {
		return palavraNo;
	}

	public void setpalavraNo(String palavraNo) {
		this.palavraNo = palavraNo;
	}

	public ListaNo getProximoNo() {
		return proximoNo;
	}

	public void setProximoNo(ListaNo proximoNo) {
		this.proximoNo = proximoNo;
	}
	
	
	
}
