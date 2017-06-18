package web.servlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UbigeoDao;
import com.model.Ubigeo;
import java.io.PrintWriter;
import java.util.ArrayList;
import com.google.gson.Gson;
import java.util.List;
/**
 *
 * @author Lucker
 */
@WebServlet(name = "UbigeoServlet", urlPatterns = {"/Ubigeo"})
public class UbigeoServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  private UbigeoDao dao;
  public UbigeoServlet() {
        super();
        dao = new UbigeoDao();
  }  
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String iddept = request.getParameter("iddept");
    String idprov = request.getParameter("idprov");    
    List<Ubigeo> ubigeo = new ArrayList<Ubigeo>();
    if (iddept.equals("")&&idprov.equals("")){
        ubigeo = dao.getAllDepartamentos();
    }else if(iddept!=null && idprov.equals("")){
        ubigeo=dao.getProvincias(iddept);
    }else if ( iddept!=null && idprov!=null ){
        ubigeo = dao.getDistritos(idprov);
    }
    Gson gson = new  Gson();                  String jsonString  = gson.toJson(ubigeo);
    response.setCharacterEncoding("UTF8");    response.setContentType("application/json");    
    PrintWriter out = response.getWriter();   out.println(jsonString);
  }
}
