package com.mastertech.itau.cambio.ApiCompra.controllers;

import com.mastertech.itau.cambio.ApiCompra.DTO.CreateCompraPostRequest;
import com.mastertech.itau.cambio.ApiCompra.mappers.MapperCompra;
import com.mastertech.itau.cambio.ApiCompra.models.Compra;
import com.mastertech.itau.cambio.ApiCompra.services.CompraService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/cambio/compra")
public class CompraController {

    @Autowired
    private CompraService compraService;

    @PostMapping
    public ResponseEntity<Compra> postCompra(@RequestBody CreateCompraPostRequest createCompraPostRequest) throws NotFoundException {
        Compra compra = MapperCompra.converterParaCompra(createCompraPostRequest);
        Compra compraObjeto = compraService.salvarCompra(compra);

        return ResponseEntity.status(201).body(compraObjeto);
    }

    @GetMapping
    public Iterable<Compra> getCompra(@RequestParam(name = "id_cliente", required = false) Long idCliente) {
        if (idCliente != null){
            return compraService.consultarListaComprasPorIdCliente(idCliente);
        }

        return compraService.consultarListaCompras();
    }

    @GetMapping("{/id_compra}")
    public Compra getCompraPorId(@PathVariable(name = "id_compra") long id) {
        try {
            Compra compraObjeto = compraService.consultarCompraPorId(id);
            return compraObjeto;
        } catch (NotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

}
