package controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Atividade;
import servico.AtividadeServico;
import servico.ServicoFactory;

@WebServlet("/operador/VisualizarParticipacoes")
public class VisualizarParticipacoes extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static String ERRO = "publico/erro.jsp";
	private static String INFORMARPRECO = "/operador/informarPreco.jsp";
	private static String LISTARATIV = "/operador/listarAtividade.jsp";
	private static String DETALHES = "/operador/listarParticipacoes.jsp";


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AtividadeServico as = ServicoFactory.criarAtividadeServico();
		
		String paginaDestino = "";
		String cmd = request.getParameter("cmd");
		if(cmd == null || cmd.equalsIgnoreCase(""))
			cmd = "informarPrecos";
		
/////////////////////////////////////////////////////////////////////////////////////////////////////////		
			
		
		if(cmd.equalsIgnoreCase("informarPrecos")){
			paginaDestino = INFORMARPRECO;
			
		}	

/////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		else if(cmd.equalsIgnoreCase("mostrarDetalhes")){
			int codAtividade = Integer.parseInt(request.getParameter("cod"));
			Atividade at = as.buscar(codAtividade);
			at.getParticipacoes().size(); //gambiara forçar o carregamento da lista aqui
			request.setAttribute("lista", at.getParticipacoes()); //apelido lista
			paginaDestino = DETALHES;
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(paginaDestino);
		rd.forward(request, response);
	
		}

/////////////////////////////////////////////////////////////////////////////////////////////////////////	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		AtividadeServico as = ServicoFactory.criarAtividadeServico();
		
		String paginaDestino = "";
		String cmd = request.getParameter("cmd");
		if(cmd == null || cmd.equalsIgnoreCase(""))
			cmd = "informarPrecos";
		
		
	
		 if(cmd.equalsIgnoreCase("visualizarAtividades")){
			BigDecimal precoMin = new BigDecimal(request.getParameter("precoMin"));
			BigDecimal precoMax = new BigDecimal(request.getParameter("precoMax"));
			
			List<Atividade> lista = as.buscarPorFaixaDePreco(precoMin, precoMax);
			request.setAttribute("lista", lista); //apelido lista, que vai ser usado no listar atividade lista
			paginaDestino = LISTARATIV;
			
		 }
		 	RequestDispatcher rd = request.getRequestDispatcher(paginaDestino);
		 	rd.forward(request, response);
		}
}