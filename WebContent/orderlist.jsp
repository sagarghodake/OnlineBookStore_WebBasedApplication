<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
	<jsp:include page="header.jsp"/>
	<jsp:include page="leftmenu.jsp"/>
        
        
        <div id="templatemo_content_right">
        	<core:if test="${admin!=null }"> <h1 title="${admin }">All Order's</h1>  </core:if>
       		<core:if test="${customer!=null }"> <h1 title="${customer}">My Order's</h1>  </core:if>
        	
       	 	<h2>
       			<span style="color:green">${msg}</span>
       			<span style="color:red">${erorrmsg}</span>
       		</h2>
       	<core:if test="${!orderlist.isEmpty()}">
        	<table class="table table-hover table-dark" style="width: 738px;" border="1">
        		<thead>
        			<tr>
        				<th rowspan="2">Id</th>
        				<core:if test="${admin!=null }"><th rowspan="2">Customer Email Id</th></core:if>
        				<th >Details</th>
        				<th rowspan="2">Total Price</th>
        				<th rowspan="2">Date</th>
        				<th rowspan="2">Status</th>
        				<th rowspan="2">Action</th>
        			</tr>
        				<tr>
        					<td>Name - Quantity - Price</td>
        			</tr>
        		</thead>
        		<tbody>
        			<core:forEach var="order" items="${orderlist}">
        				<tr>
        					<td >${order.orderId }</td>
        					<core:if test="${admin!=null }"><td>${order.custEmailId }</td></core:if>
        					<td>
        					<core:forEach var="cart" items="${order.orderedCartItems }">
	        					<table>
	        						<tr>
	        							<td>
			        						${cart.book.bookName}
			        					</td>
			        					<td>
			        						${cart.cartQuantity}
			        					</td>
			        					<td>
			        						<fmt:formatNumber value="${cart.book.bookPrice }" type="currency" currencySymbol="&#8377;"/>
			        					</td>
	        						</tr>
	        					</table>
        					</core:forEach>
        					</td>
        					<td> <fmt:formatNumber value="${order.totalAmount}" type="currency" currencySymbol="&#8377;"/> </td>
        					<td>
        						<fmt:parseDate var="date" value="${order.orderDate }" pattern="yyyy-MM-dd'T'HH:mm:ss"/>
        						<fmt:formatDate value="${date}" type="both" timeStyle="short"  />
        					</td>
        					<td>${order.orderStatus }</td>
        					<td><a class="btn btn-danger" href="#">Cancel</a>
        				</tr>
        			</core:forEach>
        		</tbody>
        	</table>
        	</core:if>
        	<core:if test="${orderlist.isEmpty() }">
        		<span class="text-white">No Order place yet...</span>
        	</core:if>
       
            <div class="cleaner_with_height">&nbsp;</div>
            
            <a href="subpage.html"><img src="images/templatemo_ads.jpg" alt="ads" /></a>
        </div> <!-- end of content right -->
    
   
   
   <jsp:include page="footer.jsp"/>