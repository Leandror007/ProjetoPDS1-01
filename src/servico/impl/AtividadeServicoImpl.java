package servico.impl;

import java.math.BigDecimal;
import java.util.List;

import dao.impl.EM;
import dao.DaoFactory;

import dao.AtividadeDao;

import dominio.Atividade;
import servico.AtividadeServico;

public class AtividadeServicoImpl implements AtividadeServico {

	private AtividadeDao dao;
	
	public AtividadeServicoImpl() {
		dao = DaoFactory.criarAtividadeDao();
	}
	
	@Override
	public void inserirAtualizar(Atividade x) {
		EM.getLocalEm().getTransaction().begin();
		dao.inserirAtualizar(x);
		EM.getLocalEm().getTransaction().commit();
	}
	
	@Override
	public void excluir(Atividade x) {
		EM.getLocalEm().getTransaction().begin();
		dao.excluir(x);
		EM.getLocalEm().getTransaction().commit();
	}
	
	@Override
	public Atividade buscar(int codAtividade) {
		return dao.buscar(codAtividade);
	}

	@Override
	public List<Atividade> buscarTodos() {
		return dao.buscarTodos();
	}

	@Override
	public List<Atividade> buscarPorFaixaDePreco(BigDecimal precoMin, BigDecimal precoMax) {
		return dao.buscarPorFaixaDePreco(precoMin, precoMax);
	}
	
}