
public class Volo {
	
	protected String nome, partenza;
	protected int costo, posti;

	public Volo(String n, String p, int c, int posti) {
		// TODO Auto-generated constructor stub
		this.costo=c;
		this.nome=n;
		this.partenza=p;
		this.posti=posti;		
	}
	
	public int getPosti() {
		return posti;
	}
	
	public int getCosto() {
		return costo;
	}

	public String getNome() {
		return nome;
	}
	
	public String getPartenza() { 
		return partenza;
	}
	
	public void modifier(int p) {
		posti = p;
	}
	
}
