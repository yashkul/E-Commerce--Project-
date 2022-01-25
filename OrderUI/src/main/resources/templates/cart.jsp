<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<br>
<br>
<br>
<br>

<table class="table table-striped table-hover table-sm">
	<caption>Cart</caption>
	<thead class="thead-dark">
		<tr>
			<th scope="col">#</th>
			<th scope="col">Name</th>
			<th scope="col">Free delivery</th>
			<th scope="col">Price</th>
			<th>Action</th>
		</tr>
	</thead>
	<c:set var="cartIndex" value="${index}" />
	<c:forEach items="${menu}" var="menu_item" varStatus="loop">
		<tr class=${cartIndex[loop.count-1]}>
			<td>${loop.count}</td>
			<td>${menu_item.foodName}</td>
			<td>${menu_item.free_delivery}</td>
			<td>${menu_item.price}</td>
			<td>
				<button type="button" class="btn btn-primary"
					id=${cartIndex[loop.count-1] } onClick="removeFromCart(this.id)">
							Remove
						</button>
			</td>
		</tr>

	</c:forEach>
	<tr>
		<td></td>
		<td></td>
		<td><b>Total</b></td>
		<td><b><span id="total"></span></b></td>
	</tr>
</table>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</body>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
	document.getElementById("total").innerHTML = "Rs. " + total().toFixed(2);
	function total() {
		var x = 0;
		<c:forEach items="${menu}" var="menu_item">
		x = x + $
		{
			menu_item.price
		}
		;
		</c:forEach>
		return x;
	}
	function removeFromCart(cart_id) {
		$.ajax({
			url : "removeFromCart",
			data : {
				"cart_id" : cart_id
			},
			success : function(result) {
				//document.getElementsByClassName(cart_id).remove();;
				//x.style.display = "none";
				$('.' + cart_id).remove();
			}
		});
	}
</script>
<%@ include file="common/footer.jspf"%>
