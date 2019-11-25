package com.program.qq.Service;


import com.program.qq.Model.User;

import java.util.List;
import java.util.Map;

/**
 * @author xgp
 * @version 1.0
 * @date 2019/11/19 10:26
 */

public interface userService {

    User getUserById(String userId);

    void addUser(User user);

    String getTagById(String userId);

    String getPhotosById(String userId);

    void updateSchoolById(String userId, String school);

    void updateImportantInfo(String userId, String school, String gender, String eduBackground);

    void updateBasicInfoById(User user);

    void updateTagById(String userId, String tag);

    void updateConfirmById(String userId, int isConfirm);

    void updateNicknameById(String userId, String nickname);

    void updateBirthdayById(String userId, String birthday);

    void updateGenderById(String userId, int gender);

    void updatePhotosById(String userId, String photos);

    void updateAvatarUrl(String userId, String avatarUrl);

    void updateAge(String userId, int age);

    User selectUser(String userId);

    Map selectChatUser(String userId);

    List<User> selectByCondition(int gender, String school, int low, int high);
}
