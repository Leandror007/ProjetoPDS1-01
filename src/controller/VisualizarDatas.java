package controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servico.ParticipacaoServico;
import servico.ServicoFactory;
import dominio.Participacao;


@WebServlet("/operador2/VisualizarDatas")
public class VisualizarDatas extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static String INFORMARDATA = "/operador2/informarData.jsp";
	private static String LISTARPARTI = "/operador2/listarParticipacaoData.jsp";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
ParticipacaoServico as = ServicoFactory.criarParticipacaoServico();
		
		String paginaDestino = "";
		String cmd = request.getParameter("cmd");
		if(cmd == null || cmd.equalsIgnoreCase(""))
			cmd = "informarData";
		
/////////////////////////////////////////////////////////////////////////////////////////////////////////		
		
		
	   if(cmd.equalsIgnoreCase("informarData")){
		   paginaDestino = INFORMARDATA;

}	

/////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		
		
	}

	
@SuppressWarnings("deprecation")
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ParticipacaoServico ps = ServicoFactory.criarParticipacaoServico();
		
		String paginaDestino = "";			
		String cmd = request.getParameter("cmd");
		
		
		if(cmd == null || cmd.equalsIgnoreCase(""))
			cmd = "informarData";		
		
	
		 if(cmd.equalsIgnoreCase("visualizarDatas")){
			 
			 SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				
			 Date dataInicial = null;
			try {
				dataInicial = sdf.parse(request.getParameter("dataInicial"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			 Date dataFinal = null;
			try {
				dataFinal = sdf.parse(request.getParameter("dataFinal"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
			 List<Participacao> lista = ps.buscarPorData(dataInicial, dataFinal);
				 
				 
				 request.setAttribute("lista", lista); //apelido lista, que vai ser usado no listar atividade lista
				 paginaDestino = LISTARPARTI;
			
				 System.out.println(cmd);
			
		 }
		 	RequestDispatcher rd = request.getRequestDispatcher(paginaDestino);
		 	rd.forward(request, response);
		}


	}


