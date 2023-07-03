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
    private ProdutoRepository produtoRep;


    @Transactional(rollbackFor = Exception.class)
    public void cadastrar (final Produto produto){


        Assert.isTrue(!produto.getNome().equals(""),"O nome do produto não pode ser nulo!");
        Assert.isTrue(produto.getNome().length() <= 100 ,"O nome do produto deve ter até 100 digitos") ;


        Assert.isTrue(!produto.getCor().equals(""),"A cor do produto não pode ser nula");


        Assert.isTrue(!produto.getDescricao().equals(""),"A descricao do produto não pode ser nula");
        Assert.isTrue(produto.getDescricao().length() <= 500 ,"A descricao deve ter ate 500 caracteres") ;


        Assert.isTrue(produto.getPreco() != 0,"O preco não pode ser nulo");



        Assert.isTrue(!produto.getTamanho().equals(""),"O tamanho não pode ser nulo");



       /* if(produto.getCategorias()==null) {
            List<Categoria> attCategoria = new ArrayList<>(); // Cria uma nova lista caso ainda não exista
            attCategoria.add(categoriaRepository.getById(idCat));
            produto.setCategorias(attCategoria); // Define a lista no favorito
        }
        else {
            produto.getCategorias().add(categoriaRepository.getById(categoria.getId())); // Adiciona o produto à lista de produtos
        }*/

        this.produtoRep.save(produto);
    }

    @Transactional(rollbackFor = Exception.class)
    public void atualizaProduto (Produto produto){
        final Produto produtoAttService=this.produtoRep.findById(produto.getId()).orElse(null);
        produto.setCadastro(produtoAttService.getCadastro());

        this.produtoRep.save(produto);
    }

    @Transactional(rollbackFor = Exception.class)
    public void delete (Long id){
        this.produtoRep.deleteById(id);
    }

    @Transactional(rollbackFor = Exception.class)
    public void fav (Produto produto){

        produto.setAtivo(true);

        this.produtoRep.save(produto);
    }

}
