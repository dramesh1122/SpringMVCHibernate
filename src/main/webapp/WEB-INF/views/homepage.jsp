<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
       <link href="resources/css/homepage.css" rel="stylesheet" type="text/css"/> 
   
  </head>
<body>

<div  class="topnav">
   <a href="registrationpage"><b>SIGNUP</b></a>
   <a href="loginpage"><b>SIGNIN</b></a>
   <a href="persons"><b>HELP/SUPPORT</b></a>
</div>

<div class="navbar">
   <img alt="logo" src="resources/img/logo.jpg" width="12%" height="8%" align="left">
	<c:forEach var="entry" items="${categories}">
		<div class="dropdown">
			<button class="dropbtn">
				${entry.key.name}<i class="fa fa-caret-down"></i>
			</button>
			<div class="dropdown-content">
				<div class="row">
				<c:forEach var="subcategory" items="${entry.value}">
					<div class="column">
						<h3>${subcategory.key.name}</h3>
                        <c:forEach var="supersubcategory" items="${subcategory.value}">
						<a href="categorypage/${supersubcategory.id}">${supersubcategory.name}</a>
						</c:forEach>

					</div>
			    </c:forEach>

				</div>
			</div>
       
		</div>
 </c:forEach>


		<!-- HTML for SEARCH BAR -->
	<div>
		<form id="searchbox" method="get" action="#">
		        <input type="text" class="inputtext" name="q" size="50" maxlength="120" placeholder="Search.....">
		        <input type="submit" value="search" class="tfbutton">
		</form>
	</div>


   
</div>

		<!-- <div id="header">Header</div> -->
		<div id="sidebar-left"><img alt="saree" src="resources/img/saree.jpg" width="220" height="630"></div>
		<div id="main">Main  
    </div>
		<div id="sidebar-right"><img alt="saree" src="resources/img/kurti.jpg" width="220" height="630"></div>
		<div id="footer">Footer</div>
		
		<!-- Scripts -->
<script>
 window.onscroll = function() {myFunction()};
 
  var navbar = document.getElementById("navbar");
  var sticky = navbar.offsetTop;

  function myFunction() {
   if (window.pageYOffset >= sticky) {
     navbar.classList.add("sticky")
   } else {
     navbar.classList.remove("sticky");
   }
 }
</script>
	</body>
</html>