
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DbManager.DbMethods;

//created by Sai Kireety Kokkiligadda
//Last 4 digits of id:	7714

/**
 * Servlet implementation class addCoursesServlet
 */
@WebServlet("/addCoursesServlet")
public class addCoursesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public addCoursesServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("user");
		HttpSession session = request.getSession();
		session.setAttribute("userName", username);
		ArrayList userCourses = new ArrayList();
		userCourses = DbMethods.listUserCourses(username);
		String crn1 = request.getParameter("crn1");
		String crn2 = request.getParameter("crn2");
		String crn3 = request.getParameter("crn3");
		if (userCourses.size() > 0) {
			request.setAttribute("crn1", crn1);
			request.setAttribute("crn2", crn2);
			request.setAttribute("crn3", crn3);
			request.setAttribute("userCourses", userCourses);
			request.getRequestDispatcher("AlreadyAdded.jsp").forward(request,
					response);
		} else {
			DbMethods.addUserCourses(username, crn1, crn2, crn3);
			request.getRequestDispatcher("userCoursesServlet").forward(request,
					response);
		}
	}

}
