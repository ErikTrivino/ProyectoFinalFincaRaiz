package com.example.proyectofincaraiz.modelos.propiedades;

import com.example.proyectofincaraiz.modelos.Propiedades;
import com.example.proyectofincaraiz.modelos.Usuario;
import com.example.proyectofincaraiz.modelos.enums.TipoEstado;
import com.example.proyectofincaraiz.modelos.enums.TipoVenta;

public class Chalet extends Propiedades {

    private boolean aguaPotable;
    private boolean servAlcantarillado;
    private  boolean servinternet;
    private boolean servEnergia;
    private boolean servGas;

    public Chalet(Integer id, String direccion, Float valorVenta, String area, Integer numCuartos, Integer numBanios, TipoEstado estado, TipoVenta tipoVenta, Usuario usuario, boolean aguaPotable, boolean servAlcantarillado, boolean servinternet, boolean servEnergia, boolean servGas) {
        super(id, direccion, valorVenta, area, numCuartos, numBanios, estado, tipoVenta, usuario);
        this.aguaPotable = aguaPotable;
        this.servAlcantarillado = servAlcantarillado;
        this.servinternet = servinternet;
        this.servEnergia = servEnergia;
        this.servGas = servGas;
    }
}
