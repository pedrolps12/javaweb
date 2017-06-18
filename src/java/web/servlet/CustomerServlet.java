package web.servlet;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.CustomerDao;
import com.model.Customer;
/**
 *
 * @author Lucker
 */
@WebServlet(name = "CustomerServlet", urlPatterns = {"/Clientes"})
public class CustomerServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  private static String INSERT_OR_EDIT = "/cliente_agregar.jsp";
  private static String LIST_USER = "/cliente_listado.jsp";
  private CustomerDao dao;
  public CustomerServlet() {
        super();
        dao = new CustomerDao();
  }
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String forward="";
    String action = request.getParameter("action");
    if (action.equalsIgnoreCase("delete")){
        int id = Integer.parseInt(request.getParameter("id"));
        dao.deleteCustomer(id);
        forward = LIST_USER;
        request.setAttribute("customers", dao.getAllCustomers());    
    } else if (action.equalsIgnoreCase("edit")){
        forward = INSERT_OR_EDIT;
        int id = Integer.parseInt(request.getParameter("id"));
        Customer customer = dao.getCustomerById(id);
        request.setAttribute("customer", customer);
    } else if (action.equalsIgnoreCase("listCustomer")){
        forward = LIST_USER;
        request.setAttribute("customers", dao.getAllCustomers());
    } else {
        forward = INSERT_OR_EDIT;
    }
    RequestDispatcher view = request.getRequestDispatcher(forward);
    view.forward(request, response);
  }
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    Customer customer = new Customer();
    customer.setFirstName(request.getParameter("firstName"));
    customer.setLastName(request.getParameter("lastName"));
    try {
        Date dob = new SimpleDateFormat("yyy-MM-dd").parse(request.getParameter("birthDate"));
        customer.setBirthDate(dob);
    } catch (ParseException e) {
        e.printStackTrace();
    }
    customer.setEmail(request.getParameter("email"));
    customer.setUbigeo(request.getParameter("distrito"));
    String id = request.getParameter("id");
    if(id == null || id.isEmpty()){
        dao.addCustomer(customer);
    }
    else{
        customer.setId(Integer.parseInt(id));
        dao.updateCustomer(customer);
    }
    //BUSCAR LA FORMA DE REDIRECCIONAR Y ALTERAR EL URL--------------------------------------------------------------------------------------------sigue grabando al actualizar 2 veces
    RequestDispatcher view = request.getRequestDispatcher(LIST_USER);
    request.setAttribute("customers", dao.getAllCustomers());
    view.forward(request, response);
}
}
