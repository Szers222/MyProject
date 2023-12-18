<html lang="en">
<%@page import="core.Category"%>
<%@page import="java.util.ArrayList"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<head>
<meta charset="utf-8">
<title>Admin Management</title>
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<meta content="" name="keywords">
<meta content="" name="description">
<link rel="stylesheet" type="text/css" href="style.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<!-- Favicon -->
<link href="img/favicon.ico" rel="icon">

<!-- Google Web Fonts -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Heebo:wght@400;500;600;700&display=swap"
	rel="stylesheet">

<!-- Icon Font Stylesheet -->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css"
	rel="stylesheet">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css"
	rel="stylesheet">

<!-- Libraries Stylesheet -->
<link href="https://cdn.jsdelivr.net/npm/owl.carousel@2.3.4/dist/assets/owl.carousel.min.css" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/tempusdominus-bootstrap-4@5.0.0-alpha14/build/css/tempusdominus-bootstrap-4.min.css" rel="stylesheet">

<!-- Customized Bootstrap Stylesheet -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- Template Stylesheet -->
<link href="css/style.css" rel="stylesheet">

</head>
<% String ss = (String) session.getAttribute("username"); %>
<body>
	<%if(ss != null) { %>
	<div class="container">

		<div class="row flex-lg-nowrap">
			<div class="col-12 col-lg-auto mb-3" style="width: 200px">
				<div class="card p-3">
					<div class="e-navlist e-navlist--active-bg">

						<ul class="nav">
							<li class="nav-item"><span class="nav-link px-2"><i
									class="fa fa-user"></i> Hello <%= ss %></span></li>
							<li class="nav-item"><a class="nav-link px-2 active"
								href="WatchServlet"><i class="fa fa-cube"></i><span>
										Products</span></a></li>
							<li class="nav-item"><a class="nav-link px-2"
								href="CategoriesServlet"><i class="fa fa-list"></i><span>
										Categories</span></a></li>

							<li class="nav-item"><a class="nav-link px-2"
								href="LogoutServlet"> <i class="fas fa-sign-out-alt mr-1"></i><span>Logout</span>
							</a></li>

						</ul>
					</div>
				</div>
			</div>

			<div class="col">
				<div class="e-tabs mb-3 px-3">

					<ul class="nav nav-tabs">
						<li class="nav-item"><a class="nav-link active" href="#">Categories</a></li>
					</ul>
				</div>

				<div class="row flex-lg-nowrap">
					<div class="col mb-3">
						<div class="e-panel card">

							<div class="container-xl">
								<div class="table-responsive">
									<div class="table-wrapper">
										<div class="table-title">
											<div class="row">
												<div class="col-sm-6">
													<h2>
														Manage <b>Category </b>
													</h2>
												</div>
												<div class="col-sm-6">
													<a href="#addEmployeeModal" class="btn btn-success"
														data-toggle="modal"><i class="material-icons">&#xE147;</i>
														<span>Add New Category</span></a>
												</div>
											</div>
										</div>
										<table class="table table-striped table-hover"
											style="margin: 0 auto; width: 100%; text-align: center;">
											<thead>
												<tr>

													<th>Id</th>
													<th>Name</th>
													<th>Description</th>
												</tr>
											</thead>
											<%
											ArrayList<Category> listCategory = (ArrayList<Category>) request.getAttribute("listCategory");
											%>
											<tbody>
												<c:forEach items="${listCategory }" var="item">
													<tr>

														<td>${item.idCatogery}</td>
														<td>${item.nameCategory}</td>
														<td>${item.descriptionCategory}</td>
														<td><a href="#editEmployeeModal" class="edit"
															data-toggle="modal"
															onclick="setEdit(${item.idCatogery},'${item.nameCategory }','${item.descriptionCategory }')"><i
																class="material-icons" data-toggle="tooltip"
																title="Edit">&#xE254;</i></a> <a href="#deleteEmployeeModal"
															class="delete" data-toggle="modal"
															onclick="setId(${item.idCatogery})"><i
																class="material-icons" data-toggle="tooltip"
																title="Delete">&#xE872;</i></a></td>
													</tr>

												</c:forEach>
											</tbody>
										</table>
										<div class="clearfix">
											<div class="hint-text">
												Showing <b>5</b> out of <b>25</b> entries
											</div>
											<ul class="pagination">
												<li class="page-item disabled"><a href="#">Previous</a></li>
												<li class="page-item"><a href="#" class="page-link">1</a></li>
												<li class="page-item"><a href="#" class="page-link">2</a></li>
												<li class="page-item active"><a href="#"
													class="page-link">3</a></li>
												<li class="page-item"><a href="#" class="page-link">4</a></li>
												<li class="page-item"><a href="#" class="page-link">5</a></li>
												<li class="page-item"><a href="#" class="page-link">Next</a></li>
											</ul>
										</div>
									</div>
								</div>
							</div>
							<!-- Edit Modal HTML -->
							<div id="addEmployeeModal" class="modal fade">
								<div class="modal-dialog">
									<div class="modal-content">
										<form action="AddCategoryServlet" method="post">
											<div class="modal-header">
												<h4 class="modal-title">Add Category</h4>
												<button type="button" class="close" data-dismiss="modal"
													aria-hidden="true">&times;</button>
											</div>
											<div class="modal-body">
												<div class="form-group">
													<label>Category Name</label> <input type="text" name="name"
														class="form-control" required>
												</div>
												<div class="form-group">
													<label>Description</label> <input type="text"
														name="description" class="form-control" required>
												</div>
											</div>
											<div class="modal-footer">
												<input type="button" class="btn btn-default"
													data-dismiss="modal" value="Cancel"> <input
													type="submit" class="btn btn-success" value="Add">
											</div>
										</form>
									</div>
								</div>
							</div>
							<!-- Edit Modal HTML -->
							<div id="editEmployeeModal" class="modal fade">
								<div class="modal-dialog">
									<div class="modal-content">
										<form action="UpdateCategoryServlet" method="post">
											<div class="modal-header">
												<h4 class="modal-title">Edit Category</h4>
												<button type="button" class="close" data-dismiss="modal"
													aria-hidden="true">&times;</button>
											</div>
											<div class="modal-body">
												<div class="form-group">
													<input type="hidden" id="categoryId" name="id" value=""
														class="form-control" required>
												</div>
												<div class="form-group">
													<label>Name</label> 
													
													<input type="text" id="categoryName"
														name="name" value="" class="form-control" required>
												</div>
												<div class="form-group">
													<label>Description</label> <input type="text"
														id="categoryDescription" name="description" value=""
														class="form-control" required>
												</div>

											</div>
											<div class="modal-footer">
												<input type="button" class="btn btn-default"
													data-dismiss="modal" value="Cancel"> <input
													type="submit" class="btn btn-info" value="Save">
											</div>
										</form>
									</div>
								</div>
							</div>
							<!-- Delete Modal HTML -->
							<div id="deleteEmployeeModal" class="modal fade">
								<div class="modal-dialog">
									<div class="modal-content">
										<form action="DeleteCategoryServlet" method="post">
											<div class="modal-header">
												<h4 class="modal-title">Delete Category</h4>
												<button type="button" class="close" data-dismiss="modal"
													aria-hidden="true">&times;</button>
											</div>
											<div class="modal-body">
												<p>Are you sure you want to delete these Records?</p>
												<p class="text-warning">
													<small>This action cannot be undone.</small>
												</p>
												<input type="hidden" id="deleteCategoryId" name="id"
													value="" class="form-control" required>
											</div>

											<div class="modal-footer">
												<input type="button" class="btn btn-default"
													data-dismiss="modal" value="Cancel"> <input
													type="submit" class="btn btn-danger" value="Delete">
											</div>

										</form>
									</div>
								</div>
							</div>

						</div>
						<div class="col-12 col-lg-3 mb-3">
							<div class="card"></div>
						</div>
					</div>
					
					<script>

function setId(id) {
    // Set the value of the hidden input field in the form
    document.getElementById('deleteCategoryId').value = id; 
    // Show the delete modal
    $('#deleteEmployeeModal').modal('show');
}
function setEdit(id, name, description) {

    document.getElementById('categoryId').value = id;
    document.getElementById('categoryName').value = name;
    document.getElementById('categoryDescription').value = description;
    console.log(id);

    $('#editEmployeeModal').modal('show');
}
</script>
					<% }else{ %>
					<style>
body {
	display: flex;
	align-items: center;
	justify-content: center;
	height: 100vh;
	margin: 0;
	font-family: Arial, sans-serif;
	background-color: #f4f4f4;
}

.error-container {
	text-align: center;
}

.error-code {
	font-size: 120px;
	color: #333;
	margin-bottom: 10px;
}

.error-message {
	font-size: 24px;
	color: #555;
}
</style>
					<div class="error-container">
						<div class="error-code">404</div>
						<div class="error-message">Not Found</div>
						<a class="nav-link px-2" href="LogoutServlet"> <i
							class="fas fa-sign-out-alt mr-1"></i><span>Back Login</span>
						</a>
					</div>
					<%} %>
				
</body>

</html>