/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.nominas.anderson;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JDayChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Ing. Mariam Estrella
 */
public class metodosVarios {
     
    public void limpiarCampos(JPanel panel, String mensaje){
        
        var opc = JOptionPane.showConfirmDialog(null, "Seguro que quiere "+mensaje+" ?", "SELECCIONE UNA OPCION",JOptionPane.YES_NO_OPTION);
        if(opc!=JOptionPane.YES_OPTION)
            return;
        try{
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
            else if(panel.getComponents()[i] instanceof JDayChooser){
                ((JDayChooser)panel.getComponents()[i]).setCalendar(null);
            }
        }
        }catch(Exception e){
            
        }

    }
    
    
       public void limpiarCampos(JPanel panel){
        try{
          for(int i = 0; panel.getComponents().length > i; i++){
            if(panel.getComponents()[i] instanceof JTextField && i!=8){
                ((JTextField)panel.getComponents()[i]).setText("");
            }
            else if(panel.getComponents()[i] instanceof JPasswordField){
                ((JPasswordField)panel.getComponents()[i]).setText("");
            }
            else if(panel.getComponents()[i] instanceof JDateChooser){
                ((JDateChooser)panel.getComponents()[i]).setCalendar(null);
            }
            else if(panel.getComponents()[i] instanceof JDayChooser){
                ((JDayChooser)panel.getComponents()[i]).setCalendar(null);
            }
        }
        }catch(Exception e){
            
        }

    }
    
}
    

