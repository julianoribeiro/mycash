package br.com.vertexsoft.mycash.autenticacao.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import br.com.vertexsoft.mycash.autenticacao.Usuario;
import br.com.vertexsoft.mycash.repository.ListQueryDslPredicateExecutor;

public interface UserRepository extends JpaRepository<Usuario, Long>, ListQueryDslPredicateExecutor<Usuario> {

	public Usuario findByLogin(String login);
	
}
