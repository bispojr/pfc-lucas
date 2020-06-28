package parserxls;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ParserXLS {

    //Alunos
    //DadosAluno[] dadosAula02_10 = new DadosAluno[20];
    //DadosAluno[] dadosAula12_09 = new DadosAluno[18];
    ArrayList<DadosAluno> alunos = new ArrayList<>();
    //Aulas
    List<DadosAula> aula = new ArrayList<>();
    
    DadosAula turmaAula12_09 = new DadosAula();
    DadosAula turmaAula12_09_2 = new DadosAula();
    DadosAula turmaAula02_10 = new DadosAula();
    DadosAula turmaAula24_10 = new DadosAula();
    DadosAula turmaAula25_10 = new DadosAula();
    DadosAula turmaAula26_10 = new DadosAula();
    DadosAula turmaAula30_10 = new DadosAula();
    DadosAula turmaAula31_10 = new DadosAula();
    DadosAula turmaAula13_11 = new DadosAula();
    DadosAula turmaAula14_11 = new DadosAula();
    DadosAula notas = new DadosAula();

    ArrayList<DadosAula> aulas = new ArrayList<>();

    ArrayList vetor1_3 = new ArrayList();
    ArrayList vetor2_3 = new ArrayList();
    ArrayList vetor3_3 = new ArrayList();
    ArrayList vetorSet = new ArrayList();
    ArrayList vetorOut = new ArrayList();
    ArrayList vetorNov = new ArrayList();
    ArrayList vetorTot = new ArrayList();
    
    ArrayList vetorSituacao = new ArrayList();
    //Arquivos
    //File arquivo_0210;
    //File arquivo_1209;
    File arquivo;

    //Global
    List<Character> respostasCorretas = new ArrayList<>();
    int total_quantidade_aulas;
    
    public ParserXLS() throws IOException {

        Leitor leitor;
        File_Writer fw = new File_Writer();
        try {
            leitor = new Leitor(this.lerNomesAlunos("mapeamentos-e-notas-finais.xlsx", 27));
            
            this.alunos = leitor.getAlunos();
            respostasCorretas = leitor.getAlternativasCorretas();
            //System.out.println("Corretas = " + respostasCorretas + "\n");
            
            int qtd = 0, i=0;
            
            // Setembro
            leitor.ler("kahoot_12_09_2018.xlsx", turmaAula12_09);
            leitor.ler("kahoot_12_09_2018_processos_design_ihc.xlsx", turmaAula12_09_2);
            leitor.questoesAcertadas(alunos, respostasCorretas.size());
            //ler.lerNotas("mapeamentos-e-notas-finais.xlsx", alunos);
            aulas.add(turmaAula12_09); qtd += aulas.get(i).getQuestoes(); i++;
            aulas.add(turmaAula12_09_2); qtd += aulas.get(i).getQuestoes(); i++;
            fw.escrever(arquivo, "arquivoIHC2018_divSet.arff", alunos, aulas, qtd);
            for(int vet = 0; vet < alunos.size(); vet++){
                vetorSet.add(alunos.get(vet).getNumSituacao());
            }
            
            // 1/3
            leitor.ler("kahoot_02_10_2018.xlsx", turmaAula02_10);
            leitor.ler("kahoot_24_10_2018.xlsx", turmaAula24_10);
            leitor.questoesAcertadas(alunos, respostasCorretas.size());
            //ler.lerNotas("mapeamentos-e-notas-finais.xlsx", alunos);
            aulas.add(turmaAula02_10); qtd += aulas.get(i).getQuestoes(); i++;
            aulas.add(turmaAula24_10); qtd += aulas.get(i).getQuestoes(); i++;
            for(int vet = 0; vet < alunos.size(); vet++){
                vetor1_3.add(alunos.get(vet).getNumSituacao());
            }
            fw.escrever(arquivo, "arquivoIHC2018_div1-3.arff", alunos, aulas, qtd);
            
            // 2/3
            leitor.questoesAcertadas(alunos, respostasCorretas.size());
            leitor.ler("kahoot_25_10_2018.xlsx", turmaAula25_10);
            leitor.ler("kahoot_26_10_2018.xlsx", turmaAula26_10);
            leitor.ler("kahoot_30_10_2018.xlsx", turmaAula30_10);            
            leitor.questoesAcertadas(alunos, respostasCorretas.size());
            //ler.lerNotas("mapeamentos-e-notas-finais.xlsx", alunos);
            aulas.add(turmaAula25_10); qtd += aulas.get(i).getQuestoes(); i++;
            aulas.add(turmaAula26_10); qtd += aulas.get(i).getQuestoes(); i++;
            aulas.add(turmaAula30_10); qtd += aulas.get(i).getQuestoes(); i++;
            for(int vet = 0; vet < alunos.size(); vet++){
                vetor2_3.add(alunos.get(vet).getNumSituacao());
            }
            fw.escrever(arquivo, "arquivoIHC2018_div2-3.arff", alunos, aulas, qtd);
            
            // Outubro
            leitor.ler("kahoot_31_10_2018.xlsx", turmaAula31_10);  
            leitor.questoesAcertadas(alunos, respostasCorretas.size());
            //ler.lerNotas("mapeamentos-e-notas-finais.xlsx", alunos);
            aulas.add(turmaAula31_10); qtd += aulas.get(i).getQuestoes(); i++;
            for(int vet = 0; vet < alunos.size(); vet++){
                vetorOut.add(alunos.get(vet).getNumSituacao());
            }
            fw.escrever(arquivo, "arquivoIHC2018_divOut.arff", alunos, aulas, qtd);
            
            // Novembro
            leitor.ler("kahoot_13_11_2018.xlsx", turmaAula13_11);
            leitor.ler("kahoot_14_11_2018.xlsx", turmaAula14_11);
            leitor.questoesAcertadas(alunos, respostasCorretas.size());
            //ler.lerNotas("mapeamentos-e-notas-finais.xlsx", alunos);
            aulas.add(turmaAula13_11); qtd += aulas.get(i).getQuestoes(); i++;
            aulas.add(turmaAula14_11); qtd += aulas.get(i).getQuestoes(); i++;
            fw.escrever(arquivo, "arquivoIHC2018_div3-3.arff", alunos, aulas, qtd);            
            fw.escrever(arquivo, "arquivoIHC2018_divNov.arff", alunos, aulas, qtd);            
            for(int vet = 0; vet < alunos.size(); vet++){
                vetor3_3.add(alunos.get(vet).getNumSituacao());
                vetorNov.add(alunos.get(vet).getNumSituacao());
            }
            
            leitor.imprimirAula(turmaAula12_09);
            leitor.imprimirAula(turmaAula12_09_2);
            leitor.imprimirAula(turmaAula02_10);
            leitor.imprimirAula(turmaAula24_10);
            leitor.imprimirAula(turmaAula25_10);
            leitor.imprimirAula(turmaAula26_10);
            leitor.imprimirAula(turmaAula30_10);
            leitor.imprimirAula(turmaAula31_10);
            leitor.imprimirAula(turmaAula13_11);
            leitor.imprimirAula(turmaAula14_11);
            leitor.imprimir(alunos);
        } catch (Exception ex) {
            Logger.getLogger(ParserXLS.class.getName()).log(Level.SEVERE, null, ex);
        }
        fw.escrever(arquivo, "arquivoIHC2018_TOTAL.arff", alunos, aulas, respostasCorretas.size());
        for(int vet = 0; vet < alunos.size(); vet++){
                vetorTot.add(alunos.get(vet).getNumSituacao());
            }
        
        System.out.println("1/3: " + vetor1_3 + "\n" + 
                           "2/3: " + vetor2_3 + "\n" +
                           "3/3: " + vetor3_3 + "\n" +
                           "Set: " + vetorSet + "\n" +
                           "Out: " + vetorOut + "\n" +
                           "Nov: " + vetorNov + "\n" +
                           "Tot: " + vetorTot);
    }

    public List<String> lerNomesAlunos(String caminhoArquivo, int n) throws Exception {
        XSSFWorkbook lerNome = new XSSFWorkbook(new FileInputStream(caminhoArquivo));
        XSSFSheet planilha = lerNome.getSheetAt(0);
        
        List<String> result = new ArrayList<>();
	
        /*BufferedReader br = null;

	try {

		br = new BufferedReader(new FileReader("Nomes.txt"));

		String line;
		while ((line = br.readLine()) != null) {
			result.add(line.trim());
		}

	} catch (IOException e) {
		e.printStackTrace();
	} finally {
		if (br != null) {
			br.close();
		}
	}
        */
        
        DadosAluno dadosAluno;
            String id = "";

            //Pegar nome
            for(int i=1;i<n;i++){
                XSSFRow row = planilha.getRow(i);
                id = row.getCell(0).getStringCellValue();
                result.add(id);
            }
            
        return result;
    }

    public static void main(String[] args) throws FileNotFoundException, IOException {
        ParserXLS parser = new ParserXLS();
    }
}
