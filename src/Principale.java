
public class Principale {

	public static void main(String[] args) 
	{
		Agente A = new Agente("Agente1", "cognome1", 1);
		
		Cliente C1 = new Cliente("cliente1", "cognome1", 1);
		Cliente C2 = new Cliente("cliente2", "cognome2", 2);
		Cliente C3 = new Cliente("cliente3", "cognome3", 3);
		
		A.addVoli();
		System.out.println("Lista voli:");
		A.printVoli();
		
		C1.Prenotazione(A, "Amsterdam", 3);
		C2.Prenotazione(A, "Bali", 5);
		C3.Prenotazione(A, "Bali", 4);
		C1.Prenotazione(A, "Newyork", 2);
		C2.Prenotazione(A, "Bali", 3);		
		C3.Prenotazione(A, "Bali", 3);
		
		System.out.println("Lista prenotazioni iniziale:");
		A.printPrenotazioni();
		
		C2.disdiciPrenotazione(A, "Bali");
		
		System.out.println("Lista prenotazioni dopo cancellazione:");
		A.printPrenotazioni();
		
		
	}

}
