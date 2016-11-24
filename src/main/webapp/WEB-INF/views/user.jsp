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
                    <h1 class="page-header">用户列表</h1>
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
                                            <th>用户名</th>
                                            <th>密码</th>
                                            <th>操作</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${pageData}" var="user" varStatus="status">
                                        <tr class="odd gradeX">
                                            <td>${user.userName}</td>
                                            <td>${user.passwd}</td>
                                            <td class="text-center">
                                             <a class="btn btn-primary" href="#" onclick="update(${user.id})">update </a>
                                             &nbsp;&nbsp;&nbsp;&nbsp;
                                            <a class="btn btn-danger" href="${pageContext.request.contextPath}/user/delete?id=${user.id}">delete </a>
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
                                            <h4 class="modal-title" id="myModalLabel">Add New User</h4>
                                        </div>
                                                                              
                                         <form role="form" id ="addForm" action="${pageContext.request.contextPath}/user/add" method="post"  enctype="multipart/form-data" >
                                         <div class="modal-body">  
                                          <div class="form-group">
                                            <label>UserName:</label>
                                            <input class="form-control" placeholder="User Name" required  name="userName" >
                                         </div>
                                           
                                         <div class="form-group">
                                            <label>Password:</label>
                                            <input class="form-control" placeholder="Password"  name="passwd" >
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
                                         <form role="form" id ="updateForm" action="${pageContext.request.contextPath}/user/update" method="post">
                                        <div class="modal-body">                                        
                                        
                                          <input type="hidden" name="id" id="updateID">
                                         <div class="form-group">
                                            <label>UserName:</label>
                                            <input class="form-control" placeholder="User Name" required  name="userName" id="updateName" >
                                         </div>
                                           
                                         <div class="form-group">
                                            <label>Password:</label>
                                            <input class="form-control" placeholder="Password"  name="passwd" id="updatePd">
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
                responsive: true
        });
        
    });
    
    function update(id){
    	 $.get("${pageContext.request.contextPath}/user/update?id="+id, function(result){
    		    var user = result;
    		    $('#updateID').val(user.id);
    		    $('#updateName').val(user.userName);
    		    $('#updatePd').val(user.passwd);
    		   
    		    $('#updateModal').modal('show');
    		  },"json");
    }
 
    </script>
</body>

</html>