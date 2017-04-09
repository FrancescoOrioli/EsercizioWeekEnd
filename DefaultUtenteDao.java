/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rubricatelefonica;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.commons.dbutils.DbUtils;

/**
 *
 * @author checco
 */
public class DefaultUtenteDao implements DaoInterfaceUtente {

    //final static Logger logger = Logger.getLogger(DefaultUtenteDAO.class);
    final static String UPDATE = "UPDATE Utente SET nome=? WHERE email = ?;";
    final static String USER_SMARTH_INFO = "SELECT u.nome,u.cognome,u.email,s.marca,s.modello FROM Utente u INNER JOIN Smartphone s on s.imei= u.imei WHERE email=?; ";
    final static String USER_INFO = "SELECT nome,cognome,email, numCell FROM Utente where email = ?;";
    final static String INSERT_UTENTE = "INSERT INTO Utente(id,imei,nome,cognome,email,numCell, numTelFisso,dataNascita)" + "values (?, ?, ?, ?, ?,?,?,?);";

    public UtenteModel getUtenteInfo(String email) {

        UtenteModel utenteModel = new UtenteModel();

        MysqlDataSource dataSource = new MysqlDataSource();

        dataSource.setUser("root");
        dataSource.setPassword("root");
        dataSource.setUrl("jdbc:mysql://localhost:3306/RubricaTelef");

        Connection conn = null;

        try {

            conn = dataSource.getConnection();

            PreparedStatement stmtUserInfo = conn.prepareStatement(USER_INFO);

            stmtUserInfo.setString(1, email);

            ResultSet rsUserInfoSet = stmtUserInfo.executeQuery();

            if (rsUserInfoSet.first()) {

                utenteModel.setNome(rsUserInfoSet.getString("nome"));
                utenteModel.setCognome(rsUserInfoSet.getString("cognome"));
                utenteModel.setEmail(rsUserInfoSet.getString("email"));
                utenteModel.setNumCell(rsUserInfoSet.getString("numCell"));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("errore!! Connessione Fallita");
        } finally {

            DbUtils.closeQuietly(conn); //oppure try with resource
        }

        return utenteModel;
    }

    public boolean insertNewUtente(UtenteModel utente) {
        boolean inserito = false;
        MysqlDataSource dataSource = new MysqlDataSource();

        dataSource.setUser("root");
        dataSource.setPassword("root");
        dataSource.setUrl("jdbc:mysql://localhost:3306/RubricaTelef");

        Connection conn = null;

        try {

            conn = dataSource.getConnection();

            PreparedStatement stmtInsertUtente = conn.prepareStatement(INSERT_UTENTE);
            stmtInsertUtente.setInt(1, utente.getId());
            stmtInsertUtente.setString(2, utente.getImei());
            stmtInsertUtente.setString(3, utente.getNome());
            stmtInsertUtente.setString(4, utente.getCognome());
            stmtInsertUtente.setString(5, utente.getEmail());
            stmtInsertUtente.setString(6, utente.getNumCell());
            stmtInsertUtente.setString(7, utente.getNumTelFisso());
            stmtInsertUtente.setString(8, utente.getData());

            if (stmtInsertUtente.executeUpdate() > 0) {
                inserito = true;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("errore!! Connessione Fallita");
        } finally {

            DbUtils.closeQuietly(conn); //oppure try with resource
        }

        //
        return inserito;
    }

    public UtenteModel getUtenteSmartphone(String email) {

        SmartphoneModel smartphoneModel = new SmartphoneModel();

        UtenteModel utenteModel = new UtenteModel();

        MysqlDataSource dataSource = new MysqlDataSource();

        dataSource.setUser("root");
        dataSource.setPassword("root");
        dataSource.setUrl("jdbc:mysql://localhost:3306/RubricaTelef");

        Connection conn = null;

        try {

            conn = dataSource.getConnection();

            PreparedStatement stmtUserInfo = conn.prepareStatement(USER_SMARTH_INFO);

            stmtUserInfo.setString(1, email);

            ResultSet rsUserInfoSet = stmtUserInfo.executeQuery();

            if (rsUserInfoSet.first()) {

                utenteModel.setNome(rsUserInfoSet.getString("nome"));
                utenteModel.setCognome(rsUserInfoSet.getString("cognome"));
                utenteModel.setEmail(rsUserInfoSet.getString("email"));
                smartphoneModel.setMarca(rsUserInfoSet.getString("marca"));
                smartphoneModel.setModello(rsUserInfoSet.getString("modello"));
                utenteModel.setSmartphone(smartphoneModel);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("errore!! Connessione Fallita");
        } finally {

            DbUtils.closeQuietly(conn); //oppure try with resource
        }

        return utenteModel;

    }

    public boolean updateUtenteInfo(String nome, String email) {

        boolean inserito = false;
        MysqlDataSource dataSource = new MysqlDataSource();

        dataSource.setUser("root");
        dataSource.setPassword("root");
        dataSource.setUrl("jdbc:mysql://localhost:3306/RubricaTelef");

        Connection conn = null;

        try {

            conn = dataSource.getConnection();

            PreparedStatement stmtUpdateUtente = conn.prepareStatement(UPDATE);
            stmtUpdateUtente.setString(1, nome);

            stmtUpdateUtente.setString(2, email);

            if (stmtUpdateUtente.executeUpdate() > 0) {
                inserito = true;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("errore!! Connessione Fallita");
        } finally {

            DbUtils.closeQuietly(conn); //oppure try with resource
        }

        //
        return inserito;

    }

}
