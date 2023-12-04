package br.com.sublimoon.pi.service;

import br.com.sublimoon.pi.config.JwtServiceGenerator;
import br.com.sublimoon.pi.dto.LoginDTO;
import br.com.sublimoon.pi.dto.UserDTO;
import br.com.sublimoon.pi.entity.User;
import br.com.sublimoon.pi.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;
    @Autowired
    private JwtServiceGenerator jwtService;
    @Autowired
    private AuthenticationManager authenticationManager;

    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity<String> postar(UserDTO userDTO){
        var user = new User();
        BeanUtils.copyProperties(userDTO, user);
        user.setRole("USER");

        this.repository.save(user);
        return ResponseEntity.ok("usuario cadastrado com sucesso!");


    }

    public UserDTO logar(LoginDTO loginDTO) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginDTO.getUsername(),
                        loginDTO.getPassword()
                )
        );
        User user = repository.findByUsername(loginDTO.getUsername()).orElseThrow();
        var jwtToken = jwtService.generateToken(user);

        return toUserDTO(user, jwtToken);
    }


    private UserDTO toUserDTO(User user, String token) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setRole(user.getRole());
        userDTO.setToken(token);
        userDTO.setUsername(user.getUsername());
        return userDTO;
    }

}