package dao;

import java.math.BigDecimal;
import java.util.List;

import dominio.Atividade;

public interface AtividadeDao {

	public void inserirAtualizar(Atividade x);
	public void excluir(Atividade x);
	public Atividade buscar(int x);
	public List<Atividade> buscarTodos();
	public List<Atividade> buscarPorFaixaDePreco(BigDecimal precoMin, BigDecimal precoMax);
}

