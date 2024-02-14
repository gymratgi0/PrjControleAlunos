package com.API.PrjControleAlunos.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.API.PrjControleAlunos.Entities.Aluno;
import com.API.PrjControleAlunos.Services.AlunoService;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
	
	private final AlunoService alunoService;
		
		@Autowired
		public AlunoController(AlunoService alunoService) {
			this.alunoService = alunoService;
		}
	
		@GetMapping("/{idAluno}")
		public ResponseEntity<Aluno> findAlunobyId(@PathVariable Long idAluno) {
			Aluno aluno = alunoService.findalunoById(idAluno);
			if (aluno != null) {
				return ResponseEntity.ok(aluno);
			} else {
				return ResponseEntity.notFound().build();
			}
		}
		
		@GetMapping("/")
		public ResponseEntity<List<Aluno>> findAllAlunocontrol() {
			List<Aluno> alunos = alunoService.findAllAluno();
			return ResponseEntity.ok(alunos);
		}
	
		@PostMapping("/")
		public ResponseEntity<Aluno> insertAlunoControl(@RequestBody Aluno aluno) {
			Aluno novoAluno = alunoService.insertAluno(aluno);
			return ResponseEntity.status(HttpStatus.CREATED).body(novoAluno);
		}
		
		@PutMapping("/idAluno")
		public ResponseEntity<Aluno> updateAlunoControl(@PathVariable Long idAluno, @RequestBody Aluno aluno) {
			Aluno mudaAluno = alunoService.updateAluno(idAluno, aluno);
			if (mudaAluno != null) {
				return ResponseEntity.ok(aluno);
			} else {
				return ResponseEntity.notFound().build();
			}
		}
	
		@DeleteMapping("/idAluno")
		public ResponseEntity<String> deleteAlunoControl(@PathVariable Long idAluno) {
			boolean remover = alunoService.deleteAluno(idAluno);
			if (remover) {
				return ResponseEntity.ok().body("Aluno excluido com sucesso");
			} else {
				return ResponseEntity.notFound().build();
			}
		}

}
