package br.com.Sublimoon.PI.service;

import br.com.Sublimoon.PI.entity.Carrinho;
<<<<<<< HEAD
import br.com.Sublimoon.PI.repository.CarrinhoRepository;
=======
import br.com.Sublimoon.PI.entity.Produto;
import br.com.Sublimoon.PI.repository.CarrinhoRepository;
import br.com.Sublimoon.PI.repository.ProdutoRepository;
>>>>>>> 7ab800cdf9be5c4a793fda40429e293138963241
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

<<<<<<< HEAD
=======
import java.util.List;
>>>>>>> 7ab800cdf9be5c4a793fda40429e293138963241
import java.util.Optional;

@Service
public class CarrinhoService {

    @Autowired
    CarrinhoRepository carrinhoRepo;
<<<<<<< HEAD
=======
    @Autowired
    ProdutoRepository produtoRepository;
>>>>>>> 7ab800cdf9be5c4a793fda40429e293138963241

    @Transactional(rollbackFor = Exception.class)
    public void createCarrinho(final Carrinho carrinho){

<<<<<<< HEAD
        Assert.isTrue(carrinho.getId() != null, "Id não pode ser nulo");
        Optional<Carrinho> carrinhoExistente = carrinhoRepo.findById(carrinho.getId());
        Assert.isTrue(carrinhoExistente == null || carrinhoExistente.equals(carrinho.getId()), "Id já existente");

        Assert.isTrue(carrinho.getProdutos() != null, "Produtos não pode ser nulo");

        Assert.isTrue(carrinho.getQuantidade() >= 0, "Quantidade não pode ser nulo");

        Assert.isTrue(carrinho.getSubTotal() != null, "SubTotal não pode ser nulo");

        this.carrinhoRepo.save(carrinho);
=======

        Optional<Carrinho> carrinhoExistente = carrinhoRepo.findById(carrinho.getId());
        Assert.isTrue(carrinhoExistente == null || carrinhoExistente.equals(carrinho.getId()), "Id já existente");



        Long produtoId = carrinho.getProdutoId();

        Produto produto = produtoRepository.getById(produtoId);
        Assert.isTrue(produto != null, "Produto não encontrado!");

        carrinho.getProdutos().add(produto);





>>>>>>> 7ab800cdf9be5c4a793fda40429e293138963241
    }

}
