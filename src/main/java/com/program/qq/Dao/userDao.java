package com.program.qq.Dao;

import com.program.qq.Model.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface userDao {

    String TABLE_NAME = " user ";
    String INSERT_FIELDS = " user_id, nickname, personal_sign, age, birthday, is_confirm, star, school, tag, photos";

    @Insert({"insert into", TABLE_NAME, "(", INSERT_FIELDS, ") values" +"({#userId},#{nickname},#{personalSign}," +
            "{age},{birthday},{isConfirm},{star},{school},{tag},{photos})"})
    void insertUser(User user);

    @Select({"select * from", TABLE_NAME, "where user_id = #{userId}"})
    void selectUserById(@Param("userId") String userId);

    @Select({"select tag from", TABLE_NAME, "where user_id = #{userId}"})
    String selectTagById(@Param("userId") String userId);

    @Select({"select photos from", TABLE_NAME, "where user_id = #{userId}"})
    String selectPhotosById(@Param("userId") String userId);

    @Update({"update", TABLE_NAME, "set school = #{school} where user_id = #{userId}"})
    void updateSchoolById(@Param("userId") String userId);

    @Update({"update", TABLE_NAME, "set is_confirm = #{isConfirm} where user_id = #{userId}"})
    void updateConfirmById(@Param("userId") String userId, @Param("isConfirm") boolean isConfirm);

    @Update({"update", TABLE_NAME, "set nickname = #{nickname} where user_id = #{userId}"})
    void updateNicknameById(@Param("userId") String userId, @Param("nickname") String nickname);

    @Update({"update", TABLE_NAME, "set nickname = #{nickname}, personal_sign = #{personalSign}," +
            "age = #{age}, star = #{star}, birthday = #{birthday} where user_id = {userId} where user_id = #{userId}"})
    void updateBasicInfoById(User user);

    @Update({"update", TABLE_NAME, "set tag = #{tag} where user_id = #{userId}"})
    void updateTagById(@Param("userId") String userId, @Param("tag") String tag);

    @Update({"update", TABLE_NAME, "set photos = #{photos} where user_id = #{userId}"})
    void updatePhotosById(@Param("userId") String userId, @Param("photos") String photos);

}
