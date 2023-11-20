package com.example.demo;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Disciplina {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long disciplinaId;
	@Column(name = "nome", columnDefinition="VARCHAR(40)", nullable = false)
	public String nome;
	@Column(name = "ementa", columnDefinition="VARCHAR(1000)", nullable = false)
	public String ementa;
	@OneToMany(mappedBy = "disciplina", fetch = FetchType.EAGER)
	List<DisciplinaAluno> disciplinaAluno;
}
