package com.example.proyectofincaraiz.modelos;

import com.example.proyectofincaraiz.modelos.enums.TipoEstado;
import com.example.proyectofincaraiz.modelos.enums.TipoVenta;

public class Propiedad {
    private String id;
    private String direccion;
    private Float valorVenta;
    private String area;

    private TipoEstado estado;
    private TipoVenta tipoVenta;
    private Usuario usuario;


    public Propiedad() {
    }


    public Propiedad(String id, String direccion, Float valorVenta, String area, TipoEstado estado, TipoVenta tipoVenta, Usuario usuario) {
        this.id = id;
        this.direccion = direccion;
        this.valorVenta = valorVenta;
        this.area = area;
        this.estado = estado;
        this.tipoVenta = tipoVenta;
        this.usuario = usuario;
    }




    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Float getValorVenta() {
        return valorVenta;
    }

    public void setValorVenta(Float valorVenta) {
        this.valorVenta = valorVenta;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }





    public TipoEstado getEstado() {
        return estado;
    }

    public void setEstado(TipoEstado estado) {
        this.estado = estado;
    }

    public TipoVenta getTipoVenta() {
        return tipoVenta;
    }

    public void setTipoVenta(TipoVenta tipoVenta) {
        this.tipoVenta = tipoVenta;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
