package sample.spring.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import sample.spring.domain.User;
import sample.spring.repository.UserRepository;

@Service
public class LoginUserDetailsService implements UserDetailsService {
	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> optionalUser = userRepository.findByName(username);
		User user = optionalUser.orElseThrow(() -> new UsernameNotFoundException("該当のユーザは存在しません"));
		return new LoginUserDetails(user, this.getAuthorities(user));
	}
	
	private Collection<GrantedAuthority> getAuthorities(User user){
		return AuthorityUtils.createAuthorityList("ROLE_USER");
	}
}
