/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuario;

import Login.Encriptar;
import Usuario.Usuario;

/**
 *
 * @author
 */
public class ControladorUsuario {
    public boolean crear (Usuario u){
        ModeloUsuario mu = new ModeloUsuario();
        return mu.crearUsuario(u);
    }
 
public int validar (Usuario u){
    ModeloUsuario mu = new ModeloUsuario();
    return mu.autenticar(u);
    
} 

}
