package com.jk.mapper;

import com.jk.model.Goods;
import com.jk.model.Order;
import com.jk.model.TreeBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.HashMap;
import java.util.List;
@Mapper
public interface OrderMapper {
    int findOrderListCount();

    List<Goods> findOrderList(HashMap<String, Object> params);

    List<TreeBean> findTreeNodeList(Integer id);
}
