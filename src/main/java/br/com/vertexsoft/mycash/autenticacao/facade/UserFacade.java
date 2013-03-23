package br.com.vertexsoft.mycash.autenticacao.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.vertexsoft.mycash.autenticacao.Usuario;
import br.com.vertexsoft.mycash.autenticacao.repository.UserRepository;

@Service
public class UserFacade {

	@Autowired
	private UserRepository userRepository;

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public Usuario register(Usuario user) {
		userRepository.save(user);
		return user;
	}

}