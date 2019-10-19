package china.nanjing.mychancellor.controller;

import china.nanjing.mychancellor.service.FeignTestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Chen Hongyu
 */
@RestController
@Slf4j
public class TestController {

    @Autowired
    private FeignTestService feignTestService;

    /**
     * 提供POSTMAN使用的测试接口，可以通过OpenFeign调用REST API服务接口
     *
     * @param firstParam 参数
     * @return 返回响应
     */
    @GetMapping(value = "/client-test/{firstParam}")
    public Object clientTest(@PathVariable(value = "firstParam") String firstParam, @RequestHeader(value = "Authorization") String authorization) {
        return feignTestService.restfulClientTest(firstParam, authorization);
    }

}
