package com.mastertech.itau.cambio.ApiCompra.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public class CreateCompraPostRequest {

    private long idCliente;

    private String tipoMoeda;

    private double quantidadeMoeda;

    private String cepCliente;

    public CreateCompraPostRequest() { }

    public long getIdCliente() { return idCliente; }

    public void setIdCliente(long idCliente) { this.idCliente = idCliente; }

    public String getTipoMoeda() { return tipoMoeda; }

    public void setTipoMoeda(String tipoMoeda) { this.tipoMoeda = tipoMoeda; }

    public double getQuantidadeMoeda() { return quantidadeMoeda; }

    public void setQuantidadeMoeda(double quantidadeMoeda) { this.quantidadeMoeda = quantidadeMoeda; }

    public String getCepCliente() { return cepCliente; }

    public void setCepCliente(String cepCliente) { this.cepCliente = cepCliente; }

}
