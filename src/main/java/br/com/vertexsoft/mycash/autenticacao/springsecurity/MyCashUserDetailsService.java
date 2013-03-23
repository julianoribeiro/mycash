package br.com.vertexsoft.mycash.autenticacao.springsecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.vertexsoft.mycash.autenticacao.QUsuario;
import br.com.vertexsoft.mycash.autenticacao.Usuario;
import br.com.vertexsoft.mycash.autenticacao.repository.UserRepository;

@Service
public class MyCashUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Transactional(readOnly = true)
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		Usuario user = null;
		try {
			user = userRepository.findOne(QUsuario.usuario.login.eq(userName));
			if (user != null) {
				user.getAuthorities();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

}
