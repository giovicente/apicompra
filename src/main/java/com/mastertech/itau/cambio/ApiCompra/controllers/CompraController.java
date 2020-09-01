package com.mastertech.itau.cambio.ApiCompra.controllers;

import com.mastertech.itau.cambio.ApiCompra.DTO.CreateCompraPostRequest;
import com.mastertech.itau.cambio.ApiCompra.DTO.CreateCompraPostResponse;
import com.mastertech.itau.cambio.ApiCompra.mappers.MapperAgendamento;
import com.mastertech.itau.cambio.ApiCompra.mappers.MapperCompra;
import com.mastertech.itau.cambio.ApiCompra.mappers.MapperCreateCompraPostResponse;
import com.mastertech.itau.cambio.ApiCompra.models.Agencia;
import com.mastertech.itau.cambio.ApiCompra.models.Agendamento;
import com.mastertech.itau.cambio.ApiCompra.models.Compra;
import com.mastertech.itau.cambio.ApiCompra.services.CompraService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.cloud.sleuth.annotation.NewSpan;

@RestController
public class CompraController {

    @Autowired
    private CompraService compraService;

    @PostMapping
    @NewSpan("Cambio-APICompra-postCompra")
    public ResponseEntity<CreateCompraPostResponse> postCompra
            (@RequestBody CreateCompraPostRequest createCompraPostRequest) throws NotFoundException {

        Agencia agencia = new Agencia();

        try {
            agencia = compraService.obterAgenciaPorNumero(createCompraPostRequest.getNumeroAgencia());
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "A Agência " + createCompraPostRequest.getNumeroAgencia() + " não é uma agência válida.");
        }

        Compra compra = MapperCompra.converterParaCompra(createCompraPostRequest);
        Compra compraObjeto = compraService.salvarCompra(compra);

        Agendamento agendamento = MapperAgendamento.converterParaAgendamento(createCompraPostRequest, compraObjeto.getId());
        Agendamento agendamentoObjeto = compraService.salvarAgendamento(agendamento);

        long idAgendamento = agendamentoObjeto.getId();

        CreateCompraPostResponse createCompraPostResponse
                = MapperCreateCompraPostResponse.converterParaCreateCompraPostResponse(compraObjeto, agencia, idAgendamento);

        return ResponseEntity.status(201).body(createCompraPostResponse);
    }

    @GetMapping
    @NewSpan("Cambio-APICompra-getCompra")
    public Iterable<Compra> getCompra(@RequestParam(name = "id_cliente", required = true) Long idCliente) {
        return compraService.consultarListaComprasPorIdCliente(idCliente);
    }

    @GetMapping("/{id_compra}")
    @NewSpan("Cambio-APICompra-getCompraPorId")
    public Compra getCompraPorId(@PathVariable(name = "id_compra") long id) {
        try {
            Compra compraObjeto = compraService.consultarCompraPorId(id);
            return compraObjeto;
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

}