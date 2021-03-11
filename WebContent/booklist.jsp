<%@page import="com.shashank.bookstore.pojo.Book"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>

	<jsp:include page="header.jsp"/>
	<jsp:include page="leftmenu.jsp"/>
        
        
        <div id="templatemo_content_right">
       		
       		<%-- <%
       			List<Book> booklist = (List<Book>)session.getAttribute("booklist");
       		%>  --%>
       		<!--  without getting explicitly or to remove Scriptlet implementation we 
       				suppose to use JSTL   -->
       				
       	<core:if test="${!booklist.isEmpty()}">
       		<h1>Book List</h1>
       		<h2>
       			<span style="color:green">${msg}</span>
       			<span style="color:red">${erorrmsg}</span>
       		</h2>
       		<table class="table table-hover table-dark" border="1" >
       			<thead>
       				<tr>
       					<th>Id</th>
       					<th>Name</th>
       					<th>Publisher</th>
       					<th>Author</th>
       					<th>Price</th>
       					<th>Description</th>
       					<th colspan="3">Action</th>
       				</tr>
       			</thead>
       			<tbody>
       				<core:forEach var="book" items="${booklist}">
       				<tr>
       					<td>${book.bookId }</td>
       					<td>${book.bookName }</td>
       					<td>${book.bookPublisher }</td>
       					<td>${book.bookAuthor }</td>
       					<td>${book.bookPrice }</td>
       					<td>${book.bookDescription }</td>
       					<td><a class="btn btn-primary" href="cartC?action=addtocart&bookId=${book.bookId}">Add To Cart</a></td>
       				<core:if test="${admin!=null }">
       					<td><a onclick="return confirm('Do you want to delete book ?')" class="btn btn-danger text-white"  href="bookC?action=delete&bookId=${book.bookId}">Delete</a></td>
       					<td><a class="btn btn-warning text-white" href="bookC?action=edit&bookId=${book.bookId}">Edit</a></td>
       				</core:if>
       				</tr>
       				</core:forEach>
       			</tbody>
       		</table>
       	</core:if>
       	<core:if test="${  booklist.isEmpty()}">
       		<h3>No Books Found</h3>
       	</core:if>
            <div class="cleaner_with_height">&nbsp;</div>
            
            <a href="subpage.html"><img src="images/templatemo_ads.jpg" alt="ads" /></a>
        </div> <!-- end of content right -->
    
   
   
   <jsp:include page="footer.jsp"/>