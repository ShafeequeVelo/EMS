
<style>
a {
	text-decoration: none;
	color: inherit;
}

.header {
	width: 100%;
	position: fixed;
	height: 80px;
	top: 0;
	background-color: #f2f2f2;
	/* Adding background color to mimic the table's white background */
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);

	/* Adding box shadow to mimic the table's shadow */
}

.header-content {
	display: flex;
	justify-content: space-between;
	padding: 10px;
}

.header-title {
	flex-grow: 1;
	text-align: left;
}

.header-links {
	width: 20%;
	margin-top: 5px;
	text-align: right;
}
</style>

<div class="header">
	<div class="header-content">
		<div class="header-title">
			<h2>
				<a href="index.jsp">Velociters</a>
			</h2>
		</div>
		<div class="header-links">
			<jsp:include page="Logout.jsp"></jsp:include>
		</div>
	</div>
</div>