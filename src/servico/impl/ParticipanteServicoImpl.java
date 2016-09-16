package servico.impl;

import java.util.List;

import dao.impl.EM;
import dao.DaoFactory;

import dao.ParticipanteDao;

import dominio.Participante;
import servico.ParticipanteServico;

public class ParticipanteServicoImpl implements ParticipanteServico {

	private ParticipanteDao dao;
	
	public ParticipanteServicoImpl() {
		dao = DaoFactory.criarParticipanteDao();
	}
	
	@Override
	public void inserirAtualizar(Participante x) {
		EM.getLocalEm().getTransaction().begin();
		dao.inserirAtualizar(x);
		EM.getLocalEm().getTransaction().commit();
	}
	
	@Override
	public void excluir(Participante x) {
		EM.getLocalEm().getTransaction().begin();
		dao.excluir(x);
		EM.getLocalEm().getTransaction().commit();
	}
	
	@Override
	public Participante buscar(int codParticipante) {
		return dao.buscar(codParticipante);
	}

	@Override
	public List<Participante> buscarTodos() {
		return dao.buscarTodos();
	}
	
}