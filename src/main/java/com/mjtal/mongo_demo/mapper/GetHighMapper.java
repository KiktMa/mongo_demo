package com.mjtal.mongo_demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface GetHighMapper {

    Double queryHigh(@Param("point1") Double lon, @Param("point2") Double lat, @Param("sgrid") int sgrid);

    int querySrid();
}
