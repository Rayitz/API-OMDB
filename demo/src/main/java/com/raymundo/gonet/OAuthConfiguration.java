package com.raymundo.gonet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.event.AbstractAuthenticationFailureEvent;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableAuthorizationServer
public class OAuthConfiguration extends AuthorizationServerConfigurerAdapter {

	private final PasswordEncoder passwordEncoder;

	private final UserDetailsService userService;

	public OAuthConfiguration(AuthenticationManager authenticationManager, PasswordEncoder passwordEncoder,
			UserDetailsService userService) {
		this.authenticationManager = authenticationManager;
		this.passwordEncoder = passwordEncoder;
		this.userService = userService;
	}

	@Autowired
	@Qualifier("authenticationManagerBean")
	private AuthenticationManager authenticationManager;
	@Autowired
	UserDetailsService userDetailsService;

	@Override
	public void configure(final AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
		oauthServer.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()");
	}

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		  BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//		  System.out.println("psw : "+encoder.encode("$2asecret"));
		clients.inMemory().withClient("gonetClientId").secret(encoder.encode("$2asecret"))
				.accessTokenValiditySeconds(7200)
				.authorizedGrantTypes("password", "authorization_code", "refresh_token").scopes("read", "write", "trust")
				.autoApprove(true);
	}

	@Override
	public void configure(final AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints.tokenStore(tokenStore()).authenticationManager(authenticationManager)
				.accessTokenConverter(defaultAccessTokenConverter()).userDetailsService(userDetailsService);
	}

	@Bean
	public TokenStore tokenStore() {
		return new JwtTokenStore(defaultAccessTokenConverter());
	}

	@Bean
	public JwtAccessTokenConverter defaultAccessTokenConverter() {
		JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
//	    converter.setSigningKey("123");
		return converter;
	}

	@EventListener
	public void authSuccessEventListener(AuthenticationSuccessEvent authorizedEvent) {
		// write custom code here for login success audit
		System.out.println("User Oauth2 login success");
		System.out.println("This is success event : " + authorizedEvent.getAuthentication().getPrincipal());
	}

	@EventListener
	public void authFailedEventListener(AbstractAuthenticationFailureEvent oAuth2AuthenticationFailureEvent) {
		// write custom code here login failed audit.
		System.out.println("User Oauth2 login Failed");
		System.out.println(oAuth2AuthenticationFailureEvent.getAuthentication().getPrincipal());
	}

}
