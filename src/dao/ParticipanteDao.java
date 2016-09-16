package dao;

import java.util.List;

import dominio.Participante;

public interface ParticipanteDao {

	public void inserirAtualizar(Participante x);
	public void excluir(Participante x);
	public Participante buscar(int x);
	public List<Participante> buscarTodos();
}

