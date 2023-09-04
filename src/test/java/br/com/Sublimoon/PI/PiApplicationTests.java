package br.com.Sublimoon.PI;

import br.com.Sublimoon.PI.entity.Envio;
import br.com.Sublimoon.PI.entity.Pedido;
import br.com.Sublimoon.PI.entity.Produto;
import br.com.Sublimoon.PI.service.PedidoService;
import br.com.Sublimoon.PI.service.ProdutoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
class PiApplicationTests {

 	@Autowired
	private PedidoService pedidoService;
	 @Autowired
	 private ProdutoService produtoService;

	@Test
	public void testProduto(){
		Produto produto = new Produto();

		produto.setNome("ProdutoTeste");
		produto.setDescricao("Teste_De_Descricao");
		produto.setTamanho("300ml");

		Assert.isTrue(!produto.getNome().equals(""),"O nome do produto não pode ser nulo!");
		Assert.isTrue(!produto.getDescricao().equals(""),"A descricao do produto não pode ser nula");
		Assert.isTrue(!produto.getTamanho().equals(""),"O tamanho não pode ser nulo");
		Assert.isTrue(produto.getDescricao().length() <= 500 ,"A descricao deve ter ate 500 caracteres") ;
	}

	@Test
	public void testEnvio(){
		Envio envio = new Envio();
		envio.setFormaEnvio("SEDEX");

		Assert.isTrue(!envio.getFormaEnvio().equals(""),"Por favor, selecione uma forma de envio válida!!");
		Assert.isTrue(envio.getFormaEnvio().length() <= 30,"Forma de envio n pode passar de 30 caracteres");

	}
}
