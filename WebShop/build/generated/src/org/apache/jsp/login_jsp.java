package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>WEBSHOP</title>\n");
      out.write("\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("            ");
 
            if(session.getAttribute("username") == null){
                session.setAttribute("username", "Insæt username");
            }
            
      out.write("   \n");
      out.write("        <div>\n");
      out.write("        <nav class=\"navbar navbar-default\" style=\"padding: 10px; width: 300px; margin: auto;\">\n");
      out.write("            <h1>Webshopname</h1>\n");
      out.write("        <div class=\"form-group\">\n");
      out.write("        <form action=\"loginservlet\" method=\"POST\">\n");
      out.write("            \n");
      out.write("            <h3>Log in her:</h3>\n");
      out.write("            <input type=\"hidden\" value=\"login\" name=\"origin\" />\n");
      out.write("            <input type=\"text\" name=\"username\" placeholder=\"Brugernavn\" value=\"");
      out.print( session.getAttribute("username"));
      out.write("\"  class=\"form-control\"/><br>\n");
      out.write("            <input type=\"password\" name=\"password\" placeholder=\"Password\" class=\"form-control\"/><br>\n");
      out.write("            <input type=\"submit\" value=\"Log in\" class=\"btn btn-default\"/><br><br>\n");
      out.write("        </form>\n");
      out.write("        <form action=\"createNewUser.jsp\" method=\"GET\">\n");
      out.write("            <input type=\"submit\" value=\"Sign up\" class=\"btn btn-default\"/>\n");
      out.write("        </form>\n");
      out.write("        </div>\n");
      out.write("        </nav>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
