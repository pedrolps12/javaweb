package web.servlet;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.CategoryDao;
import com.google.gson.Gson;
import com.model.Category;
import java.io.File;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;




import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;



/**
 *
 * @author Lucker
 */
@WebServlet(name = "CategoryServlet", urlPatterns = {"/Categorias"})

public class CategoryServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  private static String INSERT_OR_EDIT = "/categoria_agregar.jsp";
  private static String LIST_USER = "/categoria_listado.jsp";
  private CategoryDao dao;
  public CategoryServlet() {
        super();
        dao = new CategoryDao();
  }
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String forward="";String catego = "";
    String action = request.getParameter("action");
    if(action == null){
        catego = request.getParameter("catego");
    }
    
     
    List<Category> categorylist = new ArrayList<Category>();
    
    if(catego.equalsIgnoreCase("porid")){
         categorylist = dao.getAllCategories();         
    } else if (action.equalsIgnoreCase("delete")){
        int id = Integer.parseInt(request.getParameter("id"));
        dao.deleteCategory(id);
        forward = LIST_USER;
        request.setAttribute("categories", dao.getAllCategories());    
    } else if (action.equalsIgnoreCase("edit")){
        forward = INSERT_OR_EDIT;
        int id = Integer.parseInt(request.getParameter("id"));
        Category category = dao.getCategoryById(id);
        request.setAttribute("categories", category);
    } else if (action.equalsIgnoreCase("listCategories")){
        String PROJECT_ROOT_PATH = System.getProperty("user.dir");
        File file = new File(PROJECT_ROOT_PATH );
        File parentFolder = file.getParentFile();
        System.out.println("1.-"+ parentFolder );
        forward = LIST_USER;
        request.setAttribute("categories", dao.getAllCategories());
    } else {
        forward = INSERT_OR_EDIT;
    }
    if(catego.equalsIgnoreCase("porid")){
        Gson gson = new  Gson();                  String jsonString  = gson.toJson(categorylist);
        response.setCharacterEncoding("UTF8");    response.setContentType("application/json");    
        PrintWriter out = response.getWriter();   out.println(jsonString);
    }else{
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }
    
  }
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String id="";
    Category category = new Category();
    FileItemFactory itemfactory = new DiskFileItemFactory();
    ServletFileUpload upload = new ServletFileUpload(itemfactory);
    try{
        List<FileItem> items = upload.parseRequest(request);
        for(FileItem item:items){
            if (item.isFormField()) {
                String fieldName = item.getFieldName().trim();String fieldValue = item.getString();
                System.out.println(fieldName);
                switch(fieldName){
                    case "id":id = fieldValue;break;
                    case "name": category.setName(fieldValue);break;
                    case "description":category.setDescription(fieldValue);break;
                }
                
            }else{
                File uploadDir = new File("C:\\Users\\Java-Sab\\Documents\\ProyectoCibertec\\web\\imgServer");
                File file = File.createTempFile("img",".jpg",uploadDir);
                category.setPicture(file.getName());
                item.write(file);
                System.out.println("Archivo grabado correctamente");
            }            
        }        
    }catch(FileUploadException e){
        System.out.println("Subida fallida"+e.getMessage());
    } catch (Exception ex) {
        System.out.println("No se pudo grabar");
        ex.printStackTrace();
    }
    if(id == null || id.isEmpty()){
        dao.addCategory(category);
    }
    else{
        category.setId(Integer.parseInt(id));
        dao.updateCategory(category);
    }    
    RequestDispatcher view = request.getRequestDispatcher(LIST_USER);
    request.setAttribute("categories", dao.getAllCategories());
    view.forward(request, response);
}
}
