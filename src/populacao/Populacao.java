package populacao;

public class Populacao {
	
	
	
	
	
	public  Integer calcularTamanhoCadeiaGenetica(Integer[] genesDecimalPai, Integer[] genesDecimalMae) {	
		Integer valorMaiorCadeia = 0;
		for(int i=0; i<genesDecimalPai.length; i++) {
			Integer valorAtual = Integer.toBinaryString(genesDecimalPai[i]).length();			
			if(valorAtual>valorMaiorCadeia)
				valorMaiorCadeia = valorAtual;
		}
		for(int i=0; i<genesDecimalMae.length; i++) {
			Integer valorAtual = Integer.toBinaryString(genesDecimalPai[i]).length();			
			if(valorAtual>valorMaiorCadeia)
				valorMaiorCadeia = valorAtual;
		}
		return valorMaiorCadeia*2;
		
	}

}
