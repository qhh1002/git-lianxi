package com.jk.model;


import lombok.Data;
import java.util.List;
    @Data
    public class TreeBean {

        private Integer id;
        private String text;
        private String path;
        private Integer pid;
        private List<TreeBean> nodes;
        private Boolean selectable;


}
