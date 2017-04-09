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
public class UtenteModel {
       private int id; 
       private String imei;
       private String nome;
private String cognome;
 private String email;
   private String numCell;
   private String  numTelFisso;
    private SmartphoneModel smartphone;
    private String data; 

    public UtenteModel()
    {}
    
    public UtenteModel(int id, String imei, String nome, String cognome, String email, String numCell, String numTelFisso, String data) {
        this.id = id;
        this.imei = imei;
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.numCell = numCell;
        this.numTelFisso = numTelFisso;
        this.smartphone = smartphone;
        this.data=data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public int getId() {
        return id;
    }

    public String getImei() {
        return imei;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getEmail() {
        return email;
    }

    public String getNumCell() {
        return numCell;
    }

    public String getNumTelFisso() {
        return numTelFisso;
    }

    public SmartphoneModel getSmartphone() {
        return smartphone;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNumCell(String numCell) {
        this.numCell = numCell;
    }

    public void setNumTelFisso(String numTelFisso) {
        this.numTelFisso = numTelFisso;
    }

    public void setSmartphone(SmartphoneModel smartphone) {
        this.smartphone = smartphone;
    }
    
    public String toString() {
				
		StringBuilder builder = new StringBuilder();
		
		builder.append("Name = ").append(nome).append("\n")
		.append("Cognome = ").append(cognome).append("\n")
		.append("email = ").append(email).append("\n")
		.append(" cellulare ").append(numCell);	
		return builder.toString();
	}
     public String toString2() {
				
		StringBuilder builder = new StringBuilder();
		
		builder.append("Name = ").append(nome).append("\n")
		.append("Cognome = ").append(cognome).append("\n")
		.append("email = ").append(email).append("\n").append("\n")
		.append(" modello ").append(smartphone.getModello()).append("\n")
                .append(" marca ").append(smartphone.getMarca()).append("\n");
		return builder.toString();
	}
}
