package populacao;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Geracao {
	
	private Integer[] genePaisDecimalInicial;
	private Integer[] geneMaesDecimalInicial;
	private List<Individuo>individuos;
	private List<Individuo>individuosSorteados;
	private Integer tamanhoCadeiaGenetica;
	private Double somaFitnes;
	private Random r;
	
	
	
	
	
	public Geracao(Integer[] genePaisDecimalInicial, Integer[] geneMaesDecimalInicial, Integer tamanhoCadeiaGenetica) {
		super();
		this.genePaisDecimalInicial = genePaisDecimalInicial;
		this.geneMaesDecimalInicial = geneMaesDecimalInicial;
		this.tamanhoCadeiaGenetica = tamanhoCadeiaGenetica;
		r = new Random();
		this.individuos = criarPrimeiraGeracao(genePaisDecimalInicial, geneMaesDecimalInicial, tamanhoCadeiaGenetica);
		this.somaFitnes = 0.0;
		
	}

	private void calcularFitneIndividuo(Individuo individuo){
		Integer y = individuo.getGeneDecimalPai();
		Integer x = individuo.getGeneDecimalPai();
		Double f = (double)x/y+(2*y)-Math.pow(x,2);
		individuo.setValorFitnes(f);

	}

	private void calcularFitnes(){
		for(Individuo i : individuos){
			calcularFitneIndividuo(i);
		}
		this.individuos.sort(Comparator.comparing(Individuo::getValorFitnes));
		Double anterior = 0.0;
		somaFitnes=0.0;
		for(Individuo i : individuos){
			i.setValorFitnesMinimo(anterior);
			anterior = i.getValorFitnes();
			somaFitnes+=i.getValorFitnes();
		}
	}

	private void sortearIndividuos(){
		int fitnes = (int)Math.round(somaFitnes.doubleValue()*1000);
		
	}


	public List<Individuo> gerarNovaGera(){
		List<Individuo>novaGeracao = new ArrayList<>();
		calcularFitnes();
		
		return novaGeracao;
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
				oIndividuo = new Individuo(genePaisDecimalInicial[i], geneMaesDecimalInicial[i], tamanhoCadeiaGenetica, r);
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
