package com.br.estudo.method.reference;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MainMethodReference {

	public static void main(String[] args) {
		/*
		 * É importante ressaltar que nem sempre é possível substituir um lambda 
		 * por um method reference. Para conseguir fazer uma chamada a um method reference 
		 * é necessário que a invocação de método da direita receba os mesmos 
		 * parâmetros da esquerda do lambda.
		 * 
		 * Um uso para o method reference que nem sempre é de conhecimento geral é que ele 
		 * também funciona em métodos que recebem mais de um parâmetro, contanto que a 
		 * quantidade seja a mesma que a de atributo do objeto que estamos usando.
		 * 
		 * Imagine que temos um mapa de alunos e sua nota, e gostaríamos de passar
		 * isso para um outro mapa.
		 * Usando lambdas, nosso código seria:
		 * Map<String, Integer> novoMapaDeNotas = new HashMap<String, Integer>();
		 * notasAlunos.forEach( (nome, nota) -> novoMapaDeNotas.put(nome, nota));
		 * Veja que o lado esquerdo do lambda recebe dois parâmetros, 
		 * o nome e a nota. O lado direito também recebe esses parâmetros, 
		 * nessa mesma ordem. Que tal então fazer dessa forma, com method reference:
		 * Map<String, Integer> novoMapaDeNotas = new HashMap<String, Integer>();
		 * notasAlunos.forEach(novoMapaDeNotas::put);		    
		 */
		MainMethodReference m = new MainMethodReference();
		m.imprimePalavrasComLambda();
		m.imprimePalavrasComMethodReference();
	}
	
	private void imprimePalavrasComLambda() {
		
		List<String> palavras = preencherPalavras();	
		palavras.sort((String s1, String s2) -> Integer.compare(s1.length(), s2.length()));
		palavras.forEach( s -> System.out.println(s));

	}
	
	private void imprimePalavrasComMethodReference() {
		
		List<String> palavras = preencherPalavras();

		palavras.sort(Comparator.comparing(s -> s.length()));
		//Ou usando method reference		
		palavras.sort(Comparator.comparing(String::length));
		
		//Method reference transformou o lambda s -> System.out.prinln(s) no conteudo abaixo 
		palavras.forEach(System.out::println);

	}

	private List<String> preencherPalavras(){
		List<String> palavras = new ArrayList<String>();
		palavras.add("Curso Java 8");
		palavras.add("Lambda");
		palavras.add("Estudos de Java");
		return palavras;
	}


}
