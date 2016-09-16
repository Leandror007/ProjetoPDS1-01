package servico;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import dominio.Atividade;
import dominio.Participacao;

public interface ParticipacaoServico {
	
	public void inserirAtualizar(Participacao x);
	public void excluir(Participacao x);
	public Participacao buscar(int cod);
	public List<Participacao> buscarTodos();
	public List<Participacao> buscarPorData(Date dataInicial, Date dataFinal);
	
}
