/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/10.1.13
 * Generated at: 2023-12-18 10:13:07 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.jsp.*;
import dao.WatchDAO;
import core.Watch;
import java.util.ArrayList;

public final class watchmanagement_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports,
                 org.apache.jasper.runtime.JspSourceDirectives {

  private static final jakarta.servlet.jsp.JspFactory _jspxFactory =
          jakarta.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/WEB-INF/lib/jakarta.servlet.jsp.jstl-2.0.0.jar", Long.valueOf(1697639205471L));
    _jspx_dependants.put("jar:file:/C:/Users/szers/OneDrive/Máy%20tính/MyProject/.metadata/.plugins/org.eclipse.wst.server.core/tmp1/wtpwebapps/MyProject/WEB-INF/lib/jakarta.servlet.jsp.jstl-2.0.0.jar!/META-INF/c.tld", Long.valueOf(1602848772000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("jakarta.servlet");
    _jspx_imports_packages.add("jakarta.servlet.http");
    _jspx_imports_packages.add("jakarta.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("core.Watch");
    _jspx_imports_classes.add("dao.WatchDAO");
    _jspx_imports_classes.add("java.util.ArrayList");
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems;

  private volatile jakarta.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public boolean getErrorOnELNotFound() {
    return false;
  }

  public jakarta.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.release();
  }

  public void _jspService(final jakarta.servlet.http.HttpServletRequest request, final jakarta.servlet.http.HttpServletResponse response)
      throws java.io.IOException, jakarta.servlet.ServletException {

    if (!jakarta.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final jakarta.servlet.jsp.PageContext pageContext;
    jakarta.servlet.http.HttpSession session = null;
    final jakarta.servlet.ServletContext application;
    final jakarta.servlet.ServletConfig config;
    jakarta.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    jakarta.servlet.jsp.JspWriter _jspx_out = null;
    jakarta.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"utf-8\">\r\n");
      out.write("<title>Admin Management</title>\r\n");
      out.write("<meta content=\"width=device-width, initial-scale=1.0\" name=\"viewport\">\r\n");
      out.write("<meta content=\"\" name=\"keywords\">\r\n");
      out.write("<meta content=\"\" name=\"description\">\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\">\r\n");
      out.write("<link rel=\"stylesheet\"\r\n");
      out.write("	href=\"https://fonts.googleapis.com/css?family=Roboto|Varela+Round\">\r\n");
      out.write("<link rel=\"stylesheet\"\r\n");
      out.write("	href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css\">\r\n");
      out.write("<link rel=\"stylesheet\"\r\n");
      out.write("	href=\"https://fonts.googleapis.com/icon?family=Material+Icons\">\r\n");
      out.write("<link rel=\"stylesheet\"\r\n");
      out.write("	href=\"https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css\">\r\n");
      out.write("<script src=\"https://code.jquery.com/jquery-3.5.1.min.js\"></script>\r\n");
      out.write("<script\r\n");
      out.write("	src=\"https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js\"></script>\r\n");
      out.write("<script\r\n");
      out.write("	src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js\"></script>\r\n");
      out.write("<script\r\n");
      out.write("	src=\"https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js\"></script>\r\n");
      out.write("<script\r\n");
      out.write("	src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js\"></script>\r\n");
      out.write("<!-- Favicon -->\r\n");
      out.write("<link href=\"img/favicon.ico\" rel=\"icon\">\r\n");
      out.write("\r\n");
      out.write("<!-- Google Web Fonts -->\r\n");
      out.write("<link rel=\"preconnect\" href=\"https://fonts.googleapis.com\">\r\n");
      out.write("<link rel=\"preconnect\" href=\"https://fonts.gstatic.com\" crossorigin>\r\n");
      out.write("<link\r\n");
      out.write("	href=\"https://fonts.googleapis.com/css2?family=Heebo:wght@400;500;600;700&display=swap\"\r\n");
      out.write("	rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("<!-- Icon Font Stylesheet -->\r\n");
      out.write("<link\r\n");
      out.write("	href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css\"\r\n");
      out.write("	rel=\"stylesheet\">\r\n");
      out.write("<link\r\n");
      out.write("	href=\"https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css\"\r\n");
      out.write("	rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("<!-- Libraries Stylesheet -->\r\n");
      out.write("<link\r\n");
      out.write("	href=\"https://cdn.jsdelivr.net/npm/owl.carousel@2.3.4/dist/assets/owl.carousel.min.css\"\r\n");
      out.write("	rel=\"stylesheet\">\r\n");
      out.write("<link\r\n");
      out.write("	href=\"https://cdn.jsdelivr.net/npm/tempusdominus-bootstrap-4@5.0.0-alpha14/build/css/tempusdominus-bootstrap-4.min.css\"\r\n");
      out.write("	rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("<!-- Customized Bootstrap Stylesheet -->\r\n");
      out.write("<link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");

String ss = (String) session.getAttribute("username");

      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("	");

	if (ss != null) {
	
      out.write("\r\n");
      out.write("	<div class=\"container\">\r\n");
      out.write("\r\n");
      out.write("		<div class=\"row flex-lg-nowrap\">\r\n");
      out.write("			<div class=\"col-12 col-lg-auto mb-3\" style=\"width: 200px\">\r\n");
      out.write("				<div class=\"card p-3\">\r\n");
      out.write("					<div class=\"e-navlist e-navlist--active-bg\">\r\n");
      out.write("\r\n");
      out.write("						<ul class=\"nav\">\r\n");
      out.write("							<li class=\"nav-item\"><span class=\"nav-link px-2\"><i\r\n");
      out.write("									class=\"fa fa-user\"></i> Hello ");
      out.print(ss);
      out.write("</span></li>\r\n");
      out.write("							<li class=\"nav-item\"><a class=\"nav-link px-2 active\"\r\n");
      out.write("								href=\"WatchServlet\"><i class=\"fa fa-cube\"></i><span>\r\n");
      out.write("										Products</span></a></li>\r\n");
      out.write("							<li class=\"nav-item\"><a class=\"nav-link px-2\"\r\n");
      out.write("								href=\"CategoriesServlet\"><i class=\"fa fa-list\"></i><span>\r\n");
      out.write("										Categories</span></a></li>\r\n");
      out.write("							<li class=\"nav-item\"><a class=\"nav-link px-2\"\r\n");
      out.write("								href=\"LogoutServlet\"> <i class=\"fas fa-sign-out-alt mr-1\"></i><span>Logout</span>\r\n");
      out.write("							</a></li>\r\n");
      out.write("\r\n");
      out.write("						</ul>\r\n");
      out.write("					</div>\r\n");
      out.write("				</div>\r\n");
      out.write("			</div>\r\n");
      out.write("\r\n");
      out.write("			<div class=\"col\">\r\n");
      out.write("				<div class=\"e-tabs mb-3 px-3\">\r\n");
      out.write("\r\n");
      out.write("					<ul class=\"nav nav-tabs\">\r\n");
      out.write("						<li class=\"nav-item\"><a class=\"nav-link active\" href=\"#\">Products</a></li>\r\n");
      out.write("					</ul>\r\n");
      out.write("				</div>\r\n");
      out.write("\r\n");
      out.write("				<div class=\"row flex-lg-nowrap\">\r\n");
      out.write("					<div class=\"col mb-3\">\r\n");
      out.write("						<div class=\"e-panel card\">\r\n");
      out.write("\r\n");
      out.write("							<div class=\"container-xl\">\r\n");
      out.write("								<div class=\"table-responsive\">\r\n");
      out.write("									<div class=\"table-wrapper\">\r\n");
      out.write("										<div class=\"table-title\">\r\n");
      out.write("											<div class=\"row\">\r\n");
      out.write("												<div class=\"col-sm-6\">\r\n");
      out.write("													<h2>\r\n");
      out.write("														Manage <b>Product </b>\r\n");
      out.write("													</h2>\r\n");
      out.write("												</div>\r\n");
      out.write("												<div class=\"col-sm-6\">\r\n");
      out.write("													<a href=\"#addEmployeeModal\" class=\"btn btn-success\"\r\n");
      out.write("														data-toggle=\"modal\"><i class=\"material-icons\">&#xE147;</i>\r\n");
      out.write("														<span>Add New Product</span></a>\r\n");
      out.write("												</div>\r\n");
      out.write("											</div>\r\n");
      out.write("										</div>\r\n");
      out.write("										<table class=\"table table-striped table-hover\"\r\n");
      out.write("											style=\"margin: 0 auto; width: 100%; text-align: center;\">\r\n");
      out.write("											<thead>\r\n");
      out.write("												<tr>\r\n");
      out.write("													<th>Id</th>\r\n");
      out.write("													<th>Name</th>\r\n");
      out.write("													<th>Price</th>\r\n");
      out.write("													<th>Description</th>\r\n");
      out.write("													<th>Image</th>\r\n");
      out.write("													<th>CategoryId</th>\r\n");
      out.write("													<th>Edit/Delete</th>\r\n");
      out.write("												</tr>\r\n");
      out.write("											</thead>\r\n");
      out.write("											");

											ArrayList<Watch> listWatch = (ArrayList<Watch>) request.getAttribute("listWatch");
											
      out.write("\r\n");
      out.write("											<tbody>\r\n");
      out.write("												");
      if (_jspx_meth_c_005fforEach_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("											</tbody>\r\n");
      out.write("										</table>\r\n");
      out.write("										");

String id = (String) request.getAttribute("id");
int perPage = (Integer) request.getAttribute("perPage");
int cpage = 1;

if (request.getParameter("page") != null) {
    cpage = Integer.parseInt(request.getParameter("page"));
}

if (id != null) {
    int xid = Integer.parseInt(id);

      out.write("\r\n");
      out.write("				");
      out.print( WatchDAO.getPaginationBarById("WatchServlet", WatchDAO.gettotalById(xid), cpage, perPage, 1, xid) );
      out.write("\r\n");
      out.write("				");

} else {

      out.write("\r\n");
      out.write("				");
      out.print( WatchDAO.getPaginationBar("WatchServlet", WatchDAO.gettotal(), cpage, perPage, 1) );
      out.write("\r\n");
      out.write("				");

}

      out.write("\r\n");
      out.write("									</div>\r\n");
      out.write("								</div>\r\n");
      out.write("							</div>\r\n");
      out.write("							<!-- Edit Modal HTML -->\r\n");
      out.write("							<div id=\"addEmployeeModal\" class=\"modal fade\">\r\n");
      out.write("								<div class=\"modal-dialog\">\r\n");
      out.write("									<div class=\"modal-content\">\r\n");
      out.write("										<form action=\"AddWatchServlet\" method=\"post\"\r\n");
      out.write("											enctype=\"multipart/form-data\">\r\n");
      out.write("											<div class=\"modal-header\">\r\n");
      out.write("												<h4 class=\"modal-title\">Add Product</h4>\r\n");
      out.write("												<button type=\"button\" class=\"close\" data-dismiss=\"modal\"\r\n");
      out.write("													aria-hidden=\"true\">&times;</button>\r\n");
      out.write("											</div>\r\n");
      out.write("											<div class=\"modal-body\">\r\n");
      out.write("\r\n");
      out.write("												<div class=\"form-group\">\r\n");
      out.write("													<label>Name</label> <input type=\"text\" name=\"name\"\r\n");
      out.write("														class=\"form-control\" required>\r\n");
      out.write("												</div>\r\n");
      out.write("												<div class=\"form-group\">\r\n");
      out.write("													<label>Price</label> <input type=\"number\" name=\"price\"\r\n");
      out.write("														class=\"form-control\" required>\r\n");
      out.write("												</div>\r\n");
      out.write("\r\n");
      out.write("												<div class=\"form-group\">\r\n");
      out.write("													<label>Description</label>\r\n");
      out.write("													<textarea name=\"description\" class=\"form-control\" rows=\"4\"\r\n");
      out.write("														required></textarea>\r\n");
      out.write("												</div>\r\n");
      out.write("												<div class=\"form-group\">\r\n");
      out.write("													<label>Image</label> <input type=\"file\" id=\"watchImage\"\r\n");
      out.write("														name=\"image\" class=\"form-control\"\r\n");
      out.write("														onchange=\"previewImage(this, 'addImage')\" /> <img\r\n");
      out.write("														id=\"addImage\" src=\"\" alt=\"Preview Image\"\r\n");
      out.write("														class=\"img-thumbnail\"\r\n");
      out.write("														style=\"max-width: 200px; max-height: 200px; margin-top: 10px;\">\r\n");
      out.write("												</div>\r\n");
      out.write("												<div class=\"form-group\">\r\n");
      out.write("													<label>Category ID</label> <input type=\"number\"\r\n");
      out.write("														name=\"categoryid\" class=\"form-control\" required>\r\n");
      out.write("												</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("												<!-- ThÃªm cÃ¡c trÆ°á»ng thuá»c tÃ­nh khÃ¡c táº¡i ÄÃ¢y -->\r\n");
      out.write("\r\n");
      out.write("											</div>\r\n");
      out.write("											<div class=\"modal-footer\">\r\n");
      out.write("												<input type=\"button\" class=\"btn btn-default\"\r\n");
      out.write("													data-dismiss=\"modal\" value=\"Cancel\"> <input\r\n");
      out.write("													type=\"submit\" class=\"btn btn-success\" value=\"Add\">\r\n");
      out.write("											</div>\r\n");
      out.write("										</form>\r\n");
      out.write("									</div>\r\n");
      out.write("								</div>\r\n");
      out.write("							</div>\r\n");
      out.write("							<!-- Delete Modal HTML -->\r\n");
      out.write("							<div id=\"deleteEmployeeModal\" class=\"modal fade\">\r\n");
      out.write("								<div class=\"modal-dialog\">\r\n");
      out.write("									<div class=\"modal-content\">\r\n");
      out.write("										<form action=\"DeleteWatchServlet\" method=\"post\">\r\n");
      out.write("											<div class=\"modal-header\">\r\n");
      out.write("												<h4 class=\"modal-title\">Delete Category</h4>\r\n");
      out.write("												<button type=\"button\" class=\"close\" data-dismiss=\"modal\"\r\n");
      out.write("													aria-hidden=\"true\">&times;</button>\r\n");
      out.write("											</div>\r\n");
      out.write("											<div class=\"modal-body\">\r\n");
      out.write("												<p>Are you sure you want to delete these Records?</p>\r\n");
      out.write("												<p class=\"text-warning\">\r\n");
      out.write("													<small>This action cannot be undone.</small>\r\n");
      out.write("												</p>\r\n");
      out.write("												<input type=\"hidden\" id=\"deleteProductId\" name=\"id\" value=\"\"\r\n");
      out.write("													class=\"form-control\" required>\r\n");
      out.write("											</div>\r\n");
      out.write("\r\n");
      out.write("											<div class=\"modal-footer\">\r\n");
      out.write("												<input type=\"button\" class=\"btn btn-default\"\r\n");
      out.write("													data-dismiss=\"modal\" value=\"Cancel\"> <input\r\n");
      out.write("													type=\"submit\" class=\"btn btn-danger\" value=\"Delete\">\r\n");
      out.write("											</div>\r\n");
      out.write("\r\n");
      out.write("										</form>\r\n");
      out.write("									</div>\r\n");
      out.write("								</div>\r\n");
      out.write("							</div>\r\n");
      out.write("							<!-- Edit Modal HTML -->\r\n");
      out.write("							<div id=\"editProduct\" class=\"modal fade\">\r\n");
      out.write("								<div class=\"modal-dialog\">\r\n");
      out.write("									<div class=\"modal-content\">\r\n");
      out.write("										<form action=\"UpdateWatchServlet\" method=\"post\"\r\n");
      out.write("											enctype=\"multipart/form-data\">\r\n");
      out.write("											<div class=\"modal-header\">\r\n");
      out.write("												<h4 class=\"modal-title\">Edit Watch</h4>\r\n");
      out.write("												<button type=\"button\" class=\"close\" data-dismiss=\"modal\"\r\n");
      out.write("													aria-hidden=\"true\">&times;</button>\r\n");
      out.write("											</div>\r\n");
      out.write("											<div class=\"modal-body\">\r\n");
      out.write("												<div class=\"form-group\">\r\n");
      out.write("													<input type=\"hidden\" id=\"watchId\" name=\"id\" value=\"\"\r\n");
      out.write("														class=\"form-control\" required>\r\n");
      out.write("												</div>\r\n");
      out.write("												<div class=\"form-group\">\r\n");
      out.write("													<label>Name</label> <input type=\"text\" id=\"watchName\"\r\n");
      out.write("														name=\"name\" value=\"\" class=\"form-control\" required>\r\n");
      out.write("												</div>\r\n");
      out.write("												<div class=\"form-group\">\r\n");
      out.write("													<label>Price</label> <input type=\"number\" id=\"watchPrice\"\r\n");
      out.write("														name=\"price\" value=\"\" class=\"form-control\" required>\r\n");
      out.write("												</div>\r\n");
      out.write("												<div class=\"form-group\">\r\n");
      out.write("\r\n");
      out.write("													<label>Description</label>\r\n");
      out.write("													<textarea id=\"watchDescription\" name=\"description\"\r\n");
      out.write("														class=\"form-control\" rows=\"4\" required></textarea>\r\n");
      out.write("												</div>\r\n");
      out.write("												<div class=\"form-group\">\r\n");
      out.write("													<label>Image</label> <input type=\"file\" id=\"watchImage\"\r\n");
      out.write("														name=\"image\" class=\"form-control\"\r\n");
      out.write("														onchange=\"previewImage(this, 'editImage')\" /> <img\r\n");
      out.write("														id=\"editImage\" src=\"\" alt=\"Preview Image\"\r\n");
      out.write("														class=\"img-thumbnail\"\r\n");
      out.write("														style=\"max-width: 200px; max-height: 200px; margin-top: 10px;\">\r\n");
      out.write("												</div>\r\n");
      out.write("												<div class=\"form-group\">\r\n");
      out.write("													<label>CategoryId</label> <input type=\"number\"\r\n");
      out.write("														id=\"watchCategoryId\" name=\"categoryid\" value=\"\"\r\n");
      out.write("														class=\"form-control\" required>\r\n");
      out.write("												</div>\r\n");
      out.write("\r\n");
      out.write("											</div>\r\n");
      out.write("											<div class=\"modal-footer\">\r\n");
      out.write("												<input type=\"button\" class=\"btn btn-default\"\r\n");
      out.write("													data-dismiss=\"modal\" value=\"Cancel\"> <input\r\n");
      out.write("													type=\"submit\" class=\"btn btn-info\" value=\"Save\">\r\n");
      out.write("											</div>\r\n");
      out.write("										</form>\r\n");
      out.write("									</div>\r\n");
      out.write("								</div>\r\n");
      out.write("							</div>\r\n");
      out.write("							<!-- Delete Modal HTML -->\r\n");
      out.write("							<div id=\"deleteEmployeeModal\" class=\"modal fade\">\r\n");
      out.write("								<div class=\"modal-dialog\">\r\n");
      out.write("									<div class=\"modal-content\">\r\n");
      out.write("										<form action=\"DeleteWatchServlet\" method=\"post\">\r\n");
      out.write("											<div class=\"modal-header\">\r\n");
      out.write("												<h4 class=\"modal-title\">Delete Category</h4>\r\n");
      out.write("												<button type=\"button\" class=\"close\" data-dismiss=\"modal\"\r\n");
      out.write("													aria-hidden=\"true\">&times;</button>\r\n");
      out.write("											</div>\r\n");
      out.write("											<div class=\"modal-body\">\r\n");
      out.write("												<p>Are you sure you want to delete these Records?</p>\r\n");
      out.write("												<p class=\"text-warning\">\r\n");
      out.write("													<small>This action cannot be undone.</small>\r\n");
      out.write("												</p>\r\n");
      out.write("												<input type=\"hidden\" id=\"deleteProductId\" name=\"id\" value=\"\"\r\n");
      out.write("													class=\"form-control\" required>\r\n");
      out.write("											</div>\r\n");
      out.write("\r\n");
      out.write("											<div class=\"modal-footer\">\r\n");
      out.write("												<input type=\"button\" class=\"btn btn-default\"\r\n");
      out.write("													data-dismiss=\"modal\" value=\"Cancel\"> <input\r\n");
      out.write("													type=\"submit\" class=\"btn btn-danger\" value=\"Delete\">\r\n");
      out.write("											</div>\r\n");
      out.write("\r\n");
      out.write("										</form>\r\n");
      out.write("\r\n");
      out.write("									</div>\r\n");
      out.write("								</div>\r\n");
      out.write("							</div>\r\n");
      out.write("						</div>\r\n");
      out.write("					</div>\r\n");
      out.write("				</div>\r\n");
      out.write("			</div>\r\n");
      out.write("		</div>\r\n");
      out.write("	</div>\r\n");
      out.write("	<script type=\"text/javascript\">\r\n");
      out.write("function setIdWatch(id) {\r\n");
      out.write("    // Set the value of the hidden input field in the form\r\n");
      out.write("    document.getElementById('deleteProductId').value = id;\r\n");
      out.write("    \r\n");
      out.write("    \r\n");
      out.write("    // Show the delete modal\r\n");
      out.write("    $('#deleteEmployeeModal').modal('show');\r\n");
      out.write("}\r\n");
      out.write("function setEditWatch(id, name, price, description, image, categoryId) {\r\n");
      out.write("    document.getElementById('watchId').value = id;\r\n");
      out.write("    document.getElementById('watchName').value = name;\r\n");
      out.write("    document.getElementById('watchPrice').value = price;\r\n");
      out.write("    document.getElementById('watchDescription').value = description;\r\n");
      out.write("\r\n");
      out.write("    // Sá»­ dá»¥ng tháº» <img> Äá» hiá»n thá» hÃ¬nh áº£nh\r\n");
      out.write("    var imgElement = document.getElementById('editImage');\r\n");
      out.write("    imgElement.src = \"data:image/jpg;base64,\" + image;\r\n");
      out.write("    \r\n");
      out.write("    document.getElementById('watchCategoryId').value = categoryId;\r\n");
      out.write("    \r\n");
      out.write("    console.log(id);\r\n");
      out.write("    $('#editProduct').modal('show');\r\n");
      out.write("}\r\n");
      out.write("function previewImage(input, imageId) {\r\n");
      out.write("    var imgElement = document.getElementById(imageId);\r\n");
      out.write("    var fileInput = input.files[0];\r\n");
      out.write("\r\n");
      out.write("    if (fileInput) {\r\n");
      out.write("        var reader = new FileReader();\r\n");
      out.write("\r\n");
      out.write("        reader.onload = function (e) {\r\n");
      out.write("            imgElement.src = e.target.result;\r\n");
      out.write("        };\r\n");
      out.write("\r\n");
      out.write("        reader.readAsDataURL(fileInput);\r\n");
      out.write("    }\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("document.getElementById(\"submitButton\").onclick = function() {\r\n");
      out.write("    this.disabled = true;\r\n");
      out.write("    // Thá»±c hiá»n hÃ nh Äá»ng submit\r\n");
      out.write("};\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("	");

			} else {
			
      out.write("\r\n");
      out.write("	<style>\r\n");
      out.write("body {\r\n");
      out.write("	display: flex;\r\n");
      out.write("	align-items: center;\r\n");
      out.write("	justify-content: center;\r\n");
      out.write("	height: 100vh;\r\n");
      out.write("	margin: 0;\r\n");
      out.write("	font-family: Arial, sans-serif;\r\n");
      out.write("	background-color: #f4f4f4;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".error-container {\r\n");
      out.write("	text-align: center;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".error-code {\r\n");
      out.write("	font-size: 120px;\r\n");
      out.write("	color: #333;\r\n");
      out.write("	margin-bottom: 10px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".error-message {\r\n");
      out.write("	font-size: 24px;\r\n");
      out.write("	color: #555;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("	<div class=\"error-container\">\r\n");
      out.write("		<div class=\"error-code\">404</div>\r\n");
      out.write("		<div class=\"error-message\">Not Found</div>\r\n");
      out.write("		<a class=\"nav-link px-2\" href=\"LogoutServlet\"> <i\r\n");
      out.write("			class=\"fas fa-sign-out-alt mr-1\"></i><span>Back Login</span>\r\n");
      out.write("		</a>\r\n");
      out.write("	</div>\r\n");
      out.write("	");

				}
				
      out.write("\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof jakarta.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_005fforEach_005f0(jakarta.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    jakarta.servlet.jsp.PageContext pageContext = _jspx_page_context;
    jakarta.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    boolean _jspx_th_c_005fforEach_005f0_reused = false;
    try {
      _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fforEach_005f0.setParent(null);
      // /watchmanagement.jsp(139,12) name = items type = jakarta.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f0.setItems(new org.apache.jasper.el.JspValueExpression("/watchmanagement.jsp(139,12) '${listWatch}'",_jsp_getExpressionFactory().createValueExpression(_jspx_page_context.getELContext(),"${listWatch}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
      // /watchmanagement.jsp(139,12) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f0.setVar("item");
      int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
      try {
        int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
        if (_jspx_eval_c_005fforEach_005f0 != jakarta.servlet.jsp.tagext.Tag.SKIP_BODY) {
          do {
            out.write("\r\n");
            out.write("													<tr>\r\n");
            out.write("														<td>");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${item.watchId}", java.lang.String.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("</td>\r\n");
            out.write("														<td>");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${item.watchName}", java.lang.String.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("</td>\r\n");
            out.write("														<td>");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${item.watchPrice}", java.lang.String.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("</td>\r\n");
            out.write("														<td>");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${item.watchDescription}", java.lang.String.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("</td>\r\n");
            out.write("														<td>\r\n");
            out.write("															<!-- Sá»­ dá»¥ng tháº» <img> Äá» hiá»n thá» hÃ¬nh áº£nh --> <img\r\n");
            out.write("															src=\"data:image/jpg;base64,");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${item.base64Image}", java.lang.String.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("\"\r\n");
            out.write("															alt=\"Watch Image\" class=\"img-thumbnail\"\r\n");
            out.write("															style=\"height: auto; width: 150px\">\r\n");
            out.write("														</td>\r\n");
            out.write("														<td>");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${item.watchCategoryId}", java.lang.String.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("</td>\r\n");
            out.write("														<td><a href=\"#editProduct\" class=\"edit\"\r\n");
            out.write("															data-toggle=\"modal\"\r\n");
            out.write("															onclick=\"setEditWatch(");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${item.watchId}", java.lang.String.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write(',');
            out.write('\'');
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${item.watchName}", java.lang.String.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write('\'');
            out.write(',');
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${item.watchPrice}", java.lang.String.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write(',');
            out.write('\'');
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${item.watchDescription}", java.lang.String.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write('\'');
            out.write(',');
            out.write('\'');
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${item.base64Image}", java.lang.String.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write('\'');
            out.write(',');
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${item.watchCategoryId}", java.lang.String.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write(")\">\r\n");
            out.write("																<i class=\"material-icons\" data-toggle=\"tooltip\"\r\n");
            out.write("																title=\"Edit\">&#xE254;</i>\r\n");
            out.write("														</a> <a href=\"#deleteEmployeeModal\" class=\"delete\"\r\n");
            out.write("															data-toggle=\"modal\" onclick=\"setIdWatch(");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${item.watchId}", java.lang.String.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write(")\">\r\n");
            out.write("																<i class=\"material-icons\" data-toggle=\"tooltip\"\r\n");
            out.write("																title=\"Delete\">&#xE872;</i>\r\n");
            out.write("														</a></td>\r\n");
            out.write("													</tr>\r\n");
            out.write("												");
            int evalDoAfterBody = _jspx_th_c_005fforEach_005f0.doAfterBody();
            if (evalDoAfterBody != jakarta.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
        }
        if (_jspx_th_c_005fforEach_005f0.doEndTag() == jakarta.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return true;
        }
      } catch (java.lang.Throwable _jspx_exception) {
        while (_jspx_push_body_count_c_005fforEach_005f0[0]-- > 0)
          out = _jspx_page_context.popBody();
        _jspx_th_c_005fforEach_005f0.doCatch(_jspx_exception);
      } finally {
        _jspx_th_c_005fforEach_005f0.doFinally();
      }
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f0);
      _jspx_th_c_005fforEach_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fforEach_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fforEach_005f0_reused);
    }
    return false;
  }
}
