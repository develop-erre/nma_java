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
    private int _id_direccion_suc_fk;
    private int _id_empresa_fk;
    private int _casa_matriz;

    public Sucursal() {
    }

    public Sucursal(int _id_sucursal, String _nombre, int _id_direccion_suc_fk, int _id_empresa_fk, int _casa_matriz) {
        this._id_sucursal = _id_sucursal;
        this._nombre = _nombre;
        this._id_direccion_suc_fk = _id_direccion_suc_fk;
        this._id_empresa_fk = _id_empresa_fk;
        this._casa_matriz = _casa_matriz;
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

    public int getId_direccion_suc_fk() {
        return _id_direccion_suc_fk;
    }

    public void setId_direccion_suc_fk(int _id_direccion_suc_fk) {
        this._id_direccion_suc_fk = _id_direccion_suc_fk;
    }

    public int getId_empresa_fk() {
        return _id_empresa_fk;
    }

    public void setId_empresa_fk(int _id_empresa_fk) {
        this._id_empresa_fk = _id_empresa_fk;
    }

    public int getCasa_matriz() {
        return _casa_matriz;
    }

    public void setCasa_matriz(int _casa_matriz) {
        this._casa_matriz = _casa_matriz;
    }
   
}
