package com.neutech.service;

import com.github.pagehelper.PageInfo;
import com.neutech.entity.Business;
import com.neutech.form.BusinessForm;
import com.neutech.vo.LayuiVO;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface BusinessService {

    LayuiVO listByPage(Integer pageNum,Integer pageSize);

    LayuiVO listDynamics( Integer pageNum , Integer pageSize,
                         String storeName,Integer[] storeStatus,Integer orderType);

    LayuiVO dynamicsUpdateById(BusinessForm form);
}
