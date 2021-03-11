<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Online Book Store </title>
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />
<script src="js/jquery.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.2/jquery.validate.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<div id="templatemo_container">
	<div id="templatemo_menu">
    	<ul>
            <li><a href="index.jsp" class="current">Home</a></li>
            <li><a href="subpage.html">Search</a></li>
            <li><a  href="bookC?action=showlist">Books</a></li> 
            
        <!--  Admin Controls  -->  
		<core:if test="${admin!=null }">
            <li><a href="bookform.jsp">Add Book</a></li>
            <li><a href="orderC?action=showallorders">All Orders</a></li>
            <li><a href="changepasswordform.jsp">Change Password</a></li>
        </core:if>
        
       <!-- Customer Controls -->
      <core:if test="${customer!=null }">
            <li><a href="customerC?action=showprofile">Profile</a></li>
            <li><a href="cartC?action=showmycart">My Cart</a></li>
            <li><a href="orderC?action=showmyorders">My Orders</a></li>
        </core:if>
      <!--  with any any login controls -->  
        <core:if test="${admin==null && customer==null }">  
            <li><a href="customerform.jsp">Register</a></li> 
            <li><a href="login.jsp">login</a></li>
        </core:if>
            <li><a href="#">Contact</a></li>
            
        <!-- either one of login of customer or admin -->    
        <core:if test="${admin!=null || customer!=null }"> 
            <li><a href="loginC?action=logout" title="${admin} ${customer}">logout</a></li>
        </core:if>
    	</ul>
    </div> <!-- end of menu -->
    
    <div id="templatemo_header">
    	<div id="templatemo_special_offers">
        	<p>
                <span>25%</span> discounts for
        purchase over $80
        	</p>
			<a href="subpage.html" style="margin-left: 50px;">Read more...</a>
        </div>
        
        
        <div id="templatemo_new_books">
        	<ul>
                <li>Suspen disse</li>
                <li>Maece nas metus</li>
                <li>In sed risus ac feli</li>
            </ul>
            <a href="subpage.html" style="margin-left: 50px;">Read more...</a>
        </div>
    </div> <!-- end of header -->
    
    <div id="templatemo_content">