/**
 *
 */
package Servlets;

import Models.User;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import service.AccountService; // Note: Services cannot be capatalized for some reason

// /login
public class LoginServlet extends HttpServlet {

    // Handles GET
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Display login form
        request.getRequestDispatcher("/WEB-INF/Login.jsp").forward(request, response);
        // Logout the user
    }

    // Handles POST
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // get username and password from the JSP form
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // create a accountService object
        AccountService as = new AccountService();

        // Validate username and password form isnt empty
        if (username != "" || password != "") {

            // validate the username and password
            User user = as.login(username, password);

            if (user == null) {
                // auth error
                String errorMsg = "Incorrect enter username or password";                      // error message
                request.setAttribute("errorMsg", errorMsg);                                    // send to JSP
                request.getRequestDispatcher("/WEB-INF/Login.jsp").forward(request, response); // Rerender this JSP
            } else {
                // auth successful, pass variables to session and redirect to home.JSP
                HttpSession session = request.getSession();
                session.setAttribute("username", username);
                //
                response.sendRedirect("home");
            }

            return;
        } else {
            // validation error
            String errorMsg = "Please enter username and password";                        // error message
            request.setAttribute("errorMsg", errorMsg);                                    // send to JSP
            request.getRequestDispatcher("/WEB-INF/Login.jsp").forward(request, response); // Rerender this JSP
            return;
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
