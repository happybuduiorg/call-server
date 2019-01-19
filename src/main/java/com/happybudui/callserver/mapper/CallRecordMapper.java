package com.happybudui.callserver.mapper;

import com.happybudui.callserver.entity.CallRecordContentEntity;
import com.happybudui.callserver.entity.CallRecordEntity;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

//CopyRight © 2018-2018 Happybudui All Rights Reserved.
//Written by Happybudui

@Mapper
public interface CallRecordMapper {

    @Insert("insert into callrecord(callfromnumber,calltonumber,calltype,callstarttime,calllastedtime) " +
            "values(#{callFromNumber},#{callToNumber},#{callType},#{callStartTime},#{callLastedTime})")
    Integer insertCallRecord(CallRecordEntity callRecordEntity);

    @Select("select * from callrecord where callrecordid =#{callRecordId}")
    CallRecordEntity getCallRecordId(@Param("callRecordId") Integer callRecordId);

    @Select("select * from callrecord where callfromnumber=#{callFromNumber} and calltonumber = #{callToNumber}")
    CallRecordEntity getCallRecordByFromNumAndToNum(@Param("callFromNumber")BigDecimal callFromNum,@Param("callToNumber")BigDecimal callToNum);

    @Select("select * from callrecord where callfromnumber =#{callFromNumber}")
    List<CallRecordEntity>  getCallRecordsByFromNumber(@Param("callFromNumber")BigDecimal callFromNumber);

    @Select("select * from callrecord where calltonumber =#{callToNumber}")
    List<CallRecordEntity>  getCallRecordsByToNumber(@Param("callToNumber")BigDecimal callToNumber);

    @Select("select * from callrecord where calltonumber =#{callToNumber} and callstarttime>#{callStartTime}")
    List<CallRecordEntity>  getCallRecordsByToNumberAndStartTime(@Param("callToNumber")BigDecimal callToNumber,@Param("callStartTime")Timestamp startTime);

    @Update("update callrecord set calltype =#{callType} where callrecordid =#{callRecordId}")
    Integer updateCallType(@Param("callRecordId")Integer callRecordId,@Param("callType")Integer callType);

    @Update("update callrecord set callstarttime =#{callStartTime} where callrecordid =#{callRecordId}")
    Integer updateCallStartTime(@Param("callRecordId")Integer callRecordId,@Param("callStartTime")Timestamp callStartTime);

    @Update("update callrecord set calllastedtime =#{callLastedTime} where callrecordid =#{callRecordId}")
    Integer updateCallLastedTime(@Param("callRecordId")Integer callRecordId,@Param("callLastedTime")int callLastedTime);

    @Insert("insert into callrecordcontent(callrecordid,calltext,callaudio) " +
            "values(#{callRecordId},#{callText},#{callAudio})")
    Integer insertCallRecordContent(CallRecordContentEntity callRecordContentEntity);

    @Select("select * from callrecordcontent where callrecordid =#{callRecordId}")
    List<CallRecordContentEntity> getCallRecordContentById(@Param("callRecordId") int callRecordId);

    @Update("update callrecordcontent set calltext =#{callText} where callrecordid =#{callRecordId}")
    Integer updateCallText(@Param("callText")String callText, @Param("callRecordId")int callRecordId);

    @Update("update callrecordcontent set callaudio =#{callAudio} where callrecordid =#{callRecordId}")
    Integer updateCallAudio(@Param("callAudio")String callAudio, @Param("callRecordId")int callRecordId);

}