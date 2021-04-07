/*
############################################################
#             ELAAMRANI SOUFIANE                           #
#      DATABASE(books.sql) in the same project file        #
#    first CRUD application with MySQL,JSP,Servlet,EL      #
# 														   #
############################################################
*/

package com.books;

import com.dao.*;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletController
 */
//@WebServlet("/Books/*")
public class ServletController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookDao bookDao;

	/**
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @see HttpServlet#HttpServlet()
	 */

	public ServletController() throws SQLException, ClassNotFoundException {
		super();
		bookDao = new BookDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getPathInfo();
		System.out.println(action);
		if (action.equals("/new")) {
			getPageNewAdd(request, response);

		} else if (action.equals("/delete")) {
			deleteBook(Integer.parseInt(request.getParameter("id")), request, response);
		} else if (action.equals("/update")) {
			try {
				request.setAttribute("book", bookDao.getItembyID(Integer.parseInt(request.getParameter("id"))));
			} catch (NumberFormatException | ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			RequestDispatcher disp = request.getRequestDispatcher("/updatepage.jsp");
			disp.forward(request, response);
		}

		else {
			showBooks(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getPathInfo();
		if (action.equals("/insert")) {
			addBooks(request, response);
			response.sendRedirect("index");
		} else if (action.equals("/updateitem")) {

			try {
				updateBook(Integer.parseInt(request.getParameter("id")),
						new Book(Integer.parseInt(request.getParameter("id")), request.getParameter("title"),
								request.getParameter("author"), Double.parseDouble(request.getParameter("price"))),
						response);

			} catch (NumberFormatException | ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block e.printStackTrace(); }

			}

		}
	}

	private void showBooks(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			request.setAttribute("book_list", bookDao.showAllItems());
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		RequestDispatcher disp = request.getRequestDispatcher("/index.jsp");
		disp.forward(request, response);
	}

	private void addBooks(HttpServletRequest request, HttpServletResponse response) {
		try {
			bookDao.insertItem(new Book((String) request.getParameter("title"), (String) request.getParameter("author"),
					Double.parseDouble((String) request.getParameter("price"))));
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void getPageNewAdd(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher disp = request.getRequestDispatcher("/addnew.jsp");
		disp.forward(request, response);
	}

	private void deleteBook(int id, HttpServletRequest request, HttpServletResponse respense) {
		try {
			bookDao.delete(id);
			respense.sendRedirect("index");
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void updateBook(int id, Book book, HttpServletResponse respense)
			throws ClassNotFoundException, SQLException, IOException {

		bookDao.update(id, book);
		respense.sendRedirect("index");

	}

}
