package sample.spring.service;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

import sample.spring.domain.User;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class LoginUserDetails extends org.springframework.security.core.userdetails.User {
	private static final long serialVersionUID = 1L;
	private final User user;

	public LoginUserDetails(User user, Collection<GrantedAuthority> authorities) {
		super(user.getName(), user.getPass(), authorities);
		this.user = user;
	}

	public User getUser() {
		return user;
	}

	/*
	 * lombokを使わずに実装してみた
	 * 
	 * @Override
	 * public int hashCode() {
	 * 	return user.getName().hashCode();
	 * }
	 * 
	 * @Override
	 * public boolean equals(Object rhs) { 
	 * 	if (rhs instanceof User) {
	 * 		return user.getName().equals(((LoginUserDetails) rhs).user.getName()); }
	 * 		return false;
	 * }
	 * 
	 * @Override
	 * public String toString(){ 
	 * 	StringBuilder sb = new StringBuilder();
	 * 	sb.append("Username: ").append(this.user.getName()).append("; ");
	 * 	sb.append("Password: [PROTECTED]; ");
	 * 
	 * 	return sb.toString();
	 * }
	 */

}
