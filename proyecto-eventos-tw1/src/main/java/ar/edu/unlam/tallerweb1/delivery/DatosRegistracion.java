package ar.edu.unlam.tallerweb1.delivery;

public class DatosRegistracion {

    private String correo;
    private String clave;

    //agregar mas atributos.. nombre, apellido, localidad, blabla
    public DatosRegistracion(){}
    public DatosRegistracion(String correo, String clave) {
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
