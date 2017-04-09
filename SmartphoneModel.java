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
public class SmartphoneModel {
    private String imei;
    private String marca;
    
    private String modello;
    private String anno;
    private String colore;
   private String  materiale;
   private String sistOp ;

    public SmartphoneModel()
    {}
    public SmartphoneModel(String imei, String marca, String modello,String anno, String colore, String materiale, String sistOp) {
        this.imei = imei;
        this.marca = marca;
        this.modello = modello;
        this.anno=anno;
        this.colore = colore;
        this.materiale = materiale;
        this.sistOp = sistOp;
    }

    public void setAnno(String anno) {
        this.anno = anno;
    }

    public String getAnno() {
        return anno;
    }

    public String getImei() {
        return imei;
    }

    public String getMarca() {
        return marca;
    }

    public String getModello() {
        return modello;
    }

    public String getColore() {
        return colore;
    }

    public String getMateriale() {
        return materiale;
    }

    public String getSistOp() {
        return sistOp;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

    public void setColore(String colore) {
        this.colore = colore;
    }

    public void setMateriale(String materiale) {
        this.materiale = materiale;
    }

    public void setSistOp(String sistOp) {
        this.sistOp = sistOp;
    }
   
    public String toString() {
				
		StringBuilder builder = new StringBuilder();
                        builder.append("Marca = ").append(marca).append("\n")
		.append("Modello = ").append(modello).append("\n")
		.append("colore = ").append(colore).append("\n")
		.append("materiale ").append(materiale);	
		return builder.toString();
    
    
    }
}
