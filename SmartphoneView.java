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
public class SmartphoneView {
    
    private SmartphoneModel smartph;
	
	public SmartphoneView(SmartphoneModel smartph){
		this.smartph = smartph;
	}
	
	public void printInfo(){
		System.out.println(smartph.toString());
	}

	public SmartphoneModel getSmartphone() {
		return smartph;
	}

	public void setSmartphone(SmartphoneModel smartph) {
		this.smartph=smartph;
	}
    
}
