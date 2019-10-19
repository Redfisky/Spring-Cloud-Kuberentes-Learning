package china.nanjing.mychancellor.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

/**
 * @author Chen Hongyu
 */
// 不使用Zuul反向代理
//@FeignClient(value = "my-kingdom-client", url = "http://localhost:8300/my-kingdom")
// 使用Zuul反向代理
@FeignClient(value = "my-kingdom-client", url = "http://localhost:8202/my-kingdom/my-kingdom")
public interface FeignTestService {

    /**
     * 使用OpenFeign的客户端应用的测试接口
     *
     * @param firstParam 参数
     * @return 返回响应
     */
    @GetMapping(value = "/restful-test/{firstParam}", produces = "application/json")
    Object restfulClientTest(@PathVariable(value = "firstParam") String firstParam, @RequestHeader(value = "Authorization") String authorization);
}

/*
* OpenFeign 调用接口需要Oauth2 Token的解决方法
* https://stackoverflow.com/questions/35265585/trying-to-use-oauth2-token-with-feign-client-and-hystrix
* https://blog.arnoldgalovics.com/passing-headers-with-spring-cloud-feign/
* */