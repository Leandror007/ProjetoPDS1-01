package dao.impl;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.service.spi.ServiceException;

import dao.AtividadeDao;
import dominio.Atividade;

public class AtividadeDaoImpl implements AtividadeDao {

	private EntityManager em;
	
	public AtividadeDaoImpl() {
		this.em = EM.getLocalEm();
	}
	
	@Override
	public void inserirAtualizar(Atividade x) {
		if (x.getCodAtividade() != null) {
			x = em.merge(x);
		}
		em.persist(x);
	}
	
	@Override
	public void excluir(Atividade x) {
		x = em.merge(x);
		em.remove(x);
	}
	
	@Override
	public Atividade buscar(int codAtividade) {
		return em.find(Atividade.class, codAtividade);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Atividade> buscarTodos() {
		String jpql = "SELECT x FROM Atividade x";
		Query query = em.createQuery(jpql);
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Atividade> buscarPorFaixaDePreco(BigDecimal precoMin, BigDecimal precoMax)  {
		
		// para web: String s = "SELECT a FROM Atividade a WHERE 1=1";
		
		String jpql = "SELECT x FROM Atividade x WHERE x.preco >= :p1 and x.preco <= :p2";
		Query query = em.createQuery(jpql);
		query.setParameter("p1", precoMin);
		query.setParameter("p2", precoMax);
		
	return query.getResultList();			
	
	}
	
}
