package com.API.PrjControleAlunos.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.API.PrjControleAlunos.Entities.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

}
