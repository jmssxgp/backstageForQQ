package com.program.qq.Util;

import java.util.UUID;

/**
 * @author xgp
 * @version 1.0
 * @date 2019/11/21 15:11
 */
public class imageRename {

    public static String name(String preName){
        int index=preName.lastIndexOf(".");
        String suffix=preName.substring(index);//获取后缀名
        return UUID.randomUUID().toString().replace("-","")+suffix;
    }
}
