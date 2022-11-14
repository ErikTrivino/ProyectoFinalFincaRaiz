package com.example.proyectofincaraiz.modelos;

import com.example.proyectofincaraiz.modelos.enums.TipoVenta;

import java.time.LocalDate;

public class Venta {


    private Integer codigoFactura;

    private LocalDate fechaFactura;
    private Usuario usuarioCliente;
    private Usuario usuarioVenta;
    private Propiedad propiedad;
    private TipoVenta tipoVenta;
    private Double totalVenta;


    public Venta(int codigoFactura, LocalDate fechaFactura, Usuario usuarioCliente, Usuario usuarioVenta, Propiedad propiedad, TipoVenta tipoVenta, Double totalVenta) {
        this.codigoFactura = codigoFactura;
        this.fechaFactura = fechaFactura;
        this.usuarioCliente = usuarioCliente;
        this.usuarioVenta = usuarioVenta;
        this.propiedad = propiedad;
        this.tipoVenta = tipoVenta;
        this.totalVenta = totalVenta;
    }

    public int getCodigoFactura() {
        return codigoFactura;
    }

    public void setCodigoFactura(int codigoFactura) {
        this.codigoFactura = codigoFactura;
    }

    public LocalDate getFechaFactura() {
        return fechaFactura;
    }

    public void setFechaFactura(LocalDate fechaFactura) {
        this.fechaFactura = fechaFactura;
    }

    public Usuario getUsuarioCliente() {
        return usuarioCliente;
    }

    public void setUsuarioCliente(Usuario usuarioCliente) {
        this.usuarioCliente = usuarioCliente;
    }

    public Usuario getUsuarioVenta() {
        return usuarioVenta;
    }

    public void setUsuarioVenta(Usuario usuarioVenta) {
        this.usuarioVenta = usuarioVenta;
    }

    public Propiedad getPropiedad() {
        return propiedad;
    }

    public void setPropiedad(Propiedad propiedad) {
        this.propiedad = propiedad;
    }

    public TipoVenta getTipoVenta() {
        return tipoVenta;
    }

    public void setTipoVenta(TipoVenta tipoVenta) {
        this.tipoVenta = tipoVenta;
    }

    public Double getTotalVenta() {
        return totalVenta;
    }

    public void setTotalVenta(Double totalVenta) {
        this.totalVenta = totalVenta;
    }
}
