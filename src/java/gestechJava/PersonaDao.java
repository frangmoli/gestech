package gestechJava;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class PersonaDao {

    private PersonaDao() throws ClassNotFoundException,
            IOException, SQLException {
    }
    private static PersonaDao INSTANCE = null;

    public static PersonaDao getInstance() throws ClassNotFoundException,
            IOException, SQLException {
        if (INSTANCE == null) {
            INSTANCE = new PersonaDao();
        }
        return INSTANCE;
    }
    private final static String SQL_PERSONAS_SELECT = "SELECT * FROM personas;";

    public ArrayList<Persona> obtener() throws ClassNotFoundException,
            IOException, SQLException {
        ArrayList<Persona> lista = new ArrayList();
        Connection c = null;
        PreparedStatement ptsmt = null;
        ResultSet rs = null;
        try {
            c = DB.getInstance().getConnection();
            ptsmt = c.prepareStatement(SQL_PERSONAS_SELECT);
            rs = ptsmt.executeQuery();
            Persona a = null;
            while (rs.next()) {
                try {
                    a = new Persona();
                    a.setId(rs.getString("per_id"));
                    a.setNombre(rs.getString("per_nombre"));
                    a.setApellido(rs.getString("per_apellido"));
                    a.setDni(rs.getString("per_dni"));
                    a.setDireccion(rs.getString("per_direccion"));
                    a.setEmail(rs.getString("per_email"));
                    a.setTelefono(rs.getString("per_telefono"));
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                lista.add(a);
            }
        } finally {
            try {
                rs.close();
            } finally {
                try {
                    ptsmt.close();
                } finally {
                    c.close();
                }
            }
        }
        return lista;
    }
    private final static String SQL_PERSONAS_INSERT = "INSERT INTO personas (per_nombre,"
            + "per_apellido," + "per_dni," + "per_telefono," + " per_email,"+ " per_direccion)values(?,?,?,?,?,?);";

    public static void insertar(Persona a)
            throws ClassNotFoundException,
            IOException, SQLException {
        Connection c = null;
        PreparedStatement ptsmt = null;
        try {
            c = DB.getInstance().getConnection();
            ptsmt = c.prepareStatement(SQL_PERSONAS_INSERT);
            ptsmt.setString(1, a.getNombre());
            ptsmt.setString(2, a.getApellido());
            ptsmt.setString(3, a.getDni());
            ptsmt.setString(4, a.getTelefono());
            ptsmt.setString(5, a.getEmail());
            ptsmt.setString(6, a.getDireccion());
            ptsmt.execute();
        } finally {
            try {
                ptsmt.close();
            } finally {
                c.close();
            }
        }
    }
    private final static String SQL_PERSONAS_UPDATE = "UPDATE personas "
            + " set per_nombre = ?, per_apellido = ?, per_dni = ?, per_telefono = ?, per_email = ?, per_direccion = ? "
            + " WHERE per_id = ?;";

    public static void actualizar(Persona a) throws ClassNotFoundException,
            IOException, SQLException {
        Connection c = null;
        PreparedStatement ptsmt = null;
        try {
            c = DB.getInstance().getConnection();
            ptsmt = c.prepareStatement(SQL_PERSONAS_UPDATE);
             ptsmt.setString(1, a.getNombre());
            ptsmt.setString(2, a.getApellido());
            ptsmt.setString(3, a.getDni());
            ptsmt.setString(4, a.getTelefono());
            ptsmt.setString(5, a.getEmail());
            ptsmt.setString(6, a.getDireccion());
            ptsmt.setInt(7, Integer.parseInt(a.getId()));
            ptsmt.execute();
        } finally {
            try {
                ptsmt.close();
            } finally {
                c.close();
            }
        }
    }
    private final static String SQL_PERSONAS_DELETE = "DELETE FROM personas "
            + " WHERE per_id = ?;";

    public static void borrar(Persona a) throws ClassNotFoundException,
            IOException, SQLException {
        Connection c = null;
        PreparedStatement ptsmt = null;
        try {
            c = DB.getInstance().getConnection();
            ptsmt = c.prepareStatement(SQL_PERSONAS_DELETE);
            ptsmt.setInt(1, Integer.parseInt(a.getId()));
            ptsmt.execute();
        } finally {
            try {
                ptsmt.close();
            } finally {
                c.close();
            }
        }
    }
    
    
   
}
