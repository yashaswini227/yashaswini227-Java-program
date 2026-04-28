/*
 * 8b. Build a servlet program to  create a cookie to get your name through text box 
 * and press submit button to display the message by greeting Welcome back your name ! 
 * , you have visited this page n times ( n = number of your visit ) and demonstrate the 
 * expiry of cookie also. 
 */

package com.cookieservlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/CookieServlet")
public class CookieServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Read cookies
        Cookie[] cookies = request.getCookies();
        String existingUser = null;
        int count = 0;

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("user")) {
                    existingUser = cookie.getValue();
                }
                if (cookie.getName().equals("count")) {
                    count = Integer.parseInt(cookie.getValue());
                }
            }
        }

        out.println("<html><body>");

        if (existingUser != null) {
            count++;

            // Update count cookie
            Cookie countCookie = new Cookie("count", String.valueOf(count));
            countCookie.setMaxAge(60);
            countCookie.setPath("/");
            response.addCookie(countCookie);

            out.println("<h2 style='color:blue;'>Welcome back, " + existingUser + "!</h2>");
            out.println("<h2 style='color:magenta;'>You visited " + count + " times!</h2>");

            // Logout button
            out.println("<form action='CookieServlet' method='post'>");
            out.println("<input type='submit' value='Logout'>");
            out.println("</form>");

        } else {
            out.println("<h2 style='color:red;'>Welcome Guest!  you have been logged out or kindly login first time</h2>");
            out.println("<form action='CookieServlet' method='post'>");
            out.println("Enter your name: <input type='text' name='userName'>");
            out.println("<input type='submit' value='Submit'>");
            out.println("</form>");
        }

        out.println("</body></html>");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String userName = request.getParameter("userName");

        if (userName != null && !userName.isEmpty()) {
            // Create user cookie
            Cookie userCookie = new Cookie("user", userName);
            userCookie.setMaxAge(60);
            userCookie.setPath("/");
            response.addCookie(userCookie);

            // Initialize visit count
            Cookie countCookie = new Cookie("count", "0");
            countCookie.setMaxAge(60);
            countCookie.setPath("/");
            response.addCookie(countCookie);

        } else {
            // Logout logic
            Cookie userCookie = new Cookie("user", "");
            userCookie.setMaxAge(0);
            userCookie.setPath("/");
            response.addCookie(userCookie);

            Cookie countCookie = new Cookie("count", "");
            countCookie.setMaxAge(0);
            countCookie.setPath("/");
            response.addCookie(countCookie);
        }

        response.sendRedirect("CookieServlet");
    }
}