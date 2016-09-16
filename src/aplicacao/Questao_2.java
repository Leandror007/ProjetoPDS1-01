package aplicacao;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthSeparatorUI;

import servico.AtividadeServico;
import servico.ServicoFactory;
import dominio.Atividade;
import dominio.Participacao;

public class Questao_2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Entre com o preco minimo: ");
		BigDecimal precoMin = new BigDecimal(sc.nextLine());
		
		System.out.println("Entre com o preco maximo: ");
		BigDecimal precoMax = new BigDecimal(sc.nextLine());
		
		
		AtividadeServico as = ServicoFactory.criarAtividadeServico();
		
		List<Atividade> lista = as.buscarPorFaixaDePreco(precoMin, precoMax);
		
		
		System.out.println("Atividades dentro da faixa de preco: ");
		for(Atividade x: lista){
			System.out.println(x);
		}
		
		
		System.out.println("\n Digite o codigo de uma atividade: ");
		int codAtividade = Integer.parseInt(sc.nextLine());
		
		Atividade selecionada = as.buscar(codAtividade);
		
		System.out.println("Participantes da atividade "+selecionada.getNome()+":");
		
		for(Participacao x : selecionada.getParticipacoes()){
			System.out.println(x.getParticipante().getCodParticipante()+", "+x.getParticipante().getNome()+", Pagamento "+sdf.format(x.getDataPagamento()));
		}
		

	}

}
