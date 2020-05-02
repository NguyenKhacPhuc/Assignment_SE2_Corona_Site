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

import dao.WorldGeneralDao;
import model.WorldGeneral;

/**
 * This servlet acts as a page controller for the application, handling all
 * requests from the user.
 */

@WebServlet("/world")
public class worldServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private WorldGeneralDao worldGeneralDao;
	
	public void init() {
		worldGeneralDao = new WorldGeneralDao();
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
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateWorldGeneralHistoricalRecord(request, response);
				break;
			case "/auto-update":
				updateWorldCurrentRecord(request, response);
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
		List<WorldGeneral> worldGeneral = worldGeneralDao.getHistoricalWorldGeneral();
		request.setAttribute("worldGeneral", worldGeneral);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Admin/ad-theworld.jsp");
		dispatcher.forward(request, response);
	}
	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		WorldGeneral currentWorldRecod = worldGeneralDao.getCurrentWorldGeneral();
		RequestDispatcher dispatcher = request.getRequestDispatcher("ad-vietnam-editform.jsp");
		request.setAttribute("currentWorldRecod", currentWorldRecod);
		dispatcher.forward(request, response);

	}

	private void updateWorldGeneralHistoricalRecord(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String date = request.getParameter("date");
		int newConfirmed = Integer.parseInt(request.getParameter("newConfirmed"));
		int totalConfirmed = Integer.parseInt(request.getParameter("totalConfirmed"));
		int newDeaths = Integer.parseInt(request.getParameter("newDeaths"));		
		int totalDeaths = Integer.parseInt(request.getParameter("totalDeaths"));
		int newRecovered = Integer.parseInt(request.getParameter("newRecovered"));
		int totalRecovered = Integer.parseInt(request.getParameter("totalRecovered"));
		worldGeneralDao.updateWorldGeneralManually(date, newConfirmed, totalConfirmed, newDeaths, totalDeaths, newRecovered, totalRecovered);
		response.sendRedirect("list");
	}
	
	private void updateWorldCurrentRecord(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		worldGeneralDao.getCurrentWorldGeneral();
		response.sendRedirect("list");
	}
}
