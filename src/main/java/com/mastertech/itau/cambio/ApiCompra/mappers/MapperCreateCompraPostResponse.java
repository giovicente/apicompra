package com.mastertech.itau.cambio.ApiCompra.mappers;

import com.mastertech.itau.cambio.ApiCompra.DTO.CreateCompraPostResponse;
import com.mastertech.itau.cambio.ApiCompra.models.Agencia;
import com.mastertech.itau.cambio.ApiCompra.models.Compra;

public class MapperCreateCompraPostResponse {

    public static CreateCompraPostResponse converterParaCreateCompraPostResponse(Compra compra, Agencia agencia) {
        CreateCompraPostResponse createCompraPostResponse = new CreateCompraPostResponse();

        createCompraPostResponse.setId(compra.getId());
        createCompraPostResponse.setIdCliente(compra.getIdCliente());
        createCompraPostResponse.setTipoMoeda(compra.getTipoMoeda());
        createCompraPostResponse.setDataSolicitacao(compra.getDataSolicitacao());
        createCompraPostResponse.setQuantidadeMoeda(compra.getQuantidadeMoeda());
        createCompraPostResponse.setTaxaCambio(compra.getTaxaCambio());
        createCompraPostResponse.setValorCotacao(compra.getValorCotacao());
        createCompraPostResponse.setValorOperacao(compra.getValorOperacao());

        createCompraPostResponse.setNumeroAgenciaRetirada(agencia.getId());
        createCompraPostResponse.setNomeAgenciaRetirada(agencia.getNome());
        createCompraPostResponse.setEnderecoAgenciaRetirada(agencia.getEndereco());

        return createCompraPostResponse;
    }

}
