package br.com.Sublimoon.pi.service;
import br.com.Sublimoon.pi.DTO.FavoritoDTO;
import br.com.Sublimoon.pi.entity.Favorito;
import br.com.Sublimoon.pi.repository.ClienteRepository;
import br.com.Sublimoon.pi.repository.FavoritoRepository;
import br.com.Sublimoon.pi.repository.ProdutoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;




@Service
public class FavoritoService{
    @Autowired
    FavoritoRepository favoritoRepository;
    @Autowired
    ProdutoRepository produtoRepository;
    @Autowired
    ClienteRepository clienteRepository;


    @Transactional(rollbackFor = Exception.class)
    public Favorito Favoritar(final FavoritoDTO favoritoDTO) {

        var favorito = new Favorito();
        BeanUtils.copyProperties(favoritoDTO,favorito);


        Assert.isTrue(produtoRepository.findById(favorito.getCliente().getId()).get()!= null, "Produto não encontrado!");
        Assert.isTrue(clienteRepository.findById(favorito.getCliente().getId()).get()!= null, "Cliente não encontrado!");

       /*favorito.setCliente(clienteRepository.findById(clienteId).get());


        if(favorito.getProdutos()==null) {
            List<Produto> attProduto = new ArrayList<>(); // Cria uma nova lista caso ainda não exista
            attProduto.add(produtoRepository.getById(produtoId));
            favorito.setProdutos(attProduto); // Define a lista no favorito
        }
        else {
            favorito.getProdutos().add(produtoRepository.getById(produtoId)); // Adiciona o produto à lista de produtos
        }

        */

        return favoritoRepository.save(favorito);
    }


    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id) {


    }


}