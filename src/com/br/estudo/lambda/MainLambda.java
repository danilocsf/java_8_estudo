package com.br.estudo.lambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class MainLambda {

	public static void main(String[] args) {
		MainLambda m = new MainLambda();
		m.imprimePalavrasSemLambda();
		
		m.imprimePalavrasComLambda();
		
		
	}
	
	private void imprimePalavrasSemLambda() {
		
		List<String> palavras = preencherPalavras();

		//sort é um default method 
		//O Comparador foi implementado como classe anônima
		palavras.sort(new Comparator<String>(){
			@Override
			public int compare(String s1, String s2) {				
				if(s1.length() < s2.length()) {
					return -1;
				}
				if(s1.length() > s2.length()) {
					return 1;
				}
				return 0;				
			}
		});
		
		//Consumer é uma interface funcional e está sendo 
		//utilizado como classe anonima no argumento do forEach
		palavras.forEach(new Consumer<String>() {
			public void accept(String s) {
				System.out.println(s);
			}
		});

	}	
	
	private void imprimePalavrasComLambda() {
		
		List<String> palavras = preencherPalavras();

		//sort é um default method
		//O Lambda simplifica a sintaxe da Interface Funcional Comparator
		palavras.sort((String s1, String s2) -> {				
				if(s1.length() < s2.length()) {
					return -1;
				}
				if(s1.length() > s2.length()) {
					return 1;
				}
				return 0;				
			});
		
		//Outra opção
		palavras.sort((String s1, String s2) -> Integer.compare(s1.length(), s2.length()));
		
		//O Lambda simplifica a sintaxe do consumer. 
		// Ele funciona para intefaces funcionais (que possuem apenas 1 metodo abstrato)
		//Recebe-se uma String como parametro e imprime a String
		//Sintaxe: (Tipo arg1, Tipo arg2) -> {statement1; statement2;}
		// ou caso tenha apenas um argumento pode-se tirar os parenteses e
		//caso tenha apenas 1 statement por tirar as chaves, como abaixo
		palavras.forEach( s -> System.out.println(s));

	}
	private List<String> preencherPalavras(){
		List<String> palavras = new ArrayList<String>();
		palavras.add("Curso Java 8");
		palavras.add("Lambda");
		palavras.add("Estudos de Java");
		return palavras;
	}

}
