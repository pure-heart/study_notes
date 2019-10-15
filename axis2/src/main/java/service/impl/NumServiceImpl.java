package service.impl;

import service.NumService;

/**
 * @Auther:JHLY
 * @Date:2019/10/15
 * @Description:service
 * @Version:1.0
 */
public class NumServiceImpl implements NumService {
    @Override
    public String addTwo(int a, int b) {
        return "两数之和是"+a+b;
    }
}
