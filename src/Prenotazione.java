
public class Prenotazione {
	
	protected int Prezzototale, posti;
	protected String nome, cognome, volo;

	public Prenotazione(String nome, String cognome, String V, int prezzo, int posti) {
		// TODO Auto-generated constructor stub
		this.posti=posti;
		this.nome=nome;
		this.cognome=cognome;
		this.volo=V;
		this.posti=posti;
		this.Prezzototale= posti*prezzo;
	}
	
	public int getPrezzototale(){
		return Prezzototale;
	}
	
	public String infoPrenotazione() {
		return "volo "+volo+" cliente: "+cognome+" "+nome+" Posti: "+ posti + " PrezzoTotale: " + Prezzototale;
	}
	
	public String infoCliente() {
		return nome+" "+cognome+" "+volo;
	}
}
