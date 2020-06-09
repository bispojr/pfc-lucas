package parserxls_2019;

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

public class ParserXLS_2019 {

    ArrayList<DadosAluno> alunos = new ArrayList<>();
    //Aulas
    List<DadosAula> aula = new ArrayList<>();
    
    DadosAula turmaAula04_09 = new DadosAula();
    DadosAula turmaAula04_09_2 = new DadosAula();
    DadosAula turmaAula01_10 = new DadosAula();
    DadosAula turmaAula01_10_2 = new DadosAula();
    DadosAula turmaAula09_10 = new DadosAula();
    DadosAula turmaAula22_10 = new DadosAula();
    DadosAula turmaAula29_10 = new DadosAula();
    DadosAula turmaAula30_10 = new DadosAula();
    DadosAula turmaAula05_11 = new DadosAula();
    DadosAula turmaAula06_11 = new DadosAula();
    DadosAula turmaAula19_11 = new DadosAula();
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
    File arquivo;

    //Global
    List<Character> respostasCorretas = new ArrayList<>();
    int total;
    
    public ParserXLS_2019() throws IOException {

        Ler ler;
        EscreverArquivo escrever = new EscreverArquivo();
        try {

            ler = new Ler(this.lerNomesAlunos("notas_com_gamificacao.xlsx", 23));
            
            this.alunos = ler.getAlunos();
            respostasCorretas = ler.getAlternativasCorretas();
            //System.out.println("Corretas = " + respostasCorretas + "\n");
            
            int qtd = 0, i=0;
            
            // Setembro
            ler.ler("results_04_09_2019_conceitos.xlsx", turmaAula04_09);
            ler.ler("results_04_09_2019_processos_design.xlsx", turmaAula04_09_2);
//            ler.questoesAcertadas(alunos, respostasCorretas.size());
            ler.lerNotas("notas_com_gamificacao.xlsx", alunos);
            aulas.add(turmaAula04_09); qtd += aulas.get(i).getQuestoes(); i++;
            aulas.add(turmaAula04_09_2); qtd += aulas.get(i).getQuestoes(); i++;
            escrever.escrever(arquivo, "arquivoIHC2019_divSet.arff", alunos, aulas, qtd);
            for(int vet = 0; vet < alunos.size(); vet++){
                vetorSet.add(alunos.get(vet).getNumSituacao());
            }
            
            // 1/3
            //Out
            ler.ler("results_01_10_2019_parte_1.xlsx", turmaAula01_10);
            ler.ler("results_01_10_2019_parte_2.xlsx", turmaAula01_10_2);
//            ler.questoesAcertadas(alunos, respostasCorretas.size());
            ler.lerNotas("notas_com_gamificacao.xlsx", alunos);
            aulas.add(turmaAula01_10); qtd += aulas.get(i).getQuestoes(); i++;
            aulas.add(turmaAula01_10_2); qtd += aulas.get(i).getQuestoes(); i++;
            for(int vet = 0; vet < alunos.size(); vet++){
                vetor1_3.add(alunos.get(vet).getNumSituacao());
            }
            escrever.escrever(arquivo, "arquivoIHC2019_div1-3.arff", alunos, aulas, qtd);
            
            //2/3
            ler.ler("resultado_09_10_2019.xlsx", turmaAula09_10);
            ler.ler("resultado_22_10_2019.xlsx", turmaAula22_10);
            ler.ler("resultado_29_10_2019.xlsx", turmaAula29_10);
            ler.ler("resultado_30_10_2019.xlsx", turmaAula30_10);            
            //ler.questoesAcertadas(alunos, respostasCorretas.size());
            ler.lerNotas("notas_com_gamificacao.xlsx", alunos);
            aulas.add(turmaAula09_10); qtd += aulas.get(i).getQuestoes(); i++;
            aulas.add(turmaAula22_10); qtd += aulas.get(i).getQuestoes(); i++;
            aulas.add(turmaAula29_10); qtd += aulas.get(i).getQuestoes(); i++;
            aulas.add(turmaAula30_10); qtd += aulas.get(i).getQuestoes(); i++;
            for(int vet = 0; vet < alunos.size(); vet++){
                vetor2_3.add(alunos.get(vet).getNumSituacao());
            }
            escrever.escrever(arquivo, "arquivoIHC2019_div2-3.arff", alunos, aulas, qtd);
            for(int vet = 0; vet < alunos.size(); vet++){
                vetorOut.add(alunos.get(vet).getNumSituacao());
            }
            escrever.escrever(arquivo, "arquivoIHC2019_divOut.arff", alunos, aulas, qtd);
            
            // Novembro
            ler.ler("resultado_05_11_2019.xlsx", turmaAula05_11); 
            ler.ler("resultado_06_11_2019.xlsx", turmaAula05_11); 
            ler.ler("resultado_19_11_2019.xlsx", turmaAula05_11); 
            //ler.questoesAcertadas(alunos, respostasCorretas.size());
            ler.lerNotas("notas_com_gamificacao.xlsx", alunos);
            aulas.add(turmaAula05_11); qtd += aulas.get(i).getQuestoes(); i++;
            aulas.add(turmaAula06_11); qtd += aulas.get(i).getQuestoes(); i++;
            aulas.add(turmaAula19_11); qtd += aulas.get(i).getQuestoes(); i++;
            escrever.escrever(arquivo, "arquivoIHC2019_div3-3.arff", alunos, aulas, qtd);            
            escrever.escrever(arquivo, "arquivoIHC2019_divNov.arff", alunos, aulas, qtd);            
            for(int vet = 0; vet < alunos.size(); vet++){
                vetor3_3.add(alunos.get(vet).getNumSituacao());
                vetorNov.add(alunos.get(vet).getNumSituacao());
            }
            
            ler.imprimirAula(turmaAula04_09);
            ler.imprimirAula(turmaAula04_09_2);
            ler.imprimirAula(turmaAula01_10);
            ler.imprimirAula(turmaAula01_10_2);
            ler.imprimirAula(turmaAula09_10);
            ler.imprimirAula(turmaAula22_10);
            ler.imprimirAula(turmaAula29_10);
            ler.imprimirAula(turmaAula30_10);
            ler.imprimirAula(turmaAula05_11);
            ler.imprimirAula(turmaAula06_11);
            ler.imprimirAula(turmaAula19_11);
            ler.imprimir(alunos);
        } catch (Exception ex) {
            Logger.getLogger(ParserXLS_2019.class.getName()).log(Level.SEVERE, null, ex);
        }
        escrever.escrever(arquivo, "arquivoIHC2019_TOTAL.arff", alunos, aulas, respostasCorretas.size());
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
        ParserXLS_2019 parser = new ParserXLS_2019();
    }
}