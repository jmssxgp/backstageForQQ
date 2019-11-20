package com.program.qq.Controller;

import com.program.qq.Model.User;
import com.program.qq.Service.userService;
import com.program.qq.Util.getOpenIdUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author xgp
 * @version 1.0
 * @date 2019/11/19 12:14
 */
@RestController
public class userController {
    @Autowired
    userService userService;

    /**
     * 由前端返回用户code，调用util访问qq服务器获取唯一id，添加用户至用户表
     * @param code
     * @return
     */
    @GetMapping("/addOrGetUser")
    public User addOrGetUser(@RequestParam String code){
        //拼接url，获取openId
        String userId = getOpenIdUtil.getOpenId(code);
        //检查是否已注册
        userId = userId.substring(4, userId.length()-4);
        User user = userService.getUserById(userId);
        if (user==null){
            user = new User(userId);
            userService.addUser(user);
            return new User(userId);
        }else {
            return user;
        }
    }

    /**
     * 登录后必填信息，仅可修改一次。
     * @param userId
     * @param school
     * @param gender
     * @param eduBackground
     * @return
     */
    @PostMapping("/updateImportantInfo")
    public String updateImportantInfo(@RequestParam String userId, @RequestParam String school, @RequestParam String gender, @RequestParam String eduBackground){
        try {
            userService.updateImportantInfo(userId, school, gender, eduBackground);
        }catch (Exception e){
            return "failed";
        }
        return "success";
    }

    /**
     * 更新可修改的基本信息，在用户点击返回时前端传回调用
     * @param user
     * @return
     */
    @PostMapping("/updateBasicInfo")
    public String updateBasicInfo(@RequestBody User user){
        try {
            userService.updateBasicInfoById(user);
        }catch (Exception e){
            return "failed";
        }
        return "success";
    }

    /**
     * 更改用户标签列表，用","分隔标签，返回为一条字符串，当用户修改了标签，返回调用
     * @param userId
     * @param tag
     * @return
     */
    @PostMapping("/updateTagById")
    public String updateTagById(@RequestParam String userId, @RequestParam String tag){
        try {
            userService.updateTagById(userId, tag);
        }catch (Exception e){
            return "failed";
        }
        return "success";
    }

    /**
     * 更新用户照片墙，与标签相同，存储为图片路径，用","分隔，当用户照片墙出现变化时，调用
     * @param userId
     * @param photos
     * @return
     */
    @PostMapping("/updatePhotosById")
    public String updatePhotosById(@RequestParam String userId, @RequestParam String photos){
        try {
            userService.updatePhotosById(userId, photos);
        }catch (Exception e){
            return "failed";
        }
        return "success";
    }


    @PostMapping("/updateAvatarUrl")
    public String updateAvatarUrl(@RequestParam String userId, @RequestParam String avatarUrl){
        try {
            userService.updateAvatarUrl(userId, avatarUrl);
        }catch (Exception e){
            return "failed";
        }
        return "success";
    }

    @PostMapping("/updateGender")
    public String updateGender(@RequestParam String userId, @RequestParam int gender){
        try {
            userService.updateGenderById(userId, gender);
        }catch (Exception e){
            return "failed";
        }
        return "success";
    }

    @PostMapping("/updateNickname")
    public String updateNickname(@RequestParam String userId, @RequestParam String nickname){
        try {
            userService.updateNicknameById(userId, nickname);
        }catch (Exception e){
            return "failed";
        }
        return "success";
    }

    @PostMapping("/updateBirthday")
    public String updateBirthday(@RequestParam String userId, @RequestParam String birthday){
        try {
            userService.updateBirthdayById(userId, birthday);
        }catch (Exception e){
            return "failed";
        }
        return "success";
    }
}
