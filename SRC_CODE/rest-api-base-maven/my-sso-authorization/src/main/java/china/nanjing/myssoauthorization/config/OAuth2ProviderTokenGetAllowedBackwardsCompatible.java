//package china.nanjing.myssoauthorization.config;
//
//import org.springframework.beans.factory.InitializingBean;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.oauth2.provider.endpoint.FrameworkEndpointHandlerMapping;
//import org.springframework.security.oauth2.provider.endpoint.TokenEndpoint;
//
//import java.util.HashSet;
//
///**
// * @author Chen Hongyu
// */
//@Configuration
//public class OAuth2ProviderTokenGetAllowedBackwardsCompatible implements InitializingBean {
//
//    @Autowired
//    private TokenEndpoint tokenEndpoint;
//
//    @Override
//    public void afterPropertiesSet() {
//        tokenEndpoint.setAllowedRequestMethods(new HashSet<HttpMethod>() {{
//            add(HttpMethod.GET);
//            add(HttpMethod.POST);
//        }});
//    }
//
//    /**
//     * 修复Oauth2认证过程中Get Method not supported的奇怪问题
//     *
//     * @return FrameworkEndpointHandlerMapping
//     */
//    @Bean
//    public FrameworkEndpointHandlerMapping endpointHandlerMapping() {
//        return new FrameworkEndpointHandlerMapping();
//    }
//}

/*
 *
 *  不用JWT的话需要这个配置类
 *
 * */
