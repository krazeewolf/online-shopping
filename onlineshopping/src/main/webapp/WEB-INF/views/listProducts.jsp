<div class="container">


	<div class="row">

		<!--would be to be actual pro  -->
		<div class="col-md-12">
			<!--added breadcrumb component  -->
			<div class="row">

				<div class="col-lg-12">
					<c:if test="${userClickAllProducts == true}">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a href="${contextRoot }/home">Home </a></li>
							<li class="breadcrumb-item active">All Products</li>

						</ol>
					</c:if>
					<c:if test="${userClickCategoryProducts == true}">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a href="${contextRoot }/home">Home</a></li>
							<li class="breadcrumb-item active">Category</li>
							<li class="breadcrumb-item active">${category.name}</li>

						</ol>
					</c:if>
					
				</div>

			</div>
			
			
			
			<div class="row">
			
			<div class="col-xs-12">
			<table id="productListTable" class="table table-striped table-bordered">
			<thead>
			<tr> 
			<th>ID</th>
			<th>Name</th>
			
			</tr>
			
			 
			</thead>
			
			
			</table>
			</div>
			
			</div>


		</div>

	</div>


</div>