package fcu.android.backend.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import fcu.android.backend.db.DatabaseManager;

@WebServlet(name = "Login", urlPatterns = { "/Login" })
public class LoginServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DatabaseManager dbManager = DatabaseManager.getInstance();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		request.getRequestDispatcher("link.html").include(request, response);

		String name = request.getParameter("name");
		String password = request.getParameter("password");
		boolean log=dbManager.loginOrganizer(name, password);
		if (log) {
			out.print("Welcome, " + name);
			HttpSession session = request.getSession();

			session.setAttribute("account", dbManager.getOrganizer(name));
		} else {
			out.print("Sorry, username or password error!");
			request.getRequestDispatcher("login.jsp").include(request, response);
		}
		out.close();
	}
}