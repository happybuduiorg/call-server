package com.happybudui.callserver.mapper;

import com.happybudui.callserver.entity.UserEntity;
import org.apache.ibatis.annotations.*;

import java.math.BigInteger;

@Mapper
public interface UserMapper {

    @Select("select * from \"user\" where usernumber=#{userNumber}")
    UserEntity getUserInfoByNumber(@Param("userNumber") BigInteger userNumber);

    @Select("select userpassword from \"user\" where usernumber=#{userNumber}")
    String getUserPasswordByNumber(@Param("userNumber") BigInteger userNumber);

    @Select("select userscene from \"user\" where usernumber=#{userNumber}")
    int getUserSceneByNumber(@Param("userNumber") BigInteger userNumber);

    @Insert("insert into \"user\"(usernumber, userpassword, userstatus, userscene, userlongitude, userlatitude) " +
            "values(#{userNumber}, #{userPassword}, #{userStatus}, #{userScene}, #{userLongitude}, #{userLatitude})")
    int insertUser(UserEntity userEntity);

    @Update("update \"user\" set userstatus=#{userStatus} where usernumber=#{userNumber}")
    int updateUserStatusByNumber(@Param("userNumber") BigInteger userNumber, @Param("userStatus") int userStatus);

    @Update("update \"user\" set userscene=#{userScene} where usernumber=#{userNumber}")
    int updateUserSceneByNumber(@Param("userNumber") BigInteger userNumber, @Param("userScene") int userScene);

    @Update("update \"user\" set userlongitude=#{userLongitude},userlatitude=#{userLatitude} where usernumber=#{userNumber}")
    int updateUserLocationByNumber(@Param("userNumber") BigInteger userNumber, @Param("userLongitude") double userLongitude, @Param("userLatitude") double userLatitude);

}
