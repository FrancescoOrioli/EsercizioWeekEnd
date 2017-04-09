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
public class SmartphoneControl {
    	private SmartphoneView smartphoneView;
	private SmartphoneModel smartphoneModel;
	
	public SmartphoneControl(SmartphoneView smartphoneView, SmartphoneModel smartphoneModel){		
		this.smartphoneView = smartphoneView;
		this.smartphoneModel = smartphoneModel;		
	}
		
	public void updateView(SmartphoneModel smartphoneModel){
		smartphoneView.setSmartphone(smartphoneModel);
	}
	
	public void updateModel(SmartphoneView smartphoneView){
		
		this.smartphoneModel = smartphoneView.getSmartphone();		
	}

	public SmartphoneView getSmartphoneView() {
		return smartphoneView;
	}

	public void setSmartphoneView(SmartphoneView smartphoneView) {
		this.smartphoneView = smartphoneView;
	}

	public SmartphoneModel getSmartphoneModel() {
		return smartphoneModel;
	}

	public void setSmartphoneModel(SmartphoneModel smartphoneModel) {
		this.smartphoneModel = smartphoneModel;
	}
}
