package br.com.Sublimoon.PI.service;

import br.com.Sublimoon.PI.entity.Categoria;
import br.com.Sublimoon.PI.repository.CategoriaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRep;

    @Transactional(rollbackFor = Exception.class)
    public void createCategoria(final Categoria categoria){


        Assert.isTrue(!categoria.getCategorias().equals(""),"Categorias não pode ser nulo");

        this.categoriaRep.save(categoria);

    }



}
