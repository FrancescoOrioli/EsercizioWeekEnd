/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rubricatelefonica;

import java.util.LinkedList;

/**
 *
 * @author checco
 */
public interface DaoInterfaceSmartphone {
     public boolean insertNewSmartphone(SmartphoneModel smartph);
      public SmartphoneModel getSmartphoneInfo(String nome);
   
}
