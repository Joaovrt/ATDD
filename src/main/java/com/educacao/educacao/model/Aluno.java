package com.educacao.educacao.model;

import java.util.ArrayList;
import java.util.List;

public class Aluno {
    private int id;
    private String nome;
    private int qtdCursosDisponiveis;
    private List<AlunoCurso> cursosAdquiridos;

    public Aluno(int id, String nome) {
        this.id = id;
        this.nome = nome;
        this.qtdCursosDisponiveis = 0;
        this.cursosAdquiridos = new ArrayList<AlunoCurso>();
    }

    public Aluno(int id, String nome, List<AlunoCurso> listCursosAdquiridos) {
        this.id = id;
        this.nome = nome;
        this.qtdCursosDisponiveis = 0;
        this.cursosAdquiridos = listCursosAdquiridos;
    }

    public String finalizarCurso(int idCurso, double media){
        if (idCurso < 0 || idCurso >= this.cursosAdquiridos.size()) {
            throw new IndexOutOfBoundsException("Id invalido");
        }
        AlunoCurso alunoCurso = this.cursosAdquiridos.get(idCurso);
        alunoCurso.setStatus(StatusCurso.FINALIZADO);
        alunoCurso.setMedia(media);
        if(media>7.0){
            this.setQtdCursosDisponiveis(this.qtdCursosDisponiveis+3);
            return "Benefício de mais 3 cursos adquirido!";
        }
        else{
            return "Nota mínima para o benefício não atingida. Assista ao vídeo listado na aba 'Revisão'.";
        }
    }

    public void desistirCurso(int idCurso){
        if (idCurso < 0 || idCurso >= this.cursosAdquiridos.size()) {
            throw new IndexOutOfBoundsException("Id invalido");
        }
        AlunoCurso alunoCurso = this.cursosAdquiridos.get(idCurso);
        alunoCurso.setStatus(StatusCurso.NAO_INICIADO);
        alunoCurso.setMedia(0);
    }

    public void iniciarCurso(int idCurso){
        if (idCurso < 0 || idCurso >= this.cursosAdquiridos.size()) {
            throw new IndexOutOfBoundsException("Id invalido");
        }
        AlunoCurso alunoCurso = this.cursosAdquiridos.get(idCurso);
        alunoCurso.setStatus(StatusCurso.EM_ANDAMENTO);
        alunoCurso.setMedia(0);
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQtdCursosDisponiveis() {
        return qtdCursosDisponiveis;
    }

    public void setQtdCursosDisponiveis(int qtdCursosDisponiveis) {
        this.qtdCursosDisponiveis = qtdCursosDisponiveis;
    }

    public List<AlunoCurso> getCursosAdquiridos() {
        return cursosAdquiridos;
    }

    public void setCursosAdquiridos(List<AlunoCurso> cursosAdquiridos) {
        this.cursosAdquiridos = cursosAdquiridos;
    }
}
