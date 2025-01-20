package br.edu.ifsp.arq.ads.petpar.resources.security;

import br.edu.ifsp.arq.ads.petpar.domain.entity.InstitutionEntity;
import br.edu.ifsp.arq.ads.petpar.domain.entity.UserEntity;
import br.edu.ifsp.arq.ads.petpar.domain.repository.InstitutionRepository;
import br.edu.ifsp.arq.ads.petpar.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class AppUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private InstitutionRepository institutionEntity;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<UserEntity> userOptional = userRepository.findByEmail(email);
		//UserEntity user = userOptional.orElseThrow(() -> new UsernameNotFoundException("Usuário e/ou senha incorretos"));
		if(userOptional.isPresent()){
			return new SystemUser(userOptional.get(), getUserPermissions(userOptional.get()));
		}else{
			Optional<InstitutionEntity> institutionOptional = institutionEntity.findByEmail(email);
			InstitutionEntity institution = institutionOptional.orElseThrow(() -> new UsernameNotFoundException("Usuário e/ou senha incorretos"));
			return new SystemInstitution(institution, getInstitutionPermissions(institution));
		}

	}

	private Collection<? extends GrantedAuthority> getUserPermissions(UserEntity user) {
		Set<SimpleGrantedAuthority> authorities = new HashSet<>();
		user.getPermissions().forEach(p -> authorities.add(
				new SimpleGrantedAuthority(p.getDescription().toUpperCase())));
		return authorities;
	}

	private Collection<? extends GrantedAuthority> getInstitutionPermissions(InstitutionEntity user) {
		Set<SimpleGrantedAuthority> authorities = new HashSet<>();
		user.getPermissions().forEach(p -> authorities.add(
				new SimpleGrantedAuthority(p.getDescription().toUpperCase())));
		return authorities;
	}

}