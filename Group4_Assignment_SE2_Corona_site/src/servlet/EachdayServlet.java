package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EachDayDao;
import model.EachDay;

/**
 * This servlet acts as a page controller for the application, handling all
 * requests from the user.
 */

@WebServlet("/vietnam")
public class EachdayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EachDayDao eachDayDao;
	
	public void init() {
		eachDayDao = new EachDayDao();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/insert":
				insertDayStatistic(request, response);
				break;
			case "/edit":
				showEditForm(request, response);;
				break;
			case "/update":
				updateDayStatistic(request, response);
				break;
			default:
				listEachDay(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void listEachDay(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<EachDay> listeachDay = eachDayDao.getAllVietNamDays();
		request.setAttribute("listeachDay", listeachDay);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Admin/ad-vietnam-total.jsp");
		dispatcher.forward(request, response);
	}
	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int year = Integer.parseInt(request.getParameter("year"));
		int month = Integer.parseInt(request.getParameter("month"));
		int date = Integer.parseInt(request.getParameter("date"));
		EachDay existingDay = eachDayDao.selectOneDay(month,date,year);
		RequestDispatcher dispatcher = request.getRequestDispatcher("ad-vietnam-editform.jsp");
		request.setAttribute("eachDay", existingDay);
		dispatcher.forward(request, response);

	}

	private void insertDayStatistic(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String date = request.getParameter("date");
		double cases = Double.parseDouble(request.getParameter("cases"));
		double recovered = Double.parseDouble(request.getParameter("recovered"));
		double deaths = Double.parseDouble(request.getParameter("deaths"));
		eachDayDao.insertAday(date, cases, recovered, deaths);
		response.sendRedirect("list");
	}

	private void updateDayStatistic(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String date = request.getParameter("date");
		double cases = Double.parseDouble(request.getParameter("cases"));
		double recovered = Double.parseDouble(request.getParameter("recovered"));
		double deaths = Double.parseDouble(request.getParameter("deaths"));
		eachDayDao.updateASpecificDay(date, cases, recovered, deaths);
		response.sendRedirect("list");
	}
}
