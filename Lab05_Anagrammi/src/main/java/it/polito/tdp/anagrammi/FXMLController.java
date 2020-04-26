package it.polito.tdp.anagrammi;

import java.util.List;
import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.anagrammi.DAO.AnagrammaDAO;
import it.polito.tdp.anagrammi.model.Parola;
import it.polito.tdp.anagrammi.model.Ricerca;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	Ricerca ric;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnReset;

    @FXML
    private TextField txtInput;

    @FXML
    private Button btnCalcola;

    @FXML
    private TextArea txtCorretti;

    @FXML
    private TextArea txtErrati;

    @FXML
    void doCalcola(ActionEvent event) {
    	this.txtCorretti.clear();
    	this.txtErrati.clear();
    	String parola=this.txtInput.getText();
    	List<Parola> lista=ric.anagrammi(parola);
    	for(Parola p:lista) {
    		if(p!=null) {
    			if(p.isCorrect()) {
    				this.txtCorretti.appendText(p.getParola()+"\n");
    			}
    			else {
    				this.txtErrati.appendText(p.getParola()+"\n");
    			}
    		}
    	}
    }

    @FXML
    void doReset(ActionEvent event) {
    	this.txtCorretti.clear();
    	this.txtErrati.clear();
    	this.txtInput.clear();
    }

    @FXML
    void initialize() {
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtInput != null : "fx:id=\"txtInput\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCalcola != null : "fx:id=\"btnCalcola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtCorretti != null : "fx:id=\"txtCorretti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtErrati != null : "fx:id=\"txtErrati\" was not injected: check your FXML file 'Scene.fxml'.";

    }

	public void setRicerca(Ricerca model) {
		this.ric=model;
		
	}
}
