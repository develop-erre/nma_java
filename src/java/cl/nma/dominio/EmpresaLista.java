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
public class EmpresaLista {

    private int _id_empresa;
    private String _nombre;
    private String _rut;
    private String _nombre_suc;
    private String _direccion;

    public EmpresaLista() {
    }

    public EmpresaLista(int _id_empresa, String _nombre, String _rut, String _nombre_suc, String _direccion) {
        this._id_empresa = _id_empresa;
        this._nombre = _nombre;
        this._rut = _rut;
        this._nombre_suc = _nombre_suc;
        this._direccion = _direccion;
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

    public String getNombre_suc() {
        return _nombre_suc;
    }

    public void setNombre_suc(String _nombre_suc) {
        this._nombre_suc = _nombre_suc;
    }

    public String getDireccion() {
        return _direccion;
    }

    public void setDireccion(String _direccion) {
        this._direccion = _direccion;
    }
    
    
}
