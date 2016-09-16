package servico;

import java.util.List;

import dominio.Participante;

public interface ParticipanteServico {
	
	public void inserirAtualizar(Participante x);
	public void excluir(Participante x);
	public Participante buscar(int cod);
	public List<Participante> buscarTodos();
	
}
