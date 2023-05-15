package br.com.Sublimoon.PI.service;



import br.com.Sublimoon.PI.entity.Cliente;
import br.com.Sublimoon.PI.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRep;

    @Autowired

    @Transactional(rollbackFor = Exception.class)


    public void VerificarCliente (final Cliente cliente){
        Assert.isTrue(!cliente.getNome().equals(""),"O nome não pode nulo!");
        Assert.isTrue(cliente.getNome().length() <= 45 ,"O nome deve ter no máximo 45 digitos") ;

        Assert.isTrue(!cliente.getSenha().equals(""),"A senha não pode ser nula!");
        Assert.isTrue(cliente.getNome().length() <= 40 ,"A senha deve ter até 40 digitos") ;



        Assert.isTrue(!cliente.getCpf().equals(""),"O cpf não pode ser nulo!");
        Assert.isTrue(cliente.getCpf().length() <= 20 ,"O cpf deve ter no máximo 20 dígitos") ;
        Cliente cpfExistente = ClienteRepository.findByCpf(cliente.getCpf());
        Assert.isTrue(cpfExistente == null || cpfExistente.equals(cliente),"Cliente já cadastrado!");


        Assert.isTrue(!cliente.getFavoritos().equals(""),"O campo favoritos não pode nulo!");

        Assert.isTrue(!cliente.getCarrinho().equals(""),"O campo carrinho não pode nulo!");

        Assert.isTrue(!cliente.getId().equals(""),"O campo ID não pode nulo!");



        this.clienteRep.save(cliente);
    }

}
