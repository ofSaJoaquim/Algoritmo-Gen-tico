package populacao;

import java.util.Random;

public class Individuo {

	private char[] genes;
	private Double valorFitnes;
	private Double valorFitnesMinimo;
	private Integer geneDecimalPai;
	private Integer geneDecimalMae;
	private Integer tamanhoCadeiaGenetica;
	private Integer pontoCruzamento;
	private Integer indiceMutacao;
	private Random r;
	
	
	
	
	
	public Individuo(Integer geneDecimalPai, Integer geneDecimalMae, Integer tamanhoCadeiaGenetica, Random r) {
		super();
		this.geneDecimalPai = geneDecimalPai;
		this.geneDecimalMae = geneDecimalMae;
		this.tamanhoCadeiaGenetica = tamanhoCadeiaGenetica;
		this.genes = gerarGenes(geneDecimalPai, geneDecimalMae, tamanhoCadeiaGenetica);
		this.pontoCruzamento = r.nextInt(7);
		this.r=r;
	}






	public Individuo(char[] genes, Integer tamanhoCadeiaGenetica) {
		super();
		this.genes = genes;
		this.tamanhoCadeiaGenetica = tamanhoCadeiaGenetica;
		recuperarDecimal(genes, tamanhoCadeiaGenetica);
	}






	public char[] gerarGenes(Integer geneDecimalPai, Integer geneDecimalMae, Integer tamanhoCadeiaGenetica) {
		char[] genesPai = String.format("%"+tamanhoCadeiaGenetica/2+"s",Integer.toBinaryString(geneDecimalPai)).replace(' ' , '0').toCharArray();
		char[] genesMae = String.format("%"+tamanhoCadeiaGenetica/2+"s",Integer.toBinaryString(geneDecimalMae)).replace(' ' , '0').toCharArray();
		char[] individuo = new char[tamanhoCadeiaGenetica];
		
		for(int i=0; i<genesPai.length;i++) {
			individuo[i]= genesPai[i];
		}
		
		int j= genesPai.length;
		for(int i=0; i<genesMae.length;i++) {
			individuo[j]= genesMae[i];
			j++;
		}
		
		return individuo;
	}


	public void recuperarDecimal(char[] genes, Integer tamanhoCadeiaGenetica) {
		char[] genesPai = new char[tamanhoCadeiaGenetica/2];
		char[] genesMae = new char[tamanhoCadeiaGenetica/2];
		
		for(int i =0; i<tamanhoCadeiaGenetica/2 ;i++) {
			genesPai[i] = genes[i];
		}
		int j = tamanhoCadeiaGenetica/2;
		for(int i =0; i<tamanhoCadeiaGenetica/2 ;i++) {
			genesMae[i] = genes[j];
			j++;
		}
		this.geneDecimalPai = Integer.parseInt(genesPai.toString(),2);
		this.geneDecimalMae = Integer.parseInt(genesMae.toString(), 2);
		
	}

	private boolean mutacao(){
		if((this.r.nextInt(100))<=(indiceMutacao-1))
			return true;
		else 
			return false;
	}


	public char[] getGenes() {
		return genes;
	}

	public void gerarMutacao(){
		for(int i =0; i<genes.length;i++){
			if(mutacao()){
				if(genes[i]==0)
					genes[i]=1;
				else
					genes[i]=0;
			}
				
		}
	}





	public void setGenes(char[] genes) {
		this.genes = genes;
	}






	public Double getValorFitnes() {
		return valorFitnes;
	}






	public void setValorFitnes(Double valorFitnes) {
		this.valorFitnes = valorFitnes;
	}






	public Double getValorFitnesMinimo() {
		return valorFitnesMinimo;
	}






	public void setValorFitnesMinimo(Double valorFitnesMinimo) {
		this.valorFitnesMinimo = valorFitnesMinimo;
	}






	public Integer getGeneDecimalPai() {
		return geneDecimalPai;
	}






	public void setGeneDecimalPai(Integer geneDecimalPai) {
		this.geneDecimalPai = geneDecimalPai;
	}






	public Integer getGeneDecimalMae() {
		return geneDecimalMae;
	}






	public void setGeneDecimalMae(Integer geneDecimalMae) {
		this.geneDecimalMae = geneDecimalMae;
	}






	public Integer getTamanhoCadeiaGenetica() {
		return tamanhoCadeiaGenetica;
	}






	public void setTamanhoCadeiaGenetica(Integer tamanhoCadeiaGenetica) {
		this.tamanhoCadeiaGenetica = tamanhoCadeiaGenetica;
	}
	
	
	public String toString() {
		StringBuilder retorno = new StringBuilder();
		retorno.append("<"+this.geneDecimalPai+":"+this.geneDecimalMae+">|<");
		for(char item : genes)
			retorno.append(item);
		retorno.append(">");
		return retorno.toString();
	}

	public Integer getPontoCruzamento() {
		return pontoCruzamento;
	}

	public void setPontoCruzamento(Integer pontoCruzamento) {
		this.pontoCruzamento = pontoCruzamento;
	}

		
	
}
