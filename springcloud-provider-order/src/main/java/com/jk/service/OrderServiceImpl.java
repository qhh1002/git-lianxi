package com.jk.service;

import com.jk.mapper.OrderMapper;
import com.jk.model.Goods;
import com.jk.model.Order;
import com.jk.model.TreeBean;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderMapper orderMapper;
    @Override
    public Map selectGoods(Integer page, Integer rows) {
        HashMap<String, Object> result = new HashMap<>();
        HashMap<String, Object> params = new HashMap<>();
        int count = orderMapper.findOrderListCount();
        result.put("total",count);
        params.put("start",(page-1)*rows);
        params.put("end",rows);
        List<Goods> goods = orderMapper.findOrderList(params);
        result.put("rows",goods);
        return result;
    }

    @Override
    public List<TreeBean> findMyTree() {
        Integer id =0;
        return treeNode(id);
    }

    private List<TreeBean> treeNode(Integer id) {
        List<TreeBean> trees = orderMapper.findTreeNodeList(id);
        for (TreeBean treeBean: trees) {
            Integer id2 = treeBean.getId();
            List<TreeBean> treeBeans = treeNode(id2);
            if (treeBeans != null && treeBeans.size()>0){
                treeBean.setNodes(treeBeans);
            }else{
                treeBean.setSelectable(true);
            }
        }
        return trees;
    }
}
