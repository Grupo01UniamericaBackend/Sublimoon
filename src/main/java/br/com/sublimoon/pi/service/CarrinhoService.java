package br.com.sublimoon.pi.service;

import br.com.sublimoon.pi.entity.Carrinho;
import br.com.sublimoon.pi.entity.Item;
import br.com.sublimoon.pi.entity.Produto;
import br.com.sublimoon.pi.repository.CarrinhoRepository;
import br.com.sublimoon.pi.repository.ItemRepository;
import br.com.sublimoon.pi.repository.ProdutoRepository;
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
    public void createCarrinho(final Carrinho carrinho){

        for (int i = 0; i < carrinho.getItem().size(); i++){
            Item itemNovo = carrinho.getItem().get(i);

            long idProduto = itemNovo.getProduto().getId();
            Produto produto = produtoRepository.getReferenceById(idProduto);
            float valorUnitario = produto.getPreco();


            itemNovo.setValorUnit(valorUnitario);
            itemNovo.setValor(itemNovo.getValorUnit() * itemNovo.getQuantidade());
            itemNovo.setValorTotal(itemNovo.getValor());

            itemRepository.save(itemNovo);
            carrinho.getItem().set(i,itemNovo);
            carrinho.setSubTotal(carrinho.getSubTotal() + itemNovo.getValorTotal());
            //itemRepository.getById((long) i).setValorUnit(valorUnitario);

        }

        carrinhoRepo.save(carrinho);
    }

    @Transactional(rollbackFor = Exception.class)
    public Carrinho addCarrinho(long id, final Carrinho carrinho){

            Carrinho carrinhoAntigo = carrinhoRepo.getReferenceById(id);
            List<Item> carrinhoNovo = adicionarItem(carrinhoAntigo.getItem(),carrinho.getItem());


            carrinhoAntigo.setItem(carrinhoNovo);
            for(int i = 0; i < carrinhoAntigo.getItem().size(); i ++){

                Item itemNovo = carrinhoAntigo.getItem().get(i);

                long idProduto = itemNovo.getProduto().getId();
                Produto produto = produtoRepository.getReferenceById(idProduto);
                float valorUnitario = produto.getPreco();

                itemNovo.setValorUnit(valorUnitario);
                itemNovo.setValor(itemNovo.getValorUnit() * itemNovo.getQuantidade());
                itemNovo.setValorTotal(itemNovo.getValor());
                carrinho.setSubTotal(carrinho.getSubTotal() + itemNovo.getValorTotal());

                itemRepository.save(itemNovo);
                carrinhoAntigo.getItem().set(i,itemNovo);
                carrinhoAntigo.setSubTotal(carrinho.getSubTotal() + itemNovo.getValorTotal());

            }

        carrinhoRepo.save(carrinhoAntigo);

        return carrinhoAntigo;
    }

    @Transactional(rollbackFor = Exception.class)
    public List<Item> adicionarItem(List<Item> listaItens, List<Item> itens){

        for (Item iten : itens) {
            int i = -1;
            Item itemAdd = iten;
            for (int x = 0; x < listaItens.size() & i < 0; x++) {

                Produto produto = listaItens.get(x).getProduto();
                if (itemAdd.getProduto().equals(produto)) {
                    i = x;
                }
            }
            try {
                if (i < 0) { //se não encontrar nenhum item igual no carrinho ele adiciona o item

                    listaItens.add(itemAdd);
                } else { //se encontrar um item igual, ele muda a quantidade e o valor
                    itemAdd = itens.get(i);
                    int quantidade = itemAdd.getQuantidade() + listaItens.get(i).getQuantidade();//soma a quantidade

                    itemAdd.setQuantidade(quantidade);

                    listaItens.set(i, itemAdd);

                }

            } catch (RuntimeException e) {
                e.getStackTrace();
            }
        }
        return listaItens;
    }
    public Collection<Item> getItens(List<Item> itens){

        if(itens == null){
                itens = new ArrayList<>();
        }
        return itens;
    }

    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id ){
            this.carrinhoRepo.deleteById(id);
    }

}
