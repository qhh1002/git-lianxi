package com.jk.service;

import com.jk.model.TreeBean;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
@Component
public class OrderServiceError implements OrderServiceFeign {
    /*
        熔断器配置：
        1. 在跟service接口同级目录中创建熔断器类
        2. 熔断器类实现service接口（也就是带有FeignClient注解的接口）
        3. 在熔断器类上添加@Component注解，注入到spring容器中
        4. 消费者项目的配置文件中开启熔断器
            feign:
              hystrix:
                enabled: true
        5. 在service接口也就是带有FeignClient注解的接口上添加fallback属性指定熔断器类
            @FeignClient(value = "provider-user", fallback = UserServiceError.class)

        熔断器操作：
        1. 进入熔断器将用户传入得数据进行存储，存到redis或者mongodb中
            等服务器（生产者）恢复，然后进行数据恢复
        2. 消费者调用生产者的接口处所有的方法必须有返回值不管增删改查操作都得有
        3. 在消费者得controller中根据返回值判断，是正常返回得数据还是熔断器返回得数据
            如果是熔断器返回得数据，需要对返回得结果进行处理

     */
    public Map selectGoods(Integer page, Integer rows) {
        // 将数据记录mongodb或者redis
        // 等服务器恢复，将数据存储到数据库中
        System.out.println(page);
        System.out.println(rows);
        return null;
    }

    public List<TreeBean> findMyTree() {
        return null;
    }
}
