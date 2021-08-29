package com.mx.utaz.Model.Gadgets;

import com.mx.utex.Model.Address.BeanAddress;

public class BeanREG {
    private int id;
    private String nombre;
    private BeanAddress direccion_fabricante;
    private String fecharegistro;
    private int estado;



    public BeanREG() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BeanAddress getdireccion_fabricante() {
        return direccion_fabricante;
    }

    public void setdireccion_fabricante(BeanAddress direccion_fabricante) {
        this.direccion_fabricante = direccion_fabricante;
    }

    public String getFecharegistro() {
        return fecharegistro;
    }

    public void setFecharegistro(String fecharegistro) {
        this.fecharegistro = fecharegistro;
    }

    public int getEstado() {
        return estado;
    }

    public void setestado(int status) {
        this.estado = status;
    }
}
