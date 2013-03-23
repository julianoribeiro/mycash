package br.com.vertexsoft.mycash.autenticacao;

import static com.google.common.base.Preconditions.checkArgument;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Version;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.joda.time.DateTimeUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.google.common.base.Objects;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSet.Builder;

@Entity
public class Usuario implements UserDetails, Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;

	@Version
	Integer version;

	private String login;

	private String senha;

	@Type(type = "dateTime")
	private DateTime criado = new DateTime(DateTimeUtils.currentTimeMillis());

	Usuario() {
	}

	private Usuario(String login) {
		setLogin(login);
	}

	public static Usuario newUser() {
		return new Usuario();
	}

	public static Usuario newUser(String login) {
		checkArgument(!Strings.isNullOrEmpty(login));
		return new Usuario(login);
	}

	public Long getId() {
		return id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public DateTime getCriado() {
		return criado;
	}

	public void setCriado(DateTime criado) {
		this.criado = criado;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(this.login);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Usuario) {
			Usuario other = (Usuario) obj;
			return Objects.equal(this.login, other.login);
		}
		return false;
	}

	@Override
	public String toString() {
		return Objects.toStringHelper(this).add("id", id).add("login", login).toString();
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Builder<Permissao> builder = ImmutableSet.builder();
		builder.add(Permissao.ROLE_USER);
		return builder.build();
	}

	@Override
	public String getUsername() {
		return login;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public String getPassword() {
		return getSenha();
	}

}