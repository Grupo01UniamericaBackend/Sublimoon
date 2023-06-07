package br.com.Sublimoon.PI.service;


import br.com.Sublimoon.PI.entity.Carrinho;
import br.com.Sublimoon.PI.entity.Favorito;
import br.com.Sublimoon.PI.entity.Produto;
import br.com.Sublimoon.PI.repository.FavoritoRepository;
import br.com.Sublimoon.PI.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

@Service
public class FavoritoService{
    @Autowired final FavoritoRepository favoritoRepository;
    @Autowired final ProdutoRepository produtoRepository;

    public FavoritoService(FavoritoRepository favoritoRepository, ProdutoRepository produtoRepository) {
        this.favoritoRepository = favoritoRepository;
        this.produtoRepository = produtoRepository;
    }


    @Transactional(rollbackFor = Exception.class)
    public void Favorito(final Favorito favorito) {


        Long produtoId = favorito.getProdutoId();

        Produto produto = produtoRepository.getById(produtoId);
        Assert.isTrue(produto != null, "Produto não encontrado!");

        favorito.getProdutos().add(produto);
    }


}
