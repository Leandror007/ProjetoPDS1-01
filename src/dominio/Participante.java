package dominio;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tb_participantes")
public class Participante implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codParticipante;
	private String nome;
	
	@OneToMany(mappedBy="participante")
	private List<Participacao> participacoes;
	
	public Participante() {
		participacoes = new ArrayList<>();
	}

	public Participante(Integer codParticipante, String nome) {
		super();
		this.codParticipante = codParticipante;
		this.nome = nome;
		participacoes = new ArrayList<>();
	}

	public Integer getCodParticipante() {
		return codParticipante;
	}

	public void setCodParticipante(Integer codParticipante) {
		this.codParticipante = codParticipante;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Participacao> getParticipacoes() {
		return participacoes;
	}

	public void setParticipacoes(List<Participacao> participacoes) {
		this.participacoes = participacoes;
	}

	@Override
	public String toString() {
		return "Participante [codParticipante=" + codParticipante + ", nome=" + nome + "]";
	}
	
	public BigDecimal custoTotal() {
		BigDecimal soma = new BigDecimal("0.00");
		for (Participacao p : participacoes) {
			soma = soma.add(p.getAtividade().getPreco());
		}
		return soma;
	}
}
