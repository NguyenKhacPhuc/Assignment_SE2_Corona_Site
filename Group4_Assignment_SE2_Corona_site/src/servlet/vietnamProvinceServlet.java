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

import dao.VietNamProvinceDao;
import model.VietNamProvinces;

/**
 * This servlet acts as a page controller for the application, handling all
 * requests from the user.
 */

@WebServlet("/vietnamprovince")
public class vietnamProvinceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private VietNamProvinceDao provinceDao;
	
	public void init() {
		provinceDao = new VietNamProvinceDao();
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
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insertVietNamProvinces(request, response);
				break;
			case "/delete":
				deleteVietNamProvince(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateVietNamProvince(request, response);
				break;
			default:
				listVietNamProvinces(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void listVietNamProvinces(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<VietNamProvinces> listVietNamProvinces = provinceDao.selectAllProvinces();
		request.setAttribute("listVietNamProvinces", listVietNamProvinces);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Admin/ad-list-province.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Admin/ad-province-newform.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		String name = request.getParameter("name");
		VietNamProvinces existingVietNamProvinces = provinceDao.selectVietNamProvince(name);
		RequestDispatcher dispatcher = request.getRequestDispatcher("ad-province-editform.jsp");
		request.setAttribute("VietNamProvinces", existingVietNamProvinces);
		dispatcher.forward(request, response);

	}

	private void insertVietNamProvinces(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String name = request.getParameter("name");
		double confirmed = Double.parseDouble(request.getParameter("confirmed"));
		double underTreatment = Double.parseDouble(request.getParameter("underTreatment"));
		double recovered = Double.parseDouble(request.getParameter("recovered"));
		double deaths = Double.parseDouble(request.getParameter("deaths"));
		provinceDao.insertAProvince(name, confirmed, underTreatment, recovered, deaths);
		response.sendRedirect("list");
	}

	private void updateVietNamProvince(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String name = request.getParameter("name");
		double confirmed = Double.parseDouble(request.getParameter("confirmed"));
		double underTreatment = Double.parseDouble(request.getParameter("underTreatment"));
		double recovered = Double.parseDouble(request.getParameter("recovered"));
		double deaths = Double.parseDouble(request.getParameter("deaths"));
		provinceDao.updateAProvince(name, confirmed, underTreatment, recovered, deaths);
		response.sendRedirect("list");
	}

	private void deleteVietNamProvince(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String name = request.getParameter("name");
		provinceDao.deleteAprovince(name);
		response.sendRedirect("list");

	}
}
