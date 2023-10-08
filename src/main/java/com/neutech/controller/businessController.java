package com.neutech.controller;

import com.neutech.form.BusinessForm;
import com.neutech.mapper.BusinessMapper;
import com.neutech.service.BusinessService;
import com.neutech.vo.LayuiVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/business")
public class businessController {

    //测试重复提交

    @Autowired
    private BusinessService businessService;

    @Autowired
    private BusinessMapper businessMapper;

    @GetMapping("/list")
    public String list(){
        return"business/list";
    }

    @GetMapping("/listByPage")
    @ResponseBody
    public LayuiVO listByPage( @RequestParam(defaultValue = "1") Integer pageNum ,
                               @RequestParam(defaultValue = "1") Integer pageSize){

        //将实体类型转化为VO集合相应出去
        return businessService.listByPage(pageNum,pageSize);
    }

    @GetMapping("/listDynamics")
    @ResponseBody
    public LayuiVO listDynamics( @RequestParam(defaultValue = "1") Integer pageNum ,
                               @RequestParam(defaultValue = "1") Integer pageSize,
                                 String storeName,Integer[] storeStatus,Integer orderType){

        return businessService.listDynamics(pageNum, pageSize, storeName, storeStatus, orderType);
    }

    @PostMapping("/dynamicsUpdateById")
    @ResponseBody
    public LayuiVO dynamicsUpdateById(BusinessForm form){
        //判断id是否为空
        if (form.getId() == null){
            return LayuiVO.error(1,"id值不能为空");
        }
        return businessService.dynamicsUpdateById(form);
    }







//    public List<BusinessVO> createBusinessVO(Integer pageNum,Integer pageSize){
//        PageHelper.startPage(pageNum,pageSize);
//        List<Business> businesses = businessMapper.listAll();
//        List<BusinessVO> businessVOS = copyBusiness(businesses);
//        PageInfo pageInfo = PageInfo.of(businesses);
//        return businessVOS;
//
//    }
//
//    public List<BusinessVO> copyBusiness(List<Business> businessList){
//        List<BusinessVO> businessVOS = new ArrayList<BusinessVO>();
//        for (Business business : businessList) {
//            BusinessVO businessVO = new BusinessVO();
//            //属性名相同，类型相同
//            BeanUtils.copyProperties(business,businessVO);
//            //status类型不同，所以需要单独处理，使用枚举来处理
//            businessVO.setStoreStatus(BusinessStoreStatusEnum.getInstance(business.getStore_Status()).getStatusMessage());
//            businessVOS.add(businessVO);
//        }
//        return businessVOS;
//    }



}

