package cl.nma.dominio;

import java.util.Date;

public class Usuario {
    
    private int _id_usuario;
    private String _nombre;
    private String _apellidos;
    private String _rut;
    private String _password;
    private int _id_direccion_fk;
    private Date _fecha_nac;
    private String _email;
    private String _telefono;
    private int _estado;
    private int _id_rol_fk;
    private int id_sucursal_fk;

    public Usuario() {
    }

    public Usuario(int _id_usuario, String _nombre, String _apellidos, String _rut, String _password, int _id_direccion_fk, Date _fecha_nac, String _email, String _telefono, int _estado, int _id_rol_fk, int id_sucursal_fk) {
        this._id_usuario = _id_usuario;
        this._nombre = _nombre;
        this._apellidos = _apellidos;
        this._rut = _rut;
        this._password = _password;
        this._id_direccion_fk = _id_direccion_fk;
        this._fecha_nac = _fecha_nac;
        this._email = _email;
        this._telefono = _telefono;
        this._estado = _estado;
        this._id_rol_fk = _id_rol_fk;
        this.id_sucursal_fk = id_sucursal_fk;
    }

    public int getId_usuario() {
        return _id_usuario;
    }

    public void setId_usuario(int _id_usuario) {
        this._id_usuario = _id_usuario;
    }

    public String getNombre() {
        return _nombre;
    }

    public void setNombre(String _nombre) {
        this._nombre = _nombre;
    }

    public String getApellidos() {
        return _apellidos;
    }

    public void setApellidos(String _apellidos) {
        this._apellidos = _apellidos;
    }

    public String getRut() {
        return _rut;
    }

    public void setRut(String _rut) {
        this._rut = _rut;
    }

    public String getPassword() {
        return _password;
    }

    public void setPassword(String _password) {
        this._password = _password;
    }

    public int getId_direccion_fk() {
        return _id_direccion_fk;
    }

    public void setId_direccion_fk(int _id_direccion_fk) {
        this._id_direccion_fk = _id_direccion_fk;
    }

    public Date getFecha_nac() {
        return _fecha_nac;
    }

    public void setFecha_nac(Date _fecha_nac) {
        this._fecha_nac = _fecha_nac;
    }

    public String getEmail() {
        return _email;
    }

    public void setEmail(String _email) {
        this._email = _email;
    }

    public String getTelefono() {
        return _telefono;
    }

    public void setTelefono(String _telefono) {
        this._telefono = _telefono;
    }

    public int getEstado() {
        return _estado;
    }

    public void setEstado(int _estado) {
        this._estado = _estado;
    }

    public int getId_rol_fk() {
        return _id_rol_fk;
    }

    public void setId_rol_fk(int _id_rol_fk) {
        this._id_rol_fk = _id_rol_fk;
    }

    public int getId_sucursal_fk() {
        return id_sucursal_fk;
    }

    public void setId_sucursal_fk(int id_sucursal_fk) {
        this.id_sucursal_fk = id_sucursal_fk;
    }
    
    public String createPassword (String date){
        
        String pass;
        
        String var01 = getNombre().substring(0,3);
        String var02 = ".";
        String var03 = getApellidos().substring(0,3);
        String var04 = date.substring(2,7);
        
        pass = var01.toLowerCase()+var02+var03.toLowerCase()+"#"+var04;
        return pass;
    }
    
}
