/*10.b Build an Application to get Rollno, Studentname, Sub1, Sub2, Sub3, Sub4 and Sub5  
 * through JSP called index.jsp with client sided validation and submit to the servlet 
 * called ResultServlet and process all the fields with server sided validation and 
 * display all the data along with result ( Pass if all subjects greater than 40%) and 
 * Average marks through result.jsp with a link to move to the client side
*/
package com.result;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/ResultServlet")
public class ResultServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String roll = request.getParameter("roll");
        String name = request.getParameter("name");

        String[] subs = new String[5];
        for (int i = 1; i <= 5; i++) {
            subs[i-1] = request.getParameter("sub" + i);
        }

        // 🔴 Server-side validation
        if (roll == null || roll.isEmpty() || name == null || name.isEmpty()) {
            response.getWriter().println("Invalid input!");
            return;
        }

        int[] marks = new int[5];

        try {
            for (int i = 0; i < 5; i++) {
                marks[i] = Integer.parseInt(subs[i]);

                if (marks[i] < 0 || marks[i] > 100) {
                    response.getWriter().println("Marks must be between 0 and 100!");
                    return;
                }
            }
        } catch (Exception e) {
            response.getWriter().println("Invalid marks format!");
            return;
        }

        // ✅ Pass data to JSP
        request.setAttribute("roll", roll);
        request.setAttribute("name", name);

        for (int i = 0; i < 5; i++) {
            request.setAttribute("sub" + (i+1), marks[i]);
        }

        RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
        rd.forward(request, response);
    }
}