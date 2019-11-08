package com.jk.controller;

import com.jk.model.TreeBean;
import com.jk.service.OrderService;
import com.jk.service.OrderServiceFeign;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
public class OrderController implements OrderServiceFeign {
    @Resource
    private OrderService orderService;

    @GetMapping("/selectGoods")
    @Override
    public Map selectGoods(@RequestParam("page")Integer page,@RequestParam("rows")Integer rows) {
        return orderService.selectGoods(page,rows) ;
    }
    @GetMapping("/findMyTree")
    @Override
    public List<TreeBean> findMyTree(){
        return orderService.findMyTree();
    }
}
