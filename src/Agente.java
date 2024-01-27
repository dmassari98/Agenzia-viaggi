import java.util.*;
import java.io.*;

public class Agente extends Persona{
	
	File V;
	File StoricoViaggi;
	ArrayList<Volo> Voli;
	ArrayList<Prenotazione> ListaPren;

	public Agente(String nome, String cognome, int id) {
		// TODO Auto-generated constructor stub
		super(nome, cognome, id);
		V = new File("ListaVoli.txt");
		StoricoViaggi = new File("Storico.txt");
		Voli = new ArrayList<Volo>();
		ListaPren = new ArrayList<Prenotazione>();
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
	public int getId()
	{
		// TODO Auto-generated method stub
		return Id;
	}	
	
	public void addVoli() //reperisce i voli e modifica il prezzo, partenza(problema), posti.
	{
		String nomevolo, p;
		int costo, posti;
		
		try 
		{
			Scanner s = new Scanner(V);
			Scanner input = new Scanner(System.in);			
			while(s.hasNextLine()) 
			{				
				nomevolo=s.nextLine();				
				System.out.println(nomevolo);
				
				System.out.println("Partenza volo:"); //problema
				p = input.nextLine();
				System.out.println("Costo:");
				costo = input.nextInt();
				System.out.println("Posti:");
				posti = input.nextInt();
				
				Volo Volo = new Volo(nomevolo, p, costo, posti);
				Voli.add(Volo);
				
				System.out.println("Voli caricati correttamente");
				
			}
			input.close();
			s.close();
		}
		catch (FileNotFoundException e)
		{
			System.out.println("Lista voli non trovata");
		}

	}
	
	public void confermaPrenotazione(String nome, String cognome, String V, int nPosti) 
	{
		int temp=isAvaible(V);
		
		if(temp!=-1) 
		{			
			if(Voli.get(temp).getPosti()-nPosti<0)
			{
				System.out.println(nome+" "+ cognome + " Prenotazione non effettuata! posti insufficienti");
			}
			else
			{
				Prenotazione P = new Prenotazione(nome, cognome, Voli.get(temp).getNome(), Voli.get(temp).getCosto(), nPosti);
				ListaPren.add(P);
				System.out.println(nome+" "+cognome+" Prezzo totale:"+P.getPrezzototale());
				Voli.get(temp).modifier(Voli.get(temp).getPosti()-nPosti);
				scriviStorico();
			}
		}
		else 
		{
			System.out.println(nome+" "+ cognome + " Prenotazione non effettuata! posti insufficienti");
		}	
	}
	
	protected int isAvaible(String volo)
	{
		String temp;
		int posti, id=0;
		
		while(id<Voli.size()) 
		{
			temp = Voli.get(id).getNome();
			posti = Voli.get(id).getPosti();
			
			if(temp.contentEquals(volo) && posti>0)
			{	
				return id;				
			}
			else 
			{
				id++;
			}
			
		}
		return -1;
	}
	
	protected void scriviStorico() {
		BufferedWriter scrivi = null;
		try {
			scrivi = new BufferedWriter(new PrintWriter(StoricoViaggi));
			for(int i=0; i<ListaPren.size();i++)
					scrivi.write((i+1)+") "+ListaPren.get(i).infoPrenotazione()+" \n");
			scrivi.close();
		} catch (Exception e) {
			System.out.println("Problema nella scrittura del file!");
		}
	
	}
	
	public void cancellaPrenotazione(String nome, String cognome, String volo){
		int i=0;
		boolean flag = true;
		while(flag) {
			if(ListaPren.get(i).infoCliente().equals(nome+" "+cognome+" "+volo))
			{
				ListaPren.remove(i);
				flag=false;
				
				try {
					PrintWriter scrivi = new PrintWriter(StoricoViaggi);
					for(int j=0; j<ListaPren.size();j++) {
							scrivi.write((j+1)+") "+ListaPren.get(j).infoPrenotazione()+" \n"); //riscrive il file che le prenotazioni rimanenti
					}
					scrivi.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println("Problema nella scrittura del file!");
				}
				
				System.out.println("prenotazione: "+ (i+1)+") "+ nome+" " +cognome+ " del Volo:" + volo +" Cancellata");
				
			}else {
				i++;
			}
		}
		
	}
	
	public void printPrenotazioni() {
		for(int i=0;i<ListaPren.size();i++) {
			System.out.println(ListaPren.get(i).infoPrenotazione());
		}
	}
	
	public void printVoli() {
		for(int i=0;i<Voli.size();i++) {
			System.out.println(Voli.get(i).getNome());
			System.out.println(Voli.get(i).getCosto());
		}
	}

}
