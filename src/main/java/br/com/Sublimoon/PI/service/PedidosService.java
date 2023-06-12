package br.com.Sublimoon.PI.service;

import br.com.Sublimoon.PI.entity.Envio;
import br.com.Sublimoon.PI.entity.Pedido;
import br.com.Sublimoon.PI.repository.EnvioRepository;
import br.com.Sublimoon.PI.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

@Service
public class PedidosService {

    @Autowired
    final EnvioRepository envioRepository;

    @Autowired
    final PedidoRepository pedidoRepository;

    public PedidosService(EnvioRepository envioRepository, PedidoRepository pedidoRepository) {
        this.envioRepository = envioRepository;
        this.pedidoRepository = pedidoRepository;
    }

    @Transactional(rollbackFor = Exception.class)
    public void verificarPedido(final Pedido pedido){

        Assert.isTrue(!pedido.getTotal().equals(""),"Total não pode ser nulo!!");
        Assert.isTrue(!pedido.getPagamento().equals(""),"Pagamento nao pode ser nulo!!");
        Assert.isTrue(!pedido.getEndereco().equals(""),"O Endereço n pode ser nulo!!");
        Assert.isTrue(pedido.getEndereco().length() <= 60, "Endereço nao pode passar de 60 caracteres!!");
        Assert.isTrue(!pedido.getCep().equals(""),"CEP não pode ser nulo");
        Assert.isTrue(pedido.getCep().length() <= 25,"Cep n pode passar de 25 caracteres!!");


        Long envioId = pedido.getEnvio().getId();


        Assert.isTrue(envioRepository.findById(envioId).get()!=null,"Envio não encontrado!");


        pedido.setEnvio(envioRepository.getById(envioId));


    }

}

