package Equipos;

public class Equipo {

    private String id;
    private String cliente;
    private String modelo;
    private String serie;
    private String diag;
    private String fin;
    private String presup;
    private String fout;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
      public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }
     public String getDiag() {
        return diag;
    }

    public void setDiag(String diag) {
        this.diag = diag;
    }
     public String getFin() {
        return fin;
    }

    public void setFin(String fin) {
        this.fin = fin;
    }
     public String getPresup() {
        return presup;
    }

    public void setPresup(String presup) {
        this.presup = presup;
    }
     public String getFout() {
        return fout;
    }

    public void setFout(String fout) {
        this.fout = fout;
    }
}
