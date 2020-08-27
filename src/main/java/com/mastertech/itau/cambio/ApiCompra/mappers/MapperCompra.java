package com.mastertech.itau.cambio.ApiCompra.mappers;

import com.mastertech.itau.cambio.ApiCompra.DTO.CreateCompraPostRequest;
import com.mastertech.itau.cambio.ApiCompra.models.Compra;

public class MapperCompra {

    public static Compra converterParaCompra(CreateCompraPostRequest createCompraPostRequest) {
        Compra compra = new Compra();
        compra.setIdCliente(createCompraPostRequest.getIdCliente());
        compra.setTipoMoeda(createCompraPostRequest.getTipoMoeda());
        compra.setQuantidadeMoeda(createCompraPostRequest.getQuantidadeMoeda());

        return compra;
    }

}
