package com.mastertech.itau.cambio.ApiCompra.models;

public class Cotacao {

    private String moeda;

    private String nomeMoeda;

    private double cotacao;

    private String dataCotacao;

    public Cotacao() { }

    public String getMoeda() {
        return moeda;
    }

    public void setMoeda(String moeda) {
        this.moeda = moeda;
    }

    public double getCotacao() {
        return cotacao;
    }

    public void setCotacao(double cotacao) {
        this.cotacao = cotacao;
    }

    public String getNomeMoeda() {
        return nomeMoeda;
    }

    public void setNomeMoeda(String nomeMoeda) {
        this.nomeMoeda = nomeMoeda;
    }

    public String getDataCotacao() {
        return dataCotacao;
    }

    public void setDataCotacao(String dataCotacao) {
        this.dataCotacao = dataCotacao;
    }

}
