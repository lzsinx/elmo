package com.neutech.vo;

import com.fasterxml.jackson.annotation.JsonInclude;

public class LayuiVO {

    private Integer code;
    private String msg;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long count;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object data;

    public LayuiVO() {
    }

    public static LayuiVO error(Integer code,String msg){
        LayuiVO layuiVO = new LayuiVO();
        layuiVO.code = code;
        layuiVO.msg = msg;
        return layuiVO;
    }

    public static LayuiVO success(){
        LayuiVO layuiVO = new LayuiVO();
        layuiVO.code = 0;
        layuiVO.msg = "成功";
        return layuiVO;
    }
    public static LayuiVO success(Long count,Object data){
        LayuiVO layuiVO = new LayuiVO();
        layuiVO.code = 0;
        layuiVO.msg = "成功";
        layuiVO.count = count;
        layuiVO.data = data;
        return layuiVO;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public Long getCount() {
        return count;
    }

    public Object getData() {
        return data;
    }


}
