package com.jk.controller;

import com.jk.model.TreeBean;
import com.jk.service.OrderServiceFeign;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
public class OrderController {
    @Resource
    private OrderServiceFeign orderServiceFeign;

    @RequestMapping("/selectGoods")
    @ResponseBody
    public Map selectGoods(Integer page, Integer rows, HttpServletResponse response) throws IOException {

        Map map =new HashMap();
        map=orderServiceFeign.selectGoods(page,rows);
        if (map==null){
            /* 设置格式为text/json */
            response.setContentType("text/json");
            /* 设置字符集为'UTF-8' */
            response.setCharacterEncoding("UTF-8");
            PrintWriter printWriter = response.getWriter();
            printWriter.write("网络异常！请稍后重试");
            printWriter.flush();
            printWriter.close();
        }
        return map;
    }

    @RequestMapping("/findMyTree")
    @ResponseBody
    public List<TreeBean> findMyTree(){
        return orderServiceFeign.findMyTree();
    }
}
