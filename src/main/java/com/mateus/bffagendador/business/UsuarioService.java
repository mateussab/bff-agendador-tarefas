package com.mateus.bffagendador.business;

import com.mateus.bffagendador.business.dto.in.EnderecoDTORequest;
import com.mateus.bffagendador.business.dto.in.LoginRequestDTO;
import com.mateus.bffagendador.business.dto.in.TelefoneDTORequest;
import com.mateus.bffagendador.business.dto.in.UsuarioDTORequest;
import com.mateus.bffagendador.business.dto.out.EnderecoDTOResponse;
import com.mateus.bffagendador.business.dto.out.TelefoneDTOResponse;
import com.mateus.bffagendador.business.dto.out.UsuarioDTOResponse;
import com.mateus.bffagendador.infrastructure.security.client.UsuarioClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioClient usuarioClient;

    public UsuarioDTOResponse salvaUsuario(UsuarioDTORequest usuarioDTO) {
        return usuarioClient.salvaUsuario(usuarioDTO);
    }

    public String loginUsuario(LoginRequestDTO usuarioDTO) {
        return usuarioClient.login(usuarioDTO);
    }

    public UsuarioDTOResponse buscarUsuarioPorEmail(String email, String token){
        return usuarioClient.buscaUsuarioPorEmail(email, token);
    }

    public void deletarUsuarioPorEmail(String email, String token){
        usuarioClient.deletaUsuarioPorEmail(email, token);
    }

    public UsuarioDTOResponse atualizaDadosUsuario(String token, UsuarioDTORequest usuarioDTO){
        return usuarioClient.atualizaDadosUsuario(usuarioDTO, token);
    }

    public EnderecoDTOResponse atualizaEndereco (Long idEndereco, EnderecoDTORequest enderecoDTO, String token){
        return usuarioClient.atualizaEndereco(enderecoDTO, idEndereco, token);
    }

    public TelefoneDTOResponse atualizaTelefone (Long idTelefone, TelefoneDTORequest telefoneDTO, String token){
        return usuarioClient.atualizaTelefone(telefoneDTO, idTelefone, token);
    }

    public EnderecoDTOResponse cadastraEndereco (String token, EnderecoDTORequest enderecoDTO){
        return usuarioClient.cadastraEndereco(enderecoDTO, token);
    }

    public TelefoneDTOResponse cadastraTelefone (String token, TelefoneDTORequest telefoneDTO){
        return usuarioClient.cadastraTelefone(telefoneDTO, token);
    }

}
