package com.zisu.springcloud.alibaba.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.zisu.springcloud.entities.CommonResult;

/**
 * @author lx
 * @create 2022/8/10 19:38
 */
public class CustomerBlockHandler {

    public static CommonResult handleException1(BlockException exception){
        return new CommonResult(4444,"自定义的限流处理信息......CustomerBlockHandler====111");
    }

    public static CommonResult handleException2(BlockException exception){
        return new CommonResult(4444,"自定义的限流处理信息......CustomerBlockHandler====222");
    }
}
