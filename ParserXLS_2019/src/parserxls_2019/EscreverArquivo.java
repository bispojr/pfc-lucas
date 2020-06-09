package parserxls_2019;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class EscreverArquivo {
    public EscreverArquivo(){
        
    }
    
    public void escrever(File arquivo, String nomeArquivo, ArrayList<DadosAluno> alunos, ArrayList<DadosAula> aulas, int total) throws IOException{
        arquivo = new File(nomeArquivo);
        FileWriter print = new FileWriter(arquivo, true);
        
        int qtdQ = total;
        ArrayList situacao = new ArrayList();
        
        print.write("%******************************************" + "\n");
        //print.write("%||======== AULA - " +aula.getAula() + " ===========||\n");
        print.write("%||======================================||" + "\n\n");
        print.write("@relation Aulas_IHC2018 " + "\n\n\n");
        
        for(int i=0;i<qtdQ;i++){
            print.write("@attribute Questao_" + (i+1) + "{'A', 'B', 'C', 'D', '#'} " + "\n");
        }/*print.write("@attribute questao_02 {'A', 'B', 'C', 'D', '#'} " + "\n");
        print.write("@attribute questao_03 {'A', 'B', 'C', 'D', '#'} " + "\n");
        print.write("@attribute questao_04 {'A', 'B', 'C', 'D', '#'} " + "\n");
        print.write("@attribute questao_05 {'A', 'B', 'C', 'D', '#'} " + "\n");*/
        print.write("@attribute situacao{'aprovado', 'reprovado'} " + "\n\n");
        
        print.write("@data" + "\n");
        for(int i=0;i<alunos.size();i++){
            if (alunos.get(i).getSituacao() == null) continue;
            if (alunos.get(i).getNome().equals("ProfaAna")) continue;
            for(int q=0;q<qtdQ;q++){
                print.write("'"+alunos.get(i).getAlternativa(q)+"', ");
                       //+"'"+alunos.get(i).getSituacao()+"'" + "\n");
            }
            print.write("'"+alunos.get(i).getSituacao()+"'" + "\n");
            situacao.add(alunos.get(i).getNumSituacao());
        }
        //print.write(situacao.toString());
        print.close();
    }
    
}
