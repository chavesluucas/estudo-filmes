package br.com.projetosaula.meufilmes.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import br.com.projetosaula.meufilmes.dao.FilmeDAO;
import br.com.projetosaula.meusfilmes.beans.Filme;

@WebServlet(name="FilmeController", urlPatterns="/filmes")
public class FilmeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//inserindo o dao
	private FilmeDAO filmeDAO = new FilmeDAO();

    public FilmeController() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Feito dnv
		//Criado uma variavel que vai receber um request de um parametro
		String action = request.getParameter("Action");
		
		switch(action.toUpperCase()) {
		case "LIST":
				listFilmesAction(request, response);
			break;

		default:
			break;
		}
		
	}


	private void listFilmesAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//importamos a lista do filmes, criado a variavel chamada filme q vai receber getListFilmes do filmeDAO 
		
		//pega lista do banco
		List<Filme> filmes = filmeDAO.getListFilmes();
		
		//vai carregar uma pagina
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/listFilmes.jsp");
		
		
		request.setAttribute("listFilmes", filmes);
		
		rd.forward(request, response);
		
//		for (Filme filme : filmes) {
//			response.getWriter().append("Filme: " + filme.getTitulo());
//		}
	}


	//foi criado enquanto fazia o doGet
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
