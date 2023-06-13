package ar.edu.unlam.tallerweb1.delivery;

public class DatosRegistracion {

    private String correo;
    private String clave;
    private String nombre;
    private String apellido;
    private String localidad;


    public DatosRegistracion(String correo, String clave) {
        setCorreo(correo);
        setClave(clave);
    }

    public DatosRegistracion() {
    }

    public DatosRegistracion(String nombre, String apellido, String localidad) {

        setNombre(nombre);
        setApellido(apellido);
        setLocalidad(localidad);
    }

    public DatosRegistracion(String nombre, String apellido, String localidad, String correo, String clave) {

    	setNombre(nombre);
        setApellido(apellido);
        setLocalidad(localidad);
        setCorreo(correo);
        setClave(clave);
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

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }
}
