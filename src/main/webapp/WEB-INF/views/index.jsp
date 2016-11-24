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
                    <h1 class="page-header">Dashboard</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <div class="row">
                <div class="col-lg-12 text-center">
                <h3>${sessionScope.userInfo.userName} Welcome  to ArchetypeProject</h3>
                </div> 
            </div>   
        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->
</body>
</html>