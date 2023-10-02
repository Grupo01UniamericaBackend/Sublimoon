package br.com.sublimoon.pi.dto;

import br.com.sublimoon.pi.entity.Cliente;
import br.com.sublimoon.pi.entity.Produto;
import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class FavoritoDTOTest {

    private List<Produto> produtoList = new ArrayList<>();
    private Cliente cliente = new Cliente();
    FavoritoDTO favoritoDTO = new FavoritoDTO(produtoList,cliente);

    @Test
    void getProdutos() {
        List<Produto> produtos = new ArrayList<>();
        Assertions.assertEquals(produtos,produtoList);
    }


    @Test
    void setProdutos() {
        List<Produto> produtos = new ArrayList<>();
        favoritoDTO.setProdutos(produtos);
        Assertions.assertEquals(produtos,produtoList);
    }


    @Test
    void testEquals() {
        FavoritoDTO favoritoDTO1 = new FavoritoDTO(produtoList,cliente);
        Assertions.assertEquals(favoritoDTO1,favoritoDTO);
    }

    @Test
    void canEqual() {
        FavoritoDTO favoritoDTO1 = new FavoritoDTO(produtoList,cliente);
        Assertions.assertTrue(favoritoDTO.canEqual(favoritoDTO1));
    }

    @Test
    void testHashCode() {
        FavoritoDTO favoritoDTO1 = new FavoritoDTO(produtoList,cliente);
        Assertions.assertEquals(favoritoDTO1.hashCode(),favoritoDTO.hashCode());
    }

    @Test
    void testToString() {
        FavoritoDTO favoritoDTO1 = new FavoritoDTO(produtoList,cliente);

        Assertions.assertEquals(favoritoDTO1.toString(),favoritoDTO.toString());
    }
}