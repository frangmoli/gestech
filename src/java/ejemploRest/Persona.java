package ejemploRest;

public class Persona {

    private String id;
    private String nombre;
    private String apellido;
    private String dni;
    private String telefono;
    private String email;
    private String direccion;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
     public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
     public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws Exception {
        if ( email.contains("@") ) {
            this.email = email;
        } else {
            throw new Exception("Ponele Arroba al Email!!!!");
        }

    }
     public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Persona: " + nombre + apellido + dni + telefono +" : " + email + direccion;
    }
    
    public void validar() throws Exception{
        this.setEmail( this.getEmail() );
    }

}
