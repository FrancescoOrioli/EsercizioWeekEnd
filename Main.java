package com.mycompany.rubricatelefonica;

import java.util.Scanner;
import org.apache.log4j.Logger;

/**
 * Hello world!
 *
 */
public class Main {

    final static Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) {

/////////////////////////////////////////////////
////////////////////////////////////// iniserire smartphone
//dal front la vista viene aggiornata --> aggiorniamo il model e poi il db
        //personModel.setEmail("marino.pino@gmail.com");
        //aggiorno la vista
        //personController.updateView(personModel);
        //personView.printInfo();
        //aggiorno il db
        //updateUser(personModel);
        ///////////// prova join ////////////////
        /*  UtenteModel personModel = getUtenteSmartphoneFromDB("marco.ol@gmail.com"); //TODO qualche check su args[0]
        UtenteView personView = new UtenteView(personModel);
        UtenteControl personController = new UtenteControl(personView, personModel);

      personView.printInfo2();
        ////////////////////
         */
        ////////////////////////prova update
        /* UtenteModel utenteModel=new UtenteModel();
   UtenteView utenteView= new UtenteView(utenteModel);
            UtenteControl personController = new UtenteControl( utenteView,utenteModel);
    boolean update= updateUserFromDb("marco","marco.ol@gmail.com"); 
        if(update)
        {
           utenteModel = getPersonFromDB("marco");
                            personController.setUtenteModel(utenteModel);
                            personController.updateView(utenteModel);
                            System.out.println("Utente aggiornato");
                             utenteView.printInfo();
                           
        }
    //aggiorno la vista
       
        //personView.printInfo();
        //aggiorno il db
        //updateUser(personModel);
         */
        int choice;
        Scanner input = new Scanner(System.in);
        int scelta;
        String utente, smart;

        UtenteModel utenteModel = null;
        UtenteView utenteView = null;
        UtenteControl personControl = null;

        SmartphoneModel smartphoneModel = null;
        SmartphoneView smartphoneView = null;
        SmartphoneControl smartphoneControl = null;

        do {
            System.out.println("MAIN MENU\n1.Ricerca utente tramite email\n2.Ricerca telefono tramite imei  \n3.Inserire nuovo utente\n4Inserire nuovo telefono\n5.Ricerca info su utente e telefono5\n6.Inserire email dell utente a cui vuoi aggiornare il nome\n0.Esci");
            scelta = input.nextInt();
            switch (scelta) {
                case 1:
                    System.out.println("inserire email utente da cercare (ad esempio sasso.lino@gmail.com )");
                    utente = input.next();
                    utenteModel = getPersonFromDB(utente);
                    utenteView = new UtenteView(utenteModel);
                    personControl = new UtenteControl(utenteView, utenteModel);

                    personControl.setUtenteModel(utenteModel);
                    personControl.updateView(utenteModel);

                    utenteView.printInfo();
                    break;

                case 2:
                    System.out.println("inserire imei smartphone da cercare (ad esempio B5555 ");
                    smart = input.next();
                    smartphoneModel = getSmartphoneFromDB(smart);
                    smartphoneView = new SmartphoneView(smartphoneModel);
                    smartphoneControl = new SmartphoneControl(smartphoneView, smartphoneModel);

                    smartphoneControl.setSmartphoneModel(smartphoneModel);
                    smartphoneControl.updateView(smartphoneModel);

                    smartphoneView.printInfo();
                    break;

                case 3:
                    int key;
                    String imei;
                    System.out.println("inserire Dati utente: ");
                    System.out.println("key: ");
                    key = input.nextInt();
                    System.out.println("imei telefono posseduto: ");
                    imei = input.next();
                    System.out.println("nome utente: ");
                    String nome = input.next();
                    System.out.println("Cognome utente: ");
                    String Cognome = input.next();
                    System.out.println("Email utente: ");
                    String email = input.next();
                    System.out.println("Telefono cellulare utente: ");
                    String cell = input.next();
                    System.out.println("telefono fisso: ");
                    String fisso = input.next();
                    System.out.println("data nascita anno-giorno-mese: ");
                    String data = input.next();

                    UtenteModel utente1 = new UtenteModel(key, imei, nome, Cognome, email, cell, fisso, data);

                    UtenteControl personController2 = new UtenteControl(utenteView, utente1);
                    personController2.updateView(utente1);
                    if (insertUtenteInDb(utente1)) {
                        System.out.println("elemento inserito con successo");
                    } else {
                        System.out.println("elemento non inserito");
                    }
                    break;

                case 4:

                    System.out.println("inserire imei non presente nel database (ad esempio 9998A): ");
                    String ime = input.next();
                    System.out.println("inserire marca: ");
                    String marca = input.next();
                    System.out.println("inserire modello: ");
                    String modelli = input.next();
                    System.out.println("inserire anno di Produzione: ");
                    String anno = input.next();
                    System.out.println("inserire colore: ");
                    String colore = input.next();
                    System.out.println("inserire materiale: ");
                    String materiale = input.next();
                    System.out.println("inserire colore: ");
                    String color = input.next();
                    System.out.println("inserire sistemaOperativo: ");
                    String so = input.next();
                    SmartphoneModel s1 = new SmartphoneModel(ime, marca, modelli, anno, color, materiale, so);
                    smartphoneControl = new SmartphoneControl(smartphoneView, s1);
                    smartphoneControl.updateView(s1);
                    boolean trovato = insertSmartphoneInDb(s1);
                    if (trovato) {
                        System.out.println("elemento inserito con successo");
                    } else {
                        System.out.println("elemento non inserito");
                    }
                    break;

                case 5:
                    System.out.println("inserire imeil dell'utente di cui vuoi avere informazioni sui suoi dati e sul suo cellulare (ad esempio luca.bard@msn.com):");
                    String email1 = input.next();

                    utenteModel = getUtenteSmartphoneFromDB(email1); //TODO qualche check su args[0]
                    utenteView = new UtenteView(utenteModel);
                    personControl = new UtenteControl(utenteView, utenteModel);

                    personControl.setUtenteModel(utenteModel);
                    personControl.updateView(utenteModel);

                    utenteView.printInfo2();
                    break;

                case 6:

                    System.out.println("inserire email dell' utente a cui vuoi modificare il nome (ad esempio maria.rosa@libero.ot) ");
                    String email2 = input.next();
                    System.out.println("inserire il nuovo nome");
                    String nome2 = input.next();
                    getPersonFromDB(nome2);
                    utenteView = new UtenteView(utenteModel);
                    UtenteControl personController = new UtenteControl(utenteView, utenteModel);

                    boolean update = updateUserFromDb(nome2, email2);
                    if (update) {
                        utenteModel = getPersonFromDB("marco");
                        personController.setUtenteModel(utenteModel);
                        personController.updateView(utenteModel);
                        System.out.println("Utente aggiornato");
                    }
                    break;

            }
        } while (scelta != 0);

    }

    private static boolean updateUserFromDb(String nomeColonna, String email) {
        DaoInterfaceUtente personDAO = new DefaultUtenteDao();
        return personDAO.updateUtenteInfo(nomeColonna, email);
    }

    private static boolean insertSmartphoneInDb(SmartphoneModel s) {
        DaoInterfaceSmartphone smartphoneDAO = new DefaultSmartphoneDao();
        return smartphoneDAO.insertNewSmartphone(s);
    }

    private static boolean insertUtenteInDb(UtenteModel utente) {
        DaoInterfaceUtente utenteDAO = new DefaultUtenteDao();
        return utenteDAO.insertNewUtente(utente);
    }

    private static SmartphoneModel getSmartphoneFromDB(String imei) {

        DaoInterfaceSmartphone SmartphoneDAO = new DefaultSmartphoneDao();
        return SmartphoneDAO.getSmartphoneInfo(imei);
    }

    private static UtenteModel getUtenteSmartphoneFromDB(String email) {
        DaoInterfaceUtente personSmDAO = new DefaultUtenteDao();
        return personSmDAO.getUtenteSmartphone(email);
    }

    private static UtenteModel getPersonFromDB(String nome) {

        DaoInterfaceUtente personDAO = new DefaultUtenteDao();
        return personDAO.getUtenteInfo(nome);
    }
}
