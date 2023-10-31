package com.jujubaprojects.school.Repository;

import com.jujubaprojects.school.Model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {

   UserDetails findByLogin(String login);
}
