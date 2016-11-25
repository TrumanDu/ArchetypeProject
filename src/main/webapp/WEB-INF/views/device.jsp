<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@include file="common/head.jsp"%>
<body>

    <div id="wrapper">
     <%@include file="common/common.jsp"%>
<div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">设备管理</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default" id="messageId">
                       <c:if test="${message != null}">
								<div class="alert alert-success">
								   <a href="#" class="close" data-dismiss="alert">
								      &times;
								   </a>
								   <strong>提示：</strong>${message}  
								</div>
						</c:if>
                        <div class="panel-heading text-right">
 
                       
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <div class="dataTable_wrapper">
                                <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                    <thead>
                                        <tr>
                                            <th>设备名</th>
                                            <th>操作</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${pageData}" var="device" varStatus="status">
                                        <tr class="odd gradeX">
                                            <td class="text-center">${device.name}</td>
                                            <td class="text-center">
                                             <a class="btn btn-primary" href="#" onclick="updateBefore(${device.id})">设置 </a>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                        
                                    </tbody>
                                </table>
                            </div>
                            
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>

            
                                    <!-- /.row -->
            <div class="row">
                            <!-- Modal -->
                            <div class="modal fade" id="updateModal"  tabindex="-1" role="dialog" aria-labelledby="updateLabel" aria-hidden="true">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                            <h4 class="modal-title" id="updateLabel">设备设置</h4>
                                        </div>
                                         <form role="form" id ="updateForm" action="#" method="post">
                                        <div class="modal-body">                                        
                                        
                                          <input type="hidden" name="id" id="updateID">
                                          <input type="hidden" name="paramnum" id="paramnum">
                                         <div class="form-group" id="deviceName">
                                            <label>设备名:</label>
                                            <input class="form-control"  placeholder="设备名" required  name="name" id="updateName">
                                         </div>
                                         <!-- <div class="row">
                                            <div class="col-lg-6">
	                                            <div class="form-group">
	                                            <label>Host UserName:</label>
	                                            <input class="form-control"  required name="hostUserName" id="updateHostUserName">
	                                             </div>
                                            </div>
                                            <div class="col-lg-6">
	                                            <div class="form-group">
	                                            <label>Host Password:</label>
	                                            <input class="form-control"   name="hostPassword" id="updateHostPassword">
	                                            </div>
                                            </div>
                                         </div>  -->
                                                                                                 
                                        </div>
                                        <div class="modal-footer">
                                            
                                            <button type="button"  class="btn btn-primary" onclick="update()">保存</button>
                                            <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                                        </div>
                                        </form>
                                    </div>
                                    <!-- /.modal-content -->
                                </div>
                                <!-- /.modal-dialog -->
                            </div>
                            <!-- /.modal -->
            </div>
            <!-- /.row -->

        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- Page-Level Demo Scripts - Tables - Use for reference -->
    <script>
    var webSocket =null;
    $(document).ready(function() {
        $('#dataTables-example').DataTable({
                responsive: true,
                "sPaginationType" : "full_numbers",
                "oLanguage" : {
                    "sLengthMenu": "每页显示 _MENU_ 条记录",
                    "sZeroRecords": "抱歉， 没有找到",
                    "sInfo": "从 _START_ 到 _END_ /共 _TOTAL_ 条数据",
                    "sInfoEmpty": "没有数据",
                    "sInfoFiltered": "(从 _MAX_ 条数据中检索)",
                    "sZeroRecords": "没有检索到数据",
                     "sSearch": "名称:",
                    "oPaginate": {
                    "sFirst": "首页",
                    "sPrevious": "前一页",
                    "sNext": "后一页",
                    "sLast": "尾页"
                    }     
                }
        });
        if (!window.WebSocket) { 
            alert("WebSocket not supported by this browser!"); 
        } 
        webSocket = new WebSocket("ws://"+window.location.host +"${pageContext.request.contextPath}/console");
    	webSocket.onerror = function(event) {
    		alert(event);
    	};
    	webSocket.onmessage = function(event) {
    		 console.log('Info: '+event.data);  
    		event.data.split("\n").forEach(function(data){
    			document.getElementById('content').innerHTML += '<div>' + data + "</div>";
    		});
    		//checkScroll();
    	};
    	webSocket.onopen = function(){
    		//webSocket.send("${console}");
    		   console.log('Info: connection opened.');  
    	};
    	
    	webSocket.onclose = function(){
    		console.log('Info: connection closed.');  
    		$(".data-load").addClass("opacity0");
    	};  
    });
    function updateBefore(id){
     $("div").remove(".dynamicParam");	
   	 $.get("${pageContext.request.contextPath}/device/update?id="+id, function(result){
   		    var deviceInfo = result;
   		    $('#updateID').val(deviceInfo.id);
   		    $('#updateName').val(deviceInfo.name);
   		    var paramsData = deviceInfo.param;
   		    var params = paramsData.split(",")
   		    $('#paramnum').val(params.length);
   		    for(var i=0;i<params.length;i++){
   		    	var param = params[i].split(":");
   		    	var div ='<div class="row dynamicParam" ><div class="col-lg-6"><input disabled="disabled" class="form-control" value='+param[0]+' id="paramName'+i+'"></div><div class="col-lg-6"><input value="'+param[1]+'" class="form-control"  required  name="param'+i+'" id="paramValue'+i+'"></div></div>';
   		    	$("#deviceName").after(div);
   		    }
   		     $('#updateModal').modal('show');
   		  },"json");
   }
    function update(){
    	var name = $('#updateName').val();
    	var id = $('#updateID').val();
    	var num = $('#paramnum').val();
    	var param="";
    	for(var i=0;i<num;i++){
    		var paramName = $('#paramName'+i).val();
        	var paramValue = $('#paramValue'+i).val();
        	if(i==0){
        		param=paramName+":"+paramValue;
        	}else{
        		param=param+","+paramName+":"+paramValue;
        	}
        	
    	}
    	$.ajax({
    		url : '${pageContext.request.contextPath}/device/update',
    		type : "POST",
    		dataType : "JSON",
    		data : {
    			"param" : param,"name":name,"id":id
    		},
    		contentType : 'application/x-www-form-urlencoded; charset=UTF-8',
    		xhrFields : {
    			// 设置XMLHttpRequest的其它属性
    			// 如果这里将'withCredentials'设置为true
    			// 则服务器也要相应设置'Access-Control-Allow-Credentials: true'.
    			withCredentials : true
    		},
    		success : function(data) {
    			console.log(data);
    			$("div").remove(".alert");	
    			if(data){
    				$("#messageId").prepend('<div class="alert alert-success"><a href="#" class="close" data-dismiss="alert">&times;</a><strong>提示：</strong>设置成功！ </div>')
    			}else{
    				$("#messageId").prepend('<div class="alert alert-danger"><a href="#" class="close" data-dismiss="alert">&times;</a><strong>提示：</strong>设置失败！ </div>')
    			}
    			$('#updateModal').modal('hide');
    		},
    		error : function(data) {
    			console.log(data);
    		}
    	});
    }
    </script>
</body>

</html>