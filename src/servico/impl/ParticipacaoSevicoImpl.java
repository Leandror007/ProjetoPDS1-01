package servico.impl;

import java.util.Date;
import java.util.List;

import servico.ParticipacaoServico;
import dao.DaoFactory;
import dao.ParticipacaoDao;
import dao.impl.EM;
import dominio.Participacao;

public class ParticipacaoSevicoImpl implements ParticipacaoServico {

	private ParticipacaoDao dao;
	
	public ParticipacaoSevicoImpl() {
		dao = DaoFactory.criarParticipacaoDao();
	}
	
	@Override
	public void inserirAtualizar(Participacao x) {
		EM.getLocalEm().getTransaction().begin();
		dao.inserirAtualizar(x);
		EM.getLocalEm().getTransaction().commit();
	}
	
	@Override
	public void excluir(Participacao x) {
		EM.getLocalEm().getTransaction().begin();
		dao.excluir(x);
		EM.getLocalEm().getTransaction().commit();
	}
	
	@Override
	public Participacao buscar(int codParticipacao) {
		return dao.buscar(codParticipacao);
	}

	@Override
	public List<Participacao> buscarTodos() {
		return dao.buscarTodos();
	}
	
	@Override
	public List<Participacao> buscarPorData(Date dataInicial, Date dataFinal) { 
		return dao.buscarPorData(dataInicial, dataFinal);
	}
}