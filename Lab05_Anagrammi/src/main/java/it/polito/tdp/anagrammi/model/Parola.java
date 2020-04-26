package it.polito.tdp.anagrammi.model;

public class Parola {
	String parola;
	boolean correct;
	public Parola(String parola) {
		correct=false;
		this.parola = parola;
	}
	public String getParola() {
		return parola;
	}
	public void setParola(String parola) {
		this.parola = parola;
	}
	public boolean isCorrect() {
		return correct;
	}
	public void setCorrect(boolean correct) {
		this.correct = correct;
	}
	@Override
	public String toString() {
		return parola+" "+correct;
	}
	
}
