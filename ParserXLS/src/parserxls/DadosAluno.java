package parserxls;

import java.util.ArrayList;

public class DadosAluno {
    String nome;
    ArrayList alternativa = new ArrayList();
    ArrayList tempo = new ArrayList();
    ArrayList score = new ArrayList();
    int totalScore, totalQuest, corretasResp, incorretasResp, naoResp;
    String situacao;
    int numSituacao;
    float notaFinal;
    
    public DadosAluno() {

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public char getAlternativa(int index) {
        
        if (index >= alternativa.size()) {
            return '#';
        }
        
        return (char) alternativa.get(index);
    }

    public void setAlternativa(char alternativa) {
        this.alternativa.add(alternativa);
    }
    
    public float getTempo(int index) {
        
        if (index >= tempo.size()) {
            return -1.0F;
        }
        
        return (float) tempo.get(index);
    }

    public void setTempo(float tmp) {
        this.tempo.add(tmp);
    }
    
    public ArrayList getScore() {
        return score;
    }

    public void setScore(int scr) {
        this.score.add(scr);
    }
    
    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    public int getTotalQuest() {
        return totalQuest;
    }

    public void setTotalQuest(int totalQuest) {
        this.totalQuest = totalQuest;
    }

    public int getCorretasResp() {
        return corretasResp;
    }

    public void setCorretasResp(int corretasResp) {
        this.corretasResp = corretasResp;
    }

    public int getIncorretasResp() {
        return incorretasResp;
    }

    public void setIncorretasResp(int incorretasResp) {
        this.incorretasResp = incorretasResp;
    }

    public int getNaoResp() {
        return naoResp;
    }

    public void setNaoResp(int naoResp) {
        this.naoResp = naoResp;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public float getNotaFinal() {
        return notaFinal;
    }

    public void setNotaFinal(float notaFinal) {
        this.notaFinal = notaFinal;
    }

    public int getNumSituacao() {
        return numSituacao;
    }

    public void setNumSituacao(int numSituacao) {
        this.numSituacao = numSituacao;
    }
    
    @Override
    public String toString() {
        return "DadosAluno{" + 
            "\n\tId=" + nome + 
            ",\n\tAlternativa Marcada = " + alternativa + 
            ",\n\tTempo de Resposta = " + tempo + 
            ",\n\tScore Total = " + score + 
//            ",\n\ttotalScore=" + totalScore + 
//            ",\n\ttotalQuest=" + totalQuest + 
            ",\n\tQestões corretas = " + corretasResp + 
            ",\n\tQestões incorretas = " + incorretasResp + 
//            ",\n\tnaoResp=" + naoResp + 
            ",\n\tSituacao = " + situacao + ", " +numSituacao+
            ",\n\tNota = " +notaFinal +
        "\n}";
    }
}