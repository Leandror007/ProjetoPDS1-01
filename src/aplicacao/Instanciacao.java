package aplicacao;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import servico.AtividadeServico;
import servico.ParticipacaoServico;
import servico.ParticipanteServico;
import servico.ServicoFactory;
import dominio.Atividade;
import dominio.Participacao;
import dominio.Participante;

public class Instanciacao {

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Participante p1 = new Participante(null, "Joao");
		Participante p2 = new Participante(null, "Ana");
		
		Atividade a1 = new Atividade(null, "Minicurso", new BigDecimal("30.00"));
		Atividade a2 = new Atividade(null, "Paletra", new BigDecimal("15.00"));
		Atividade a3 = new Atividade(null, "Oficina", new BigDecimal("20.00"));
		
		
		Participacao pa1 = new Participacao(null, sdf.parse("10/12/2015"), a1, p1);
		Participacao pa2 = new Participacao(null, sdf.parse("15/12/2015"), a3, p1);
		Participacao pa3 = new Participacao(null, sdf.parse("13/12/2015"), a2, p2);
		Participacao pa4 = new Participacao(null, sdf.parse("15/12/2015"), a3, p2);
		
		
		//para agilizar, basta associar o muitos para um, que o programa entende
		//sysout
		
		ParticipanteServico ps = ServicoFactory.criarParticipanteServico();
		AtividadeServico as = ServicoFactory.criarAtividadeServico();
		ParticipacaoServico pas = ServicoFactory.criarParticipacaoServico();
		
		
		ps.inserirAtualizar(p1);
		ps.inserirAtualizar(p2);
		
		as.inserirAtualizar(a1);
		as.inserirAtualizar(a2);
		as.inserirAtualizar(a3);
		
		
		pas.inserirAtualizar(pa1);
		pas.inserirAtualizar(pa1);
		pas.inserirAtualizar(pa3);
		pas.inserirAtualizar(pa4);
		
		
		System.out.println("Terminado!");
	}

}
