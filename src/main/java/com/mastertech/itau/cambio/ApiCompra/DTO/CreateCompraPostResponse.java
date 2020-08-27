package com.mastertech.itau.cambio.ApiCompra.DTO;

import java.time.LocalDateTime;

public class CreateCompraPostResponse {

    private long id;

    private long idCliente;

    private String tipoMoeda;

    private LocalDateTime dataSolicitacao;

    private double quantidadeMoeda;

    private double taxaCambio;

    private double valorCotacao;

    private double valorOperacao;

    private String numeroAgenciaRetirada;

    private String nomeAgenciaRetirada;

    private String enderecoAgenciaRetirada;

    private long idAgendamento;

    public CreateCompraPostResponse() { }

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

    public void setValorOperacao(double valorOperacao) { this.valorOperacao = valorOperacao; }

    public String getNumeroAgenciaRetirada() { return numeroAgenciaRetirada; }

    public void setNumeroAgenciaRetirada(String numeroAgenciaRetirada) { this.numeroAgenciaRetirada = numeroAgenciaRetirada; }

    public String getNomeAgenciaRetirada() { return nomeAgenciaRetirada; }

    public void setNomeAgenciaRetirada(String nomeAgenciaRetirada) { this.nomeAgenciaRetirada = nomeAgenciaRetirada; }

    public String getEnderecoAgenciaRetirada() { return enderecoAgenciaRetirada; }

    public void setEnderecoAgenciaRetirada(String enderecoAgenciaRetirada) { this.enderecoAgenciaRetirada = enderecoAgenciaRetirada; }

    public long getIdAgendamento() { return idAgendamento; }

    public void setIdAgendamento(long idAgendamento) { this.idAgendamento = idAgendamento; }

}
