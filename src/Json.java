import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class Json extends LeitorDeArquivo{
	

	public Json(String caminho) {
		super(caminho);
		this.conteudo = lerArquivo();
	}

	@Override
	public void converteParaObjeto() {
		Gson g = new Gson();
		String json = conteudo.toString();
		
		Type lista = new TypeToken<List<Remessa>>() {}.getType();
		
		remessasJson = g.fromJson(json, lista);
		System.out.println("ok");
	}

	public void imprimeClienteEmPosicaoEspecifica(int posicao) {
		 
		// Pegando cliente na posicao indicada
		Remessa res = remessasJson.get(posicao);
		
		this.impressor.imprimeCliente(res);
	}
	
	@Override
	public void imprimeRemessa() {
		
		for(Remessa res: remessasJson) {
			System.out.println("Nome: " + res.getNome());
			System.out.println("CPF: " + res.getCPF());
			System.out.println("Banco do Recebimento: " + res.getBancoRecebimento());
			System.out.println("Banco do Pagamaento: " + res.getBancoPagamento());
			System.out.println("Data da Transa��o: " + res.getData());
			System.out.printf( "%.2f", res.getValor() );
			
			if (res.getNumeroBoleto() != null) {
				// Se o valor do boleto  n�o � nulo
				// Ent�o o cliente pagou com boleto
				System.out.println("\nPAGO COM BOLETO:");
				System.out.println("N�m. Boleto: " + res.getNumeroBoleto());
			}
			else if (res.getParcelas() == 0) {
				// Se o cliente n�o pagou com boleto ent�o pagou com cart�o
				// Se n�o tem a quantidade de parcelas
				// Ent�o o cliente pagou com cart�o de D�bito
				System.out.println("\nPAGO COM CART�O DE D�BITO:");
				System.out.println("Nome T�tular do Cart�o: " + res.getNomeTitular());
				System.out.println("N�m. Cart�o: " + res.getNumeroCartao());
			}
			
			else {
				// Se n�o o cliente pagou com o cart�o de Cr�dito
				System.out.println("\nPAGO COM CART�O DE CR�DITO:");
				System.out.println("Nome T�tular do Cart�o: " + res.getNomeTitular());
				System.out.println("N�m. Cart�o: " + res.getNumeroCartao());
				System.out.println("Qnt. Parcelas: " + res.getParcelas());
			}
		}
	}
}


