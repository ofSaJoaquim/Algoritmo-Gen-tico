package populacao;

import java.util.ArrayList;
import java.util.List;

public class Geracao {
	
	private Integer[] genePaisDecimalInicial;
	private Integer[] geneMaesDecimalInicial;
	private List<Individuo>individuos;
	private Integer tamanhoCadeiaGenetica;
	
	
	
	
	
	
	public Geracao(Integer[] genePaisDecimalInicial, Integer[] geneMaesDecimalInicial, Integer tamanhoCadeiaGenetica) {
		super();
		this.genePaisDecimalInicial = genePaisDecimalInicial;
		this.geneMaesDecimalInicial = geneMaesDecimalInicial;
		this.tamanhoCadeiaGenetica = tamanhoCadeiaGenetica;
		this.individuos = criarPrimeiraGeracao(genePaisDecimalInicial, geneMaesDecimalInicial, tamanhoCadeiaGenetica);
	}

	




	public Geracao(List<Individuo> individuos) {
		super();
		this.individuos = individuos;
	}






	public List<Individuo> criarPrimeiraGeracao(Integer[] genePaisDecimalInicial, Integer[] geneMaesDecimalInicial,Integer tamanhoCadeiaGenetica  ){
		if(genePaisDecimalInicial.length==geneMaesDecimalInicial.length) {
			List<Individuo> retorno = new ArrayList<Individuo>();
			Individuo oIndividuo;
			for(int i=0; i<genePaisDecimalInicial.length;i++) {
				oIndividuo = new Individuo(genePaisDecimalInicial[i], geneMaesDecimalInicial[i], tamanhoCadeiaGenetica);
				retorno.add(oIndividuo);
			}
			return retorno;
		}
		else {
			return null;
		}
	}
	public String toString() {
		StringBuilder retorno = new StringBuilder();
		for(Individuo item : individuos) {
			retorno.append(item.toString()+"\n");
		}
		return retorno.toString();
	}

}
