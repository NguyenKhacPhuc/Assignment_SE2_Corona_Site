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

import dao.CountryDao;
import model.Country;

/**
 * This servlet acts as a page controller for the application, handling all
 * requests from the user.
 */

@WebServlet("/country")
public class countryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private dao.CountryDao countryDao;

	public void init() {
		try {
			countryDao = new CountryDao();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");

		try {
			String action = request.getServletPath();
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insertCountry(request, response);
				break;
			case "/delete":
				deleteCountry(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateCountry(request, response);
				break;
			case "/auto-update":
				autoUpdateCountry(request, response);
				break;
			case "/vn":
				selectVn(request, response);
				break;
			default:
				listCountry(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	
	private void listCountry(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Country> listCountry = countryDao.selectAllCountry();
		request.setAttribute("listCountry", listCountry);
		System.out.println(listCountry.get(1).getCountry());
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Admin/ad-list-country.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Admin/ad-country-newform.jsp");
		dispatcher.forward(request, response);
	}

	private void autoUpdateCountry(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		List<Country> listCountry = countryDao.selectAllCountry();
		request.setAttribute("listCountry", listCountry);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Admin/ad-list-country.jsp");
		dispatcher.forward(request, response);
	}
	
	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		String cD = request.getParameter("countryCode");
		Country existingCountry = countryDao.selectCustomCountry(cD);
		System.out.println(existingCountry.getCountry());
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Admin/ad-country-editform.jsp");
		request.setAttribute("country", existingCountry);
		dispatcher.forward(request, response);

	}
	
	private void selectVn(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		Country existingCountry = countryDao.selectVietNamCurrent();
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Admin/ad-vietnam-editform.jsp");
		request.setAttribute("country", existingCountry);
		dispatcher.forward(request, response);
	}

	
	private void insertCountry(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		String country = request.getParameter("country");
		double newConfirmed = Double.parseDouble(request.getParameter("newConfirmed"));
		double totalConfirmed = Double.parseDouble(request.getParameter("totalConfirmed"));
		double newDeaths = Double.parseDouble(request.getParameter("newDeaths"));		
		double totalDeaths = Double.parseDouble(request.getParameter("totalDeaths"));
		double newRecovered = Double.parseDouble(request.getParameter("newRecovered"));
		double totalRecovered = Double.parseDouble(request.getParameter("totalRecovered"));
		String date = request.getParameter("date");
		String countryCode = request.getParameter("countryCode");
		countryDao.insertACountry(country, newConfirmed, totalConfirmed, newDeaths, totalDeaths, newRecovered, totalRecovered, date, countryCode);;
		response.sendRedirect("list");
	}

	private void updateCountry(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		String country = request.getParameter("country");
		double newConfirmed = Double.parseDouble(request.getParameter("newConfirmed"));
		double totalConfirmed = Double.parseDouble(request.getParameter("totalConfirmed"));
		double newDeaths = Double.parseDouble(request.getParameter("newDeaths"));		
		double totalDeaths = Double.parseDouble(request.getParameter("totalDeaths"));
		double newRecovered = Double.parseDouble(request.getParameter("newRecovered"));
		double totalRecovered = Double.parseDouble(request.getParameter("totalRecovered"));
		String date = request.getParameter("date");
		String countryCode = request.getParameter("countryCode");
		countryDao.updateSpecificCountry(country, newConfirmed, totalConfirmed, newDeaths, totalDeaths, newRecovered, totalRecovered, date, countryCode);
		response.sendRedirect("list");
	}

	private void deleteCountry(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		String countryCode = request.getParameter("countryCode");
		countryDao.deleteCountry(countryCode);
		response.sendRedirect("list");

	}
}
