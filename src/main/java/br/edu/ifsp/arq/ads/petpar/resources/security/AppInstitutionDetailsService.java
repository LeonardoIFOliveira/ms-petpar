package br.edu.ifsp.arq.ads.petpar.resources.security;

import br.edu.ifsp.arq.ads.petpar.domain.entity.InstitutionEntity;
import br.edu.ifsp.arq.ads.petpar.domain.repository.InstitutionRepository;
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
public class AppInstitutionDetailsService implements UserDetailsService {

	@Autowired
	private InstitutionRepository institutionRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<InstitutionEntity> userOptional = institutionRepository.findByEmail(email);
        InstitutionEntity institution = userOptional.orElseThrow(() -> new UsernameNotFoundException("Usuário e/ou senha incorretos"));
		return new SystemInstitution(institution, getPermissions(institution));
	}

	private Collection<? extends GrantedAuthority> getPermissions(InstitutionEntity institution) {
		Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        institution.getPermissions().forEach(p -> authorities.add(
				new SimpleGrantedAuthority(p.getDescription().toUpperCase())));
		return authorities;
	}

}