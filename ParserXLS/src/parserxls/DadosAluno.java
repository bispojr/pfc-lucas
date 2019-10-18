package parserxls;

import java.util.ArrayList;

public class DadosAluno {
    String nome;
    ArrayList alternativa = new ArrayList();
    ArrayList tempo = new ArrayList();
    ArrayList score = new ArrayList();
    int totalScore, totalQuest, corretasResp, incorretasResp, naoResp;
    String situacao;
    
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
            return '-';
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

//    public String toString() {
//        return "DadosAlunos{\n" + "Id = " + getNome()
//                + "\nAlternativa Marcada = [" + getAlternativa(0)
//                + ", " + getAlternativa(1) + ", " + getAlternativa(2) + ", "
//                + getAlternativa(3) + ", " + getAlternativa(4) + "]"
//                + "\nTempo de Resposta = [" + getTempo(0)
//                + ", " + getTempo(1) + ", " + getTempo(2) + ", "
//                + getTempo(3) + ", " + getTempo(4) + "]" 
//                + "\nScore Total = " + getTotalScore()
//                + "\nSituação = " +getSituacao()
//                /*+ "\nQestões corretas = " + getCorretasResp() 
//                + "\nQestões incorretas = " + getIncorretasResp()*/
//                + '}' + "\n";
//    }

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
            ",\n\tsituacao=" + situacao + 
        "\n}";
    }
}