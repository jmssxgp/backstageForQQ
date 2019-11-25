package com.program.qq.Service.impl;

import com.program.qq.Dao.userDao;
import com.program.qq.Model.User;
import com.program.qq.Service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author xgp
 * @version 1.0
 * @date 2019/11/19 12:07
 */
@Service
public class userServiceImpl implements userService {

    @Autowired
    userDao userDao;

    @Override
    public User getUserById(String userId) {
        return userDao.selectUserById(userId);
    }

    @Override
    public void addUser(User user) {
        userDao.insertUser(user);
    }

    @Override
    public String getTagById(String userId) {
        return userDao.selectTagById(userId);
    }

    @Override
    public String getPhotosById(String userId) {
        return userDao.selectPhotosById(userId);
    }

    @Override
    public void updateSchoolById(String userId, String school) {
        userDao.updateSchoolById(userId, school);
    }

    @Override
    public void updateImportantInfo(String userId, String school, String gender, String eduBackground) {
        userDao.updateImportantInfo(userId, school, gender, eduBackground);
    }

    @Override
    public void updateBasicInfoById(User user) {
        userDao.updateBasicInfoById(user);
    }

    @Override
    public void updateTagById(String userId, String tag) {
        userDao.updateTagById(userId, tag);
    }

    @Override
    public void updateConfirmById(String userId, int isConfirm) {
        userDao.updateConfirmById(userId, isConfirm);
    }

    @Override
    public void updateNicknameById(String userId, String nickname) {
        userDao.updateNicknameById(userId, nickname);
    }

    @Override
    public void updatePhotosById(String userId, String photos) {
        userDao.updatePhotosById(userId, photos);
    }

    @Override
    public void updateAvatarUrl(String userId, String avatarUrl) {
        userDao.updateAvatarUrl(userId, avatarUrl);
    }

    @Override
    public void updateBirthdayById(String userId, String birthday) {
        userDao.updateBirthdayById(userId, birthday);
    }

    @Override
    public void updateGenderById(String userId, int gender) {
        userDao.updateGenderById(userId, gender);
    }

    @Override
    public void updateAge(String userId, int age) {
        userDao.updateAge(userId, age);
    }

    @Override
    public User selectUser(String userId) {
        return userDao.selectUserById(userId);
    }

    @Override
    public Map selectChatUser(String userId) {
        return userDao.selectChatUser(userId);
    }

    @Override
    public List<User> selectByCondition(int gender, String school, int low, int high) {
        return userDao.selectByCondition(gender, school, low, high);
    }
}
