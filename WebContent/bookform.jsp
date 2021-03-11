<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	    pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>

<core:if test="${action==null }">
	<core:set var="action" value="Add" scope="request"/>
</core:if>


	<jsp:include page="header.jsp"/>
	<jsp:include page="leftmenu.jsp"/>
        
        
        <div id="templatemo_content_right">
       	 	<h1>Book Form</h1>
       	 	<h2>
       			<span style="color:green">${msg}</span>
       			<span style="color:red">${erorrmsg}</span>
       		</h2>
       		<h3>${action} Book Here</h3>
        	<form action="bookC" method="post">
        		<input type="hidden" name="action" value="${action}">
        		<table class="table table-bordered w-75 m-auto">
        		
        		<core:if test="${action=='Update'}">
        			<tr>
        				<th><label class="text-white" for="bookId">Id</label></th>
        				<td><input class="form-control" type="text" name="bookId" value="${bookObj.bookId}" readonly></td>
        			</tr>
        		</core:if>
        			<tr>
        				<th><label class="text-white" for="bookName">Name</label></th>
        				<td><input class="form-control" type="text" name="bookName" value="${bookObj.bookName}"></td>
        			</tr>
        			<tr>
        				<th><label class="text-white" for="bookPublisher">Publisher</label></th>
        				<td><input class="form-control" type="text" name="bookPublisher" value="${bookObj.bookPublisher}"></td>
        			</tr>
        			<tr>
        				<th><label class="text-white" for="bookAuthor">Author</label></th>
        				<td><input class="form-control" type="text" name="bookAuthor" value="${bookObj.bookAuthor}"></td>
        			</tr>
        			<tr>
        				<th><label class="text-white" for="bookPrice">Price</label></th>
        				<td><input class="form-control" type="text" name="bookPrice" value="${bookObj.bookPrice}"></td>
        			</tr>
        			<tr>
        				<th><label class="text-white" for="bookDescription">Description</label></th>
        				<td><input class="form-control" type="text" name="bookDescription" value="${bookObj.bookDescription}"></td>
        			</tr>
        			<tr>
        				<td align="right" colspan="2">
        					<input class="btn btn-success" type="submit" value="${action}">
        					<input class="btn btn-warning" type="reset" value="Clear">
        				</td>
        			</tr>
        		</table>
        	</form>
        
       
            <div class="cleaner_with_height">&nbsp;</div>
            
            <a href="subpage.html"><img src="images/templatemo_ads.jpg" alt="ads" /></a>
        </div> <!-- end of content right -->
    
   
   
   <jsp:include page="footer.jsp"/>