package com.happybudui.callserver.mapper;

import com.happybudui.callserver.entity.UserEntity;
import org.apache.ibatis.annotations.*;

import java.math.BigDecimal;

@Mapper
public interface UserMapper {

    @Select("select * from \"user\" where usernumber=#{userNumber}")
    UserEntity getUserInfoByNumber(@Param("userNumber") BigDecimal userNumber);

    @Insert("insert into \"user\"(usernumber, userpassword, userstatus, userscene, userlongitude, userlatitude, usertoken) " +
            "values(#{userNumber}, #{userPassword}, #{userStatus}, #{userScene}, #{userLongitude}, #{userLatitude}, #{userToken})")
    int insertUser(UserEntity userEntity);

    @Update("update \"user\" set userstatus=#{userStatus} where usernumber=#{userNumber}")
    int updateUserStatusByNumber(@Param("userNumber") BigDecimal userNumber, @Param("userStatus") int userStatus);

    @Update("update \"user\" set userscene=#{userScene} where usernumber=#{userNumber}")
    int updateUserSceneByNumber(@Param("userNumber") BigDecimal userNumber, @Param("userScene") int userScene);

    @Update("update \"user\" set userlongitude=#{userLongitude},userlatitude=#{userLatitude} where usernumber=#{userNumber}")
    int updateUserLocationByNumber(@Param("userNumber") BigDecimal userNumber, @Param("userLongitude") double userLongitude, @Param("userLatitude") double userLatitude);

    @Update("update \"user\" set usertoken=#{userToken} where usernumber=#{userNumber}")
    int updateUserTokenByNumber(@Param("userNumber") BigDecimal userNumber, @Param("userToken") String userToken);

}
