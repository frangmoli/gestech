/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuario;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author
 */
public class Usuario {
    private String nombre;
    private String apellido;  
    private String alias;
    private String password;  
    private int tipoUs;
    private int userId;

    public Usuario(String nombre, String apellido, String alias, String password) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.alias = alias;
        this.password = password;

        //Date d = new Date();
        //SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
        //this.fechaAlta = sdf.format(d);
        
    }
    
  public Usuario (String alias, String password){
      this.alias = alias;
      this.password = password;
  }  

    Usuario() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Usuario(String nombre, String apellido, String dni, String telefono, String usuario, String password, String email) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * @param apellido the apellido to set
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getAlias() {
        return alias;
    }

    /**
     * @param alias the usuario to set
     */
    public void setAlias(String alias) {
        this.alias = alias;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }


    /**
     * @return the tipoUs
     */
    public int getTipoUs() {
        return tipoUs;
    }

    /**
     * @param tipoUs the tipoUs to set
     */
    public void setTipoUs(int tipoUs) {
        this.tipoUs = tipoUs;
    }

    /**
     * @return the userId
     */
    public int getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    void setId(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
              
}
