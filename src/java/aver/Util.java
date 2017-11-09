/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aver;

import Login.Encriptar;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ifts
 */
public class Util {
    public static void main(String[] args) {
        try {
            System.out.println("..");
            System.out.println(Encriptar.sha1("marce"));
            System.out.println("OK");
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
