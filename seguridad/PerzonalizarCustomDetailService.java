package com.pildoraslin.aurrera.seguridad;

import com.pildoraslin.aurrera.entidad.Rol;
import com.pildoraslin.aurrera.entidad.Usuario;
import com.pildoraslin.aurrera.repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PerzonalizarCustomDetailService implements UserDetailsService {

    @Autowired
    UsuarioRepositorio usuarioRepositorio;


    //AuthenticationProvider utiliza UserDetailsService que implementa la responsabilidad de gestión de usuarios .
    // Su principal responsabilidad es encontrar un usuario por su nombre de usuario desde el caché o el almacenamiento subyacente



    @Override
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {

        Usuario usuario = usuarioRepositorio.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail)
                .orElseThrow( () -> new UsernameNotFoundException("el usuario con username o email indicado no exixte: " + usernameOrEmail));



        return new User( usuario.getEmail(), usuario.getPassword(), mapearRoles(usuario.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapearRoles(Set<Rol> roles){
        return roles.stream().map(rol -> new SimpleGrantedAuthority(rol.getNombre())).collect(Collectors.toList());
    }
}
