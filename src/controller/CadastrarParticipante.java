package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servico.ParticipanteServico;
import servico.ServicoException;
import servico.ServicoFactory;
import dominio.Participante;


@WebServlet("/cadParticipante/CadastrarParticipante")
public class CadastrarParticipante extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static String ERRO = "publico/erro.jsp";
	private static String LISTAR = "/cadParticipante/participanteListar.jsp";
	private static String INSERIR_OU_ALTERAR = "/cadParticipante/participanteForm.jsp";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ParticipanteServico ps = ServicoFactory.criarParticipanteServico();	
		
		String forward = "";
		String cmd = request.getParameter("cmd");
		List<Participante> aux = ps.buscarTodos();
		
		if (cmd == null || cmd.equalsIgnoreCase("")){			
			request.setAttribute("lista", aux);		
			RequestDispatcher rd = request.getRequestDispatcher(LISTAR);
			rd.forward(request, response);
			cmd = "listar";		
		}
		
		/*-----------------------------------------------------------------------------------------------------------------------------*/
		/*-----------------------------------------------------------------------------------------------------------------------------*/
				
				
				if (cmd.equalsIgnoreCase("deletar")) {
					int cod = Integer.parseInt(request.getParameter("cod"));
					try {
						Participante part = ps.buscar(cod);
						if (part != null) {
							ps.excluir(part);
						
						}
						request.setAttribute("lista", ps.buscarTodos());				
						forward = LISTAR;
					} catch (RuntimeException e) {
						request.setAttribute("erro", "Erro de execução: " + e.getMessage());
						forward = ERRO;
					}
					/*comando necessario para atualizar a pagina */
					RequestDispatcher rd = request.getRequestDispatcher(forward);
					rd.forward(request, response);
				}
				
		/*-----------------------------------------------------------------------------------------------------------------------------*/
		/*-----------------------------------------------------------------------------------------------------------------------------*/		
			
				else if (cmd.equalsIgnoreCase("editar")) {
					int cod = Integer.parseInt(request.getParameter("cod"));
					try {
						Participante part = ps.buscar(cod);
						if (part != null) {
							request.setAttribute("part", part);
							forward = INSERIR_OU_ALTERAR;
						}
						else {
							request.setAttribute("lista", ps.buscarTodos());
							forward = LISTAR;
						}
					} catch (RuntimeException e) {
						request.setAttribute("Erro de execução: ", e.getMessage());
						forward = ERRO;
					}
					RequestDispatcher rd = request.getRequestDispatcher(forward);
					rd.forward(request, response);
				}
				

		/*-----------------------------------------------------------------------------------------------------------------------------*/
		/*-----------------------------------------------------------------------------------------------------------------------------*/		

				else if (cmd.equalsIgnoreCase("listar")) {
					try {
						request.setAttribute("lista", ps.buscarTodos());
						forward = LISTAR;
					} catch (RuntimeException e) {
						request.setAttribute("erro", "Erro de execução: " + e.getMessage());
						forward = ERRO;
					}
				}
				
		/*-----------------------------------------------------------------------------------------------------------------------------*/
		/*-----------------------------------------------------------------------------------------------------------------------------*/		
				else if (cmd.equalsIgnoreCase("novo")) {
					
					try {
						Participante part = new Participante();	
						
						request.setAttribute("part", part);
						forward = INSERIR_OU_ALTERAR;
						
					} catch (RuntimeException e) {
						request.setAttribute("erro", "Erro de execução: " + e.getMessage());
						forward = ERRO;
					}
					RequestDispatcher rd = request.getRequestDispatcher(forward);
					rd.forward(request, response);
				}
		}
			
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ParticipanteServico ps = ServicoFactory.criarParticipanteServico();
		String forward = "";
		Participante part = instanciar(request);
		ps.inserirAtualizar(part);
		request.setAttribute("lista", ps.buscarTodos());			
		forward = LISTAR;
			RequestDispatcher rd = request.getRequestDispatcher(forward);
			rd.forward(request, response);
		}

	private Participante instanciar(HttpServletRequest req) {
		ParticipanteServico ps = ServicoFactory.criarParticipanteServico();
		String aux;
		Participante x = new Participante();
		
		aux = req.getParameter("codParticipante");
		
		if (aux != null && !aux.isEmpty())
		x.setCodParticipante(Integer.parseInt(aux));
		
		aux = req.getParameter("nome");
		x.setNome(aux);
		
		return x;
	}
}


