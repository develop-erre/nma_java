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

    private int id_empresa;
    private String nombre_empresa;
    private String rut;
    private String nombre_sucursal;
    private String nombre_calle;
    private String numero;
    private String comuna;
    private String region;
    
    public EmpresaLista() {
        
    }

    public EmpresaLista(int id_empresa, String nombre_empresa, String rut, String nombre_sucursal, String nombre_calle, String numero, String comuna, String region) {
        this.id_empresa = id_empresa;
        this.nombre_empresa = nombre_empresa;
        this.rut = rut;
        this.nombre_sucursal = nombre_sucursal;
        this.nombre_calle = nombre_calle;
        this.numero = numero;
        this.comuna = comuna;
        this.region = region;
    }

    public int getId_empresa() {
        return id_empresa;
    }

    public void setId_empresa(int id_empresa) {
        this.id_empresa = id_empresa;
    }

    public String getNombre_empresa() {
        return nombre_empresa;
    }

    public void setNombre_empresa(String nombre_empresa) {
        this.nombre_empresa = nombre_empresa;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre_sucursal() {
        return nombre_sucursal;
    }

    public void setNombre_sucursal(String nombre_sucursal) {
        this.nombre_sucursal = nombre_sucursal;
    }

    public String getNombre_calle() {
        return nombre_calle;
    }

    public void setNombre_calle(String nombre_calle) {
        this.nombre_calle = nombre_calle;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComuna() {
        return comuna;
    }

    public void setComuna(String comuna) {
        this.comuna = comuna;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
    
}
