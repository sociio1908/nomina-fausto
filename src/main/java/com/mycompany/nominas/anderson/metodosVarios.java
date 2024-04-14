/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.nominas.anderson;

import com.toedter.calendar.JDateChooser;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Ing. Mariam Estrella
 */
public class metodosVarios {
     
    public void limpiarCampos(JPanel panel){
        for(int i = 0; panel.getComponents().length > i; i++){
            if(panel.getComponents()[i] instanceof JTextField){
                ((JTextField)panel.getComponents()[i]).setText("");
            }
            else if(panel.getComponents()[i] instanceof JPasswordField){
                ((JPasswordField)panel.getComponents()[i]).setText("");
            }
            else if(panel.getComponents()[i] instanceof JDateChooser){
                ((JDateChooser)panel.getComponents()[i]).setCalendar(null);
            }
            else if(panel.getComponents()[i] instanceof JDateChooser){
                ((JDateChooser)panel.getComponents()[i]).setCalendar(null);
            }
            
        }
    }
    
}
    

