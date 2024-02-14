package com.API.PrjControleAlunos.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.API.PrjControleAlunos.Entities.Aluno;
import com.API.PrjControleAlunos.Repositories.AlunoRepository;

@Service
public class AlunoService {
	
	private final AlunoRepository alunoRepository;
	
	@Autowired
	public AlunoService(AlunoRepository alunoRepository) {
		this.alunoRepository = alunoRepository;
	}
	
	// preparando as buscas por id
	public Aluno findalunoById(Long idAluno) {
		Optional<Aluno> Aluno = alunoRepository.findById(idAluno);
		return Aluno.orElse(null);
	}
	
	// preparando a busca geral
	public List<Aluno> findAllAluno() {
		return alunoRepository.findAll();
	}

	// salvando o Aluno
	public Aluno insertAluno( Aluno aluno) {
		return alunoRepository.save(aluno);
	}
	
	// fazendo o update do aluno com o optional
	public Aluno updateAluno(Long idAluno, Aluno novoAluno) {
		Optional<Aluno> alunoOptional = alunoRepository.findById(idAluno);
		if (alunoOptional.isPresent()) {
			Aluno alunoExistente = alunoOptional.get();
			alunoExistente.setNome(novoAluno.getNome());
			return alunoRepository.save(alunoExistente);
		} else {
			return null;
		}
	}
	
	// deletando o update do usuario com o optional
	public boolean deleteAluno(Long idAluno) {
		Optional<Aluno> alunoExistente = alunoRepository.findById(idAluno);
		if (alunoExistente.isPresent()) {
			alunoRepository.deleteById(idAluno);
			return true;
		} else {
			return false;
		}
	}

}
