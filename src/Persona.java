
public abstract class Persona {

	protected String nome, cognome;
	protected int Id;
	
	public Persona(String nome, String cognome, int id) {
		this.nome=nome;
		this.cognome=cognome;
		this.Id=id;
	}
	
	public abstract String getNome();
	
	public abstract String getCognome();
	
	public abstract int getId();

}
