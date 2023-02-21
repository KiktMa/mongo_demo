package com.mjtal.mongo_demo.service.impl;

import com.mjtal.mongo_demo.mapper.GetHighMapper;
import com.mjtal.mongo_demo.service.GetHightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.mjtal.mongo_demo.util.MyTools.getCoordinate;

@Service
public class GetHightServiceImpl implements GetHightService {

    @Autowired
    private GetHighMapper highMapper;

    @Override
    public Double queryHigh(Double point1, Double point2) {
//        int srid = highMapper.querySrid();
        Double[] coordinate = getCoordinate(point1, point2,4540);
        try {
            Double high = highMapper.queryHigh(coordinate[1], coordinate[0],4540);
            return high == null? 0d:high;
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0d;
    }
}
