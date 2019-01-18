package com.happybudui.callserver.mapper;

import com.happybudui.callserver.entity.CallRecoderEntity;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;

import java.sql.Timestamp;

@Mapper
@CacheConfig(cacheNames = "callrecoder")
public interface CallRecoderMapper {

    @Insert("insert into callrecoder(callrecoderid,callfromnumber,calltonumber,calltype,callstarttime,calllastedtime) " +
            "values(#{callRecoderId},#{callFromNumber},#{callToNumber},#{callType},#{callStartTime},#{callLastedTime})")
    public int insertCallRecord(CallRecoderEntity callRecoderEntity);

    @Select("select * from \"callrecoder\" where callrecoderdid =#{callRecoderId}")
    @Cacheable(key ="#p0")
    CallRecoderEntity getCallRecoder(@Param("callrecoderId") int callRecoderId);

//    @Select("select callfromnumber from callrecoder where callrecoderdid =#{callRecoderId}")
//    @Cacheable(key ="#p0")
//    CallRecoderEntity getCallFromNumber(@Param("callfromnumber")String callFromNumber, @Param("callrecoderId") int callRecoderId);
//
//    @Select("select calltonumber from callrecoder where callrecoderdid =#{callRecoderId}")
//    @Cacheable(key ="#p0")
//    CallRecoderEntity getCallToNumber(@Param("calltonumber")String callToNumber, @Param("callrecoderId") int callRecoderId);
//
//    @Select("select calltype from callrecoder where callrecoderdid =#{callRecoderId}")
//    @Cacheable(key ="#p0")
//    CallRecoderEntity getCallType(@Param("calltype")int callType, @Param("callrecoderId") int callRecoderId);

    @Update("update \"callrecoder\" set callfromnumber =#{callFromNumber} where callrecoderid =#{callRecoderId}")
    @Cacheable(key ="#p0")
    CallRecoderEntity setCallFromNumber(@Param("callfromnumber")long callFromNumber, @Param("callrecoderid")int callRecoderId);

    @Update("update \"callrecoder\" set calltonumber =#{callToNumber} where callrecoderid =#{callRecoderId}")
    @Cacheable(key ="#p0")
    CallRecoderEntity setCallToNumber(@Param("calltonumber")long callToNumber, @Param("callrecoderid")int callRecoderId);

    @Update("update \"callrecoder\" set calltype =#{callType} where callrecoderid =#{callRecoderId}")
    @Cacheable(key ="#p0")
    CallRecoderEntity setCallType(@Param("calltype")int callType, @Param("callrecoderid")int callRecoderId);

    @Update("update \"callrecoder\" set callstarttime =#{callStartTime} where callrecoderid =#{callRecoderId}")
    @Cacheable(key ="#p0")
    CallRecoderEntity setCallStartTime(@Param("callstarttime")Timestamp callStartTime, @Param("callrecoderid")int callRecoderId);

    @Update("update \"callrecoder\" set calllastedtime =#{callLastedTime} where callrecoderid =#{callRecoderId}")
    @Cacheable(key ="#p0")
    CallRecoderEntity setCallLastedTime(@Param("calllastedtime")int callLastedTime, @Param("callrecoderid")int callRecoderId);

//    @Select("select callstarttime from callrecoder where callrecoderdid =#{callRecoderId}")
//    @Cacheable(key ="#p0")
//    CallRecoderEntity getCallStartTime(@Param("callstarttime")Timestamp callStartTime, @Param("callrecoderId") int callRecoderId);
//
//    @Select("select calllastedtime from callrecoder where callrecoderdid =#{callRecoderId}")
//    @Cacheable(key ="#p0")
//    CallRecoderEntity getCallLastedTime(@Param("calllastedtime")int callStartTime, @Param("callrecoderId") int callRecoderId);

}
