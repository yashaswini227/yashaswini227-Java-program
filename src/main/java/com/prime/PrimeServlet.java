/*
 * 6c. Build a servlet program to check the given number is prime number or not ,
 *  using HTML with Error Code when an invalid number is entered  step by step procedure.
 */


package com.prime;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/PrimeServlet")
public class PrimeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("<h2 style='color:blue;'>Welcome to Prime Checker</h2>");
        out.println("<a href='index.html'>Click here to enter a number</a>");
        out.println("</body></html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String input = request.getParameter("number");

        out.println("<html><body>");

        if (input == null || input.trim().isEmpty()) {
            out.println("<h2 style='color:red;'>Error: Number is required!</h2>");
        } else {
            try {
                int num = Integer.parseInt(input);

                if (num <= 1) {
                    out.println("<h2 style='color:red;'>Enter number greater than 1!</h2>");
                } else {
                    boolean isPrime = true;

                    for (int i = 2; i <= Math.sqrt(num); i++) {
                        if (num % i == 0) {
                            isPrime = false;
                            break;
                        }
                    }

                    if (isPrime) {
                        out.println("<h2 style='color:green;'>" + num + " is Prime</h2>");
                    } else {
                        out.println("<h2 style='color:red;'>" + num + " is Not Prime</h2>");
                    }
                }

            } catch (NumberFormatException e) {
                out.println("<h2 style='color:red;'>Invalid number format!</h2>");
            }
        }

        out.println("<br><a href='index.html'>Try Again</a>");
        out.println("</body></html>");
    }
}    