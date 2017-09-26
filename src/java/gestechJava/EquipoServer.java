package gestechJava;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;        

@WebServlet(name = "EquipoServer", urlPatterns = {"/EquipoServer"})
public class EquipoServer extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            
            String texto = request.getReader().readLine();
            ArrayList<Equipo> listado = EquipoDao.getInstance().obtener();
            Gson convertir = new Gson();
            String resultado = convertir.toJson(listado);
            out.println("" + resultado);

        } catch (ClassNotFoundException ex) {
            out.println("" + ex.getMessage());
        } catch (SQLException ex) {
            out.println("" + ex.getMessage());
        } catch (Exception ex) {
            out.println("" + ex.getMessage());
        } finally {
            out.close();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {

            Gson convertir = new Gson();
            String texto = request.getReader().readLine();
            
            Equipo equipoParametro = convertir.fromJson(texto, Equipo.class);
            //equipoParametro.validar();
            
            EquipoDao.insertar(equipoParametro);
            out.println(convertir.toJson("OK"));

        } catch (ClassNotFoundException ex) {
            out.println("" + ex.getMessage());
        } catch (SQLException ex) {
            out.println("" + ex.getMessage());
        } catch (Exception ex) {
            out.println("" + ex.getMessage());
        } finally {
            out.close();
        }
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            Gson convertir = new Gson();
            Equipo equipoParametro = convertir.fromJson(request.getReader(), Equipo.class);
            EquipoDao.actualizar(equipoParametro);
            out.println(convertir.toJson("OK"));
        } catch (ClassNotFoundException ex) {
            out.println("" + ex.getMessage());
        } catch (SQLException ex) {
            out.println("" + ex.getMessage());
        } catch (Exception ex) {
            out.println("" + ex.getMessage());
        } finally {
            out.close();
        }
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {

            Gson convertir = new Gson();
            
            Equipo equipoParametro = convertir.fromJson(request.getParameter("q"), Equipo.class);
            
            EquipoDao.borrar(equipoParametro);
            out.println(convertir.toJson("OK"));

        } catch (ClassNotFoundException ex) {
            out.println("" + ex.getMessage());
        } catch (SQLException ex) {
            out.println("" + ex.getMessage());
        } catch (Exception ex) {
            out.println("" + ex.getMessage());
        } finally {
            out.close();
        }
    }

}
