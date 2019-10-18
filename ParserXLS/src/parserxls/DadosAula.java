package parserxls;

import java.util.ArrayList;

public class DadosAula {

    String aula;
    int jogadores = 0, questoes;
    float acertosTotal, errosTotal, médiaScore;
    ArrayList alternativaCorreta = new ArrayList();
    ArrayList acertosAlt = new ArrayList();
    ArrayList respostasAlt = new ArrayList();
    ArrayList tempoMedioRes = new ArrayList();
    //ArrayList<DadosAluno> vetorAluno = new ArrayList<>();

    public DadosAula() {
    }

    public String getAula() {
        return aula;
    }

    public void setAula(String aula) {
        this.aula = aula;
    }

    public int getJogadores() {
        return jogadores;
    }

    public void setJogadores(int jogadores) {
        this.jogadores = jogadores;
    }

    public int getQuestoes() {
        return questoes;
    }

    public void setQuestoes(int questoes) {
        this.questoes = questoes;
    }

    public float getAcertosTotal() {
        return acertosTotal;
    }

    public void setAcertosTotal(float acertosTotal) {
        this.acertosTotal = acertosTotal;
    }

    public float getErrosTotal() {
        return errosTotal;
    }

    public void setErrosTotal(float errosTotal) {
        this.errosTotal = errosTotal;
    }

    public float getMédiaScore() {
        return médiaScore;
    }

    public void setMédiaScore(float médiaScore) {
        this.médiaScore = médiaScore;
    }

    public char getAlternativaCorreta(int index) {
        return (char) alternativaCorreta.get(index);
    }

    public void setAlternativaCorreta(char tmp) {
        this.alternativaCorreta.add(tmp);
    }

    public int getAcertosAlt(int index) {
        return (int) acertosAlt.get(index);
    }

    public void setAcertosAlt(int acertosAlt) {
        this.acertosAlt.add(acertosAlt);
    }

    public int getRespostas(int index) {
        return (int) respostasAlt.get(index);
    }

    public void setRespostas(int Respostas) {
        this.respostasAlt.add(Respostas);
    }

    public float getTempoMedioRes(int index) {
        return (float) tempoMedioRes.get(index);
    }

    public void setTempoMedioRes(float tempoMedioRes) {
        this.tempoMedioRes.add(tempoMedioRes);
    }

    /*
    public DadosAluno getVetorAluno(int index) {
        return (DadosAluno) vetorAluno.get(index);
    }

    public void setVetorAluno(DadosAluno vetorAluno) {
        this.vetorAluno.add(vetorAluno);
    }
    */
    
    @Override
    public String toString() {
        return "||======================================||"
                + "\n"
                + "\n||\t\t  Alunos = " + getJogadores() + "\t\t||"
                + "\n||\t\t  Questões = " + getQuestoes() + "\t\t||"
                + "\n||\t Total de acertos = " + getAcertosTotal() * 100 + "\t||"
                + "\n||\t Total de erros = " + getErrosTotal() * 100 + "\t||"
                + "\n||\t Média de pontos = " + getMédiaScore() + "\t||"
                + "\n|| Número de resposta = [A = " + getRespostas(0)
                + ", B = " + getRespostas(1) + ", C = "
                + getRespostas(2) + ", D = " + getRespostas(3) + "] ||"
                + "\n|| Média de tempo das respostas = [A = " + getTempoMedioRes(0)
                + ", B = " + getTempoMedioRes(1) + ", C = " + getTempoMedioRes(2)
                + ", D = " + getTempoMedioRes(3) + "] ||"
                + "\n||======================================||\n";
    }
    
    public ArrayList getAlternativasCorretas() {
        return alternativaCorreta;
    }
}