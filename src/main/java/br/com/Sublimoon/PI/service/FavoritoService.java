package br.com.Sublimoon.PI.service;

<<<<<<< HEAD
public class FavoritoService {
=======

import br.com.Sublimoon.PI.entity.Favorito;
import br.com.Sublimoon.PI.entity.Produto;
import br.com.Sublimoon.PI.repository.FavoritoRepository;
import br.com.Sublimoon.PI.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

@Service
public class FavoritoService{
    @Autowired final FavoritoRepository favoritoRepository;
    @Autowired final ProdutoRepository produtoRepository;

    public FavoritoService(FavoritoRepository favoritoRepository, ProdutoRepository produtoRepository) {
        this.favoritoRepository = favoritoRepository;
        this.produtoRepository = produtoRepository;
    }


    @Transactional(rollbackFor = Exception.class)
    public Favorito Favoritar(final Favorito favorito) {


        Long produtoId = favorito.getProdutoId();

        Assert.isTrue(produtoRepository.findById(produtoId).get()!= null, "Produto não encontrado!");





        if(favorito.getProdutos()==null) {

            List<Produto> attProduto = new ArrayList<>(); // Cria uma nova lista caso ainda não exista
            favorito.setProdutos(attProduto); // Define a lista no favorito
        }
        else {

            favorito.getProdutos().add(produtoRepository.getById(produtoId)); // Adiciona o produto à lista de produtos
        }
        return favoritoRepository.save(favorito);

    }

>>>>>>> 7ab800cdf9be5c4a793fda40429e293138963241

}
