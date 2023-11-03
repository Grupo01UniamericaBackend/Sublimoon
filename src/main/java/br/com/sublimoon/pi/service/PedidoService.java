package br.com.sublimoon.pi.service;
import br.com.sublimoon.pi.dto.PedidoDTO;
import br.com.sublimoon.pi.entity.Carrinho;
import br.com.sublimoon.pi.entity.Envio;
import br.com.sublimoon.pi.entity.Pedido;
import br.com.sublimoon.pi.repository.CarrinhoRepository;
import br.com.sublimoon.pi.repository.EnvioRepository;
import br.com.sublimoon.pi.repository.PedidoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRep;
    @Autowired
    private CarrinhoRepository carrinhoRepository;
    @Autowired
    private EnvioRepository envioRepository;


    @Transactional(rollbackFor = Exception.class)
    public Pedido verificarPedido(final PedidoDTO pedidoDTO){

        var pedido = new Pedido();
        BeanUtils.copyProperties(pedidoDTO,pedido);

        Assert.isTrue(!pedido.getPagamento().equals(""),"Pagamento nao pode ser nulo!!");
        Assert.isTrue(!pedido.getEndereco().equals(""),"O Endereço n pode ser nulo!!");
        Assert.isTrue(pedido.getEndereco().length() <= 60, "Endereço nao pode passar de 60 caracteres!!");
        Assert.isTrue(!pedido.getCep().equals(""),"CEP não pode ser nulo");
        Assert.isTrue(pedido.getCep().length() <= 25,"Cep n pode passar de 25 caracteres!!");

        Carrinho carrinho =  carrinhoRepository.getReferenceById(pedido.getCarrinho().getId());
        Envio envio = envioRepository.getReferenceById(pedido.getEnvio().getId());
        float total1 = envio.getValorFrete();

        float total2 = carrinho.getSubTotal();

        pedido.setTotal(total1 + total2);

        return pedidoRep.save(pedido);
    }

    @Transactional(rollbackFor = Exception.class)
    public void editarpedido(final Pedido pedido){


        Assert.isTrue(!pedido.getPagamento().equals(""),"Pagamento nao pode ser nulo!!");
        Assert.isTrue(!pedido.getEndereco().equals(""),"O Endereço n pode ser nulo!!");
        Assert.isTrue(pedido.getEndereco().length() <= 60, "Endereço nao pode passar de 60 caracteres!!");
        Assert.isTrue(!pedido.getCep().equals(""),"CEP não pode ser nulo");
        Assert.isTrue(pedido.getCep().length() <= 25,"Cep n pode passar de 25 caracteres!!");

        Carrinho carrinho =  carrinhoRepository.getReferenceById(pedido.getCarrinho().getId());
        Envio envio = envioRepository.getReferenceById(pedido.getEnvio().getId());
        float total1 = envio.getValorFrete();

        float total2 = carrinho.getSubTotal();

        pedido.setTotal(total1 + total2);

        this.pedidoRep.save(pedido);
    }

    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id){

        this.pedidoRep.deleteById(id);
    }

}