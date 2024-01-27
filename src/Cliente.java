
public class Cliente extends Persona{

	public Cliente(String nome, String cognome, int Id) {
		// TODO Auto-generated constructor stub
		super(nome, cognome, Id);
	}

	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return nome;
	}

	@Override
	public String getCognome() {
		// TODO Auto-generated method stub
		return cognome;
	}

	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return Id;
	}
	
	public void Prenotazione(Agente A, String V, int Posti) {
		A.confermaPrenotazione(nome, cognome, V, Posti);
	}
	
	public void disdiciPrenotazione(Agente A, String V) {
		A.cancellaPrenotazione(nome, cognome, V);
	}
	
}
