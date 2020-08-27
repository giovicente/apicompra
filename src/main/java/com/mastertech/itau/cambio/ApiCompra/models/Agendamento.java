package com.mastertech.itau.cambio.ApiCompra.models;

public class Agendamento {

    private long id;

    private String agencia;

    private Long idCliente;

    private String tipoAgendamento;

    private long idSolicitacao;

    private String statusAgendamento;

    public Agendamento() { }

    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

    public String getAgencia() { return agencia; }

    public void setAgencia(String agencia) { this.agencia = agencia; }

    public Long getIdCliente() { return idCliente; }

    public void setIdCliente(Long idCliente) { this.idCliente = idCliente; }

    public String getTipoAgendamento() { return tipoAgendamento; }

    public void setTipoAgendamento(String tipoAgendamento) { this.tipoAgendamento = tipoAgendamento; }

    public long getIdSolicitacao() { return idSolicitacao; }

    public void setIdSolicitacao(long idSolicitacao) { this.idSolicitacao = idSolicitacao; }

    public String getStatusAgendamento() { return statusAgendamento; }

    public void setStatusAgendamento(String statusAgendamento) { this.statusAgendamento = statusAgendamento; }

}
