package com.mastertech.itau.cambio.ApiCompra.clients;

import com.mastertech.itau.cambio.ApiCompra.models.Cotacao;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "cambio-apicotacao", url = "http://k8s-itau.mastertech.com.br/cambio/cotacao/")
public interface CotacaoClient {

    @GetMapping
    Iterable<Cotacao> consultarCotacao();

}
