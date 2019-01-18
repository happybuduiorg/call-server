package com.happybudui.callserver.mapper;

import com.happybudui.callserver.entity.CallRecordContentEntity;
import com.happybudui.callserver.entity.CallRecordEntity;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;

@Mapper
public interface CallRecordContentMapper {

    @Insert("insert into callrecordcontent(calltext,callaudio) " +
            "values(#{callText},#{callAudio})")
    Integer insertCallRecordContent(CallRecordContentEntity callRecordContentEntity);

    @Select("select * from callrecordcontent where callrecordid =#{callRecordId}")
    CallRecordEntity getCallRecordContentById(@Param("callRecordId") int callRecordId);

    @Update("update callrecordcontent set calltext =#{callText} where callrecordid =#{callRecordId}")
    Integer updateCallText(@Param("callText")String callText, @Param("callRecordId")int callRecordId);

    @Update("update callrecordcontent set callaudio =#{callAudio} where callrecordid =#{callRecordId}")
    Integer updateCallAudio(@Param("callAudio")String callAudio, @Param("callRecordId")int callRecordId);

}