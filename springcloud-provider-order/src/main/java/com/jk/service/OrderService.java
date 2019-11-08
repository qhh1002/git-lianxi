package com.jk.service;

import com.jk.model.TreeBean;

import java.util.List;
import java.util.Map;

public interface OrderService {
    Map selectGoods(Integer page, Integer rows);

    List<TreeBean> findMyTree();
}
