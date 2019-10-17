package cl.nma.dominio;

import java.sql.Date;

public class Contrato {
    
    private int _id_contrato;
    private Date _fecha_de_contrato;
    private int _valor;
    private String _descripcion;
    private int _id_empresa_fk;

    public Contrato() {
    }

    public Contrato(int _id_contrato, Date _fecha_de_contrato, int _valor, String _descripcion, int _id_empresa_fk) {
        this._id_contrato = _id_contrato;
        this._fecha_de_contrato = _fecha_de_contrato;
        this._valor = _valor;
        this._descripcion = _descripcion;
        this._id_empresa_fk = _id_empresa_fk;
    }

    public int getId_contrato() {
        return _id_contrato;
    }

    public void setId_contrato(int _id_contrato) {
        this._id_contrato = _id_contrato;
    }

    public Date getFecha_de_contrato() {
        return _fecha_de_contrato;
    }

    public void setFecha_de_contrato(Date _fecha_de_contrato) {
        this._fecha_de_contrato = _fecha_de_contrato;
    }

    public int getValor() {
        return _valor;
    }

    public void setValor(int _valor) {
        this._valor = _valor;
    }

    public String getDescripcion() {
        return _descripcion;
    }

    public void setDescripcion(String _descripcion) {
        this._descripcion = _descripcion;
    }

    public int getId_empresa_fk() {
        return _id_empresa_fk;
    }

    public void setId_empresa_fk(int _id_empresa_fk) {
        this._id_empresa_fk = _id_empresa_fk;
    }

    @Override
    public String toString() {
        return "Contrato{" + "_id_contrato=" + _id_contrato + ", _fecha_de_contrato=" + _fecha_de_contrato + ", _valor=" + _valor + ", _descripcion=" + _descripcion + ", _id_empresa_fk=" + _id_empresa_fk + '}';
    }
    
    
    
}
