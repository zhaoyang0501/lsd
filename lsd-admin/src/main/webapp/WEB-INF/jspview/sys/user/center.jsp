<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>
</head>
<body class="fixed-sidebar full-height-layout gray-bg" style="overflow:hidden">
    <div class="wrapper wrapper-content animated fadeInRight">
       <div class="row">
            <div class="col-sm-12">
                <div class="ibox ">
                 
      		 	<div class="ibox-content">
 		 			<div class="row">
                            <div class="col-sm-12 b-r">
                            <form class="form-horizontal" action="" method="get">
		                           <input name='id' type="hidden"/>
		                           	<table class='table table-bordered'>
		                           		<thead>
		                           		<tr style="text-align: center;" ><td colspan="6" ><h3>员工信息<h3></h3></td></tr>
		                           		</thead>
		                           		<tbody>
		                           			<tr>
		                           				<td>姓名</td>
		                           				<td> ${user.chinesename }</td>
		                           			</tr>
		                           			
		                           			<tr>
		                           			<td>性别</td>
		                           				<td>
												  ${user.sex }
		                           				</td>
		                           			</tr>
		                           			
		                           				
		                           			<tr>
		                           				<td>手机号码</td>
		                           				<td> ${user.username }</td>
		                           			</tr>
		                           			
		                           			<tr>
		                           				<td>备用号码</td>
		                           				<td>  ${user.tel }</td>
		                           			</tr>
		                           			
		                           			
		                           			<tr>
		                           				<td>email</td>
		                           				<td>  ${user.email }</td>
		                           			</tr>
		                           			
											<tr>
												<td>责任范围</td>
		                           				<td> ${user.remark }</td>
		                           			</tr>
		                           			
		                           			
		                           		
		                           			
		                           		
		                           			
		                           		</tbody>
		                           	</table>
		                           	</form>
                            </div>
                        </div>
                        </div>
                    
                </div>
            </div>
        </div>
   </div>
 </body>
</html>
