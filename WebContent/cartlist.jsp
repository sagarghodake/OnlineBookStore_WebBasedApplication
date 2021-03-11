<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>



	<jsp:include page="header.jsp"/>
	<jsp:include page="leftmenu.jsp"/>
  
  <script type="text/javascript">
	
	function calcTotalPrice()
	{
		cartQuantitylist = $("input[name=cartQuantity]");
		bookPricelist = $("input[name=bookPrice]");
		//alert("cartQuantitylist length :- "+cartQuantitylist.length)
		//alert("bookPricelist length :- "+bookPricelist.length)
		var totalPrice = 0;
		$.each(cartQuantitylist,function(index,cartQtyelement){
		//	alert(index +":- "+cartQtyelement.value)
			totalPrice = totalPrice + (cartQtyelement.value * bookPricelist[index].value)
		});
		$(".totalPrice").text(totalPrice);
	}
	
	$(function(){
		calcTotalPrice(); // it should be call after the page loding ie (when page is ready.)

		$("input[name=cartQuantity]").click(function(){
			calcTotalPrice(); 
			var data={"action":"updateCartQty","cartId":this.nextSibling.value,"cartQuantity":this.value}
			$.post("cartC",data,function(response){
				$("#msg").html(response)
			})
		});
		
	});
	
	
</script>      
        
        <div id="templatemo_content_right">
       	<core:if test="${!cartlist.isEmpty()}">
       		<h1>My Cart</h1>
       		<h2>
       			<span id="msg" style="color:green">${msg}</span>
       			<span style="color:red">${erorrmsg}</span>
       		</h2>
       		<form action="orderC" method="post">
       			<input type="hidden" name="action" value="placeorder">
       		<table class="table table-hover table-dark" border="1" title="${customer}">
       			<thead>
       				<tr>
       					<th>Id</th>
       					<th>Book Name</th>
       					<th>Quantity</th>
       					<th>Book Price</th>
       					<th >Action</th>
       				</tr>
       			</thead>
       			<tbody>
       				<core:forEach var="cart" items="${cartlist}">
       				<tr>
       					<td>${cart.cartId }</td>
       					<td>${cart.book.bookName}</td>
       					<td><input type="number" min="1" name="cartQuantity" value="${cart.cartQuantity}"/><input type="hidden" name="cartId" value="${cart.cartId }"/></td>
       					<td><input type="text" name="bookPrice" value="${cart.book.bookPrice}" readonly/></td>
       					<td><a onclick="return confirm('Do you want to delete book ?')" class="btn btn-danger text-white"  href="cartC?action=delete&cartId=${cart.cartId}">Delete</a></td>
       				</tr>
       				</core:forEach>
       			</tbody>
       			<tfoot>
       				<tr>
       					<td colspan="2">
       						<label>Total Amount</label>
       					</td>
       					<td colspan="2" align="center">
       						<big>&#8377; <span class="totalPrice"></span></big>
       					</td>
       					<td>
       						<input class="btn btn-success" type="submit" value="Place Order"/>
       					</td>
       				</tr>
       			</tfoot>
       		</table>
       		</form>
       	</core:if>
       	<core:if test="${  cartlist.isEmpty()}">
       		<h3>No Books Found</h3>
       	</core:if>
            <div class="cleaner_with_height">&nbsp;</div>
            <a href="subpage.html"><img src="images/templatemo_ads.jpg" alt="ads" /></a>
        </div> <!-- end of content right -->
    
   
   
   <jsp:include page="footer.jsp"/>