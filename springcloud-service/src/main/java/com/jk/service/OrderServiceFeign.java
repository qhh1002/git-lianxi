package com.jk.service;

import com.jk.model.TreeBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@FeignClient(value="provider-order",fallback = OrderServiceError.class)
public interface OrderServiceFeign {

    // 请求注解：
    // GetMapping  get方式请求  查询
    // PostMapping  post方式请求 新增
    // DeleteMapping delete方式请求 删除
    // PutMapping  put请求  修改

    // 参数注解：
    // RequestParam 传入一个或多个不同类型的参数 例： http://localhost:8080/test?userName=李伊龙
    // PathVariable 通过地址栏中/传入参数，通过此注解指定别名来接受参数
    //              例：传参：http://localhost:8080/test/liyilong/28
    //              例如：mapping映射路径 GetMapping("/test/{userName}/{userAge}")
    // RequestBody 用于接受一个实体类对象，传输一个对象的数据需要添加此注解
    /* SpringQueryMaq 用于接受一个实体类对象，传输一个对象的数据需要添加此注解
     例：@GetMapping("/findUserList")
        List<User> findUserList(@SpringQueryMap User user);*/


    @GetMapping("/selectGoods")
    Map selectGoods(@RequestParam("page") Integer page, @RequestParam("rows") Integer rows);

    @GetMapping("/findMyTree")
    List<TreeBean> findMyTree();
}
