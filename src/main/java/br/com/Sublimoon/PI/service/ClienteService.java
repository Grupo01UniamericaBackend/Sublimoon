package br.com.Sublimoon.PI.service;

import br.com.Sublimoon.PI.entity.Cliente;
import br.com.Sublimoon.PI.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Transactional(rollbackFor = Exception.class)
    public void VerificarCliente (final Cliente cliente){


        Assert.isTrue(!cliente.getNome().equals(""),"O nome não pode nulo!");
        Assert.isTrue(cliente.getNome().length() <= 45 ,"O nome deve ter no máximo 45 digitos") ;

        Assert.isTrue(!cliente.getSenha().equals(""),"A senha não pode ser nula!");
        Assert.isTrue(cliente.getNome().length() <= 40 ,"A senha deve ter até 40 digitos") ;

        Assert.isTrue(!cliente.getCpf().equals(""),"O cpf não pode ser nulo!");
        Assert.isTrue(cliente.getCpf().length() <= 20 ,"O cpf deve ter no máximo 20 dígitos") ;




        //Assert.isTrue(!cliente.getFavorito().equals(""),"O campo favoritos não pode nulo!");

       // Assert.isTrue(!cliente.getCarrinho().equals(""),"O campo carrinho não pode nulo!");

        //Assert.isTrue(!cliente.getId().equals(""),"O campo ID não pode nulo!");

        Assert.isTrue(cliente.getTelefone().substring(0,11).matches("[0-9]*"),"Telefone deve conter apenas números!");
        Assert.isTrue(!cliente.getTelefone().equals(""),"O telefone não pode ser nulo!");
        Assert.isTrue(cliente.getTelefone().length() == 11 ,"O numero deve ter 11 digitos, contando o DDD") ;

        Assert.isTrue(!cliente.getEmail().equals(""),"O email não pode ser nulo!");
        Assert.isTrue(cliente.getEmail().length() <= 50 ,"O email deve ter no maximo 50 caracteres") ;

        this.clienteRepository.save(cliente);

    }

}
