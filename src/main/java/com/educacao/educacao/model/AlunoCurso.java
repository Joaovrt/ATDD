package com.educacao.educacao.model;

public class AlunoCurso {
    private Curso curso;
    private double media;
    private StatusCurso status;

    public AlunoCurso(Curso curso) {
        this.curso = curso;
        this.media = 0;
        this.status = StatusCurso.NAO_INICIADO;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public double getMedia() {
        return media;
    }

    public void setMedia(double media) {
        this.media = media;
    }

    public StatusCurso getStatus() {
        return status;
    }

    public void setStatus(StatusCurso status) {
        this.status = status;
    }
}
