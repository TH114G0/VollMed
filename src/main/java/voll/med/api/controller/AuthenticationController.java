package voll.med.api.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import voll.med.api.domain.users.UserEntity;
import voll.med.api.dto.AuthenticationDataDTO;
import voll.med.api.infra.security.TokenService;

@RestController
@RequestMapping("/authentication")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity Login(@RequestBody @Valid AuthenticationDataDTO dataDTO) {
        var token = new UsernamePasswordAuthenticationToken(dataDTO.login(), dataDTO.password());
        var authentication = manager.authenticate(token);

        return ResponseEntity.ok(tokenService.generateToken((UserEntity) authentication.getPrincipal()));
    }
}
