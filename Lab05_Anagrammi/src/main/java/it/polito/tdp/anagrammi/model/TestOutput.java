package it.polito.tdp.anagrammi.model;

import java.util.List;

public class TestOutput {
	
	public static void main(String[] args) {
	
		
	Ricerca ric=new Ricerca();
	  List<Parola> s=ric.anagrammi("eat");
	  System.out.print(s);
	}

}
