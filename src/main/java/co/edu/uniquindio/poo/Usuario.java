package co.edu.uniquindio.poo;

public class Usuario {

    private String nombre;
    private String direccion;
    private String cedula;
    private String Correo;
    private String password;

    public Usuario(String nombre, String direccion, String cedula, String Correo, String password) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.cedula = cedula;
        this.Correo = Correo;
        this.password = password;
    }

    public void RecargarBilletera() {}

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String correo) {
        Correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
