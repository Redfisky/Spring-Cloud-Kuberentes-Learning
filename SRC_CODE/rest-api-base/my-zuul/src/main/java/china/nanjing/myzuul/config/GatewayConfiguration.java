package china.nanjing.myzuul.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

/**
 * Zuul兼做Oauth2 SSO资源服务器的配置类
 *
 * @author Chen Hongyu
 */
@Configuration
@EnableResourceServer
public class GatewayConfiguration extends ResourceServerConfigurerAdapter {
    @Override
    public void configure(final HttpSecurity http) throws Exception {
        // 只允许访问"/my-sso-authorization/**"等, 也就是授权服务器的授权/Token接口。其余接口一律要验证
        http.csrf().disable().authorizeRequests()
                .antMatchers("/my-sso-authorization/**", "/my-sso-client/**")
                .permitAll()
                // TODO 本地调试图方便先放开以下微服务的验证，不然POSTMAN必须请求端口8203的Authorization Server经过Oauth2验证才可以访问接口,
                //  而且Feign还要配置Token(代码中已通过@RequestHeader配置)，待优化
                // ######本地开发暂时放开######
                .antMatchers("/my-chancellor/**", "/my-kingdom/**")
                .permitAll()
                // ######本地开发暂时放开######
                .antMatchers("/**")
                .authenticated();
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer config) {
        config.tokenServices(tokenServices());
    }

    @Bean
    public TokenStore tokenStore() {
        return new JwtTokenStore(accessTokenConverter());
    }

    @Bean
    public JwtAccessTokenConverter accessTokenConverter() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setSigningKey("my-jwt-signing-key");
        return converter;
    }

    @Bean
    @Primary
    public DefaultTokenServices tokenServices() {
        DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
        defaultTokenServices.setTokenStore(tokenStore());
        return defaultTokenServices;
    }

}
