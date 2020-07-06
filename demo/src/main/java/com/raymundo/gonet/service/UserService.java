package com.raymundo.gonet.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.authentication.AnonymousAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.raymundo.gonet.api.UserRepository;
import com.raymundo.gonet.model.RaymundoGonetOmbdUser;

@Service
public class UserService implements UserDetailsService{

	
	@Autowired
	private UserRepository rUser;
    
    @SuppressWarnings("unused")
    @Override
	public UserDetails loadUserByUsername(String idUser) {
    	Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
    	RaymundoGonetOmbdUser user = rUser.findByUsername(idUser);
    	 System.out.println("psw : "+user.getPassword());
        if (user == null) {
            throw new UsernameNotFoundException(idUser);
        }
        return new User(user.getUsername(),user.getPassword(),authorities);
    	
	}

    
    
}


  
