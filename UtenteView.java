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
public class UtenteView {
  
	
	private UtenteModel person;
	
	public UtenteView(UtenteModel person){
		this.person = person;
	}
	
	public void printInfo(){
		System.out.println(person.toString());
	}
        public void printInfo2(){
		System.out.println(person.toString2());
	}

	public UtenteModel getUtente() {
		return person;
	}

	public void setUtente(UtenteModel person) {
		this.person = person;
	}
	
}  

