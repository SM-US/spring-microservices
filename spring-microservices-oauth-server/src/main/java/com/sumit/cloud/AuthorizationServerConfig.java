package com.sumit.cloud;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

@Configuration
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

	@Autowired
	private AuthenticationManager authManager;

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints.authenticationManager(authManager);
	}

	

	//Below method commented to use another configure method for jdbc based store
	/*@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.inMemory().withClient("webapp").secret("websecret").authorizedGrantTypes("password")
				.scopes("read,write,trust");
	}*/
	
	
	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
		
		//Below we are specifying anyone can use this method by supplying a security expression permit all.
		//This will allow token to be delivered from token access point as well as token to be validate from this point.
		security.checkTokenAccess("permitAll()");
	}
	
	
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.jdbc(dataSource());
	}

	@Bean
	public TokenStore tokenStore(){
		return new JdbcTokenStore(dataSource());
	}

	
	@Bean
	public DataSource dataSource(){
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.hsqldb.jdbcDriver");
		dataSource.setUrl("jdbc:hsqldb:hsql://localhost/testdb");
		dataSource.setUsername("SA");
		dataSource.setPassword("");
		return dataSource;
	}

	

}
