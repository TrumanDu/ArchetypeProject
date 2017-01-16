<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="cn">
    <%@include file="common/head.jsp"%>
<body >
<img src="images/bg.jpg" width="100%" height="100%" style="position:absolute;top:0;left:0;right:100;bottom:500;z-index:-1" />
 <div class="container" id="bg">
        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <div class="login-panel panel panel-default">
                    <div class="panel-heading text-center">
                        <h1 class="panel-title">XXX接入单元</h1>
                    </div>
                    <div class="panel-body">
                        <form role="form" action="${pageContext.request.contextPath}/login" method="post">
                            <fieldset>
                                <div class="form-group">
                                    <input class="form-control" placeholder="Account" name="userName" type="account" autofocus>
                                </div>
                                <div class="form-group">
                                    <input class="form-control" placeholder="Password" name="passwd" type="password" value="">
                                </div>
                                <div class="checkbox">
                                    <label>
                                        <input name="remember" type="checkbox" value="Remember Me">Remember Me
                                    </label>
                                </div>
                                <!-- Change this to a button or input when using this as a form -->
                                <button onclick="$('form').submit()" class="btn btn-lg btn-success btn-block">Login</button>
                            </fieldset>
                        </form>
                    </div>
                    <c:if test="${message != null}">
								<div class="alert alert-danger">
								   <a href="#" class="close" data-dismiss="alert">
								      &times;
								   </a>
								   <strong>提示：</strong>${message}  
								</div>
				   </c:if>
                </div>
            </div>
        </div>
    </div>
</body>

</html>