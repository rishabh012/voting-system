
 package login;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class login extends HttpServlet {

   

    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
       response.setContentType("text/html");
       PrintWriter out = response.getWriter();
       String n = request.getParameter("Username");
       
       String p = request.getParameter("Password");
       if(loginDAO.validate(n, p)){
          RequestDispatcher rd = request.getRequestDispatcher("login.html");
          rd.forward(request,response);
       }
       else{
           out.print("Sorry username or password error");  
        RequestDispatcher rd=request.getRequestDispatcher("login.html");  
        rd.include(request,response);  
       }
       out.close();
    }
}
   
    





  