package com.mastertech.itau.cambio.ApiCompra.services;

import com.mastertech.itau.cambio.ApiCompra.clients.AgenciaClient;
import com.mastertech.itau.cambio.ApiCompra.clients.AgendamentoClient;
import com.mastertech.itau.cambio.ApiCompra.clients.CotacaoClient;
import com.mastertech.itau.cambio.ApiCompra.models.Agencia;
import com.mastertech.itau.cambio.ApiCompra.models.Agendamento;
import com.mastertech.itau.cambio.ApiCompra.models.Compra;
import com.mastertech.itau.cambio.ApiCompra.models.Cotacao;
import com.mastertech.itau.cambio.ApiCompra.repositories.CompraRepository;
import com.mastertech.itau.cambio.ApiCompra.repositories.LogRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;

@Service
public class CompraService {

    @Autowired
    private CompraRepository compraRepository;

    @Autowired
    private CotacaoClient cotacaoClient;

    @Autowired
    private AgenciaClient agenciaClient;

    @Autowired
    private AgendamentoClient agendamentoClient;

    @Autowired
    private LogRepository logRepository;

    // Necessário ajuste para validar de onde obter essa informação de forma dinâmica
    private static final double TAXA_CAMBIO = 0.18;

    public Compra salvarCompra(Compra compra) throws NotFoundException {
        compra.setDataSolicitacao(LocalDateTime.now());
        compra.setTaxaCambio(TAXA_CAMBIO);
        compra.setValorCotacao(obterCotacao(compra.getTipoMoeda()));
        compra.setValorOperacao(calcularValorOperacao(compra.getQuantidadeMoeda(), compra.getValorCotacao()));

        // TODO -> consumir API de débito da conta

        Compra compraObjeto = compraRepository.save(compra);

        logarCompra(compraObjeto);

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

        compras.forEach(compra -> {
            logarCompra(compra);
        });

        return compras;
    }

    public Compra consultarCompraPorId(long id) {
        Optional<Compra> compraOptional = compraRepository.findById(id);

        if (compraOptional.isPresent()) {
            logarCompra(compraOptional.get());
            return compraOptional.get();
        }

        throw new RuntimeException("Compra não encontrada.");
    }

    public Agencia obterAgenciaPorNumero(String numeroAgencia) { return agenciaClient.consultarAgencia(numeroAgencia); }

    public Agendamento salvarAgendamento(Agendamento agendamento) { return agendamentoClient.criarAgendamentoEspecie(agendamento); }

    public void logarCompra(Compra compra) { logRepository.log(Level.INFO, this.getClass(), compra); }

}