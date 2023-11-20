package com.example.demo;

import java.util.Optional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ExemploJpaNNAtributoRelacionamentoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExemploJpaNNAtributoRelacionamentoApplication.class, args);
	}

	@Bean
	public CommandLineRunner inserindoAlunoDisciplina(AlunoRepositorio alunoRepositorio, DisciplinaRepositorio disciplinaRepositorio) {
		return (args) -> {
			for (int i = 1; i < 11; i++) {
				Aluno aluno = new Aluno();
				aluno.nome = "Melo" + i;
				aluno.cpf = "" + i;
				aluno.rg = "" + i;
				aluno = alunoRepositorio.save(aluno);
				System.out.println(aluno.alunoId);
			}
			for (int i = 1; i < 11; i++) {
				Disciplina disciplina = new Disciplina();
				disciplina.nome = ("Disciplina" + i);
				disciplina.ementa = ("Ementa" + i);

				disciplina = disciplinaRepositorio.save(disciplina);
				System.out.println(disciplina.disciplinaId);
			}
		};
	}
	
	@Bean
	public CommandLineRunner inserindoNotaAluno(AlunoRepositorio alunoRepositorio, DisciplinaRepositorio disciplinaRepositorio, 
			DisciplinaAlunoRepositorio disciplinaAlunoRepositorio) {
		return (args) -> {
			Optional<Aluno> a = alunoRepositorio.findById(1l);
			if (a.isPresent()) {
				Optional<Disciplina> d = disciplinaRepositorio.findById(2l);
				if (d.isPresent()) {
					DisciplinaAluno da = new DisciplinaAluno();
					da.disciplina = d.get();
					da.aluno = a.get();
					da.notaAv1 = 9;
					da = disciplinaAlunoRepositorio.save(da);
					System.out.println("Salvo");
				}

			}
		};
	}
}
