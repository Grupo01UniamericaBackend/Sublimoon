package br.com.Sublimoon.PI.service;

import br.com.Sublimoon.PI.entity.Carrinho;
import br.com.Sublimoon.PI.entity.Envio;
import br.com.Sublimoon.PI.entity.Pedido;
import br.com.Sublimoon.PI.repository.CarrinhoRepository;
import br.com.Sublimoon.PI.repository.EnvioRepository;
import br.com.Sublimoon.PI.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRep;
    @Autowired
    private CarrinhoRepository carrinhoRepository;
    @Autowired
    private EnvioRepository envioRepository;


    @Transactional(rollbackFor = Exception.class)
    public Pedido verificarPedido(final Pedido pedido){


        Assert.isTrue(!pedido.getPagamento().equals(""),"Pagamento nao pode ser nulo!!");
        Assert.isTrue(!pedido.getEndereco().equals(""),"O Endereço n pode ser nulo!!");
        Assert.isTrue(pedido.getEndereco().length() <= 60, "Endereço nao pode passar de 60 caracteres!!");
        Assert.isTrue(!pedido.getCep().equals(""),"CEP não pode ser nulo");
        Assert.isTrue(pedido.getCep().length() <= 25,"Cep n pode passar de 25 caracteres!!");

       Carrinho carrinho =  carrinhoRepository.getById(pedido.getCarrinho().getId());
        Envio envio = envioRepository.getById(pedido.getEnvio().getId());
        float total1 = envio.getValorFrete();

        float total2 = carrinho.getSubTotal();

        pedido.setTotal(total1 + total2);

        return pedidoRep.save(pedido);
    }

    @Transactional(rollbackFor = Exception.class)
    public void editarpedido(final Pedido pedido){


        Assert.isTrue(!pedido.getPagamento().equals(""),"Pagamento nao pode ser nulo!!");
        Assert.isTrue(!pedido.getEndereco().equals(""),"O Endereço n pode ser nulo!!");
        Assert.isTrue(pedido.getEndereco().length() <= 60, "Endereço nao pode passar de 60 caracteres!!");
        Assert.isTrue(!pedido.getCep().equals(""),"CEP não pode ser nulo");
        Assert.isTrue(pedido.getCep().length() <= 25,"Cep n pode passar de 25 caracteres!!");

        Carrinho carrinho =  carrinhoRepository.getById(pedido.getCarrinho().getId());
        Envio envio = envioRepository.getById(pedido.getEnvio().getId());
        float total1 = envio.getValorFrete();

        float total2 = carrinho.getSubTotal();

        pedido.setTotal(total1 + total2);

        this.pedidoRep.save(pedido);
    }

    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id){

            this.pedidoRep.deleteById(id);
    }

}

