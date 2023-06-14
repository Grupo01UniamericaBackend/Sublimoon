package br.com.Sublimoon.PI.service;
import br.com.Sublimoon.PI.entity.Favorito;
import br.com.Sublimoon.PI.entity.Produto;
import br.com.Sublimoon.PI.repository.ClienteRepository;
import br.com.Sublimoon.PI.repository.FavoritoRepository;
import br.com.Sublimoon.PI.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;



@Service
public class FavoritoService{
    @Autowired final FavoritoRepository favoritoRepository;
    @Autowired final ProdutoRepository produtoRepository;
    @Autowired final ClienteRepository clienteRepository;

    public FavoritoService(FavoritoRepository favoritoRepository, ProdutoRepository produtoRepository, ClienteRepository clienteRepository) {
        this.favoritoRepository = favoritoRepository;
        this.produtoRepository = produtoRepository;
        this.clienteRepository = clienteRepository;
    }


    @Transactional(rollbackFor = Exception.class)
    public Favorito Favoritar(final Favorito favorito) {


        Long produtoId = favorito.getProdutoId();


        Assert.isTrue(produtoRepository.findById(produtoId).get()!= null, "Produto não encontrado!");


        if(favorito.getCliente()!=null)
        {
            favorito.setCliente(clienteRepository.getById(favorito.getCliente().getId()));
        }

        if(favorito.getProdutos()==null) {
            List<Produto> attProduto = new ArrayList<>(); // Cria uma nova lista caso ainda não exista
            attProduto.add(produtoRepository.getById(produtoId));
            favorito.setProdutos(attProduto); // Define a lista no favorito
        }
        else {
            favorito.getProdutos().add(produtoRepository.getById(produtoId)); // Adiciona o produto à lista de produtos
        }


        return favoritoRepository.save(favorito);

    }




}
