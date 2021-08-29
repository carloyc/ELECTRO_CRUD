package com.mx.utaz.Model.Address;

public class BeanAddress {
    private int id_direccion;
    private String calle;
    private String colonia;
    private int codigo_postal;
    private String estado;
    private String pais;


    public BeanAddress() {
    }

    public int getid_direccion() {
        return id_direccion;
    }

    public void setid_direccion(int id_direccion) {
        this.id_direccion = id_direccion;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public int getcodigo_postal() {
        return codigo_postal;
    }

    public void setcodigo_postal(int codigo_postal) {
        this.codigo_postal = codigo_postal;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
}
