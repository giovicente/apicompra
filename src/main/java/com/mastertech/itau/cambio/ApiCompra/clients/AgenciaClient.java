package com.mastertech.itau.cambio.ApiCompra.clients;

import com.mastertech.itau.cambio.ApiCompra.models.Agencia;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "agencia")
public interface AgenciaClient {

    @GetMapping("/porNumero/{numero}")
    Agencia consultarAgencia(@PathVariable(name = "numero") String numero);

}
