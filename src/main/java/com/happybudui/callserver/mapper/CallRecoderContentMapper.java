package com.happybudui.callserver.mapper;

import com.happybudui.callserver.entity.CallRecoderContentEntity;
import com.happybudui.callserver.entity.CallRecoderEntity;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;

import java.sql.Timestamp;

@Mapper
@CacheConfig(cacheNames = "callrecodercontent")
public interface CallRecoderContentMapper {

    @Insert("insert into callrecodercontent(callrecoderid,callindex,calltext,callaudio) " +
            "values(#{callRecoderId},#{callIndex},#{callText},#{callAudio})")
    public int insertCallRecord(CallRecoderContentEntity callRecoderContentEntity);

    @Select("select * from \"callrecodercontent\" where callrecoderdid =#{callRecoderId}")
    @Cacheable(key ="#p0")
    CallRecoderEntity getCallRecoder(@Param("callrecoderId") int callRecoderId);

//    @Select("select callindex from callrecodercontent where callrecoderdid =#{callRecoderId}")
//    @Cacheable(key ="#p0")
//    CallRecoderEntity getCallIndex(@Param("callindex")int callIndex, @Param("callrecoderId") int callRecoderId);
//
//    @Select("select calltext from callrecodercontent where callrecoderdid =#{callRecoderId}")
//    @Cacheable(key ="#p0")
//    CallRecoderEntity getCallText(@Param("calltext")String callText, @Param("callrecoderId") int callRecoderId);
//
//    @Select("select callaudio from callrecodercontent where callrecoderdid =#{callRecoderId}")
//    @Cacheable(key ="#p0")
//    CallRecoderEntity getCallAudio(@Param("callaudio")String callAudio, @Param("callrecoderId") int callRecoderId);

    @Update("update \"callrecodercontent\" set callindex =#{callIndex} where callrecoderid =#{callRecoderId}")
    @Cacheable(key ="#p0")
    CallRecoderEntity setCallIndex(@Param("callindex")int callIndex, @Param("callrecoderid")int callRecoderId);

    @Update("update \"callrecodercontent\" set calltext =#{callText} where callrecoderid =#{callRecoderId}")
    @Cacheable(key ="#p0")
    CallRecoderEntity setCallText(@Param("calltext")String callText, @Param("callrecoderid")int callRecoderId);

    @Update("update \"callrecodercontent\" set callaudio =#{callAudio} where callrecoderid =#{callRecoderId}")
    @Cacheable(key ="#p0")
    CallRecoderEntity setCallAudio(@Param("callaudio")String callAudio, @Param("callrecoderid")int callRecoderId);

}
