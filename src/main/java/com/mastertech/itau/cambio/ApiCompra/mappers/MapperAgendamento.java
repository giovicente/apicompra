package com.mastertech.itau.cambio.ApiCompra.mappers;

import com.mastertech.itau.cambio.ApiCompra.DTO.CreateCompraPostRequest;
import com.mastertech.itau.cambio.ApiCompra.models.Agendamento;

public class MapperAgendamento {

    private static final String STATUS_AGENDAMENTO = "AGENDADO";
    private static final String TIPO_AGENDAMENTO = "ESPECIE";

    public static Agendamento converterParaAgendamento(CreateCompraPostRequest createCompraPostRequest, long idCompra) {

        Agendamento agendamento = new Agendamento();

        agendamento.setAgencia(createCompraPostRequest.getNumeroAgencia());
        agendamento.setIdCliente(createCompraPostRequest.getIdCliente());
        agendamento.setTipoAgendamento(TIPO_AGENDAMENTO);
        agendamento.setIdSolicitacao(idCompra);
        agendamento.setStatusAgendamento(STATUS_AGENDAMENTO);

        return agendamento;
    }

}
