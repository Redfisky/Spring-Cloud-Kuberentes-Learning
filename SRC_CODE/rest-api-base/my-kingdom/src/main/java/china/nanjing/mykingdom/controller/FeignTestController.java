package china.nanjing.mykingdom.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * RESTFUL API TEST INTERFACES
 *
 * @author Chen Hongyu
 */
@RestController
public class FeignTestController {

    /**
     * 提供给前台客户端或SDK使用的测试接口
     *
     * @param firstParam 参数
     * @return 返回响应
     */
    @GetMapping("/restful-test/{firstParam}")
    public Object restfulTest(@PathVariable(value = "firstParam") String firstParam, @RequestHeader(value = "Authorization") String authorization) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("ABC", firstParam);
        hashMap.put("Authorization", authorization);
        return hashMap;
    }


}
