package br.com.Sublimoon.PI.service;

import br.com.Sublimoon.PI.entity.Carrinho;
import br.com.Sublimoon.PI.entity.Produto;
import br.com.Sublimoon.PI.repository.CarrinhoRepository;
import br.com.Sublimoon.PI.repository.ProdutoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CarrinhoService {

    @Autowired
    CarrinhoRepository carrinhoRepo;
    @Autowired
    ProdutoRepository produtoRepository;

    @Transactional(rollbackFor = Exception.class)
    public void createCarrinho(final Carrinho carrinho){


        Assert.isTrue(carrinho.getProdutos() != null, "Produtos não pode ser nulo");

        Assert.isTrue(carrinho.getQuantidade() >= 0, "Quantidade não pode ser nulo");

        Assert.isTrue(carrinho.getSubTotal() != null, "SubTotal não pode ser nulo");


        this.carrinhoRepo.save(carrinho);


    }

}
