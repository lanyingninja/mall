<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

	
  <link rel="stylesheet" href="css/1.css" type="text/css"></link>
  
  <script type="text/javascript" src="js/jquery-1.8.3.js"></script>
  
  <script type="text/javascript" src="js/header.js"></script>
  </head>
  
  <body>
     <c:if test="${empty username}">
 	 <script type="text/javascript">
	$(document).ready(function () {
		$("#span4").hide();
	
	});
 </script>
 </c:if>
 <c:if test="${!empty username}">
 <script type="text/javascript">
	$(document).ready(function () {
		$("#span3").hide();
	
	});

 </script>
  </c:if>
  <div style="width: 1349px">
<div id="top">
	<span id="span1"><a href="#">skylake官网</a>|<a href="https://www.taobao.com/">淘宝官网</a>|<a href="https://www.jd.com/">京东商城</a>|<a href="https://www.scut.edu.cn/new/">scut</a></span><span id="span2"><span id="span3"><a href="login.jsp">登录</a> <a href="register.jsp">注册</a></span><span id="span4">欢迎登录！${username}|<a href="UserServlets?opr=exit">退出</a></span>|<a href="CartServlet?opr=list">我的购物车</a></span>
    </div>
  <div id="banner"><img src="img/logo1.png" />
  <form action="GoodsServlet?opr=fuzzy&from=user" method="post">
  <span>
  <input type="text" name="goods" id="input1" value="手机"/>
  <input type="submit" value="搜索" id="input2" />
  </span>
  </form>
  </div>
  <div id="menu">
    <ul>
     <li><a href="#">首页</a></li>
     <li><a href="#">手机</a>
     	 <div class="div" id="div1">
         	<div><a href="GoodsServlet?opr=det&id=10101"><img src="img/xiala1.png" /></a></div>
            <div><a href="GoodsServlet?opr=det&id=10105"><img src="img/xiala2.png" /></a></div>
            <div><a href="GoodsServlet?opr=det&id=10104"><img src="img/xiala5.png" /></a></div>
         
         </div>  
     </li>
     
     <li><a href="#">智能硬件</a>
     	<div class="div" id="div2">
         	<div><a href="#"><img src="img/xiala9.png" /></a></div>
            <div><a href="#"><img src="img/xiala10.png" /></a></div>
            <div><a href="#"><img src="img/xiala8.png" /></a></div>
            <div><a href="#"><img src="img/xiala7.png" /></a></div>
            <div><a href="#"><img src="img/xiala11.png" /></a></div>
            <div><a href="#"><img src="img/xiala12.png" /></a></div>    
         </div>  
     </li>
    
     <li><a href="#">服装</a>
     	 <div class="div" id="div3">
         	<div><a href="GoodsServlet?opr=det&id=12001"><img src="img/xiala22.jpg" /></a></div>
            <div><a href="GoodsServlet?opr=det&id=12002"><img src="img/xiala25.jpg" /></a></div>
            <div><a href="GoodsServlet?opr=det&id=12003"><img src="img/xiala23.jpg" /></a></div>
            <div><a href="GoodsServlet?opr=det&id=12004"><img src="img/xiala24.jpg" /></a></div>        
         </div>  
     </li>
     <li><a href="#">书籍</a>
     	 <div class="div" id="div4">
         </div>  
     </li>
     <li><a href="#">日用品</a>
     	 <div class="div" id="div5">
         	</div>  
     </li>
     
     
    </ul>
  </div>
  </div>
  </body>
</html>
