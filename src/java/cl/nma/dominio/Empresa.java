/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.nma.dominio;

/**
 *
 * @author Richard Foncea
 */
public class Empresa {
    
    private int _id_empresa;
    private String _nombre;
    private String _rut;
    private String _sitio_web;
    private String _telefono;
    private int _estado;
    private int _id_rubro_fk;

    public Empresa() {
    }

    public Empresa(int _id_empresa, String _nombre, String _rut, String _sitio_web, String _telefono, int _estado, int _id_rubro_fk) {
        this._id_empresa = _id_empresa;
        this._nombre = _nombre;
        this._rut = _rut;
        this._sitio_web = _sitio_web;
        this._telefono = _telefono;
        this._estado = _estado;
        this._id_rubro_fk = _id_rubro_fk;
    }

    public int getId_empresa() {
        return _id_empresa;
    }

    public void setId_empresa(int _id_empresa) {
        this._id_empresa = _id_empresa;
    }

    public String getNombre() {
        return _nombre;
    }

    public void setNombre(String _nombre) {
        this._nombre = _nombre;
    }

    public String getRut() {
        return _rut;
    }

    public void setRut(String _rut) {
        this._rut = _rut;
    }

    public String getSitio_web() {
        return _sitio_web;
    }

    public void setSitio_web(String _sitio_web) {
        this._sitio_web = _sitio_web;
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

    public int getId_rubro_fk() {
        return _id_rubro_fk;
    }

    public void setId_rubro_fk(int _id_rubro_fk) {
        this._id_rubro_fk = _id_rubro_fk;
    }

    @Override
    public String toString() {
        return "Empresa{" + "_id_empresa=" + _id_empresa + ", _nombre=" + _nombre + ", _rut=" + _rut + ", _sitio_web=" + _sitio_web + ", _telefono=" + _telefono + ", _estado=" + _estado + ", _id_rubro_fk=" + _id_rubro_fk + '}';
    }
    
    public String nombreSucursal (String nom){
        
        String nombre = "CASA MATRIZ "+nom.toUpperCase();
        
        return nombre;
    }
    
    
}
