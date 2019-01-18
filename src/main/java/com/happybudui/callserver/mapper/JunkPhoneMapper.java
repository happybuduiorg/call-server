package com.happybudui.callserver.mapper;

import com.happybudui.callserver.entity.JunkPhoneEntity;
import org.apache.ibatis.annotations.*;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

@Mapper
public interface JunkPhoneMapper {
    @Select("select * from junkphone")
    List<JunkPhoneEntity> getAllJunkPhones();

    @Select("select * from junkphone where junktype=#{junkType}")
    List<JunkPhoneEntity> getAllJunkPhonesByType(@Param("junkType") int junkType);

    @Select("select * from junkphone where junknumber=#{junkNumber}")
    JunkPhoneEntity getJunkPhoneByNumber(@Param("junkNumber") BigDecimal junkNumber);

    @Insert("insert into junkphone(junknumber,junktype) values(#{junkNumber},#{junkType})")
    int insertJunkPhone(JunkPhoneEntity junkPhoneEntity);

    @Update("update junkphone set junktype=#{junkType} where junknumber=#{junkNumber}")
    int updateJunkTypeByNumber(@Param("junkNumber") BigDecimal junkNumber, @Param("junkType") int junkType);

    @Delete("delete from junkphone where junknumber=#{junkNumber}")
    int deleteJunkPhoneByNumber(@Param("junkNumber") BigDecimal junkNumber);
}
