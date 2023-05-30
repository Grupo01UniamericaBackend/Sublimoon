package br.com.Sublimoon.PI.service;
import br.com.Sublimoon.PI.entity.Produto;
import br.com.Sublimoon.PI.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

@Service
public class ProdutoService {

    @Autowired
    final ProdutoRepository produtoRep;

    @Autowired
    final ProdutoService produtoService;

    public ProdutoService(ProdutoRepository produtoRep, ProdutoService produtoService) {
        this.produtoRep = produtoRep;
        this.produtoService = produtoService;
    }


    @Transactional(rollbackFor = Exception.class)
    public void VerificarProduto (final Produto produto){


        Assert.isTrue(!produto.getNome().equals(""),"O nome do produto não pode ser nulo!");
        Assert.isTrue(produto.getNome().length() <= 100 ,"O nome do produto deve ter até 100 digitos") ;
        Produto produtoExistente = produtoRep.findByNome(produto.getNome());
        Assert.isTrue(produtoExistente == null || produtoExistente.equals(produto),"Nome já cadastrado!");


        Assert.isTrue(!produto.getCor().equals(""),"A cor do produto não pode ser nula");
        Assert.isTrue(produto.getNome().length() <= 15 ,"A cor do produto deve ter até 15 digitos") ;

        Assert.isTrue(!produto.getDescricao().equals(""),"A descricao do produto não pode ser nula");
        Assert.isTrue(produto.getDescricao().length() <= 500 ,"A descricao deve ter ate 500 caracteres") ;

        Assert.isTrue(produto.getImagem().length() <= 500 ,"A imagem deve ter ate 500 caracteres") ;


        Assert.isTrue(!produto.getPreco().equals(""),"O preco não pode ser nulo");

        Assert.isTrue(!produto.getPesoproduto().equals(""),"O peso não pode ser nulo");

        Assert.isTrue(!produto.getTamanho().equals(""),"O tamanho não pode ser nulo");
        Assert.isTrue(produto.getImagem().length() <= 4 ,"O tamanho pode ter ate 4 caracteres") ;











        this.produtoRep.save(produto);
    }
}
