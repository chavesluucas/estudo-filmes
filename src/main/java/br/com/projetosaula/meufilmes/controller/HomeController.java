package br.com.projetosaula.meufilmes.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="HomeController", urlPatterns = "/")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public HomeController() {
        super(); 
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Estamos estanciando essa Request, está requisitando uma view
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/home.jsp");
		rd.forward(request, response);
	}

}
