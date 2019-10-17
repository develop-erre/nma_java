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
public class Sucursal {
    
    private int _id_sucursal;
    private String _nombre;
    private String _direccion;
    private int _id_empresa_fk;
    private int _id_comuna_suc_fk;

    public Sucursal() {
    }

    public Sucursal(int _id_sucursal, String _nombre, String _direccion, int _id_empresa_fk, int _id_comuna_suc_fk) {
        this._id_sucursal = _id_sucursal;
        this._nombre = _nombre;
        this._direccion = _direccion;
        this._id_empresa_fk = _id_empresa_fk;
        this._id_comuna_suc_fk = _id_comuna_suc_fk;
    }

    public int getId_sucursal() {
        return _id_sucursal;
    }

    public void setId_sucursal(int _id_sucursal) {
        this._id_sucursal = _id_sucursal;
    }

    public String getNombre() {
        return _nombre;
    }

    public void setNombre(String _nombre) {
        this._nombre = _nombre;
    }

    public String getDireccion() {
        return _direccion;
    }

    public void setDireccion(String _direccion) {
        this._direccion = _direccion;
    }

    public int getId_empresa_fk() {
        return _id_empresa_fk;
    }

    public void setId_empresa_fk(int _id_empresa_fk) {
        this._id_empresa_fk = _id_empresa_fk;
    }

    public int getId_comuna_suc_fk() {
        return _id_comuna_suc_fk;
    }

    public void setId_comuna_suc_fk(int _id_comuna_suc_fk) {
        this._id_comuna_suc_fk = _id_comuna_suc_fk;
    }

    @Override
    public String toString() {
        return "Sucursal{" + "_id_sucursal=" + _id_sucursal + ", _nombre=" + _nombre + ", _direccion=" + _direccion + ", _id_empresa_fk=" + _id_empresa_fk + ", _id_comuna_suc_fk=" + _id_comuna_suc_fk + '}';
    }
    
    
    
}
