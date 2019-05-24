package com.aak.configuration;

import com.aak.domain.Credentials;
import com.aak.repository.CredentialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Created by ahmed on 21.5.18.
 */
public class JdbcUserDetails implements UserDetailsService{

    @Autowired
    private CredentialRepository credentialRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("loadUserByUsername(String username)");
        System.out.println("User Name, " + username);
        Credentials credentials = credentialRepository.findByName(username);
        if(credentials==null){

            throw new UsernameNotFoundException("User"+username+"can not be found");
        }
        System.out.println("credentials name : " + credentials.getName());
        System.out.println("credentials password : " + credentials.getPassword());
        System.out.println("credentials.isEnabled() : " + credentials.isEnabled());
        User user = new User(credentials.getName(),credentials.getPassword(),credentials.isEnabled(),true,true,true,credentials.getAuthorities());

        return  user;


    }
}
