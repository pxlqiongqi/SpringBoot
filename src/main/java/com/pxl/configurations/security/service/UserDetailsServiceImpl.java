package com.pxl.configurations.security.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
@Component
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return new UserDetails() {
			
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isEnabled() {
				System.out.println("isEnabled");
				return true;
			}
			//密码是否过期
			@Override
			public boolean isCredentialsNonExpired() {
				System.out.println("isCredentialsNonExpired");
				return true;
			}
			//是否锁定
			@Override
			public boolean isAccountNonLocked() {
				System.out.println("isAccountNonLocked");
				return true;
			}
			//帐号是否过期
			@Override
			public boolean isAccountNonExpired() {
				System.out.println("isAccountNonExpired");
				return true;
			}
			
			@Override
			public String getUsername() {
				System.out.println("getUsername");
				return "name";
			}
			
			@Override
			public String getPassword() {
				System.out.println("getPassword");
				return passwordEncoder.encode("password");
			}
			
			@Override
			public Collection<? extends GrantedAuthority> getAuthorities() {
				System.out.println("getAuthorities");
				return AuthorityUtils.commaSeparatedStringToAuthorityList("admin");
			}
		};
	}

}
