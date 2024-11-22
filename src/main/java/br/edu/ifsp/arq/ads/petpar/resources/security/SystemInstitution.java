package br.edu.ifsp.arq.ads.petpar.resources.security;

import br.edu.ifsp.arq.ads.petpar.domain.entity.InstitutionEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class SystemInstitution extends User {

	private static final long serialVersionUID = 1L;

	private InstitutionEntity institution;

	public SystemInstitution(InstitutionEntity institution, Collection<? extends GrantedAuthority> authorities) {
		super(institution.getEmail(), institution.getPassword(), authorities);
		this.institution = institution;
	}

	public InstitutionEntity getInstitution() {
		return institution;
	}
	
}
