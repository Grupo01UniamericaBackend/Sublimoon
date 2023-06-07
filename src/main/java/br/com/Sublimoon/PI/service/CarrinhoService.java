package br.com.Sublimoon.PI.service;

import br.com.Sublimoon.PI.entity.Carrinho;
import br.com.Sublimoon.PI.entity.Produto;
import br.com.Sublimoon.PI.repository.CarrinhoRepository;
import br.com.Sublimoon.PI.repository.ProdutoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

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


        Optional<Carrinho> carrinhoExistente = carrinhoRepo.findById(carrinho.getId());
        Assert.isTrue(carrinhoExistente == null || carrinhoExistente.equals(carrinho.getId()), "Id já existente");



        Long produtoId = carrinho.getProdutoId(); // Supondo que você tenha o ID do produto disponível

        Produto produto = produtoRepository.getById(produtoId);
        Assert.isTrue(produto != null, "Produto não encontrado!");

        carrinho.getProdutos().add(produto);





    }

}
