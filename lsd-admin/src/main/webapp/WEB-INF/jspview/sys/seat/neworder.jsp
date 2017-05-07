<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/spinner/bootstrap/bootstrap-spinner.css" />
</head>
<body >
    <div class="wrapper wrapper-content animated fadeInRight">
       <div class="row">
            <div class="col-sm-12">
                <div class="ibox ">
                    
                    <div class="ibox-content ">
                         <table ID='dt_table_view' class="table table-striped table-bordered table-hover ">
                            <thead>
                                <tr>
									<th>桌号</th>
									<th>开台时间</th>
									<th>状态</th>
									<th>操作</th>
								</tr>
                            </thead>
                       		 <tbody>
                            </tbody>
                          </table>
                    </div>
                    
                </div>
            </div>
        </div>
   </div>
   
   <div id='_formchoose' style="display: none;">
       <div class="ibox-content">
 		 <div class="row">
                <div class="col-sm-12 b-r">
		                    
		                    <div class="clients-list">
                            
                            <ul class="nav nav-tabs">
                                <li class="active"><a data-toggle="tab" href="#tab-1"><i class="fa fa-user"></i> 菜单</a>
                                </li>
                                <li class=""><a data-toggle="tab" href="#tab-2"><i class="fa fa-briefcase"></i> 已点</a>
                                </li>
                            </ul>
                            
                            <div class="tab-content">
                                <div id="tab-1" class="tab-pane active">
                                    <div class="slimScrollDiv" style="position: relative; width: auto; height: 100%;"><div class="full-height-scroll" style="width: auto; height: 100%;">
                                        <div class="table-responsive">
                                            <table class="table table-striped table-hover">
                                                <tbody>
                                                	<c:forEach items="${foods}" var="food">
                                                	<tr>
                                                        <td ><img alt="image"  style="height: 60px" src="${pageContext.request.contextPath}/upload/${food.img}"> </td>
                                                        <td><a data-toggle="tab" href="#contact-1" class="client-link">${food.name }</a>
                                                        </td>
                                                        <td> <a tager='_blank' href='javascript:void(0)' onclick='fun_additem(${food.id})'>加入菜篮</a></td>
                                                        <td> </td>
                                                    </tr>
                                                	</c:forEach>
                                                    
                                                </tbody>
                                            </table>
                                        </div>
                                    </div><div class="slimScrollBar" style="width: 4px; position: absolute; top: 0px; opacity: 0.4; display: block; border-radius: 7px; z-index: 99; right: 1px; height: 365.112px; background: rgb(0, 0, 0);"></div><div class="slimScrollRail" style="width: 4px; height: 100%; position: absolute; top: 0px; display: none; border-radius: 7px; opacity: 0.2; z-index: 90; right: 1px; background: rgb(51, 51, 51);"></div></div>
                                </div>
                                
                                
                                <div id="tab-2" class="tab-pane">
                                   <form id='_form_check'>
                                   	<input type="hidden" value="1" name="id" />
                                    <div class="slimScrollDiv" style="position: relative; width: auto; height: 100%;"><div class="full-height-scroll" style="width: auto; height: 100%;">
                                        <div class="table-responsive">
                                            <table class="table table-striped table-hover">
                                                <tbody id='cashed'>
                                                </tbody>
                                            </table>
                                        </div>
                                     </div>
                                     </div>
                                    </form>
                                   </div>
                                </div><!-- tab context -->
                            </div>

                        </div>
                  </div>
             </div>
         </div>
   </div>
   
   
      <div id='_formcash' style="display: none;">
       <div class="ibox-content">
 		 	<div class="row">
              
              <div class="col-sm-12">
                <div class="ibox-content p-xl">
                    <div class="row">
                        <div class="col-sm-6">
                            <address>
                                        <strong>零食店店欢迎您</strong><br>
                                     		  北京市海淀区上地十街10号<br>
                                        <abbr title="Phone">总机：</abbr> (+86 10) 5992 8888
                                    </address>
                        </div>

                        <div class="col-sm-6 text-right">
                            	<address>
                                        <abbr title="Phone">客户姓名：</abbr> <span id='cash_name' ></span>
                                    </address>
                            <p>
                                <span><strong>下单日期：</strong>  <span id='cash_createDate' ></span>  </span>
                            </p>
                        </div>
                    </div>

                    <div class="table-responsive m-t">
                        <table class="table invoice-table">
                            <thead>
                                <tr>
                                    <th>清单</th>
                                    <th>数量</th>
                                    <th>单价</th>
                                    <th>总价</th>
                                </tr>
                            </thead>
                            <tbody id='cashitem' >

                            </tbody>
                        </table>
                    </div>
                    <!-- /table-responsive -->

                    <table class="table invoice-total">
                        <tbody>
                            <tr>
                                <td><strong>总价：</strong>
                                </td>
                                <td>¥<span class='cash_total'></span></td>
                            </tr>
                            
                            <tr>
                                <td><strong>折扣：</strong>
                                </td>
                                <td>¥0.00</td>
                            </tr>
                            
                            <tr>
                                <td><strong>总计</strong>
                                </td>
                                <td>¥<span class='cash_total'></span></td>
                            </tr>
                        </tbody>
                    </table>
                    <div class="text-right">
                        <button onclick="fun_docheck()" class="btn btn-primary"><i class="fa fa-dollar"></i> 付款完成</button>
                    </div>
                </div>
            </div>
              
                            
           </div>
      </div>
   </div>
   
   
   <div id='_formopen' style="display: none;">
       <div class="ibox-content">
 		 <div class="row">
                            <div class="col-sm-12 b-r">
		                           <form   class="form-horizontal" action="" method="get">
		                           <input name='id' type="hidden"/>
		                           	<table class='table table-bordered'>
		                           		<thead>
		                           		<tr style="text-align: center;" ><td colspan="6" ><h3>开台<h3></h3></td></tr>
		                           		</thead>
		                           		<tbody>
		                           			<tr>
		                           				<td>会员账号</td>
		                           				<td> <input name='userName' type="text" class="form-control"></td>
		                           			</tr>
		                           			
		                           			<tr>
		                           			
		                           			<td>桌号</td>
		                           				<td>
												  <input readonly="readonly" name='seatName' type="text" class="form-control">
		                           				</td>
		                           			</tr>
		                           			
		                           			<tr>
		                           				<td colspan="6"> 
		                           					 <div class="col-sm-4 col-sm-offset-2">
		                                  			  		<button class="btn btn-primary" type="button" onclick="submit_open()">确认开台</button>
		                               				 </div>
		                           				</td>
		                           			</tr>
		                           		</tbody>
		                           	</table>
		                           	</form>
                            </div>
                        </div>
                        </div>
   </div>
   <script>
    var table=null;
    var thisid;
    $('.date').datepicker({
        format: 'yyyy-mm-dd',
        autoclose: true
    });
    
    
    function submit_form(){
    	$.ajax({
    		   type: "POST",
    		   url:  $.common.getContextPath() + "/sys/order/save",
    		   data: $("_form").serialize(),
    		   success: function(msg){
    		     if(msg.code==1){
    		    	 toastr.success('操作成功');
    		    	 table.draw();
    		     }
    		     layer.closeAll() ;
    		   }
    		});
     }
    
    /**执行付款动作*/
    function fun_docheck(){
    	$.ajax({
 		   url:  $.common.getContextPath() + "/sys/seat/check?formid="+thisid,
 		   success: function(msg){
 		     if(msg.code==1){
 		    	 toastr.success('付款成功');
 		    	 table.draw();
 		     }
 		     layer.closeAll() ;
 		   }
 		});	
    }
    /**执行付款动作*/
    function fun_additem(id){
    	$.ajax({
 		   url:  $.common.getContextPath() + "/sys/seat/additem?formid="+thisid+"&foodid="+id,
 		   success: function(msg){
 		     if(msg.code==1){
 		    	toastr.success('加入菜篮成功');
 		    	$("#cashed").empty();
 		    	$.ajax({
 		  		   url:  $.common.getContextPath() + "/sys/seat/precheck?formid="+thisid,
 		  		   success: function(msg){
 		  		     if(msg.code==1){
 		  		    	for(i=0;i<msg.datas.foodItem.length;i++){
 		  		    		$("#cashed").append("<tr> <input type='hidden' value='"+msg.datas.foodItem[i].food.id+"' name='foodItems["+i+"].food.i' />"+
			                        	""+
			                     	   "<td ><img alt='image'  style='height: 60px' src='${pageContext.request.contextPath}/upload/"+msg.datas.foodItem[i].food.img+"'> </td>"+
			                           "  <td><a data-toggle='tab' href='#contact-1' class='client-link'>"+msg.datas.foodItem[i].food.name+"</a>"+
			                            " </td>"+
			                           "  <td> "+
			                            " 	 <input type='text' style='width: 40px' name='foodItems["+i+"].num' class='form-control' value='"+msg.datas.foodItem[i].num+"' size='2'> "+
										"	</td>"+
			                             "<td> </td> "+
			                           " </tr>");
 		  		    	}
 		  		     }
 		  		   }
 		  		});
 		    	 
 		     }
 		     
 		   }
 		});	
    }
    
    
    function fun_gocheck(){
    	$.ajax({
 		   type: "POST",
 		   url:  $.common.getContextPath() + "/sys/seat/choose",
 		   data: $("#_form_check").serialize(),
 		   success: function(msg){
 		     if(msg.code==1){
 		    	 toastr.success('操作成功');
 		    	 table.draw();
 		     }
 		     layer.closeAll() ;
 		   }
 		});
    }
    
    function submit_open(){
    	$.ajax({
    		   type: "POST",
    		   url:  $.common.getContextPath() + "/sys/seat/open",
    		   data: $("#_formopen form").serialize(),
    		   success: function(msg){
    		     if(msg.code==1){
    		    	 toastr.success('操作成功');
    		    	 table.draw();
    		     }
    		     layer.closeAll() ;
    		   }
    		});
     }
    function fun_delete(id){
    	
    	layer.confirm('确定删除当前员工？', {
    		  btn: ['确定','取消'] //按钮
    		}, function(){
    			$.ajax({
    		 		   url:  $.common.getContextPath() + "/sys/order/delete?id="+id,
    		 		   success: function(msg){
    		 		     if(msg.code==1){
    		 		    	 toastr.success('操作成功');
    		 		    	 table.draw();
    		 		     }
    		 		     layer.closeAll() ;
    		 		   }
    		 	});
    		}, function(){
    			 layer.closeAll() ;
    		});
    	
    	
     }
    
    function fun_open(name){
    	
    	$("input[name='seatName']").val(name);
    	
    	layer.open({
			  type: 1,
			  skin: 'layui-layer-rim', 
			  content: $("#_formopen"),
			  area: "800px"
		});
    }
    function fun_choose(id){
    	thisid=id;
		$("input[name='seatName']").val(name);
	    	layer.open({
				  type: 1,
				  skin: 'layui-layer-rim', 
				  content: $("#_formchoose"),
				  area: "800px"
			});
    }
    
    function fun_check(id){
    	thisid=id;
    	$.ajax({
  		   url:  $.common.getContextPath() + "/sys/seat/precheck?formid="+id,
  		   success: function(msg){
  		     if(msg.code==1){
  		    	$("#cash_name").html(msg.datas.user.name);
  		    	$("#cash_createDate").html(msg.datas.createDate);
  		    	$(".cash_total").html(msg.datas.price);
  		    	$("#cashitem").empty();
  		    	
  		    	for(i=0;i<msg.datas.foodItem.length;i++){
  		    		$("#cashitem").append("<tr>"+
			                  "  <td>"+
			                  "  <div><strong>"+msg.datas.foodItem[i].food.name+"</strong>"+
			                  "  </div>"+
			               " </td>"+
			               " <td>"+msg.datas.foodItem[i].num+"</td>"+
			               " <td>¥"+msg.datas.foodItem[i].food.price+"</td>"+
			               " <td>¥"+msg.datas.foodItem[i].food.price*msg.datas.foodItem[i].num+"</td>"+
			           " </tr>");
  		    	}
  		    	
  		    	layer.open({
  				  type: 1,
  				  skin: 'layui-layer-rim', 
  				  content: $("#_formcash"),
  				  area: "800px"
  			});
  		     }
  		   }
  		});
    }
    
    function fun_update(id){
    	$.ajax({
 		   url:  $.common.getContextPath() + "/sys/order/get?id="+id,
 		   success: function(msg){
 		     if(msg.code==1){
 		    	layer.open({
      			  type: 1,
      			  skin: 'layui-layer-rim', 
      			  content: $("#_form"),
      			  area: "800px"
      			});
 		     }
 		   }
 		});
     }
    
    $(document).ready(function(){
    		$('#spinner').spinner();

        	$("#_new").click(function(){
        		$("input[name='id']").val("");
 		    	$("input[name='chinesename']").val("");
 		    	$("radio[name='sex']").val("");
 		   		$("input[name='username']").val("");
 				$("input[name='tel']").val("");
 				$("input[name='email']").val("");
 				$("textarea[name='remark']").val("");
        		layer.open({
        			  type: 1,
        			  skin: 'layui-layer-rim', //加上边框
        			  content: $("#_form"),
        			  area: "800px"
        			});
        	});
        	table=$('#dt_table_view').DataTable( {
        		"dom": "rt<'row'<'col-sm-5'i><'col-sm-7'p>>",
	            "ajax": {
	                "url":  $.common.getContextPath() + "/sys/seat/list",
	                "type": "POST",
	                "dataSrc": "datas"
	              },
				"columns" : [{
					"data" : "name"
				},{
					"data" : "form",
				}, {
					"data" : "state"
				},{
					"data" : "id",
				}] ,
				 "columnDefs": [
				            	{
								    "render": function ( data, type, row ) {
								        if(data=='1'){
								        	return "<span class='label label-danger'>使用中</span>";
								        }else{
								        	return "<span class='label label-primary'>空闲</span>";
								        }
								    },
								    "targets":2
								},
								{
								    "render": function ( data, type, row ) {
								        if(data==null){
								        	return "";
								        }else{
								        	return data.createDate;
								        }
								    },
								    "targets":1
								},
				                {
				                    "render": function ( data, type, row ) {
				                    	if(row.state==1){   
				                    		 return "<a   tager='_blank' href='javascript:void(0)' onclick='fun_check("+row.form.id+")'>结账</a>"+
						                        "<a tager='_blank' href='javascript:void(0)' onclick='fun_choose("+row.form.id+")'>点菜 </a>";
				                    	}else{
				                    		 return "<a tager='_blank' href='javascript:void(0)' onclick='fun_open("+row.name+")'>开台</a>";
				                    
				                    	}
				                       
				                    },
				                    "targets":3
				                }
				               
				            ],
        		"initComplete": function () {
        			var api = this.api();
        			$("#_search").on("click", function(){
            		 	api.draw();
        			} );
        		} 
        	 } ).on('preXhr.dt', function ( e, settings, data ) {
		        	return true;
		     } ).on('xhr.dt', function ( e, settings, json, xhr ) {
		    		 $(".dataTables_processing").hide();	
		     } )
        });
    </script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/plugins/spinner/spinner/jquery.spinner.js"></script>
</body>

</html>
