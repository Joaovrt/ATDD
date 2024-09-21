package com.educacao.educacao.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.educacao.educacao.dtos.AdquirirCursoDTO;
import com.educacao.educacao.dtos.CriarAlunoDTO;
import com.educacao.educacao.dtos.DesistirCursoDTO;
import com.educacao.educacao.dtos.FinalizarCursoDTO;
import com.educacao.educacao.model.Aluno;
import com.educacao.educacao.model.AlunoCurso;
import com.educacao.educacao.model.Curso;

@RestController

@RequestMapping("/aluno")
public class AlunoController {

    private List<Aluno> alunos = new ArrayList<Aluno>();

    @PostMapping
    public Aluno criarAluno(@RequestBody CriarAlunoDTO request){
        Aluno aluno = new Aluno(alunos.size(), request.nome());
        alunos.add(aluno);
        return aluno;
    }

    @PostMapping("/adquirirCurso")
    public Aluno adquirirCurso(@RequestBody AdquirirCursoDTO request){
        if (request.idAluno() < 0 || request.idAluno() >= alunos.size()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Id invalido");
        }
        Aluno aluno = alunos.get(request.idAluno());
        List<AlunoCurso> listAlunoCurso = aluno.getCursosAdquiridos();
        Curso curso = new Curso(listAlunoCurso.size(), request.nome());
        AlunoCurso alunoCurso = new AlunoCurso(curso);
        listAlunoCurso.add(alunoCurso);
        return aluno;
    }

    @PostMapping("/finalizarCurso")
    public String finalizarCurso(@RequestBody FinalizarCursoDTO request){
        if (request.idAluno() < 0 || request.idAluno() >= alunos.size()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Id invalido");
        }
        Aluno aluno = alunos.get(request.idAluno());
        return aluno.finalizarCurso(request.idCurso(), request.media());
    }

    @PostMapping("/desistirCurso")
    public Aluno desistirCurso(@RequestBody DesistirCursoDTO request){
        if (request.idAluno() < 0 || request.idAluno() >= alunos.size()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Id invalido");
        }
        Aluno aluno = alunos.get(request.idAluno());
        aluno.desistirCurso(request.idCurso());
        return aluno;
    }

    @GetMapping
    public List<Aluno> listarAlunos() {
        return alunos;
    }

}
