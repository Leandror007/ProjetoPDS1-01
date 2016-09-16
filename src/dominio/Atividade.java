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
@Table(name="tb_atividades")
public class Atividade implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codAtividade;
	private String nome;
	private BigDecimal preco;
	
	@OneToMany(mappedBy="atividade")
	private List<Participacao> participacoes;
	
	public Atividade() {
		participacoes = new ArrayList<>();
	}

	public Atividade(Integer codAtividade, String nome, BigDecimal preco) {
		super();
		this.codAtividade = codAtividade;
		this.nome = nome;
		this.preco = preco;
		participacoes = new ArrayList<>();
	}

	public Integer getCodAtividade() {
		return codAtividade;
	}

	public void setCodAtividade(Integer codAtividade) {
		this.codAtividade = codAtividade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public List<Participacao> getParticipacoes() {
		return participacoes;
	}

	public void setParticipacoes(List<Participacao> participacoes) {
		this.participacoes = participacoes;
	}

	@Override
	public String toString() {
		return "Atividade [codAtividade=" + codAtividade + ", nome=" + nome + ", preco=" + preco + "]";
	}
	
	
}
