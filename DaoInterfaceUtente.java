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
public interface DaoInterfaceUtente {
    public UtenteModel getUtenteInfo(String nome);
    public boolean insertNewUtente(UtenteModel utente);
    public boolean updateUtenteInfo(String nomeColonna,String email);
public UtenteModel  getUtenteSmartphone (String email);
}