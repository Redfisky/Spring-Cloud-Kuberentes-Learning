//package china.nanjing.myssoresource.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
//
///**
// * @author Chen Hongyu
// */
//@Configuration
//@EnableWebSecurity
//public class ResourceConfiguration extends ResourceServerConfigurerAdapter {
//
//    @Override
//    public void configure(final HttpSecurity http) throws Exception {
//        http.csrf().disable().authorizeRequests()
//                .antMatchers("/auth/**","my-sso-authorization")
//                .permitAll()
//                .antMatchers("/**")
//                .authenticated();
//    }
//
//}

/*
 *
 * 使用Zuul当作Resource Server后就不用在每个真正的资源服务器配置一遍Spring Security Oauth2 ResourceServerConfigurerAdapter 了
 *
 * */
