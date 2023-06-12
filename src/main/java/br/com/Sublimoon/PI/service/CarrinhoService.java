package br.com.Sublimoon.PI.service;

import br.com.Sublimoon.PI.entity.Carrinho;
import br.com.Sublimoon.PI.repository.CarrinhoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import java.util.Optional;

@Service
public class CarrinhoService {

    @Autowired
    CarrinhoRepository carrinhoRepo;

    @Transactional(rollbackFor = Exception.class)
    public void createCarrinho(final Carrinho carrinho){

        Assert.isTrue(carrinho.getId() != null, "Id não pode ser nulo");
        Optional<Carrinho> carrinhoExistente = carrinhoRepo.findById(carrinho.getId());
        Assert.isTrue(carrinhoExistente == null || carrinhoExistente.equals(carrinho.getId()), "Id já existente");

        Assert.isTrue(carrinho.getProdutos() != null, "Produtos não pode ser nulo");

        Assert.isTrue(carrinho.getQuantidade() >= 0, "Quantidade não pode ser nulo");

        Assert.isTrue(carrinho.getSubTotal() != null, "SubTotal não pode ser nulo");

        this.carrinhoRepo.save(carrinho);
    }

}
