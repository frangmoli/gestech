/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuario;

import Login.Conexion;
import Login.Encriptar;
import Login.Encriptar;
import Usuario.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author 
 */
public class ModeloUsuario extends Conexion {
    
    public boolean crearUsuario(Usuario u){
        boolean flag = false;
        PreparedStatement pst = null;
                    try{
            String sql = "insert into usuarios (nombre, apellido, dni, telefono, usuario, password, correo, fechaAlta) values (?,?,?,?,?,?,?,?)";
            pst = getConnection ().prepareStatement(sql);
            pst.setString(1, u.getNombre());
            pst.setString(2, u.getApellido());
            pst.setString(3, u.getAlias());
            pst.setString(4, Encriptar.sha1(u.getPassword()));       
    
            
            if(pst.executeUpdate() ==1){
                flag = true;
            }
        } catch (Exception e){
            System.err.println(e.getMessage());
                }finally{
                    try{
                        if(getConnection() != null)getConnection().close();
                        if(pst != null)pst.close();
                        } catch (Exception e) {
                        System.err.println(e.getMessage());
                        }
            
                        }  
            
            return flag;
            
            }
    
      public int autenticar (Usuario u){
          
          int tipoUsuario = 0;
          PreparedStatement pst = null;
          ResultSet rs = null;
          
          try{
              String sql = "select tipoUsuario from usuarios where usuario = ? and password = ?";
              pst = getConnection().prepareStatement(sql);
              pst.setString(1, u.getAlias());              
              pst.setString(2, Encriptar.sha1(u.getPassword())); 
              rs = pst.executeQuery();

                      
        while(rs.next()){
            tipoUsuario = rs.getInt(1);
   
        }
           

                        if(getConnection() != null)getConnection().close();
                        if(pst != null)pst.close();
              
          } catch (Exception e) {
              System.err.println(e.getMessage());
              
          } 
          
                 
    
            return tipoUsuario;  
    }

       }