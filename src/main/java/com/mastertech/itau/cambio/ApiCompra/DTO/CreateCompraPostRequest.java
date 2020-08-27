package com.mastertech.itau.cambio.ApiCompra.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public class CreateCompraPostRequest {

    @JsonProperty("id_cliente")
    private long idCliente;

    @JsonProperty("cep_cliente")
    private String cepCliente;

    @JsonProperty("tipo_moeda")
    private String tipoMoeda;

    @JsonProperty("quantidade_moeda")
    private double quantidadeMoeda;

    public CreateCompraPostRequest() { }

    public long getIdCliente() { return idCliente; }

    public void setIdCliente(long idCliente) { this.idCliente = idCliente; }

    public String getCepCliente() { return cepCliente; }

    public void setCepCliente(String cepCliente) { this.cepCliente = cepCliente; }

    public String getTipoMoeda() { return tipoMoeda; }

    public void setTipoMoeda(String tipoMoeda) { this.tipoMoeda = tipoMoeda; }

    public double getQuantidadeMoeda() { return quantidadeMoeda; }

    public void setQuantidadeMoeda(double quantidadeMoeda) { this.quantidadeMoeda = quantidadeMoeda; }

}
