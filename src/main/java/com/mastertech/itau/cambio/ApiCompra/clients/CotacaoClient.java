package com.mastertech.itau.cambio.ApiCompra.clients;

import com.mastertech.itau.cambio.ApiCompra.models.Cotacao;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "cotacao")
public interface CotacaoClient {

    @GetMapping("/cambio/cotacao")
    Iterable<Cotacao> consultarCotacao();

}
