package br.com.Sublimoon.PI.service;

import br.com.Sublimoon.PI.entity.Carrinho;
import br.com.Sublimoon.PI.entity.Item;
import br.com.Sublimoon.PI.entity.Produto;
import br.com.Sublimoon.PI.repository.CarrinhoRepository;
import br.com.Sublimoon.PI.repository.ItemRepository;
import br.com.Sublimoon.PI.repository.ProdutoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class CarrinhoService {

    @Autowired
     private CarrinhoRepository carrinhoRepo;
    @Autowired
     private ProdutoRepository produtoRepository;

    @Autowired
    private ItemRepository itemRepository;



    @Transactional(rollbackFor = Exception.class)
    public Carrinho createCarrinho(final Carrinho carrinho){

        for (int i = 0; i < carrinho.getItem().size(); i++){
            Item itemNovo = carrinho.getItem().get(i);

            long idProduto = itemNovo.getProduto().getId();
            Produto produto = produtoRepository.getById(idProduto);
            float valorUnitario = produto.getPreco();

            //itemNovo.setProduto(produto);
            itemNovo.setValorUnit(valorUnitario);
            itemNovo.setValor(itemNovo.getValorUnit() * itemNovo.getQuantidade());
            itemNovo.setValorTotal(itemNovo.getValor());

            itemRepository.save(itemNovo);
            carrinho.getItem().set(i,itemNovo);
            carrinho.setSubTotal(carrinho.getSubTotal() + itemNovo.getValorTotal());
            //itemRepository.getById((long) i).setValorUnit(valorUnitario);

        }

        return carrinhoRepo.save(carrinho);
    }

    @Transactional(rollbackFor = Exception.class)
    public Carrinho addCarrinho(long id, final Carrinho carrinho){

            Carrinho carrinhoAntigo = carrinhoRepo.getById(id);
            List<Item> carrinhoNovo = adicionarItem(carrinhoAntigo.getItem(),carrinho.getItem());

            //BeanUtils.copyProperties(carrinhoNovo, carrinhoAntigo, "id");
            carrinhoAntigo.setItem(carrinhoNovo);
            for(int i = 0; i < carrinhoAntigo.getItem().size(); i ++){
                Item itemNovo = carrinhoAntigo.getItem().get(i);

                Produto produto = itemNovo.getProduto();
                float valorUnitario = produto.getPreco();

                itemNovo.setValorUnit(valorUnitario);
                itemNovo.setValor(itemNovo.getValorUnit() * itemNovo.getQuantidade());
                itemNovo.setValorTotal(itemNovo.getValor());
                carrinho.setSubTotal(carrinho.getSubTotal() + itemNovo.getValorTotal());

            }

        carrinhoRepo.save(carrinhoAntigo);

        return carrinhoAntigo;
    }

    @Transactional(rollbackFor = Exception.class)
    public List<Item> adicionarItem(List<Item> listaItens, List<Item> Itens){

        for(int pos = 0; pos < Itens.size(); pos++) {
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

    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id ){
            this.carrinhoRepo.deleteById(id);
    }

}
