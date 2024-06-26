/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mantenimientos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ariel
 */
class MetodosGenerales {
         public void eliminar (String ruta,String id){
        try {
            FileReader leer = new FileReader(ruta);
            BufferedReader b = new BufferedReader(leer);
            String linea=b.readLine();
            try (FileWriter escribir = new FileWriter(ruta)) {
                while(linea!=null){
                    if(id.equals(linea.split("~")[0])==false){
                        escribir.write(linea+"\r\n");
                    }
                    linea=b.readLine();
                }
            }
           JOptionPane.showMessageDialog(null,"Se ha eliminado correctamente.");

     
            
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null,"No hay registro en el archivo");
        }
      
        
        
    }
      
      
          public ArrayList<String> LlenarTablaCondicion (String ruta, int posicion, String condicion){
        ArrayList<String> vector = new ArrayList();
        try {
            BufferedReader b;
            try (FileReader leer = new FileReader(ruta)) {
                b = new BufferedReader(leer);
                String linea=b.readLine();
                while(linea!=null){
                    if(linea.split("~")[posicion].equals(condicion)){
                        vector.add(linea);
                    }
                    
                    linea=b.readLine();
                }
            }
            b.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null,"No hay registro en el archivo");
        }
        return vector;
        
    }
        
            public String IdAutomatico (String ruta){
        int i=0;
                
        try {
            BufferedReader b;
            try (FileReader leer = new FileReader(ruta)) {
                b = new BufferedReader(leer);
                String linea=b.readLine();
                while(linea!=null){
                    i++;
                    linea=b.readLine();
                }
            }
            b.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null,"No hay registro en el archivo");
        }
        return (++i+"");
        
    }
            
            
          public void  LlenarTablaModel(String ruta,JTable tabla,int ElementosVector){
         DefaultTableModel  modelo =(DefaultTableModel) tabla.getModel();
         ArrayList vector = new ArrayList();
         modelo.setRowCount(0);
         tabla.setModel(modelo);
         String datos [ ] = new String [ElementosVector];
         vector=this.LlenarTabla(ruta);
         
         for (int i = 0; i <vector.size(); i++) {
             System.arraycopy(vector.get(i).toString().split("~"), 0, datos, 0, ElementosVector);
           modelo.addRow(datos);
         }
         
    }
          
          
          
    
     
    public void  LlenarTablaModel(String ruta,JTable tabla,int ElementosVector,String filtro, int posicion){
         DefaultTableModel  modelo =(DefaultTableModel) tabla.getModel();
         ArrayList vector = new ArrayList();
         modelo.setRowCount(0);
         tabla.setModel(modelo);
         String datos [ ] = new String [ElementosVector];
         vector=this.LlenarTablaCondicion(ruta,posicion,filtro);
         
         for (int i = 0; i <vector.size(); i++) {
             System.arraycopy(vector.get(i).toString().split("~"), 0, datos, 0, ElementosVector);
           modelo.addRow(datos);
         }
    }
    
    
     public void  LlenarTablaModelEmpleado(String ruta,JTable tabla,int ElementosVector){
          DefaultTableModel  modelo =(DefaultTableModel) tabla.getModel();
         ArrayList vector = new ArrayList();
         modelo.setRowCount(0);
         tabla.setModel(modelo);
         String datos [ ] = new String [ElementosVector];
         vector=this.LlenarTabla(ruta);
         
           
         for (int i = 0; i <vector.size(); i++) {
              String departamentos = (this.validarID("departamentos.txt",vector.get(i).toString().split("~")[7]).split("~")[1]);
              String puestos = (this.validarID("puestos.txt",vector.get(i).toString().split("~")[8]).split("~")[1]);
           for(int j=0;j< ElementosVector; j++){
                  switch (j) {
                      case 7 -> {
                          datos[5]=vector.get(i).toString().split("~")[j];
                          datos[6] = departamentos;
                      }
                      case 8 -> {
                          datos[7]=vector.get(i).toString().split("~")[j];
                          datos[8] = puestos;
                      }
                      default -> {
                          if(j<10 && j!=5 && j!=6 && j!=7 && j!=8){
                              datos[j]=vector.get(i).toString().split("~")[j];
                                datos[10]=vector.get(i).toString().split("~")[6];
                                  datos[11]=vector.get(i).toString().split("~")[10];
                                  datos[12]=vector.get(i).toString().split("~")[11];
                                  datos[13]=vector.get(i).toString().split("~")[5];
                          }
                      }
                  }
           
           }
           modelo.addRow(datos);
         }
    }
     
      public void  LlenarTablaModelEmpleadoFiltro(JTable tabla,int ElementosVector,String filtro,String valor){
          DefaultTableModel  modelo =(DefaultTableModel) tabla.getModel();
         ArrayList vector = new ArrayList();
         modelo.setRowCount(0);
         tabla.setModel(modelo);
         String datos [ ] = new String [ElementosVector];
         if(filtro.equals("Nombre empleado")){
             vector = this.LlenarTablaFiltroEmpleado(valor,1);
         }else if(filtro.equals("Id Puestos")){
             vector = this.LlenarTablaFiltroEmpleado(valor,8);
         }else if(filtro.equals("Id Departamentos")){
             vector = this.LlenarTablaFiltroEmpleado(valor,7);
         }else{
              vector = this.LlenarTablaFiltroEmpleado(valor,9);
         }
         
           
         for (int i = 0; i <vector.size(); i++) {
              String departamentos = (this.validarID("departamentos.txt",vector.get(i).toString().split("~")[7]).split("~")[1]);
              String puestos = (this.validarID("puestos.txt",vector.get(i).toString().split("~")[8]).split("~")[1]);
           for(int j=0;j< ElementosVector; j++){
                  switch (j) {
                      case 7 -> {
                          datos[5]=vector.get(i).toString().split("~")[j];
                          datos[6] = departamentos;
                      }
                      case 8 -> {
                          datos[7]=vector.get(i).toString().split("~")[j];
                          datos[8] = puestos;
                      }
                      default -> {
                          if(j<10 && j!=5 && j!=6 && j!=7 && j!=8){
                              datos[j]=vector.get(i).toString().split("~")[j];
                                datos[10]=vector.get(i).toString().split("~")[6];
                                  datos[11]=vector.get(i).toString().split("~")[10];
                                  datos[12]=vector.get(i).toString().split("~")[11];
                                  datos[13]=vector.get(i).toString().split("~")[5];
                          }
                      }
                  }
           
           }
           modelo.addRow(datos);
         }
    }
        public ArrayList<String> LlenarTabla (String ruta){
        ArrayList<String> vector = new ArrayList();
        try {
            BufferedReader b;
            try (FileReader leer = new FileReader(ruta)) {
                b = new BufferedReader(leer);
                String linea=b.readLine();
                while(linea!=null){
                    vector.add(linea);
                    linea=b.readLine();
                }
            }
            b.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null,"No hay registro en el archivo");
        }
        return vector;
        
    }
        
        
         public ArrayList<String> LlenarTablaFiltroEmpleado (String filtro,int posicion){
        ArrayList<String> vector = new ArrayList();
        try {
            BufferedReader b;
            try (FileReader leer = new FileReader("empleados.txt")) {
                b = new BufferedReader(leer);
                String linea=b.readLine();
                while(linea!=null){
                     
                    if(linea.split("~")[posicion].equals(filtro)){
                       vector.add(linea);
                    }
                    linea=b.readLine();
                }
            }
            b.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null,"No hay registro en el archivo");
        }
        return vector;
        
    }
        
        
         public void modificar (String ruta,String id,String dato){
        try{
            FileReader leer = new FileReader(ruta);
        BufferedReader b=new  BufferedReader(leer);
        String texto=b.readLine();
            try (FileWriter escribir = new FileWriter(ruta)) {
                while(texto!=null){
                    if(id.equals(texto.split("~")[0])){
                        escribir.write(dato+"\r\n");
                    }else{
                        escribir.write(texto+"\r\n");
                    }
                    texto=b.readLine();
                }   }
        if(ruta.equals("Cuotas_Prestamos.txt")==false && ruta.equals("cooperativa.txt")==false){
         JOptionPane.showMessageDialog(null,"Se ha modificado correctamente.");
        }

        }catch (IOException ex) {
        }
        
    }
         
         
           public String validarCondicion(String ruta,String condicion,int posicion){
        try {
            FileReader leer = new FileReader(ruta);
            BufferedReader b= new BufferedReader(leer);
            String dato=b.readLine();
            while(dato!=null){
                if(condicion.equals(dato.split("~")[posicion])){
                    return dato;
                }
                dato=b.readLine();
            }
            leer.close();
            b.close();
        } catch (IOException ex) {
//             JOptionPane.showMessageDialog(null,"El archivo no existe","Error",JOptionPane.ERROR_MESSAGE);
        }
          return "no";
    }
           
           
            public String validarID(String ruta,String id){
        try {
            FileReader leer = new FileReader(ruta);
            BufferedReader b= new BufferedReader(leer);
            String dato=b.readLine();
            while(dato!=null){
                if(id.equals(dato.split("~")[0])){
                    return dato;
                }
                dato=b.readLine();
            }
            leer.close();
            b.close();
        } catch (IOException ex) {
//             JOptionPane.showMessageDialog(null,"El archivo no existe","Error",JOptionPane.ERROR_MESSAGE);
        }
        
          return "no";
    }
            
            
                 public void registrar (String ruta,String dato){
        try {
            try (FileWriter guardar = new FileWriter(ruta,true)) {
                guardar.write(dato+"\r\n");
            }
            if(ruta.equals("Prestamos.txt")==false &&  ruta.equals("Cuotas_Prestamos.txt")==false &&  ruta.equals("Detalles_Cobros.txt")==false && ruta.equals("empleadosCoop.txt")==false ){
              JOptionPane.showMessageDialog(null,"Se ha registrado correctamente.");
   
            }

        } catch (IOException ex) {
           JOptionPane.showMessageDialog(null,"El archivo no existe");
        }
        
        
    }
                 
                 
       static String nivel_usuario ="";
    public String nivel_acceso(String login,String pass){
        try {
            FileReader leer = new FileReader("usuarios.txt");
            BufferedReader b = new BufferedReader(leer);
            String linea=b.readLine();
            while(linea!=null){
                if(linea.split("~")[0].equals(login) && linea.split("~")[1].equals(pass)){
                    MetodosGenerales.nivel_usuario=linea.split("~")[2];
                    return linea.split("~")[2];
                   
                }
               
                linea=b.readLine();
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null,"No hay registro en el archivo usuario");
        }
       return "no";
    }
    
}
