/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rubricatelefonica;

/**
 *
 * @author checco
 */
public class UtenteControl {
  

	private UtenteView utenteView;
	private UtenteModel utenteModel;
	
	public UtenteControl(UtenteView utenteView, UtenteModel utenteModel){		
		this.utenteView = utenteView;
		this.utenteModel = utenteModel;		
	}
		
	public void updateView(UtenteModel utenteModel){
		utenteView.setUtente(utenteModel);}
	
	public void updateModel(UtenteView personView){
		
		this.utenteModel = personView.getUtente();		
	}

	public UtenteView getUtenteView() {
		return utenteView;
	}

	public void setPersonView(UtenteView personView) {
		this.utenteView = utenteView;
	}

	public UtenteModel getUtenteModel() {
		return utenteModel;
	}

	public void setUtenteModel(UtenteModel utenteModel) {
		this.utenteModel = utenteModel;
	}
}
