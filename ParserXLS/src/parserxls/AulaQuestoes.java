/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parserxls;

import java.util.ArrayList;

/**
 *
 * @author lucas
 */
public class AulaQuestoes {
    
    private int numeroAula;
    private boolean isPresente = false;
    private int quantidadeQuestoes = 0;
    private ArrayList<Character> alternativa = new ArrayList<>();
    private ArrayList<Float> tempo = new ArrayList<>();
    private ArrayList<Float> score = new ArrayList<>(); 
            
    public int getNumeroAula() {
        return numeroAula;
    }

    public void setNumeroAula(int numeroAula) {
        this.numeroAula = numeroAula;
    }

    public boolean isIsPresente() {
        return isPresente;
    }

    public void setIsPresente(boolean isPresente) {
        this.isPresente = isPresente;
    }

    public void addQuestao(char alternativa, float tempoResposta, float score) {
        this.alternativa.add(alternativa);
        this.tempo.add(tempoResposta);
        this.score.add(score);
    }

    public int getQuantidadeQuestoes() {
        return quantidadeQuestoes;
    }

    public void setQuantidadeQuestoes(int quantidadeQuestoes) {
        this.quantidadeQuestoes = quantidadeQuestoes;
    }

    public ArrayList<Character> getAlternativa() {
        
        if (!this.isPresente) {
            
            for (int i = 0; i < this.quantidadeQuestoes; i++) {
             
                this.alternativa.add('#');
            }
        }
        
        return alternativa;
    }

    public ArrayList<Float> getTempo() {
        
        if (!this.isPresente) {
            for (int i = 0; i < this.quantidadeQuestoes; i++) {
                this.tempo.add(0.0F);
            }
        }
        
        return tempo;
    }
    
    public ArrayList<Float> getScore() {
        
        if (!this.isPresente) {
            for (int i = 0; i < this.quantidadeQuestoes; i++) {
                this.score.add(0.0F);
            }
        }
        
        return score;
    }
}
