package teste;

import populacao.Geracao;
import populacao.Individuo;

public class TestePrincipal {

	public static void main(String[] args) {
		/*Individuo oIndividuo = new Individuo(2, 3, 2*2);
		System.out.print(oIndividuo.getGenes());*/
		Integer[] pais = {10,2,7,20};
		Integer[] maes =  {20,7,2,10};
		Geracao geracao = new Geracao(pais,maes, 5*2);
		System.out.println(geracao.toString());

	}

}
