package web.servlet;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ProductDao;

import com.model.Product;
import java.io.File;
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
@WebServlet(name = "ProductServlet", urlPatterns = {"/Productos"})
public class ProductServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  private static String INSERT_OR_EDIT = "/producto_agregar.jsp";
  private static String LIST_USER = "/producto_listado.jsp";
  private ProductDao dao;
  public ProductServlet() {
        super();
        dao = new ProductDao();
  }
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String forward="";
    String action = request.getParameter("action");
    if (action.equalsIgnoreCase("delete")){
        int id = Integer.parseInt(request.getParameter("id"));
        dao.deleteProduct(id);
        forward = LIST_USER;
        request.setAttribute("products", dao.getAllProducts());    
    } else if (action.equalsIgnoreCase("edit")){
        forward = INSERT_OR_EDIT;
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = dao.getProductById(id);
        request.setAttribute("products", product);
    } else if (action.equalsIgnoreCase("listProducts")){
        forward = LIST_USER;
        request.setAttribute("products", dao.getAllProducts());
    } else {
        forward = INSERT_OR_EDIT;
    }
    RequestDispatcher view = request.getRequestDispatcher(forward);
    view.forward(request, response);
  }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id="";
        Product product = new Product();
        FileItemFactory itemfactory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(itemfactory);
        try{
            List<FileItem> items = upload.parseRequest(request);
            for(FileItem item:items){
                if (item.isFormField()) {
                    String fieldName = item.getFieldName().trim();String fieldValue = item.getString();
                    
                    switch(fieldName){
                        case "id":id = fieldValue;break;
                        case "name": product.setName(fieldValue);break;
                        case "description":product.setDescription(fieldValue);break;
                        case "categories_id":product.setCategories_id(Integer.parseInt(fieldValue));break;
                        case "quantityPerUnit":product.setQuantityPerUnit(Integer.parseInt(fieldValue));break;
                        case "unitInStock":product.setUnitInStock(Integer.parseInt(fieldValue));break;
                        case "unitPrice":product.setUnitPrice(Double.parseDouble(fieldValue));break;
                        case "disccount":product.setDisccount(Double.parseDouble(fieldValue));break;
                    }

                }else{
                    File uploadDir = new File("C:\\Users\\Java-Sab\\Documents\\ProyectoCibertec\\web\\imgServer");
                    File file = File.createTempFile("img",".jpg",uploadDir);
                    product.setPicture(file.getName());
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
            dao.addProduct(product);
        }
        else{
            product.setId(Integer.parseInt(id));
            dao.updateProduct(product);
        }    
        RequestDispatcher view = request.getRequestDispatcher(LIST_USER);
        request.setAttribute("products", dao.getAllProducts());
        view.forward(request, response);
    }
}
