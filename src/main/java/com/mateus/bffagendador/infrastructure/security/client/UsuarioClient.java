package com.mateus.bffagendador.infrastructure.security.client;

import com.mateus.bffagendador.business.dto.EnderecoDTO;
import com.mateus.bffagendador.business.dto.TelefoneDTO;
import com.mateus.bffagendador.business.dto.UsuarioDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "usuario", url = "${usuario.url}")
public interface UsuarioClient {

    @GetMapping
    UsuarioDTO buscaUsuarioPorEmail(@RequestParam("email") String email,
                                    @RequestHeader("Authorization") String token);

    @PostMapping
    UsuarioDTO salvaUsuario(@RequestBody UsuarioDTO usuarioDTO);

    @PostMapping("/login")
    String login(@RequestBody UsuarioDTO  usuarioDTO);


   @DeleteMapping("/{email}")
   void deletaUsuarioPorEmail(@PathVariable("email") String email,
                              @RequestHeader("Authorization") String token);

   @PutMapping
   UsuarioDTO atualizaDadosUsuario(@RequestBody UsuarioDTO usuarioDTO,
                                   @RequestHeader("Authorization") String token);

   @PutMapping("/endereco")
   EnderecoDTO atualizaEndereco(@RequestBody EnderecoDTO enderecoDTO,
                                @RequestParam("id") Long id,
                                @RequestHeader("Authorization") String token);

   @PutMapping("/telefone")
   TelefoneDTO atualizaTelefone(@RequestBody TelefoneDTO telefoneDTO,
                                @RequestParam("id") Long id,
                                @RequestHeader("Authorization") String token);

   @PostMapping("/endereco")
   EnderecoDTO cadastraEndereco(@RequestBody EnderecoDTO enderecoDTO,
                                @RequestHeader("Authorization") String token);

   @PostMapping("/telefone")
   TelefoneDTO cadastraTelefone(@RequestBody TelefoneDTO telefoneDTO,
                                @RequestHeader("Authorization") String token);
}
