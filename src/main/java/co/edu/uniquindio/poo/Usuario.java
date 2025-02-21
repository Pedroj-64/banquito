package co.edu.uniquindio.poo;

public class Usuario {

    private String nombre;
    private String direccion;
    private String cedula;
    private String correo;
    private String password;

    public Usuario(String nombre, String direccion, String cedula, String correo, String password) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.cedula = cedula;
        this.correo = correo;
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
        return correo;
    }

    public void setCorreo(String correo) {
        correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", cedula='" + cedula + '\'' +
                ", Correo='" + correo + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
