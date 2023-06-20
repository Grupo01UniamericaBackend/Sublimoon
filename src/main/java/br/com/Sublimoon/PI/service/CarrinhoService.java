package br.com.Sublimoon.PI.service;

import br.com.Sublimoon.PI.entity.Carrinho;
import br.com.Sublimoon.PI.entity.Item;
import br.com.Sublimoon.PI.entity.Produto;
import br.com.Sublimoon.PI.repository.CarrinhoRepository;
import br.com.Sublimoon.PI.repository.ProdutoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class CarrinhoService {

    @Autowired
     CarrinhoRepository carrinhoRepo;
    @Autowired
     ProdutoRepository produtoRepository;



    @Transactional(rollbackFor = Exception.class)
    public Carrinho createCarrinho(final Carrinho carrinho){
        float quantidadeTotal = 0;

        float subTotal = 0;

        float teste = carrinho.getProdutos().get(1).getQuantidadeProCarrinho();

        System.out.println(teste);

        /*for(int i = 0; i < carrinho.getProdutos().size(); i ++){

           quantidadeTotal += carrinho.getProdutos().get(i).getQuantidadeProCarrinho();

           subTotal += (carrinho.getProdutos().get(i).getQuantidadeProCarrinho() * carrinho.getProdutos().get(i).getPreco());
        }*/
        for(int i = 0; i < carrinho.getProdutos().size(); i ++){

            adicionarItem(carrinho.getProdutos().get(i),carrinho.getItens());
        }

        return carrinhoRepo.save(carrinho);
    }

    @Transactional(rollbackFor = Exception.class)
    public void adicionarItem(Produto produto, List<Item> Itens){
        int i = -1;
        float valorUnitario = produto.getPesoProduto();
        int quantidade = produto.getQuantidadeProCarrinho();

        for(int x = 0; x < getItens(Itens).size() & i < 0; i++){
            Item itemAdd = Itens.get(x);

            if(itemAdd.getProduto().equals(produto)){
                i = x;
            }
        }
        try{
            if(i < 0){
                Item item = new Item();
                item.setValor(item.getValorTotal());
                getItens(Itens).add(item);
            }
            else{
                Item itemAdd = Itens.get(i);
                quantidade = itemAdd.getQuantidade() + quantidade;
                valorUnitario = itemAdd.getValorUnit();
                Item item = new Item();
                item.setValor(item.getValorTotal());

                Itens.set(i,item);


            }
        }
        catch (RuntimeException e){
            e.getStackTrace();
        }
    }
    public Collection<Item> getItens(List<Item> Itens){

        if(Itens == null){
                Itens = new ArrayList<>();
        }
        return Itens;
    }

}
