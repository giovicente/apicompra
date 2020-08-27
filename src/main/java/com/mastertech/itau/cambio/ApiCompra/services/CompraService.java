package com.mastertech.itau.cambio.ApiCompra.services;

import com.mastertech.itau.cambio.ApiCompra.clients.CotacaoClient;
import com.mastertech.itau.cambio.ApiCompra.models.Compra;
import com.mastertech.itau.cambio.ApiCompra.models.Cotacao;
import com.mastertech.itau.cambio.ApiCompra.repositories.CompraRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CompraService {

    @Autowired
    private CompraRepository compraRepository;

    @Autowired
    private CotacaoClient cotacaoClient;

    private static final double TAXA_CAMBIO = 0.18;

    public Compra salvarCompra(Compra compra) throws NotFoundException {
        compra.setDataSolicitacao(LocalDateTime.now());
        compra.setTaxaCambio(TAXA_CAMBIO);
        compra.setValorCotacao(obterCotacao(compra.getTipoMoeda()));
        compra.setValorOperacao(calcularValorOperacao(compra.getQuantidadeMoeda(), compra.getValorCotacao()));

        // TODO -> consumir API de débito da conta
        Compra compraObjeto = compraRepository.save(compra);

        return compraObjeto;
    }

    public double obterCotacao(String tipoMoeda) {
        Iterable<Cotacao> cotacoes = cotacaoClient.consultarCotacao();
        List<Cotacao> cotacoesList = new ArrayList<>();

        cotacoes.forEach(cotacoesList::add);

        for (int i = 0; i < cotacoesList.size(); i++) {
            if (cotacoesList.get(i).getMoeda().equals(tipoMoeda)) {
                return cotacoesList.get(i).getCotacao();
            }
        }

        throw new RuntimeException("Tipo de Moeda inválido: " + tipoMoeda);
    }

    private double calcularValorOperacao(double quantidadeMoeda, double valorCotacao) { return quantidadeMoeda * valorCotacao; }

    public Iterable<Compra> consultarListaComprasPorIdCliente(long idCliente) {
        Iterable<Compra> compras = compraRepository.findAllByIdCliente(idCliente);
        return compras;
    }

    public Compra consultarCompraPorId(long id) {
        Optional<Compra> compraOptional = compraRepository.findById(id);

        if (compraOptional.isPresent()) {
            return compraOptional.get();
        }

        throw new RuntimeException("Compra não encontrada.");
    }

}