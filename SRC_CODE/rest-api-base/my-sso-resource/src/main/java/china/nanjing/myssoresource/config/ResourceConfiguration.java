package china.nanjing.myssoresource.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

/**
 * @author Chen Hongyu
 */
@Configuration
@EnableWebSecurity
public class ResourceConfiguration extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(final HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
                .antMatchers("/auth/**", "/my-sso-authorization/**")
                .permitAll()
                .antMatchers("/**")
                .authenticated();
    }

}

/*
 *
 * 使用Zuul当作Resource Server后就不用在每个真正的资源服务器配置一遍Spring Security Oauth2 ResourceServerConfigurerAdapter 了
 * 但是通过Zuul反向代理请求Authorization Server的Token是不行的，必须直接去Authorization Server请求。目前主要是为了方便开发这样编写。
 * 另一种可能的解决方案是，Authorization Server及其相关服务（例如Client,UserDetails相关数据库操作）另外由一个或Zuul集群反向代理，和Zuul反向代理&业务应用API隔离开
 * 其实就是懒得每个微服务里配一遍Resource Server的代码……单独封装应该也可以。
 *
 * */
