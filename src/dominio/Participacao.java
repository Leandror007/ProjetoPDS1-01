package dominio;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tb_participacoes")
public class Participacao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codParticipacao;
	private Date dataPagamento;

	@ManyToOne
	@JoinColumn(name="atividade")
	private Atividade atividade;
	
	@ManyToOne
	@JoinColumn(name="participante")
	private Participante participante;
		
	public Participacao() {	
	}

	public Participacao(Integer codParticipacao, Date dataPagamento, Atividade atividade, Participante participante) {
		super();
		this.codParticipacao = codParticipacao;
		this.dataPagamento = dataPagamento;
		this.atividade = atividade;
		this.participante = participante;
	}

	public Integer getCodParticipacao() {
		return codParticipacao;
	}

	public void setCodParticipacao(Integer codParticipacao) {
		this.codParticipacao = codParticipacao;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public Atividade getAtividade() {
		return atividade;
	}

	public void setAtividade(Atividade atividade) {
		this.atividade = atividade;
	}

	public Participante getParticipante() {
		return participante;
	}

	public void setParticipante(Participante participante) {
		this.participante = participante;
	}

	@Override
	public String toString() {
		return "Participacao [codParticipacao=" + codParticipacao + ", dataPagamento=" + dataPagamento + "]";
	}
	
	
	
}