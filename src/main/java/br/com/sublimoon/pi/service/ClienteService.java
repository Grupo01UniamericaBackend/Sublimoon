package br.com.sublimoon.pi.service;

import br.com.sublimoon.pi.DTO.ClienteDTO;
import br.com.sublimoon.pi.entity.Cliente;
import br.com.sublimoon.pi.repository.ClienteRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;


@Service
public class ClienteService {

    @Autowired
    final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Transactional(rollbackFor = Exception.class)
    public void VerificarCliente (final @NotNull ClienteDTO cliente){


        var clienteNovo = new Cliente();
        BeanUtils.copyProperties(cliente, clienteNovo);

        Assert.isTrue(clienteNovo.getNome().length() <= 45 ,"O nome deve ter no máximo 45 digitos") ;

        Assert.isTrue(!clienteNovo.getNome().equals(""),"O nome não pode nulo!");

        Assert.isTrue(!clienteNovo.getSenha().equals(""),"A senha não pode ser nula!");
        Assert.isTrue(clienteNovo.getNome().length() <= 40 ,"A senha deve ter até 40 digitos") ;

        Assert.isTrue(!clienteNovo.getCpf().equals(""),"O cpf não pode ser nulo!");
        Assert.isTrue(clienteNovo.getCpf().length() <= 20 ,"O cpf deve ter no máximo 20 dígitos") ;


       // Cliente cpfExistente = clienteRepository.findByCpf(cliente.getCpf());
        //Assert.isTrue(cpfExistente == null || cpfExistente.equals(cliente),"Cliente já cadastrado!");
        //Cliente telefoneExistente = clienteRepository.findByTelefone(cliente.getTelefone());
        //Assert.isTrue(telefoneExistente == null || telefoneExistente.equals(cliente),"Telefone já cadastrado!");
        //Cliente emailExistente = clienteRepository.findByEmail(cliente.getEmail());
        //Assert.isTrue(emailExistente == null || emailExistente.equals(cliente),"Email já cadastrado!")


        Assert.isTrue(clienteNovo.getTelefone().substring(0,11).matches("[0-9]*"),"Telefone deve conter apenas números!");
        Assert.isTrue(!clienteNovo.getTelefone().equals(""),"O telefone não pode ser nulo!");
        Assert.isTrue(clienteNovo.getTelefone().length() == 11 ,"O numero deve ter 11 digitos, contando o DDD") ;

        Assert.isTrue(!clienteNovo.getEmail().equals(""),"O email não pode ser nulo!");
        Assert.isTrue(clienteNovo.getEmail().length() <= 50 ,"O email deve ter no maximo 50 caracteres") ;

        this.clienteRepository.save(clienteNovo);

    }

    @Transactional(rollbackFor = Exception.class)
    public void delete (Long id ){

        this.clienteRepository.deleteById(id);


    }

}
