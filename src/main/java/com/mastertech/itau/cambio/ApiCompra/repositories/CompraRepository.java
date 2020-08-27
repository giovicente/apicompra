package com.mastertech.itau.cambio.ApiCompra.repositories;

import com.mastertech.itau.cambio.ApiCompra.models.Compra;
import org.springframework.data.repository.CrudRepository;

public interface CompraRepository extends CrudRepository<Compra, Long> {
    Iterable<Compra> findAllByIdCliente(long idCliente);
}
