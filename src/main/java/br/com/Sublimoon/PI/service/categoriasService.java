package br.com.Sublimoon.PI.service;

import br.com.Sublimoon.PI.entity.Categoria;
import br.com.Sublimoon.PI.repository.CategoriasRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import java.util.Optional;

@Service
public class categoriasService {

    @Autowired
    private CategoriasRepository categoriaRep;

    @Transactional(rollbackFor = Exception.class)
    public void createCategoria(final Categoria categoria){

        Assert.isTrue(categoria.getId() != null,"Id não pode ser nulo");
        Optional<Categoria> categoriaExistente = categoriaRep.findById(categoria.getId());
        Assert.isTrue(categoriaExistente == null || categoriaExistente.equals(categoria.getId()),"Id já existente");

        Assert.isTrue(!categoria.getCategorias().equals(""),"Categorias não pode ser nulo");

    }



}
