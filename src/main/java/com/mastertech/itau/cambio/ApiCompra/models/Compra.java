package com.mastertech.itau.cambio.ApiCompra.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @JsonProperty("id_cliente")
    private long idCliente;

    @JsonProperty("tipo_moeda")
    private String tipoMoeda;

    @JsonProperty("data_solicitacao")
    private LocalDateTime dataSolicitacao;

    @JsonProperty("quantidade_moeda")
    private double quantidadeMoeda;

    @JsonProperty("taxa_cambio")
    private double taxaCambio;

    @JsonProperty("valor_cotacao")
    private double valorCotacao;

    @JsonProperty("valor_total_operacao")
    private double valorOperacao;

    public Compra() { }

    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

    public long getIdCliente() { return idCliente; }

    public void setIdCliente(long idCliente) { this.idCliente = idCliente; }

    public String getTipoMoeda() { return tipoMoeda; }

    public void setTipoMoeda(String tipoMoeda) { this.tipoMoeda = tipoMoeda; }

    public LocalDateTime getDataSolicitacao() { return dataSolicitacao; }

    public void setDataSolicitacao(LocalDateTime dataSolicitacao) { this.dataSolicitacao = dataSolicitacao; }

    public double getQuantidadeMoeda() { return quantidadeMoeda; }

    public void setQuantidadeMoeda(double quantidadeMoeda) { this.quantidadeMoeda = quantidadeMoeda; }

    public double getTaxaCambio() { return taxaCambio; }

    public void setTaxaCambio(double taxaCambio) { this.taxaCambio = taxaCambio; }

    public double getValorCotacao() { return valorCotacao; }

    public void setValorCotacao(double valorCotacao) { this.valorCotacao = valorCotacao; }

    public double getValorOperacao() { return valorOperacao; }

    public void setValorOperacao(double valorOperacao) {
        this.valorOperacao = valorOperacao;
    }
}
