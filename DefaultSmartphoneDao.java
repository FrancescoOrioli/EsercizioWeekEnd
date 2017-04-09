/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rubricatelefonica;

import static com.mycompany.rubricatelefonica.DefaultUtenteDao.USER_INFO;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import org.apache.commons.dbutils.DbUtils;

/**
 *
 * @author checco
 */
public class DefaultSmartphoneDao implements DaoInterfaceSmartphone {

    final static String SMARTPHONE_INFO = "SELECT marca,modello, colore, materiale FROM Smartphone where imei=?";
    final static String INSERT_SMARTPHONE = "INSERT INTO SMARTPHONE (imei,marca,modello,annoProduzione,colore,materiale,sistOp)" + "values (?, ?, ?, ?, ?,?,?)";

    public boolean insertNewSmartphone(SmartphoneModel s) {
        boolean inserito = false;
        MysqlDataSource dataSource = new MysqlDataSource();

        dataSource.setUser("root");
        dataSource.setPassword("root");
        dataSource.setUrl("jdbc:mysql://localhost:3306/RubricaTelef");

        Connection conn = null;

        try {

            conn = dataSource.getConnection();

            PreparedStatement stmtInsertSmartph = conn.prepareStatement(INSERT_SMARTPHONE);
            stmtInsertSmartph.setString(1, s.getImei());
            stmtInsertSmartph.setString(2, s.getMarca());
            stmtInsertSmartph.setString(3, s.getModello());
            stmtInsertSmartph.setString(4, s.getAnno());
            stmtInsertSmartph.setString(5, s.getColore());
            stmtInsertSmartph.setString(6, s.getMateriale());
            stmtInsertSmartph.setString(7, s.getSistOp());

            if (stmtInsertSmartph.executeUpdate() > 0) {
                inserito = true;
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("errore!! Connessione Fallita");
        } finally {

            DbUtils.closeQuietly(conn); //oppure try with resource
        }

        return inserito;

    }

    public SmartphoneModel getSmartphoneInfo(String imei) {

     
        SmartphoneModel smartphoneModel=new SmartphoneModel();

        MysqlDataSource dataSource = new MysqlDataSource();

        dataSource.setUser("root");
        dataSource.setPassword("root");
        dataSource.setUrl("jdbc:mysql://localhost:3306/RubricaTelef");

        Connection conn = null;

          try {

            conn = dataSource.getConnection();

           PreparedStatement stmtUserInfo = conn.prepareStatement(SMARTPHONE_INFO);
           

           stmtUserInfo.setString(1, imei);

           ResultSet rsUserInfoSet = stmtUserInfo.executeQuery();
           
        if(rsUserInfoSet.first()) {

             smartphoneModel = new SmartphoneModel();
                smartphoneModel.setMarca(rsUserInfoSet.getString("marca"));
                smartphoneModel.setModello(rsUserInfoSet.getString("modello"));
                smartphoneModel.setColore(rsUserInfoSet.getString("colore"));
                smartphoneModel.setMateriale(rsUserInfoSet.getString("materiale"));
               
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("errore!!");
        } finally {

            DbUtils.closeQuietly(conn); //oppure try with resource
        }

        return smartphoneModel;
    }

}
