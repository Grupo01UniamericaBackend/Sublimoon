package br.com.sublimoon.pi.service;
import br.com.sublimoon.pi.dto.FavoritoDTO;
import br.com.sublimoon.pi.entity.Favorito;
import br.com.sublimoon.pi.repository.ClienteRepository;
import br.com.sublimoon.pi.repository.FavoritoRepository;
import br.com.sublimoon.pi.repository.ProdutoRepository;
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
    public Favorito favoritar(final FavoritoDTO favoritoDTO) {

        var favorito = new Favorito();
        BeanUtils.copyProperties(favoritoDTO,favorito);


       // Assert.isTrue(produtoRepository.findById(favorito.getCliente().getId()).get()!= null, "Produto não encontrado!");
       // Assert.isTrue(clienteRepository.findById(favorito.getCliente().getId()).get()!= null, "Cliente não encontrado!");



        return favoritoRepository.save(favorito);
    }


    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id) {


    }


}
