package it.polito.tdp.anagrammi.model;

import java.util.*;

import it.polito.tdp.anagrammi.DAO.AnagrammaDAO;

public class Ricerca {
	AnagrammaDAO dao=new AnagrammaDAO();
	private List<Parola> soluzione;
	public List<Parola> anagrammi(String parola){
		this.soluzione=new ArrayList<>();
		parola=parola.toLowerCase();
		int livello=0;
		List<Character> disponibili=new ArrayList<>();
		for(int i=0;i<parola.length();i++) {
			disponibili.add(parola.charAt(i));
		}
		//avvio ricorsione
		cerca("",livello,disponibili);
		return soluzione;
	}
	/**
	 * procedura ricorsiva per il calcolo dell'anagramma
	 * @param parziale parte iniziale dell'anagramma fatto fin'ora
	 * @param livello della ricorsione pari a parziale.lenght()
	 * @param disponibili insieme delle lettere ancora non utilizzate
	 */
	private void cerca(String parziale,int livello, List<Character> disponibili) {
		if(disponibili.size()==0) { //oppure livello=parola.length()
			//caso terminale
			Parola pTemp=new Parola(parziale);
			pTemp.setCorrect(dao.isCorrect(parziale));
			this.soluzione.add(pTemp);
		}
		//caso normale
		//provare ad aggiungere alla parziale tutti i caretteri presenti tra i disponibili
		for(Character ch: disponibili) {
			String tentativo = parziale + ch ;
			
			List<Character> rimanenti= new ArrayList<>(disponibili);
			rimanenti.remove(ch);
			
			cerca(tentativo, livello+1, rimanenti);
		}
	}
}
