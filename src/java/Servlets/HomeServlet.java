package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// /home
public class HomeServlet extends HttpServlet {

    // Handles GET
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        // create a session object
        HttpSession session = request.getSession();

        // redirect to login if there is no user attribute in the session
        if (session.getAttribute("username") == null ){
            response.sendRedirect("login");
            return;
        }
        
        // logout functionality
        if (request.getParameter("logout") != null) {
            session.invalidate();           // destroy the session
            response.sendRedirect("login"); // redirect to the login page
            return;
        }
        

        // render home.jsp.
        request.getRequestDispatcher("/WEB-INF/Home.jsp").forward(request, response);
    }

    // Handles POST
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
