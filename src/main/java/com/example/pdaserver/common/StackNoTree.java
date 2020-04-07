package com.example.pdaserver.common;

import java.util.List;

/**
 * @program: pdaserver
 * @description: 板号节点树
 * @author: 唐庆阳
 * @create: 2020-04-07 21:46
 **/
public class StackNoTree {
    private String label;//板号
    private List<StackNoTree> Chirden;//产品id列表

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<StackNoTree> getChirden() {
        return Chirden;
    }

    public void setChirden(List<StackNoTree> chirden) {
        Chirden = chirden;
    }
}
