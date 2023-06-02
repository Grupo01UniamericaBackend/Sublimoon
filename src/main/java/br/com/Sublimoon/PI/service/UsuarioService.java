package br.com.Sublimoon.PI.service;

import br.com.Sublimoon.PI.entity.Usuario;
import br.com.Sublimoon.PI.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRep;

    @Transactional(rollbackFor = Exception.class)
    public void createUsuario(final Usuario usuario){

        Assert.isTrue(usuario.getId() != null, "Id não pode ser nulo");
        Optional<Usuario> usuarioExistente = usuarioRep.findById(usuario.getId());
        Assert.isTrue(usuarioExistente == null || usuarioExistente.equals(usuario.getId()), "Id já existente");

        Assert.isTrue(!usuario.getTelefone().equals(""), "Telefone não pode ser nulo");
        Usuario usuarioExistentee = usuarioRep.findByTelefone(usuario.getTelefone());
        Assert.isTrue(usuarioExistentee == null || usuarioExistentee.equals(usuario.getTelefone()), "Telefone já cadastrado");
        Assert.isTrue(usuario.getTelefone().length() <= 40, "Telefone deve ter até 40 caracteres");

        Assert.isTrue(!usuario.getEmail().equals(""), "E-mail não pode ser nulo");
        Usuario usuarioExistente2 = usuarioRep.findByEmail(usuario.getEmail());
        Assert.isTrue(usuarioExistente2 == null || usuarioExistente2.equals(usuario.getEmail()),"Email já cadastrado");
        Assert.isTrue(usuario.getEmail().length() <= 50, "E-mail deve ter até 50 caracteres");

    }



}
