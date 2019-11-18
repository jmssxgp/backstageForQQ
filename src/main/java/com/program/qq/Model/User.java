package com.program.qq.Model;

import lombok.Data;

@Data
public class User {

    //qq返回唯一ID
    private String userId;

    //用户昵称
    private String nickname;

    //个人签名
    private String personalSign;

    //年龄
    private int age;

    //生日
    private String birthday;

    //是否认证
    private boolean isConfirm;

    //星座
    private String star;

    //学校
    private String school;

    //标签
    private String tag;

    //照片
    private String photos;

    public User(){

    }

    public User(String userId) {
        this.userId = userId;
    }
}
