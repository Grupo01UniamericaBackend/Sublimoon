package br.com.Sublimoon.PI.service;

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
    @Autowired
    FavoritoRepository favoritoRepository;
    @Autowired
    ProdutoRepository produtoRepository;



   /* @Transactional(rollbackFor = Exception.class)
    public Favorito Favoritar(final Favorito favorito) {
    }*/


}
