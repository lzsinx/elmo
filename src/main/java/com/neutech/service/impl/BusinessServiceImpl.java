package com.neutech.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neutech.entity.Business;
import com.neutech.entity.BusinessVO;
import com.neutech.enumeration.BusinessStoreStatusEnum;
import com.neutech.form.BusinessForm;
import com.neutech.mapper.BusinessMapper;
import com.neutech.service.BusinessService;
import com.neutech.vo.LayuiVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BusinessServiceImpl implements BusinessService {

    @Autowired
    private BusinessMapper businessMapper;

    public LayuiVO listByPage(Integer pageNum,Integer pageSize) {
        //调用分页
        PageHelper.startPage(pageNum,pageSize);
        List<Business> businesses = businessMapper.listAll();
        PageInfo pageInfo = PageInfo.of(businesses);
        return LayuiVO.success(pageInfo.getTotal(),entity2VOList(businesses));
    }

    private BusinessVO entity2VO(Business business){
        BusinessVO businessVO = new BusinessVO();
        BeanUtils.copyProperties(business,businessVO);
        businessVO.setStoreStatus(
                BusinessStoreStatusEnum.getInstance(business.getStore_Status())
        );
        return businessVO;
    }

    private List<BusinessVO> entity2VOList(List<Business> businessList){
        List<BusinessVO> businessVOList = new ArrayList<BusinessVO>();
        for (Business business:businessList){
            businessVOList.add(entity2VO(business));
        }
        return businessVOList;
    }



    //动态查询
    public LayuiVO listDynamics(Integer pageNum, Integer pageSize, String storeName, Integer[] storeStatus, Integer orderType) {
        PageHelper.startPage(pageNum,pageSize);
        List<Business> businessList = businessMapper.listDynamics(storeName,storeStatus,orderType);
        PageInfo pageInfo = PageInfo.of(businessList);
        return LayuiVO.success(pageInfo.getTotal(),entity2VOList(businessList));
    }

    public LayuiVO dynamicsUpdateById(BusinessForm form) {
        Business business = new Business();

        //对象拷贝
        BeanUtils.copyProperties(form,business);
        //单独处理客户端没传我们还需要的
        business.setUpdateTime(new Date());
        System.out.println(2);
        businessMapper.dynamicsUpdateById(business);
        System.out.println(3);
        return LayuiVO.success();
    }

}
