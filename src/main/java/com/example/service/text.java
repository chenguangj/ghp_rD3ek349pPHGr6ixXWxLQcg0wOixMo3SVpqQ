package com.example.service;

import cn.hutool.core.util.ObjectUtil;

public class text {
    public static void main(String[] args) {
        String str = "&1&2&31&52";
        String[] split = str.split("&");
        for (String s : split) {
            if (ObjectUtil.isEmpty(s)) {
                continue;
            }
            System.out.println(s);
        }
    }
}
