<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh_CN">
<head>
    <meta charset="utf-8">
    <title>简单用法 - 数据表格</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layuiadmin/layui/css/layui.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layuiadmin/style/admin.css">
    <style>
        .condition{
            padding: 15px 0;
        }
        .condition .layui-icon{
            right: 0;
            top: 0;
            margin-top: 0;
        }
        .condition .layui-icon:before{
            line-height: 30px;
        }
        .condition .layui-form-checkbox{
            margin-top: -4px;
        }
    </style>
</head>
<body>

<div class="layui-card layadmin-header">
    <div class="layui-breadcrumb" lay-filter="breadcrumb">
        <a lay-href="">主页</a>
        <a><cite>组件</cite></a>
        <a><cite>数据表格</cite></a>
        <a><cite>简单用法</cite></a>
    </div>
</div>

<div class="layui-fluid">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md12">
            <div class="layui-card">
                <div class="layui-card-header">商家列表</div>
                <div class="layui-card-header condition">

                    <form class="layui-form" >
                        <div class="layui-form-item">
                            <div class="layui-inline">
                                <label class="layui-form-label">商家名</label>
                                <div class="layui-input-block">
                                    <input type="text"  autocomplete="on"
                                           placeholder="请输入商家名" id = "store-name" class="layui-input">
                                </div>
                            </div>
                            <div class="layui-inline">
                                <label class="layui-form-label">商家类别</label>
                                <div class="layui-input-block">
                                    <select id = "order-type">
                                        <option value=""></option>
                                        <option value="0" selected>全部</option>
                                        <option value="1">面条</option>
                                        <option value="2">米饭</option>
                                        <option value="3">超市</option>
                                    </select>
                                </div>
                            </div>

                            <div class="layui-inline">
                                <label class="layui-form-label">状态</label>
                                <div class="layui-input-block store-status" >
                                    <input type="checkbox"title="未审核" value="1" checked>
                                    <input type="checkbox" title="正常"  value="2" checked>
                                    <input type="checkbox"  title="封禁" value="3" checked>
                                </div>
                            </div>
                            <div class="layui-inline">
                                <button type="button" class="layui-btn" id = "query">查询</button>
                            </div>
                        </div>
                    </form>

                </div>
                <div class="layui-card-body">
                    <table class="layui-hide" id="business-list" lay-filter = "business-list"></table>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="${pageContext.request.contextPath}/layuiadmin/layui/layui.js"></script>
<script>
    layui.config({
        base: '${pageContext.request.contextPath}/layuiadmin/' //静态资源所在路径
    }).extend({
        index: 'lib/index' //主入口模块
    }).use(['index', 'table'], function () {
        let table = layui.table,
            //加载layui内置的jquery
        $ = layui.$;
        layer = layui.layer

        //请求参数对象

        table.render({
            id:'businessList'
            ,elem: '#business-list'
            , url: '${pageContext.request.contextPath}/business/listDynamics'
            , cellMinWidth: 80 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
            , cols: [[
                {type: "checkbox"}
                , {type: "numbers", title: "序号"}
                , {field: 'storeName', title: '商家名', edit: "text"}
                , {field: 'storeAddress', title: '地址'}
                , {field: 'phone', title: '电话'}
                , {field: 'orderType', title: '分类'}
                , {field: 'startPrice', title: '起送费'}
                , {field: 'deliveryPrice', title: '配送费'}
                , {field: 'storeRemarks', title: '备注'}
                , {title: '状态', templet: '<div>{{=d.storeStatus.statusMessage}}</div>'}
                // ,{title: '状态', templet: function (data) {
                //         return data.storeStatus.statusMessage;
                //     }}
            ]],

            request: {
                pageName: 'pageNum',
                limitName: 'pageSize'
            },
            toolbar: 'default',
            page: true,
            limit: 3,
            limits: [1, 3, 20]
        });

        table.on('edit(business-list)',function (obj){
            console.log(obj)
            //发送ajax请求
            $.ajax({
                type:"post",
                url: '${pageContext.request.contextPath}/business/dynamicsUpdateById',
                data:{
                    id: obj.data.id,
                    storeName:obj.value
                },
                success: function (res) {
                    if (res.code == 0){
                        //刷新界面
                        layer.msg('修改成功',{icon:1})
                        table.reloadData('businessList')
                    }else {
                        layer.alert(res.msg,{icon:2})
                    }
                }
            })
        })

        let param = {};

        $('#query').click(function (e) {
            //清空param对象
            param = {};
            //获取状态
            let storeStatus =  $('.store-status input:checked');
            if (storeStatus.length == 0){
                layer.alert('至少选择一个状态',{icon:0})
                return;
            }
            if (storeStatus.length != 3){
                //防止一开始拼接上undefined
                param.storeStatus = '';
                //遍历选中的数组
                for (let item of storeStatus) {
                    param.storeStatus = param.storeStatus + item.value + ',';
                }
                //去除结尾逗号
                param.storeStatus = param.storeStatus.substr(0,param.storeStatus.length - 1)
            }


            //获取输入框等内的内容改变param对象
            let storeName =$('#store-name').val();
            if (storeName.trim()) {
                param.storeName = storeName
            }
            //获取下拉条
            let orderType = $('#order-type option:selected').val()
            if (orderType != 0) {
                param.orderType = orderType;
            }


            //让表格重新请求一下
            table.reload('businessList',{
                where: param
            })
        })
    });
</script>
</body>
</html>

