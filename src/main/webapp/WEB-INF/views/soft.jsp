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
                    <h1 class="page-header">Soft List</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                       <c:if test="${message != null}">
								<div class="alert alert-success">
								   <a href="#" class="close" data-dismiss="alert">
								      &times;
								   </a>
								   <strong>提示：</strong>${message}  
								</div>
						</c:if>
                        <div class="panel-heading text-right">
 
                        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal">Add</button>
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <div class="dataTable_wrapper">
                                <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                    <thead>
                                        <tr>
                                            <th>软件名称</th>
                                            
                                            <th>操作</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${pageData}" var="soft" varStatus="status">
                                        <tr class="odd gradeX">
                                            <td>${soft.name}</td>
                                            
                                            <td class="text-center">
                                             <a class="btn btn-primary" href="#" onclick="update(${soft.id})">Update </a>
                                             &nbsp;&nbsp;&nbsp;&nbsp;
                                            <a class="btn btn-danger" href="#" onclick="dele(${soft.id})">Delete </a>
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
                            <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                            <h4 class="modal-title" id="myModalLabel">Add New Soft</h4>
                                        </div>
                                                                              
                                         <form role="form" id ="addForm" action="${pageContext.request.contextPath}/soft/add" method="post"  enctype="multipart/form-data" >
                                         <div class="modal-body">  
                                          <div class="form-group">
                                            <label>Name:</label>
                                            <input class="form-control" placeholder="Soft Name" required  name="name" >
                                         </div>
                                         
                                         <div class="row">
                                            <div class="col-lg-6">
	                                            <div class="form-group">
	                                            <label>Host UserName:</label>
	                                            <input class="form-control" placeholder="Host UserName" required name="hostUserName">
	                                             </div>
                                            </div>
                                            <div class="col-lg-6">
	                                            <div class="form-group">
	                                            <label>Host Password:</label>
	                                            <input class="form-control"  placeholder="Host Password"  name="hostPassword">
	                                            </div>
                                            </div>
                                         </div>   
                                         
                                         
                                           <div class="form-group">
                                           <label>Start Script:</label>
                                           <textarea class="form-control" rows="3"  name="startScript"></textarea>
                                            </div>
                                          
                                           <div class="form-group">
                                           <label>Stop Script:</label>
                                            <textarea class="form-control" rows="3"  name="stopScript"></textarea>
                                           </div>
                                        
                                        <div class="form-group">
                                            <label>Host IP:</label>
                                            <textarea class="form-control" rows="3"  name="hostIPs"></textarea>
                                        </div> 

                                    
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                            <button type="submit"  class="btn btn-primary">Save changes</button>
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
            
                                    <!-- /.row -->
            <div class="row">
                            <!-- Modal -->
                            <div class="modal fade" id="updateModal"  tabindex="-1" role="dialog" aria-labelledby="updateLabel" aria-hidden="true">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                            <h4 class="modal-title" id="updateLabel">Update Soft</h4>
                                        </div>
                                         <form role="form" id ="updateForm" action="${pageContext.request.contextPath}/soft/update" method="post">
                                        <div class="modal-body">                                        
                                        
                                          <input type="hidden" name="id" id="updateID">
                                         <div class="form-group">
                                            <label>Name:</label>
                                            <input class="form-control" placeholder="Soft Name" required  name="name" id="updateName">
                                         </div>
                                         
                                         <div class="row">
                                            <div class="col-lg-6">
	                                            <div class="form-group">
	                                            <label>Host UserName:</label>
	                                            <input class="form-control" placeholder="Host UserName" required name="hostUserName" id="updateHostUserName">
	                                             </div>
                                            </div>
                                            <div class="col-lg-6">
	                                            <div class="form-group">
	                                            <label>Host Password:</label>
	                                            <input class="form-control"  placeholder="Host Password"  name="hostPassword" id="updateHostPassword">
	                                            </div>
                                            </div>
                                         </div>   
                                        
                                         
                                           <div class="form-group">
                                           <label>Start Script:</label>
                                           <textarea class="form-control" rows="3"  name="startScript" id="updateStartScript"></textarea>
                                            </div>
                                          
                                           <div class="form-group">
                                           <label>Stop Script:</label>
                                            <textarea class="form-control" rows="3"  name="stopScript" id="updateStopScript"></textarea>
                                           </div>
                                        
                                        <div class="form-group">
                                            <label>Host IP:</label>
                                            <textarea class="form-control" rows="3"  name="hostIPs" id="updateHostIPs"></textarea>
                                        </div>

                                    
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                            <button type="submit"  class="btn btn-primary">Save changes</button>
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