<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
<link href="${pageContext.request.contextPath}/css/plugins/webuploader/webuploader.css" rel="stylesheet">
</head>
<body>
	<div class="wrapper wrapper-content animated fadeInRight">
		<div class="row">
			<div class="col-sm-12">
				<div class="ibox ">
					<div class="ibox-title">
						<h5>商品管理</h5>
						<div class="ibox-tools"></div>
					</div>

					<div class="ibox-content">
						<form role="form" class="form-inline">
							<div class="form-group">
								<label for="exampleInputEmail2" class="sr-only">名称</label> <input
									type="text" placeholder="名称" id="_name" class="form-control">
							</div>
							<button class="btn btn-primary" type="button" id='_search'>查询</button>
							<button class="btn btn-primary" type="button" id='_new'>新建</button>
						</form>
					</div>

					<div class="ibox-content ">
						<table ID='dt_table_view'
							class="table table-striped table-bordered table-hover ">
							<thead>
								<tr>
									<th>图片</th>
									<th>商品</th>
									<th>分类</th>
									<th>价格</th>
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

	<div id='_form' style="margin-top: 30000px " >
		<div class="ibox-content" >
			<div class="row">
				<div class="col-sm-12 b-r">
					<form class="form-horizontal" action="" method="get">
						<input name='id' type="hidden" />
						<table class='table table-bordered'>
							<thead>
								<tr style="text-align: center;">
									<td colspan="6"><h3>商品信息</h3></td>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>名称</td>
									<td><input name='name' type="text" class="form-control"></td>
								</tr>
								
								<tr>
									<td>分类</td>
									<td>
										<select name='foodCategory.id' class='form-control'>
									 			<c:forEach var="bean" items="${categorys}">
									 				<option value="${bean.id }">${bean.name }</option>
									 			</c:forEach>
									 	</select>
									 </td>
								</tr>
								
								<tr>
									<td>价格</td>
									<td><input name='price' type="text" class="form-control"></td>
								</tr>
								
								
								<tr>
									<td>照片</td>
									<td> 
										  <div id="uploader" >
							                        <div class="container-fluid">
														  <div id="thelist" class="row ">
														  </div>
														</div>
													    	
													    	<div class="row">
													    		<div class="col-xs-12">
													    			<div id="picker">选择文件</div>
													    		</div>
													    	</div>
													</div>
									</td>
								</tr>

								<tr>
									<td>描述</td>
									<td><textarea name='remark' rows="4" cols=""
											style="width: 80%"></textarea></td>
								</tr>

								<tr>
									<td colspan="6">
										<div class="col-sm-4 col-sm-offset-2">
											<button class="btn btn-primary" type="button"
												onclick="submit_form()">提交</button>
											<button class="btn btn-white" type="submit">取消</button>
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
    
    function submit_form(){
    	$.ajax({
    		   type: "POST",
    		   url:  $.common.getContextPath() + "/sys/food/save",
    		   data: $("form").serialize(),
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
    	layer.confirm('确定删除当前商品？', {
    		  btn: ['确定','取消'] //按钮
    		}, function(){
    			$.ajax({
    		 		   url:  $.common.getContextPath() + "/sys/food/delete?id="+id,
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
    
    function fun_update(id){
    	$.ajax({
 		   url:  $.common.getContextPath() + "/sys/food/get?id="+id,
 		   success: function(msg){
 		     if(msg.code==1){
 		    	$("input[name='id']").val(msg.datas.id);
 		    	$("input[name='name']").val(msg.datas.name);
 		    	$("input[name='foodCategory.id']").val(msg.datas.foodCategory.id);
 		    	$("input[name='price']").val(msg.datas.price);
 				$("textarea[name='remark']").val(msg.datas.remark);
 				  $("#thelist").empty();
        		layer.open({
        			  type: 1,
        			  skin: 'layui-layer-rim', //加上边框
        			  content: $("#_form"),
        			  area: "800px"
        			});
        		$("#_form").css("margin-top","0px");
 		     }
 		   }
 		});
     }
    var uploader=null;
    $(document).ready(function(){
    	var uploader = WebUploader.create({
    		auto:true,
    	    server: '${pageContext.request.contextPath}/fileupload/upload',
    	    pick: '#picker',
    	    resize: false
    	});
    	
    	uploader.on( 'fileQueued', function( file ) {
    		
    		 var $li = $(
    		            '<div id="' + file.id + '" class="col-xs-12 col-sm-2 file-item thumbnail">' +
    		                '<img>' +
    		                '<div class="info">' + file.name + '</div>' +
    		                '<p class="state">等待上传...</p>' +
    		     	       ' <input type="hidden" name="img" value=""/>'+
    		            '</div>'
    		            ),
    		        $img = $li.find('img');
    		    $("#thelist").append( $li );
    		
    		    uploader.makeThumb( file, function( error, src ) {
    		        if ( error ) {
    		            $img.replaceWith('<span>不能预览</span>');
    		            return;
    		        }

    		        $img.attr( 'src', src );
    		    }, 100, 100 );
    	});
    	uploader.on( 'uploadSuccess',  function(file, data){
    		 $( '#'+file.id ).find('p.state').text('已上传');
    		 $( '#'+file.id ).find("input").val(data.datas.filepath);
    		    return false;
		});

    	uploader.on( 'uploadError', function( file ) {
    	    $( '#'+file.id ).find('p.state').text('上传出错');
    	});

    	uploader.on( 'uploadComplete', function( file ) {
    	    $( '#'+file.id ).find('.progress').fadeOut();
    	});
    	
    	 $("#submitfile").on( 'click', function() {
    		 uploader.upload();
    	  });
    	
        	$("#_new").click(function(){
        		$("input[name='id']").val("");
 		    	$("input[name='name']").val("");
 		    	$("radio[name='sex']").val("");
 		   		$("input[name='price']").val("");
 				$("textarea[name='remark']").val("");
 				uploader.reset();
 				  $("#thelist").empty();
        		layer.open({
        			  type: 1,
        			  skin: 'layui-layer-rim', //加上边框
        			  content: $("#_form"),
        			  area: "800px"
        			});
        		$("#_form").css("margin-top","0px");
        	});
        	table=$('#dt_table_view').DataTable( {
        		"dom": "rt<'row'<'col-sm-5'i><'col-sm-7'p>>",
	            "ajax": {
	                "url":  $.common.getContextPath() + "/sys/food/list",
	                "type": "POST",
	                "dataSrc": "datas"
	              },
				"columns" : [{
					"data" : "img"
				}, {
					"data" : "name"
				},{
					"data" : "foodCategory.name",
				},{
					"data" : "price",
				},{
					"data" : "id",
				}] ,
				 "columnDefs": [
				                

								{
								    "render": function ( data, type, row ) {
								        return "<img alt='image' style='    height: 50px;' class='img-circle'  src='${pageContext.request.contextPath}/upload/"+data+"'>";
								    },
								    "targets":0
								}, 
				                {
				                    "render": function ( data, type, row ) {
				                        return "<a tager='_blank' href='javascript:void(0)' onclick='fun_delete("+data+")'>删除 </a>"+
				                        "<a tager='_blank' href='javascript:void(0)' onclick='fun_update("+data+")'>编辑 </a>";
				                    },
				                    "targets":4
				                }
				               
				            ],
        		"initComplete": function () {
        			var api = this.api();
        			$("#_search").on("click", function(){
            		 	api.draw();
        			} );
        		} 
        	 } ).on('preXhr.dt', function ( e, settings, data ) {
		        	data.value = $("#_name").val();
		        	data.columnname = 'name';
		        	return true;
		     } ).on('xhr.dt', function ( e, settings, json, xhr ) {
		    		 $(".dataTables_processing").hide();	
		     } )
        });
    </script>
	<script src="${pageContext.request.contextPath}/plugins/webuploader/webuploader.js "></script>

</body>

</html>
