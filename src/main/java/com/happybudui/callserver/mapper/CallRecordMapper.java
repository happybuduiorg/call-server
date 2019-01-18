package com.happybudui.callserver.mapper;

import com.happybudui.callserver.entity.CallRecordEntity;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

@Mapper
public interface CallRecordMapper {

    @Insert("insert into callrecord(callfromnumber,calltonumber,calltype,callstarttime,calllastedtime) " +
            "values(#{callFromNumber},#{callToNumber},#{callType},#{callStartTime},#{callLastedTime})")
    Integer insertCallRecord(CallRecordEntity callRecordEntity);

    @Select("select * from callrecord where callrecordid =#{callRecordId}")
    CallRecordEntity getCallRecordId(@Param("callRecordId") Integer callRecordId);

    @Select("select * from callrecord where callfromnumber=#{callFromNumber} and calltonumber = #{callToNumber}")
    CallRecordEntity getCallRecordByFromNumAndToNum(@Param("callFromNumber")BigDecimal callFromNum,@Param("callToNumber")BigDecimal callToNum);

    @Select("select * from callrecord where callfromnum =#{callFromNumber}")
    List<CallRecordEntity>  getCallRecordsByFromNumber(@Param("callFromNumber")BigDecimal callFromNumber);

    @Select("select * from callrecord where calltonum =#{callToNumber}")
    List<CallRecordEntity>  getCallRecordsByToNumber(@Param("callToNumber")BigDecimal callToNumber);

    @Update("update callrecord set calltype =#{callType} where callrecordid =#{callRecordId}")
    Integer updateCallType(@Param("callRecordId")Integer callRecordId,@Param("callType")Integer callType);

    @Update("update callrecord set callstarttime =#{callStartTime} where callrecordid =#{callRecordId}")
    Integer updateCallStartTime(@Param("callRecordId")Integer callRecordId,@Param("callStartTime")Timestamp callStartTime);

    @Update("update callrecord set calllastedtime =#{callLastedTime} where callrecordid =#{callRecordId}")
    Integer updateCallLastedTime(@Param("callRecordId")Integer callRecordId,@Param("callLastedTime")int callLastedTime);

}