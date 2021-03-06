/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import Data.dataBase;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author cb-adithyaks
 */
public class SignUp extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out=response.getWriter();
        RequestDispatcher reqDis=request.getRequestDispatcher("SignUp.jsp");
        RequestDispatcher reqDis2=request.getRequestDispatcher("Login.jsp");
        String firstName=request.getParameter("firstName");
        String lastName=request.getParameter("lastName");
        String email=request.getParameter("email");
        String password=request.getParameter("password");
        String error=null;
        try{
            if(password==null || password.equals("")){
                error="Enter a valid password";
            }
            if(email==null || email.equals("")){
                error="Enter a valid emailId";
            }
            else if(dataBase.checkIfUserExists(email)!=null){
                error="User already exists";
            }
            if(lastName==null || lastName.equals("")){
                error="Enter the last name";
            }
            if(firstName==null || firstName.equals("")){
                error="Enter the first name";
            }
            if(!email.equals(request.getParameter("confirmEmail"))){
                error="Email mismatch";
            }
            if(!password.equals(request.getParameter("confirmPassword"))){
                error="Password mismatch";
            }
            if(error!=null){
                reqDis.include(request, response);
                out.println(error);
            }
            else{
                dataBase.createUser(firstName,lastName,email,password);
                reqDis2.include(request, response);
                out.println("<center> Successfully created Please use emailId and password to log in");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
