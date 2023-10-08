package com.neutech.mapper;

import com.neutech.entity.Business;
import com.neutech.entity.BusinessVO;
import com.neutech.vo.LayuiVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BusinessMapper {

    List<Business> listAll();

    List<Business> listDynamics(@Param("storeName") String storeName, @Param("storeStatus")Integer[] storeStatus,
                                @Param("orderType")Integer orderType);


    int dynamicsUpdateById(Business business);

}
