package br.com.bliblioteca.entity;
//
//import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@Entity
//@Table(name="usuario")
//@ToString @Getter @Setter @NoArgsConstructor @AllArgsConstructor
//@Builder
//public class Usuario implements Serializable {//, UserDetails {
//	
//	private static final long serialVersionUID = 1L;
//	
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	private Integer id;
//	
//	@Column(name="username")
//	private String username;
//	
//	@Column(name="password")
//	private String password;
//	
//	@Transient
//	private List<String> role;
	
//	@Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>(); 		
//        for (String auth : this.role) { 			
//            grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_" + auth)); 		
//        }
//        return grantedAuthorities; 	 
//    }
//
//	@Override
//    public String getPassword() {
//        return this.password;
//    } 
//
//    @Override
//    public String getUsername() {
//        return this.username;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() { 
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true; 
//    }
//
//}
	