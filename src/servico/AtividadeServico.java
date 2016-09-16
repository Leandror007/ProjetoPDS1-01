package servico;

import java.math.BigDecimal;
import java.util.List;

import dominio.Atividade;

public interface AtividadeServico {
	
	public void inserirAtualizar(Atividade x);
	public void excluir(Atividade x);
	public Atividade buscar(int cod);
	public List<Atividade> buscarTodos();
	public List<Atividade> buscarPorFaixaDePreco(BigDecimal precoMin, BigDecimal precoMax);
}
