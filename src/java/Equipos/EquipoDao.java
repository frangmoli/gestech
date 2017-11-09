package Equipos;

import gestechJava.DB;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class EquipoDao {

    private EquipoDao() throws ClassNotFoundException,
            IOException, SQLException {
    }
    private static EquipoDao INSTANCE = null;

    public static EquipoDao getInstance() throws ClassNotFoundException,
            IOException, SQLException {
        if (INSTANCE == null) {
            INSTANCE = new EquipoDao();
        }
        return INSTANCE;
    }
    private final static String SQL_EQUIPOS_SELECT = "SELECT * FROM equipos;";

    public ArrayList<Equipo> obtener() throws ClassNotFoundException,
            IOException, SQLException {
        ArrayList<Equipo> lista = new ArrayList();
        Connection c = null;
        PreparedStatement ptsmt = null;
        ResultSet rs = null;
        try {
            c = DB.getInstance().getConnection();
            ptsmt = c.prepareStatement(SQL_EQUIPOS_SELECT);
            rs = ptsmt.executeQuery();
            Equipo a = null;
            while (rs.next()) {
                try {
                    a = new Equipo();
                    a.setId(rs.getString("equipo_id"));
                    a.setModelo(rs.getString("equipo_modelo"));
                    a.setSerie(rs.getString("equipo_serie"));
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
    private final static String SQL_EQUIPOS_INSERT = "INSERT INTO equipos (equipo_modelo,"
            + "equipo_serie)values(?,?);";

    public static void insertar(Equipo a)
            throws ClassNotFoundException,
            IOException, SQLException {
        Connection c = null;
        PreparedStatement ptsmt = null;
        try {
            c = DB.getInstance().getConnection();
            ptsmt = c.prepareStatement(SQL_EQUIPOS_INSERT);
            ptsmt.setString(1, a.getModelo());
            ptsmt.setString(2, a.getSerie());
            ptsmt.execute();
        } finally {
            try {
                ptsmt.close();
            } finally {
                c.close();
            }
        }
    }
    private final static String SQL_EQUIPOS_UPDATE = "UPDATE equipos "
            + " set equipo_modelo = ?, equipo_serie = ?"
            + " WHERE equipo_id = ?;";

    public static void actualizar(Equipo a) throws ClassNotFoundException,
            IOException, SQLException {
        Connection c = null;
        PreparedStatement ptsmt = null;
        try {
            c = DB.getInstance().getConnection();
            ptsmt = c.prepareStatement(SQL_EQUIPOS_UPDATE);
             ptsmt.setString(1, a.getModelo());
            ptsmt.setString(2, a.getSerie());
            ptsmt.setInt(3, Integer.parseInt(a.getId()));
            ptsmt.execute();
        } finally {
            try {
                ptsmt.close();
            } finally {
                c.close();
            }
        }
    }
    private final static String SQL_EQUIPOS_DELETE = "DELETE FROM equipos "
            + " WHERE equipo_id = ?;";

    public static void borrar(Equipo a) throws ClassNotFoundException,
            IOException, SQLException {
        Connection c = null;
        PreparedStatement ptsmt = null;
        try {
            c = DB.getInstance().getConnection();
            ptsmt = c.prepareStatement(SQL_EQUIPOS_DELETE);
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
