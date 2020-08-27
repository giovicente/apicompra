package com.mastertech.itau.cambio.ApiCompra.DTO;

import com.mastertech.itau.cambio.ApiCompra.models.Agencia;
import com.mastertech.itau.cambio.ApiCompra.models.Compra;

import java.util.List;

public class CreateCompraPostResponse {

    private Compra compra;

    private List<Agencia> agencias;

    public CreateCompraPostResponse() { }

    public CreateCompraPostResponse(Compra compra, List<Agencia> agencias) {
        this.compra = compra;
        this.agencias = agencias;
    }

    public Compra getCompra() { return compra; }

    public void setCompra(Compra compra) { this.compra = compra; }

    public List<Agencia> getAgencias() { return agencias; }

    public void setAgencias(List<Agencia> agencias) { this.agencias = agencias; }

}
