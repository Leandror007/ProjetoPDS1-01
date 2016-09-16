package servico;

import servico.impl.AtividadeServicoImpl;
import servico.impl.ParticipacaoSevicoImpl;
import servico.impl.ParticipanteServicoImpl;

public class ServicoFactory {

	public static AtividadeServico criarAtividadeServico() {
		return new AtividadeServicoImpl();
	}
	
	public static ParticipacaoServico criarParticipacaoServico() {
		return new ParticipacaoSevicoImpl();
	}
	
	public static ParticipanteServico criarParticipanteServico() {
		return new ParticipanteServicoImpl();
	}
	
}