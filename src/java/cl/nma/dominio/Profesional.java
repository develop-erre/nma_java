/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.nma.dominio;

import java.sql.Date;

/**
 *
 * @author Richard Foncea
 */
public class Profesional {
    
    private int _id_usuario;
    private String _nombre;
    private String _apellidos;
    private String _rut;
    private String _password;
    private String _direccion;
    private Date _fecha_nac;
    private String _email;
    private String _telefono;
    private int _estado;
    private int _id_comuna_us_fk;
    private int _id_rol_fk;
    private int id_empresa_fk;

    public Profesional() {
    }

    //crear profesional
    public Profesional(String nombre, String apellidos, String rut, String pass, String direccion, Date fecha, String email, String telefono, int estado ,int idComuna, int idRol  ) {
        this._nombre = nombre;
        this._apellidos = apellidos;
        this._rut = rut;
        this._password = pass;
        this._direccion = direccion;
        this._fecha_nac = fecha;
        this._email = email;
        this._telefono = telefono;
        this._estado = estado;
        this._id_comuna_us_fk = idComuna;
        this._id_rol_fk = idRol;
    }
    
    //listar profesional
    public Profesional(int id,String nombre, String apellidos, String rut, String pass, String direccion, Date fecha, String email, String telefono, int estado ,int idComuna, int idRol  ) {
        this._id_usuario = id;
        this._nombre = nombre;
        this._apellidos = apellidos;
        this._rut = rut;
        this._password = pass;
        this._direccion = direccion;
        this._fecha_nac = fecha;
        this._email = email;
        this._telefono = telefono;
        this._estado = estado;
        this._id_comuna_us_fk = idComuna;
        this._id_rol_fk = idRol;
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

    public String getDireccion() {
        return _direccion;
    }

    public void setDireccion(String _direccion) {
        this._direccion = _direccion;
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

    public int getId_comuna_us_fk() {
        return _id_comuna_us_fk;
    }

    public void setId_comuna_us_fk(int _id_comuna_us_fk) {
        this._id_comuna_us_fk = _id_comuna_us_fk;
    }

    public int getId_rol_fk() {
        return _id_rol_fk;
    }

    public void setId_rol_fk(int _id_rol_fk) {
        this._id_rol_fk = _id_rol_fk;
    }

    public int getId_empresa_fk() {
        return id_empresa_fk;
    }

    public void setId_empresa_fk(int id_empresa_fk) {
        this.id_empresa_fk = id_empresa_fk;
    }

    @Override
    public String toString() {
        return "Usuario{" + "_id_usuario=" + _id_usuario + ", _nombre=" + _nombre + ", _apellidos=" + _apellidos + ", _rut=" + _rut + ", _password=" + _password + ", _direccion=" + _direccion + ", _fecha_nac=" + _fecha_nac + ", _email=" + _email + ", _telefono=" + _telefono + ", _estado=" + _estado + ", _id_comuna_us_fk=" + _id_comuna_us_fk + ", _id_rol_fk=" + _id_rol_fk + ", id_empresa_fk=" + id_empresa_fk + '}';
    }

    
    
    
}
