package br.com.sublimoon.pi;

import br.com.sublimoon.pi.entity.Envio;
import br.com.sublimoon.pi.entity.Produto;
import br.com.sublimoon.pi.service.PedidoService;
import br.com.sublimoon.pi.service.ProdutoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;
import org.junit.jupiter.api.Assertions;


@SpringBootTest
class PiApplicationTests {

 	@Autowired
	private PedidoService pedidoService;
	 @Autowired
	 private ProdutoService produtoService;

	@Test
	void testProduto(){
		Produto produto = new Produto();

		produto.setNome("ProdutoTeste");
		produto.setDescricao("Teste_De_Descricao");
		produto.setTamanho("300ml");

		Assertions.assertFalse(produto.getNome().equals(""), "O nome do produto não pode ser nulo!");
		Assert.isTrue(!produto.getDescricao().equals(""),"A descricao do produto não pode ser nula");
		Assert.isTrue(!produto.getTamanho().equals(""),"O tamanho não pode ser nulo");
		Assert.isTrue(produto.getDescricao().length() <= 500 ,"A descricao deve ter ate 500 caracteres") ;
	}

	@Test
	void testEnvio(){
		Envio envio = new Envio();
		envio.setFormaEnvio("SEDEX");

		Assertions.assertFalse(envio.getFormaEnvio().equals(""), "Por favor, selecione uma forma de envio válida!!");
		Assert.isTrue(envio.getFormaEnvio().length() <= 30,"Forma de envio n pode passar de 30 caracteres");

	}
}
