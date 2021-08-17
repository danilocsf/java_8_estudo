package com.br.estudo.streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

class Curso {
	
	public Curso(String nome, int alunos) {
		super();
		this.nome = nome;
		this.alunos = alunos;
	}

	private String nome;
	
	private int alunos;

	public int getAlunos() {
		return alunos;
	}

	public void setAlunos(int alunos) {
		this.alunos = alunos;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
			    
}

public class MainStream {

	public static void main(String[] args) {
		List<Curso> cursos = new ArrayList<Curso>();
		cursos.add(new Curso("Java", 50));
		cursos.add(new Curso("Python", 40));
		cursos.add(new Curso("Javascript", 60));
		cursos.add(new Curso("C", 10));
		
		//Ordenando pelo numero de alunos
		cursos.sort(Comparator.comparing(Curso::getAlunos));
		cursos.forEach(c -> System.out.println(c.getNome()));
		
		//Imprimir cursos com mais de 40 alunos
		cursos.stream()
			.filter(c -> c.getAlunos() > 40)
			.forEach(c -> System.out.println(c.getNome()));
		
		//Obter cursos com mais de 40 alunos
		List<Curso> cursosList = cursos.stream().filter(c -> c.getAlunos() > 40)
				.collect(Collectors.toList());
		
		//Obter um mapa com o nome do curso e a qtd de alunos, dos cursos com mais de 40
		cursos.stream()
			.filter(c -> c.getAlunos() > 40)
			.collect(Collectors.toMap(Curso::getNome, Curso::getAlunos))
			.forEach((nome, alunos) -> System.out.println(nome + " tem " + alunos + " alunos"));

		//Imprimir a quantidade de alunos dos cursos com mais de 40 alunos
		cursos.stream()
			.filter(c -> c.getAlunos() > 40)
			//Aqui retorna uma Stream de inteiros
			.map(c -> c.getAlunos()) // ou map(Curso::getAlunos)
			.forEach(qtdAlunos -> System.out.println(qtdAlunos));// ou forEach(System.out::println)
		
		//Imprimir um curso qualquer com mais de 40 alunos
		Optional<Curso> curso = cursos.stream()
			.filter(c -> c.getAlunos() > 40)			
			.findAny();
		curso.ifPresent(c -> System.out.println(c.getNome()));		

		
		//Imprimir a coma de alunos dos cursos com mais de 40 alunos
		int sum = cursos.stream()
			.filter(c -> c.getAlunos() > 40)			
			.mapToInt(Curso::getAlunos)
			.sum();
		System.out.println(sum);
		

		
		
	}
	
	
	
}
