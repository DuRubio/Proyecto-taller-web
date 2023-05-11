package ar.edu.unlam.tallerweb1.delivery;

public class DatosLogin {

    private String correo;
    private String clave;

    public DatosLogin() {
    }

    public DatosLogin(String correo, String clave) {
        this.correo = correo;
        this.clave = clave;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
}
