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

@Service
public class CarrinhoService {

    @Autowired
    final CarrinhoRepository carrinhoRepo;
    @Autowired
    final ProdutoRepository produtoRepository;

    public CarrinhoService(CarrinhoRepository carrinhoRepo, ProdutoRepository produtoRepository) {
        this.carrinhoRepo = carrinhoRepo;
        this.produtoRepository = produtoRepository;
    }

    @Transactional(rollbackFor = Exception.class)
    public void createCarrinho(final Carrinho carrinho){

        Assert.isTrue(carrinho.getQuantidade() >= 0, "Quantidade não pode ser nulo");

        Assert.isTrue(carrinho.getSubTotal() != 0, "SubTotal não pode ser nulo");

        Long produtoId = carrinho.getProdutoId();

        Produto produto = produtoRepository.getById(produtoId);

        if(carrinho.getProdutos()==null) {
            List<Produto> attProduto = new ArrayList<>(); // Cria uma nova lista caso ainda não exista
            attProduto.add(produtoRepository.getById(produtoId));
            carrinho.setProdutos(attProduto); // Define a lista no carrinho
        }
        else {
            carrinho.getProdutos().add(produtoRepository.getById(produtoId)); // Adiciona o produto ao carrinho
        }

        //Assert.isTrue(carrinho.getProdutos() != null, "Produtos não pode ser nulo");

        this.carrinhoRepo.save(carrinho);


    }

}
