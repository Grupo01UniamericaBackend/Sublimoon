package br.com.Sublimoon.PI.service;

import br.com.Sublimoon.PI.entity.Carrinho;
import br.com.Sublimoon.PI.entity.Item;
import br.com.Sublimoon.PI.entity.Produto;
import br.com.Sublimoon.PI.repository.CarrinhoRepository;
import br.com.Sublimoon.PI.repository.ProdutoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

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
       /* float quantidadeTotal = 0;

        float subTotal = 0;
       // float teste = carrinho.getProdutos().get(1).getQuantidadeProCarrinho();
       // System.out.println(teste);
        for(int i = 0; i < carrinho.getProdutos().size(); i ++){
           quantidadeTotal += carrinho.getProdutos().get(i).getQuantidadeProCarrinho();
           subTotal += (carrinho.getProdutos().get(i).getQuantidadeProCarrinho() * carrinho.getProdutos().get(i).getPreco());
        }*/




        for(int i = 0; i < carrinho.getItem().size(); i ++){
            Item itemNovo = carrinho.getItem().get(i);

            Produto produto = itemNovo.getProduto();
            float valorUnitario = produto.getPreco();

            itemNovo.setValorUnit(valorUnitario);
            itemNovo.setValor(itemNovo.getValorTotal());

            carrinho.setSubTotal(carrinho.getSubTotal() + itemNovo.getValorTotal());

        }

        return carrinhoRepo.save(carrinho);
    }

    @Transactional(rollbackFor = Exception.class)
    public Carrinho addCarrinho(long id, final Carrinho carrinho){

            Carrinho carrinhoAntigo = carrinhoRepo.getById(id);
            List<Item> CarrinhoNovo = adicionarItem(carrinhoAntigo.getItem(),carrinho.getItem());

            BeanUtils.copyProperties(carrinho, carrinhoAntigo, "id");

            for(int i = 0; i < carrinho.getItem().size(); i ++){
                Item itemNovo = carrinho.getItem().get(i);

                Produto produto = itemNovo.getProduto();
                float valorUnitario = produto.getPreco();

                itemNovo.setValorUnit(valorUnitario);
                itemNovo.setValor(itemNovo.getValorTotal());
                carrinho.setSubTotal(carrinho.getSubTotal() + itemNovo.getValorTotal());

            }


        return carrinhoRepo.save(carrinho);
    }

    @Transactional(rollbackFor = Exception.class)
    public List<Item> adicionarItem(List<Item> listaItens, List<Item> Itens){

        for(int pos = 0; pos <= Itens.size(); pos++) {
            int i = -1;
            Item itemAdd = Itens.get(pos);
            for (int x = 0; x < listaItens.size() & i < 0; x++) {

                Produto produto = listaItens.get(x).getProduto();
                if (itemAdd.getProduto().equals(produto)) {
                    i = x;
                }
            }
            try {
                if (i < 0) { //se não encontrar nenhum item igual no carrinho ele adiciona o item

                    listaItens.add(itemAdd);
                }
                else { //se encontrar um item igual, ele muda a quantidade e o valor
                    itemAdd = Itens.get(i);
                    int quantidade = itemAdd.getQuantidade() + listaItens.get(i).getQuantidade();//soma a quantidade

                    itemAdd.setQuantidade(quantidade);

                    listaItens.set(i, itemAdd);

                }

            }
            catch (RuntimeException e) {
                e.getStackTrace();
            }
        }
        return listaItens;
    }
    public Collection<Item> getItens(List<Item> Itens){

        if(Itens == null){
                Itens = new ArrayList<>();
        }
        return Itens;
    }

}
