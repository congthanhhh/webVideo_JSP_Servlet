/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.55
 * Generated at: 2023-08-18 21:13:28 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.common;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class header_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
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

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
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
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
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

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write(" \r\n");
      out.write("\r\n");
      out.write("        <!-- Page Loader -->\r\n");
      out.write("    <div id=\"loader-wrapper\">\r\n");
      out.write("        <div id=\"loader\"></div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"loader-section section-left\"></div>\r\n");
      out.write("        <div class=\"loader-section section-right\"></div>\r\n");
      out.write("\r\n");
      out.write("    </div>\r\n");
      out.write("    <nav class=\"navbar navbar-expand-lg\">\r\n");
      out.write("        <div class=\"container-fluid\">\r\n");
      out.write("            <a class=\"navbar-brand\" href=\"<c:url value='/index'/>\">\r\n");
      out.write("                <i class=\"fas fa-film mr-2\"></i>\r\n");
      out.write("                Video Entertainment\r\n");
      out.write("            </a>\r\n");
      out.write("            <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarSupportedContent\" aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\r\n");
      out.write("                <i class=\"fas fa-bars\"></i>\r\n");
      out.write("            </button>\r\n");
      out.write("            <div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">\r\n");
      out.write("            <ul class=\"navbar-nav ml-auto mb-2 mb-lg-0\">\r\n");
      out.write("            <c:choose>\r\n");
      out.write("            	<c:when test = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${not empty sessionScope.currentUser}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("	                <li class=\"nav-item\">\r\n");
      out.write("	                    <a class=\"nav-link nav-link-1 active\" aria-current=\"page\" class=\"btn btn-primary\" data-toggle=\"modal\" data-target=\"#myModal\">Well come ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.currentUser.username}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</a>\r\n");
      out.write("	                </li>\r\n");
      out.write("	                <li class=\"nav-item\">\r\n");
      out.write("	                    <a class=\"nav-link nav-link-1\" href=\"favorites\">My favorites</a>\r\n");
      out.write("	                </li>\r\n");
      out.write("	                <li class=\"nav-item\">\r\n");
      out.write("	                    <a class=\"nav-link nav-link-2\" href=\"history\">History</a>\r\n");
      out.write("	                </li>\r\n");
      out.write("	                <li class=\"nav-item\">\r\n");
      out.write("	                    <a class=\"nav-link nav-link-3\" href=\"logout\">Log out</a>\r\n");
      out.write("	                </li>            	\r\n");
      out.write("            	</c:when>\r\n");
      out.write("            	<c:otherwise>\r\n");
      out.write("	                <li class=\"nav-item\">\r\n");
      out.write("	                    <a class=\"nav-link nav-link-2\" href=\"login\">Login</a>\r\n");
      out.write("	                </li>\r\n");
      out.write("	                <li class=\"nav-item\">\r\n");
      out.write("	                    <a class=\"nav-link nav-link-3\" href=\"register\">Register</a>\r\n");
      out.write("	                </li>\r\n");
      out.write("	                <li class=\"nav-item\">\r\n");
      out.write("	                    <a class=\"nav-link nav-link-4\" href=\"forgotPass\">Forgot password</a>\r\n");
      out.write("	                </li>            	\r\n");
      out.write("            	</c:otherwise>\r\n");
      out.write("            </c:choose>\r\n");
      out.write("            \r\n");
      out.write("            </ul>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </nav>\r\n");
      out.write("\r\n");
      out.write("    <div class=\"tm-hero d-flex justify-content-center align-items-center\" data-parallax=\"scroll\" data-image-src=\"<c:url value ='/template/user/img'/>\">\r\n");
      out.write("        <form class=\"d-flex tm-search-form\">\r\n");
      out.write("            <input class=\"form-control tm-search-input\" type=\"search\" placeholder=\"Search\" aria-label=\"Search\">\r\n");
      out.write("            <button class=\"btn btn-outline-success tm-search-btn\" type=\"submit\">\r\n");
      out.write("                <i class=\"fas fa-search\"></i>\r\n");
      out.write("            </button>\r\n");
      out.write("        </form>\r\n");
      out.write("    </div>\r\n");
      out.write("    \r\n");
      out.write("    \r\n");
      out.write("    <!-- The Modal -->\r\n");
      out.write("  <div class=\"modal\" id=\"myModal\">\r\n");
      out.write("    <div class=\"modal-dialog\">\r\n");
      out.write("      <div class=\"modal-content\">\r\n");
      out.write("      \r\n");
      out.write("        <!-- Modal Header -->\r\n");
      out.write("        <div class=\"modal-header\">\r\n");
      out.write("          <h4 class=\"modal-title\">Change Password</h4>\r\n");
      out.write("          <button type=\"button\" class=\"close\" data-dismiss=\"modal\">&times;</button>\r\n");
      out.write("        </div>\r\n");
      out.write("        \r\n");
      out.write("        <!-- Modal body -->\r\n");
      out.write("        <div class=\"modal-body\">\r\n");
      out.write("          \r\n");
      out.write("          <div class=\"form-group\">\r\n");
      out.write("             <input type=\"password\" id=\"currentPass\" name=\"currentPass\" class=\"form-control rounded-0\" placeholder=\"Current Password\" required />\r\n");
      out.write("          </div>\r\n");
      out.write("          <div class=\"form-group\">\r\n");
      out.write("             <input type=\"password\" id=\"newPass\" name=\"newPass\" class=\"form-control rounded-0\" placeholder=\"New Password\" required />\r\n");
      out.write("          </div>\r\n");
      out.write("          <h5 style=\"color: red\" id=\"messageChangePass\"></h5>\r\n");
      out.write("        </div>\r\n");
      out.write("        \r\n");
      out.write("        <!-- Modal footer -->\r\n");
      out.write("        <div class=\"modal-footer\">\r\n");
      out.write("          <button type=\"button\" id=\"changePassBtn\" class=\"btn btn-success\">Save</button>\r\n");
      out.write("          <button type=\"button\" class=\"btn btn-danger\" data-dismiss=\"modal\">Close</button>\r\n");
      out.write("        </div>\r\n");
      out.write("        \r\n");
      out.write("      </div>\r\n");
      out.write("    </div>\r\n");
      out.write("  </div>\r\n");
      out.write("  \r\n");
      out.write("  	\r\n");
      out.write("  ");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
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
}
