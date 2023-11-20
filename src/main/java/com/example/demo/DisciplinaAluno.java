package com.example.demo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class DisciplinaAluno {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long Id;
    @ManyToOne
    @JoinColumn(name = "alunoId")
    Aluno aluno;
    @ManyToOne
    @JoinColumn(name = "disciplinaId")
    Disciplina disciplina;
    @Column(name = "notaAv1", columnDefinition = "decimal", nullable = false)
    public float notaAv1;
    @Column(name = "notaAv2", columnDefinition = "decimal", nullable = false)
    public float notaAv2;
    @Column(name = "notaFinal", columnDefinition = "decimal", nullable = false)
    public float notaFinal;
}

