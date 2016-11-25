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
                    <h1 class="page-header">文件列表</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading text-right">
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <div class="dataTable_wrapper">
                                <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                    <thead>
                                        <tr>
                                            <th>文件名</th>
                                            
                                            <th>创建时间</th>
                                            
                                            <th>文件大小(Byte)</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${pageData}" var="file" varStatus="status">
                                        <tr class="odd gradeX">
                                            <td>${file.name}</td>
                                            <td>${file.createDate}</td>
                                            <td>${file.fileSize}</td> 
                                           
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
    
    function update(id){
    	 $.get("${pageContext.request.contextPath}/soft/update?id="+id, function(result){
    		    var softInfo = result;
    		    $('#updateID').val(softInfo.id);
    		    $('#updateName').val(softInfo.name);
    		    $('#updateHostUserName').val(softInfo.hostUserName);
    		    $('#updateHostPassword').val(softInfo.hostPassword);
    		   
    		    $('#updateStartScript').val(softInfo.startScript);
    		    $('#updateStopScript').val(softInfo.stopScript);
    		  
    		    $('#updateHostIPs').val(softInfo.hostIPs);
    		    $('#updateModal').modal('show');
    		  },"json");
    }
    
    
    function dele(id){
    	bootbox.confirm("Are you want to delete?", function(result) {
  		  if(result){
  			window.location.href="${pageContext.request.contextPath}/soft/delete?id="+id;
  		  }
  		}); 
    }
    </script>
</body>

</html>