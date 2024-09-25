package com.educacao.educacao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.educacao.educacao.model.Aluno;
import com.educacao.educacao.model.AlunoCurso;
import com.educacao.educacao.model.Curso;
import com.educacao.educacao.model.StatusCurso;

public class AlunoTests {

  @Test
  public void deveObterBeneficioTresCursos(){
    //cenario
    Curso curso = new Curso(0, "Curso");
    AlunoCurso alunoCurso = new AlunoCurso(curso);
    List<AlunoCurso> listAlunoCurso = new ArrayList<AlunoCurso>();
    listAlunoCurso.add(alunoCurso);
    Aluno aluno = new Aluno(0, "Aluno", listAlunoCurso);
    aluno.setQtdCursosDisponiveis(aluno.getQtdCursosDisponiveis()-1);

    //primeira execucao
    aluno.iniciarCurso(0);
    StatusCurso statusPosInicio = aluno.getCursosAdquiridos().get(0).getStatus();
    //primeiro assert
    assertEquals(StatusCurso.EM_ANDAMENTO,statusPosInicio);

    //segunda execucao
    String resposta = aluno.finalizarCurso(0, 7.1);
    int qtdCursosDisponiveis = aluno.getQtdCursosDisponiveis();
    //segundo assert
    assertEquals("Benefício de mais 3 cursos adquirido!", resposta);
    assertEquals(3,qtdCursosDisponiveis);
  }

  @Test
  public void naoDeveObterBeneficioTresCursos(){
    //cenario
    Curso curso = new Curso(0, "Curso");
    AlunoCurso alunoCurso = new AlunoCurso(curso);
    List<AlunoCurso> listAlunoCurso = new ArrayList<AlunoCurso>();
    listAlunoCurso.add(alunoCurso);
    Aluno aluno = new Aluno(0, "Aluno", listAlunoCurso);
    aluno.setQtdCursosDisponiveis(aluno.getQtdCursosDisponiveis()-1);

    //primeira execucao
    aluno.iniciarCurso(0);
    StatusCurso statusPosInicio = aluno.getCursosAdquiridos().get(0).getStatus();
    //primeiro assert
    assertEquals(StatusCurso.EM_ANDAMENTO,statusPosInicio);

    //segunda execucao
    String resposta = aluno.finalizarCurso(0, 7);
    int qtdCursosDisponiveis = aluno.getQtdCursosDisponiveis();
    //segundo assert
    assertEquals("Nota mínima para o benefício não atingida. Assista ao vídeo listado na aba 'Revisão'.", resposta);
    assertEquals(0,qtdCursosDisponiveis);
  }

  @Test
  public void devePoderRefazerCursoDeclinado(){
    //cenario
    Curso curso = new Curso(0, "Curso");
    AlunoCurso alunoCurso = new AlunoCurso(curso);
    List<AlunoCurso> listAlunoCurso = new ArrayList<AlunoCurso>();
    listAlunoCurso.add(alunoCurso);
    Aluno aluno = new Aluno(0, "Aluno", listAlunoCurso);
    
    //primeira execucao
    aluno.iniciarCurso(0);
    StatusCurso statusPosInicio = aluno.getCursosAdquiridos().get(0).getStatus();
    //primeiro assert
    assertEquals(StatusCurso.EM_ANDAMENTO,statusPosInicio);

    //segunda execucao
    aluno.desistirCurso(0);
    StatusCurso statusPosDesistencia = aluno.getCursosAdquiridos().get(0).getStatus();
    //primeiro assert
    assertEquals(StatusCurso.NAO_INICIADO,statusPosDesistencia);
  }

}
