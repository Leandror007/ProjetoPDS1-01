package dao.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.ParticipacaoDao;
import dominio.Atividade;
import dominio.Participacao;

public class ParticipacaoDaoImpl implements ParticipacaoDao {

	private EntityManager em;
	
	public ParticipacaoDaoImpl() {
		this.em = EM.getLocalEm();
	}
	
	@Override
	public void inserirAtualizar(Participacao x) {
		if (x.getCodParticipacao() != null) {
			x = em.merge(x);
		}
		em.persist(x);
	}
	
	@Override
	public void excluir(Participacao x) {
		x = em.merge(x);
		em.remove(x);
	}
	
	@Override
	public Participacao buscar(int codParticipacao) {
		return em.find(Participacao.class, codParticipacao);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Participacao> buscarTodos() {
		String jpql = "SELECT x FROM Participacao x";
		Query query = em.createQuery(jpql);
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Participacao> buscarPorData(Date dataInicial, Date dataFinal)  {
		
		// para web: String s = "SELECT a FROM Atividade a WHERE 1=1";
		
		String jpql = "SELECT x FROM Participacao x WHERE x.dataPagamento >= :p1 and x.dataPagamento <= :p2";
		Query query = em.createQuery(jpql);
		query.setParameter("p1", dataInicial);
		query.setParameter("p2", dataFinal);
		
	return query.getResultList();			
	
	}
	
}
