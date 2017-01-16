<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
 <%@include file="common/head.jsp"%>
<body>
    <div id="wrapper">
        <%@include file="common/common.jsp"%>
        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">设备信息</h1>
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
                                            <th>IP</th>
                                            <th>MAC</th>
                                            <th>Port</th>
                                            <th>UID</th>
                                            <th>认证状态</th>
                                            <th>连接状态</th>
                                            <th>工作状态</th>
                                            <th>固件版本</th>
                                            <th>制造商</th>
                                            <th>制造日期</th>
                                            
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
        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->
    <script type="text/javascript">
    $.fn.dataTable.ext.errMode = 'none';
    $(document).ready(function() {
    	var table = $('#dataTables-example').DataTable({
            responsive: true,
            "ajax": "device/list",
            "columns": [
                        { "data": "dEV_NAME"},
                        { "data": "ip_addr"},
                        { "data": "mac_addr"},
                        { "data": "port_number"},
                        { "data": "uid"},
                        { "data": "authenication_state"},
                        { "data": "connected_state"},
                        { "data": "connected_work_state"},
                        { "data": "firmware_ver"},
                        { "data": "manufacture_name"},
                        { "data": "manufacture_date"},
                    ],
             /* "columnDefs": [ {
                "targets": -1,
                "data": "id",
                "render": function ( data, type, full, meta ) {
                  return '<a class="btn btn-primary" href="#" onclick="updateBefore('+data+')">设置 </a>';
                }
              } ],  */
              "createdRow": function ( row, data, index ) {
            	  $('td', row).addClass('text-center');
              },
            "sPaginationType" : "full_numbers",
            "sDefaultContent" :"",
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
    setInterval( function () {
        table.ajax.reload();
    }, 2000 );
    });
    
    </script>
</body>
</html>