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

    //性别
    private int gender;

    //学历
    private String eduBackground;

    //生日
    private String birthday;

    //是否认证
    private int isConfirm;

    //星座
    private String star;

    //学校
    private String school;

    //标签
    private String tag;

    //照片
    private String photos;

    //头像
    private String avatarUrl;

    public User(){

    }

    public User(String userId) {
        this.userId = userId;
        this.nickname = "初始昵称";
        this.age = 0;
        this.eduBackground ="";
        this.isConfirm = 0;
        this.photos = "";
        this.tag = "";
        this.photos = "";
        this.gender = 0;
        this.personalSign = "";
        this.star = "";
        this.birthday = "";
        this.school ="";
        this.avatarUrl="";
    }
}
