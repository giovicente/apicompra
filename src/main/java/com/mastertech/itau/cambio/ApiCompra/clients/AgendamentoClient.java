package com.mastertech.itau.cambio.ApiCompra.clients;

import com.mastertech.itau.cambio.ApiCompra.models.Agendamento;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "cambio-agendamento", url = "http://k8s-itau.mastertech.com.br/cambio/agendamento/")
public interface AgendamentoClient {

    @PostMapping("/especie")
    Agendamento criarAgendamentoEspecie(@RequestBody Agendamento agendamento);

}
