
public class InterfaceDeImpressao {
	
	public void imprimeCliente(Remessa res) {
		
		VerificadorDeCPF verifCpf = new VerificadorDeCPF(res.getCPF());
		
		System.out.println("\nINFORMA��ES DO CLIENTE ");
		System.out.println("Nome: " + res.getNome());
		String cpf = res.getCPF();
		System.out.println("CPF: " + cpf);
		verifCpf = new VerificadorDeCPF(cpf);
		
		if (verifCpf.verificaCPF() == true) {
			System.out.println("---- CPF V�LIDO! ----\n");
			
			System.out.println("BANCO DO RECEBIMENTO: " + res.getBancoRecebimento());
			System.out.println("BANCO DO PAGAMENTO: " + res.getBancoPagamento());
			System.out.println("DATA DA TRANSA��O: " + res.getData());
			System.out.printf( "VALOR: %.2f", res.getValor() );
			
			if (res.getNumeroBoleto() != null) {
				// Se o valor do boleto  n�o � nulo
				// Ent�o o cliente pagou com boleto
				System.out.println("\n\n-- PAGO COM BOLETO --");
				System.out.println("N� BOLETO: " + res.getNumeroBoleto());
			}
			else if (res.getParcelas() == 0) {
				// Se o cliente n�o pagou com boleto ent�o pagou com cart�o
				// Se n�o tem a quantidade de parcelas
				// Ent�o o cliente pagou com cart�o de D�bito
				System.out.println("\n\n-- PAGO COM CART�O DE D�BITO --");
				System.out.println("NOME TITULAR DO CART�O: " + res.getNomeTitular());
				System.out.println("N� CART�O: " + res.getNumeroCartao());
			}
			
			else {
				// Se n�o o cliente pagou com o cart�o de Cr�dito
				System.out.println("\n\n-- PAGO COM CART�O DE CR�DITO --");
				System.out.println("NOME TITULAR DO CART�O: " + res.getNomeTitular());
				System.out.println("N� CART�O: " + res.getNumeroCartao());
				System.out.println("QNT. PARCELAS: " + res.getParcelas());
			}
		} else {
			System.out.println("\n------ CPF INV�LIDO! ------");
		}
	}
	
	
}
