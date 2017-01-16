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
                        <div class="panel-heading text-left">
                          
                       <a class="btn btn-primary" href="#" onclick="updateBefore()">参数管理</a>&nbsp;&nbsp;<a class="btn btn-info" href="#" onclick="authenication()">认证</a>&nbsp;&nbsp;<a class="btn btn-warning" href="#" onclick="reboot()">重启</a>&nbsp;&nbsp;<a class="btn btn-danger" href="#" onclick="reset()">恢复出厂设置</a>&nbsp;&nbsp;<a class="btn btn-success" href="#" onclick="updateFirmware()">软件升级</a>
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <div class="dataTable_wrapper">
                                <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                    <thead>
                                        <tr>
                                            <th>选择</th>
                                            <th>设备名</th>
                                            <th>IP</th>
                                            <th>MAC</th>
                                            <th>Port</th>
                                            <th>UID</th>
                                           <!--  <th>认证状态</th>
                                            <th>连接状态</th>
                                            <th>工作状态</th>
                                            <th>固件版本</th> -->
                                            <!-- <th>制造商</th>
                                            <th>制造日期</th> -->
                                            <!-- <th >操作</th> -->
                                        </tr>
                                    </thead>
                                    
                                    <%-- <tbody>
                                    <c:forEach items="${pageData}" var="device" varStatus="status">
                                        <tr class="odd gradeX">
                                            <td class="text-center">${device.name}</td>
                                            <td class="text-center">
                                             <a class="btn btn-primary" href="#" onclick="updateBefore(${device.id})">设置 </a>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                        
                                    </tbody> --%>
                 
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
                                          <!-- <input type="hidden" name="paramnum" id="paramnum">
                                         <div class="form-group" id="deviceName">
                                            <label>设备名:</label>
                                            <input class="form-control"  placeholder="设备名" required  name="name" id="updateName">
                                         </div> -->
                                         <div class="row">
                                            <div class="col-lg-6">
	                                            <div class="form-group">
	                                            <label>天线1</label>
	                                            <input class="form-control"  required name="param1" id="param1">
	                                             </div>
                                            </div>
                                            <div class="col-lg-6">
	                                            <div class="form-group">
	                                            <label>天线2</label>
	                                            <input class="form-control"   name="param2" id="param2">
	                                            </div>
                                            </div>
                                         </div>
                                         <div class="row">
                                            <div class="col-lg-6">
	                                            <div class="form-group">
	                                            <label>天线3</label>
	                                            <input class="form-control"  required name="param3" id="param3">
	                                             </div>
                                            </div>
                                            <div class="col-lg-6">
	                                            <div class="form-group">
	                                            <label>天线4</label>
	                                            <input class="form-control"   name="param4" id="param4">
	                                            </div>
                                            </div>
                                         </div>
                                         <div class="row">
                                            <div class="col-lg-6">
	                                            <div class="form-group">
	                                            <label>事件触发周期(秒)</label>
	                                            <input class="form-control"  required name="param5" id="param5">
	                                             </div>
                                            </div>
                                            <div class="col-lg-6">
	                                            <div class="form-group">
	                                            <label>用户自定义数据</label>
	                                            <input class="form-control"   name="param6" id="param6">
	                                            </div>
                                            </div>
                                         </div>
                                                                                                 
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
    var flag =true;
    var savemac="";
    $(document).ready(function() {
    	var table = $('#dataTables-example').DataTable({
            responsive: true,
            "ajax": "device/list",
            "columns": [
                        { "data": null},
                        { "data": "dEV_NAME"},
                        { "data": "ip_addr"},
                        { "data": "mac_addr"},
                        { "data": "port_number"},
                        { "data": "uid"},
                        /* { "data": "authenication_state"},
                        { "data": "connected_state"},
                        { "data": "connected_work_state"},
                        { "data": "firmware_ver"}, */
                        /* { "data": "manufacture_name"},
                        { "data": "manufacture_date"}, */
                    ],
             "columnDefs": [ /* {
                "targets": -1,
                "data": "mac_addr",
                "render": function ( data, type, full, meta ) {
                	
                  return '<a class="btn btn-primary" href="#" onclick="updateBefore(\''+data.mac_addr+'\')">参数管理</a>&nbsp;&nbsp;<a class="btn btn-info" href="#" onclick="authenication(\''+data.mac_addr+'\')">认证</a>&nbsp;&nbsp;<a class="btn btn-warning" href="#" onclick="reboot(\''+data.mac_addr+'\')">重启</a>&nbsp;&nbsp;<a class="btn btn-danger" href="#" onclick="reset(\''+data.mac_addr+'\')">恢复出厂设置</a><a class="btn btn-success" href="#" onclick="updateFirmware(\''+data.mac_addr+'\')">软件升级</a>';
                }
              } , */
              {
                  "targets": 0,
                  "data": "null",
                  "render": function ( data, type, full, meta ) {
                  	if(savemac!=""&&savemac==data.mac_addr){
                  		 return '<input type="radio" name="selecteMac"  checked="checked" onclick="selectSave(\''+data.mac_addr+'\')">';
          			}else{
          				 return '<input type="radio" name="selecteMac"  onclick="selectSave(\''+data.mac_addr+'\')">';
          			}
                   
                  }
                }], 
              "createdRow": function ( row, data, index ) {
            	 //$('td', row).addClass('text-center');
              },
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
    intervalId=setInterval( function () {
    	table.ajax.reload();
    }, 2000);
       /* if (!window.WebSocket) { 
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
    	};  */ 
    });
    function updateBefore(id){
     //$("div").remove(".dynamicParam");	
    	$('#updateID').val(savemac);
        $('#updateModal').modal('show');
        flag=false;
        
   }
    function update(){
    	var name = $('#updateName').val();
    	var id = $('#updateID').val();
    	var param1 = $('#param1').val();
    	var param2 = $('#param2').val();
    	var param3 = $('#param3').val();
    	var param4 = $('#param4').val();
    	var param5 = $('#param5').val();
    	var param6 = $('#param6').val();
    	/* if(typeof param1 =="undefined"){
    		param1="";
    	} */
    	param = id+","+param1+","+param2+","+param3+","+param4+","+param6+","+param5
    	$.ajax({
    		url : '${pageContext.request.contextPath}/device/update',
    		type : "POST",
    		dataType : "JSON",
    		data : {
    			"param" : param
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
    
    function authenication(mac){
    	console.log(savemac);
    	$.ajax({
    		url : '${pageContext.request.contextPath}/device/authenication',
    		type : "POST",
    		dataType : "JSON",
    		data : {
    			"mac" : savemac
    		},
    		contentType : 'application/x-www-form-urlencoded; charset=UTF-8',
    		xhrFields : {
    			withCredentials : true
    		},
    		success : function(data) {
    			console.log(data);
    			$("div").remove(".alert");	
    			if(data){
    				$("#messageId").prepend('<div class="alert alert-success"><a href="#" class="close" data-dismiss="alert">&times;</a><strong>提示：</strong>认证成功！ </div>')
    			}else{
    				$("#messageId").prepend('<div class="alert alert-danger"><a href="#" class="close" data-dismiss="alert">&times;</a><strong>提示：</strong>认证失败！ </div>')
    			}
    			$('#updateModal').modal('hide');
    		},
    		error : function(data) {
    			console.log(data);
    		}
    	});
    }
    function reboot(mac){
    	$.ajax({
    		url : '${pageContext.request.contextPath}/device/reboot',
    		type : "POST",
    		dataType : "JSON",
    		data : {
    			"mac" : savemac
    		},
    		contentType : 'application/x-www-form-urlencoded; charset=UTF-8',
    		xhrFields : {
    			withCredentials : true
    		},
    		success : function(data) {
    			console.log(data);
    			$("div").remove(".alert");	
    			if(data){
    				$("#messageId").prepend('<div class="alert alert-success"><a href="#" class="close" data-dismiss="alert">&times;</a><strong>提示：</strong>重启成功！ </div>')
    			}else{
    				$("#messageId").prepend('<div class="alert alert-danger"><a href="#" class="close" data-dismiss="alert">&times;</a><strong>提示：</strong>重启失败！ </div>')
    			}
    			$('#updateModal').modal('hide');
    		},
    		error : function(data) {
    			console.log(data);
    		}
    	});
    }
    function reset(mac){
    	$.ajax({
    		url : '${pageContext.request.contextPath}/device/reset',
    		type : "POST",
    		dataType : "JSON",
    		data : {
    			"mac" : savemac
    		},
    		contentType : 'application/x-www-form-urlencoded; charset=UTF-8',
    		xhrFields : {
    			withCredentials : true
    		},
    		success : function(data) {
    			console.log(data);
    			$("div").remove(".alert");	
    			if(data){
    				$("#messageId").prepend('<div class="alert alert-success"><a href="#" class="close" data-dismiss="alert">&times;</a><strong>提示：</strong>恢复出厂设置成功！ </div>')
    			}else{
    				$("#messageId").prepend('<div class="alert alert-danger"><a href="#" class="close" data-dismiss="alert">&times;</a><strong>提示：</strong>恢复出厂设置失败！ </div>')
    			}
    			$('#updateModal').modal('hide');
    		},
    		error : function(data) {
    			console.log(data);
    		}
    	});
    }
    function updateFirmware(mac){
    	$.ajax({
    		url : '${pageContext.request.contextPath}/device/updateFirmware',
    		type : "POST",
    		dataType : "JSON",
    		data : {
    			"mac" : savemac
    		},
    		contentType : 'application/x-www-form-urlencoded; charset=UTF-8',
    		xhrFields : {
    			withCredentials : true
    		},
    		success : function(data) {
    			console.log(data);
    			$("div").remove(".alert");	
    			if(data){
    				$("#messageId").prepend('<div class="alert alert-success"><a href="#" class="close" data-dismiss="alert">&times;</a><strong>提示：</strong>升级成功！ </div>')
    			}else{
    				$("#messageId").prepend('<div class="alert alert-danger"><a href="#" class="close" data-dismiss="alert">&times;</a><strong>提示：</strong>升级失败！ </div>')
    			}
    			$('#updateModal').modal('hide');
    		},
    		error : function(data) {
    			console.log(data);
    		}
    	});
    }
    
    function selectSave(mac){
    	savemac=mac;
    }
    </script>
</body>

</html>