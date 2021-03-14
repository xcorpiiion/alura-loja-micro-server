package br.com.study.ouath.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;

@Configuration
public class AuthorizationServerConfigurer extends AuthorizationServerConfigurerAdapter {

    @Getter
    @Autowired
    private AuthenticationManager authenticationManager;

    @Getter
    @Autowired
    private UserDetailsService detailsService;

    @Getter
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.authenticationManager(this.getAuthenticationManager()).userDetailsService(this.getDetailsService());
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                .withClient("loja")
                .secret(this.getPasswordEncoder().encode("lojapwd"))
                .authorizedGrantTypes("password")
                .scopes("web", "mobile");
    }
}
