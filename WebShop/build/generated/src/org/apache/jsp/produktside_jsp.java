package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import model.ProduktMapper;
import model.UserMapper;
import model.entity.Product;
import model.entity.User;

public final class produktside_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>WEBSHOP - Produkt liste</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"navbar navbar-default\">\n");
      out.write("            <div class=\"form-group\" style=\"float: left; padding-left: 10px;\"><h1> Plakat Webshop</h1></div>\n");
      out.write("            <div class=\"form-group\" style=\"float: right;\">   \n");
      out.write("            <form action=\"loginservlet\" method=\"POST\">\n");
      out.write("                Logget ind som: ");
      out.print( session.getAttribute("username") );
      out.write("\n");
      out.write("                        ");
  // Tjekker at bruger er logget ind //
                        if(session.getAttribute("authenticated") == null){
                            request.getRequestDispatcher("login.jsp").forward(request, response);
                            return; }
                        
      out.write("\n");
      out.write("                        \n");
      out.write("                <input type=\"hidden\" name=\"origin\" value=\"logout\">\n");
      out.write("                <input type=\"submit\" value=\"Logout\" class=\"btn btn-default\">\n");
      out.write("            </form>\n");
      out.write("                        \n");
      out.write("                        \n");
      out.write("            </div>\n");
      out.write("        </div>     \n");
      out.write("\n");
      out.write("        <h1></h1>\n");
      out.write("        \n");
      out.write("        <div style=\"float: right; text-align: center; padding: 10px; margin-right: 5px;\" class=\"navbar navbar-default\">\n");
      out.write("            <input type=\"hidden\" name=\"orderid\" value=\"");
      out.print(  session.getAttribute("orderid") );
      out.write("\">\n");
      out.write("            <a style=\"color: red\">");
      out.print(  session.getAttribute("besked") );
      out.write("</a>\n");
      out.write("            <br/><br/>\n");
      out.write("            <form action=\"showPurchaseServlet\" method=\"POST\">\n");
      out.write("                <input type=\"hidden\" name=\"orderid\" value=\"");
      out.print(  session.getAttribute("orderid") );
      out.write("\">\n");
      out.write("                <input type=\"hidden\" name=\"username\" value=\"");
      out.print( session.getAttribute("username") );
      out.write("\">\n");
      out.write("                <input type=\"submit\" value=\"Inkøbskurv\" class=\"btn btn-default\"/>\n");
      out.write("                <br/><br/>\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("        <div style=\"margin: auto; width: 65%; height: 100%; float: inside; padding: 10px;\">\n");
      out.write("                <table class=\"table table-striped\">\n");
      out.write("                    <tbody>\n");
      out.write("                        ");
  
                            List<Product> produktliste = (List<Product>)session.getAttribute("ProductListe");
                            for (Product product : produktliste){
                         
      out.write("\n");
      out.write("\n");
      out.write("                        <form action=\"BuyProduct\" method=\"POST\">\n");
      out.write("\n");
      out.write("                        \n");
      out.write("                        <div style=\"float: left; padding: 10px; border: gray solid 1px;\">\n");
      out.write("                                <input type=\"hidden\" name=\"origin\" value=\"AlleProdukter\">\n");
      out.write("                                <input type=\"hidden\" name=\"produktid\" value=\"");
      out.print( product.getId() );
      out.write("\">\n");
      out.write("                                <input type=\"hidden\" name=\"orderid\" value=\"");
      out.print(  session.getAttribute("orderid") );
      out.write("\">\n");
      out.write("                                <img src=\"https://1369994046.rsc.cdn77.org/bilder/artiklar/750");
      out.print(product.getId() );
      out.write(".jpg\" style=\"width: 250px\">\n");
      out.write("                                <br/><br/>\n");
      out.write("                                <h3>");
      out.print( product.getProduktname() );
      out.write("</h3>\n");
      out.write("                                ");
      out.print( product.getKategori() );
      out.write("\n");
      out.write("                                <br/><br/>\n");
      out.write("\n");
      out.write("                                ");
      out.print( product.getPris() );
      out.write(" kr.<br/><br/>\n");
      out.write("                            <input type=\"submit\" name=\"submit\" value=\"Tilføj inkøbskurv\" class=\"btn\"></form>\n");
      out.write("                            <form action=\"ProductDetail\" method=\"POST\" style=\"float: right;\">\n");
      out.write("                                <input type=\"hidden\" name=\"produktid\" value=\"");
      out.print( product.getId() );
      out.write("\">\n");
      out.write("                                <input type=\"submit\" name=\"submit\" value=\"Se mere\" class=\"btn btn-default\">\n");
      out.write("                            </form>  \n");
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                        \n");
      out.write("                    ");
 } 
      out.write("\n");
      out.write("            </div>    \n");
      out.write("                \n");
      out.write("            </tbody>\n");
      out.write("        </table>\n");
      out.write("        \n");
      out.write("        \n");
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
