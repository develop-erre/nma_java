/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.nma.dominio;

/**
 * 
 * @author 
 */
public class Direccion {
    
    private int id_direccion;
    private String nombre_calle;
    private String numero;
    private String depto;
    private int id_comuna_fk;

    public Direccion() {
    }

    public Direccion(int id_direccion, String nombre_calle, String numero, String depto, int id_comuna_fk) {
        this.id_direccion = id_direccion;
        this.nombre_calle = nombre_calle;
        this.numero = numero;
        this.depto = depto;
        this.id_comuna_fk = id_comuna_fk;
    }

    public int getId_direccion() {
        return id_direccion;
    }

    public void setId_direccion(int id_direccion) {
        this.id_direccion = id_direccion;
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

    public String getDepto() {
        return depto;
    }

    public void setDepto(String depto) {
        this.depto = depto;
    }

    public int getId_comuna_fk() {
        return id_comuna_fk;
    }

    public void setId_comuna_fk(int id_comuna_fk) {
        this.id_comuna_fk = id_comuna_fk;
    }

    
}
