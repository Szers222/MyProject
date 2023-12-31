<%@page import="dao.WatchDAO"%>
<html lang="en">
<%@page import="core.Watch"%>
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
<link
	href="https://cdn.jsdelivr.net/npm/owl.carousel@2.3.4/dist/assets/owl.carousel.min.css"
	rel="stylesheet">
<link
	href="https://cdn.jsdelivr.net/npm/tempusdominus-bootstrap-4@5.0.0-alpha14/build/css/tempusdominus-bootstrap-4.min.css"
	rel="stylesheet">

<!-- Customized Bootstrap Stylesheet -->
<link href="css/bootstrap.min.css" rel="stylesheet">

</head>
<%
String ss = (String) session.getAttribute("username");
%>
<body>
	<%
	if (ss != null) {
	%>
	<div class="container">

		<div class="row flex-lg-nowrap">
			<div class="col-12 col-lg-auto mb-3" style="width: 200px">
				<div class="card p-3">
					<div class="e-navlist e-navlist--active-bg">

						<ul class="nav">
							<li class="nav-item"><span class="nav-link px-2"><i
									class="fa fa-user"></i> Hello <%=ss%></span></li>
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
						<li class="nav-item"><a class="nav-link active" href="#">Products</a></li>
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
														Manage <b>Product </b>
													</h2>
												</div>
												<div class="col-sm-6">
													<a href="#addEmployeeModal" class="btn btn-success"
														data-toggle="modal"><i class="material-icons">&#xE147;</i>
														<span>Add New Product</span></a>
												</div>
											</div>
										</div>
										<table class="table table-striped table-hover"
											style="margin: 0 auto; width: 100%; text-align: center;">
											<thead>
												<tr>
													<th>Id</th>
													<th>Name</th>
													<th>Price</th>
													<th>Description</th>
													<th>Image</th>
													<th>CategoryId</th>
													<th>Edit/Delete</th>
												</tr>
											</thead>
											<%
											ArrayList<Watch> listWatch = (ArrayList<Watch>) request.getAttribute("listWatch");
											%>
											<tbody>
												<c:forEach items="${listWatch}" var="item">
													<tr>
														<td>${item.watchId}</td>
														<td>${item.watchName}</td>
														<td>${item.watchPrice}</td>
														<td>${item.watchDescription}</td>
														<td>
															<!-- Sử dụng thẻ <img> để hiển thị hình ảnh --> <img
															src="data:image/jpg;base64,${item.base64Image}"
															alt="Watch Image" class="img-thumbnail"
															style="height: auto; width: 150px">
														</td>
														<td>${item.watchCategoryId}</td>
														<td><a href="#editProduct" class="edit"
															data-toggle="modal"
															onclick="setEditWatch(${item.watchId},'${item.watchName}',${item.watchPrice},'${item.watchDescription}','${item.base64Image}',${item.watchCategoryId})">
																<i class="material-icons" data-toggle="tooltip"
																title="Edit">&#xE254;</i>
														</a> <a href="#deleteEmployeeModal" class="delete"
															data-toggle="modal" onclick="setIdWatch(${item.watchId})">
																<i class="material-icons" data-toggle="tooltip"
																title="Delete">&#xE872;</i>
														</a></td>
													</tr>
												</c:forEach>
											</tbody>
										</table>
										<%
String id = (String) request.getAttribute("id");
int perPage = (Integer) request.getAttribute("perPage");
int cpage = 1;

if (request.getParameter("page") != null) {
    cpage = Integer.parseInt(request.getParameter("page"));
}

if (id != null) {
    int xid = Integer.parseInt(id);
%>
				<%= WatchDAO.getPaginationBarById("WatchServlet", WatchDAO.gettotalById(xid), cpage, perPage, 1, xid) %>
				<%
} else {
%>
				<%= WatchDAO.getPaginationBar("WatchServlet", WatchDAO.gettotal(), cpage, perPage, 1) %>
				<%
}
%>
									</div>
								</div>
							</div>
							<!-- Edit Modal HTML -->
							<div id="addEmployeeModal" class="modal fade">
								<div class="modal-dialog">
									<div class="modal-content">
										<form action="AddWatchServlet" method="post"
											enctype="multipart/form-data">
											<div class="modal-header">
												<h4 class="modal-title">Add Product</h4>
												<button type="button" class="close" data-dismiss="modal"
													aria-hidden="true">&times;</button>
											</div>
											<div class="modal-body">

												<div class="form-group">
													<label>Name</label> <input type="text" name="name"
														class="form-control" required>
												</div>
												<div class="form-group">
													<label>Price</label> <input type="number" name="price"
														class="form-control" required>
												</div>

												<div class="form-group">
													<label>Description</label>
													<textarea name="description" class="form-control" rows="4"
														required></textarea>
												</div>
												<div class="form-group">
													<label>Image</label> <input type="file" id="watchImage"
														name="image" class="form-control"
														onchange="previewImage(this, 'addImage')" /> <img
														id="addImage" src="" alt="Preview Image"
														class="img-thumbnail"
														style="max-width: 200px; max-height: 200px; margin-top: 10px;">
												</div>
												<div class="form-group">
													<label>Category ID</label> <input type="number"
														name="categoryid" class="form-control" required>
												</div>


												<!-- Thêm các trường thuộc tính khác tại đây -->

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
							<!-- Delete Modal HTML -->
							<div id="deleteEmployeeModal" class="modal fade">
								<div class="modal-dialog">
									<div class="modal-content">
										<form action="DeleteWatchServlet" method="post">
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
												<input type="hidden" id="deleteProductId" name="id" value=""
													class="form-control" required>
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
							<!-- Edit Modal HTML -->
							<div id="editProduct" class="modal fade">
								<div class="modal-dialog">
									<div class="modal-content">
										<form action="UpdateWatchServlet" method="post"
											enctype="multipart/form-data">
											<div class="modal-header">
												<h4 class="modal-title">Edit Watch</h4>
												<button type="button" class="close" data-dismiss="modal"
													aria-hidden="true">&times;</button>
											</div>
											<div class="modal-body">
												<div class="form-group">
													<input type="hidden" id="watchId" name="id" value=""
														class="form-control" required>
												</div>
												<div class="form-group">
													<label>Name</label> <input type="text" id="watchName"
														name="name" value="" class="form-control" required>
												</div>
												<div class="form-group">
													<label>Price</label> <input type="number" id="watchPrice"
														name="price" value="" class="form-control" required>
												</div>
												<div class="form-group">

													<label>Description</label>
													<textarea id="watchDescription" name="description"
														class="form-control" rows="4" required></textarea>
												</div>
												<div class="form-group">
													<label>Image</label> <input type="file" id="watchImage"
														name="image" class="form-control"
														onchange="previewImage(this, 'editImage')" /> <img
														id="editImage" src="" alt="Preview Image"
														class="img-thumbnail"
														style="max-width: 200px; max-height: 200px; margin-top: 10px;">
												</div>
												<div class="form-group">
													<label>CategoryId</label> <input type="number"
														id="watchCategoryId" name="categoryid" value=""
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
										<form action="DeleteWatchServlet" method="post">
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
												<input type="hidden" id="deleteProductId" name="id" value=""
													class="form-control" required>
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
					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
function setIdWatch(id) {
    // Set the value of the hidden input field in the form
    document.getElementById('deleteProductId').value = id;
    
    
    // Show the delete modal
    $('#deleteEmployeeModal').modal('show');
}
function setEditWatch(id, name, price, description, image, categoryId) {
    document.getElementById('watchId').value = id;
    document.getElementById('watchName').value = name;
    document.getElementById('watchPrice').value = price;
    document.getElementById('watchDescription').value = description;

    // Sử dụng thẻ <img> để hiển thị hình ảnh
    var imgElement = document.getElementById('editImage');
    imgElement.src = "data:image/jpg;base64," + image;
    
    document.getElementById('watchCategoryId').value = categoryId;
    
    console.log(id);
    $('#editProduct').modal('show');
}
function previewImage(input, imageId) {
    var imgElement = document.getElementById(imageId);
    var fileInput = input.files[0];

    if (fileInput) {
        var reader = new FileReader();

        reader.onload = function (e) {
            imgElement.src = e.target.result;
        };

        reader.readAsDataURL(fileInput);
    }
}

document.getElementById("submitButton").onclick = function() {
    this.disabled = true;
    // Thực hiện hành động submit
};

</script>
	<%
			} else {
			%>
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
	<%
				}
				%>

</body>

</html>