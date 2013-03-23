package br.com.vertexsoft.mycash.autenticacao;

import org.springframework.security.core.GrantedAuthority;

public enum Permissao implements GrantedAuthority {

	ROLE_USER,
	ROLE_ADMIN;

	@Override
	public String getAuthority() {
		return name();
	}
	
}