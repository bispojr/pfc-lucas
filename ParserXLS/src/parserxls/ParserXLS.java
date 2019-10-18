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

public class ParserXLS {

    //Alunos
    //DadosAluno[] dadosAula02_10 = new DadosAluno[20];
    //DadosAluno[] dadosAula12_09 = new DadosAluno[18];
    ArrayList<DadosAluno> alunos = new ArrayList<>();
    //Aulas
    DadosAula turmaAula02_10 = new DadosAula();
    DadosAula turmaAula12_09 = new DadosAula();
    ArrayList<DadosAula> aulas = new ArrayList<>();

    //Arquivos
    //File arquivo_0210;
    //File arquivo_1209;
    File arquivo;

    //Global
    List<Character> respostasCorretas = new ArrayList<>();

    public ParserXLS() throws IOException {

        Ler ler;
        try {

            ler = new Ler(this.lerNomesAlunos());

            ler.ler("kahoot_02_10_2018.xlsx", turmaAula02_10);
            ler.ler("kahoot_12_09_2018.xlsx", turmaAula12_09);

            this.alunos = ler.getAlunos();
            respostasCorretas = ler.getAlternativasCorretas();
            System.out.println("Corretas = " + respostasCorretas + "\n");
            ler.questoesAcertadas(alunos);
            ler.imprimirAula(turmaAula02_10);
            ler.imprimirAula(turmaAula12_09);
            ler.imprimir(alunos);

            aulas.add(turmaAula02_10);
            aulas.add(turmaAula12_09);

        } catch (Exception ex) {
            Logger.getLogger(ParserXLS.class.getName()).log(Level.SEVERE, null, ex);
        }

        EscreverArquivo escrever = new EscreverArquivo();
        escrever.escrever(arquivo, "arquivoIHC2018.arff", alunos, aulas);
    }

    public List<String> lerNomesAlunos() throws Exception {

        List<String> result = new ArrayList<>();
	       BufferedReader br = null;

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
        
        return result;
        
        /*List<String> result = new ArrayList<>();
        BufferedReader in = null;
        File fileDir = new File("Nomes.txt");

        in = new BufferedReader(
                new InputStreamReader(
                    new FileInputStream(fileDir), "UTF8"));

        String str;

        while ((str = in.readLine()) != null) {
            result.add(str.trim());
        }
          
        in.close();

        return result;*/
    }

    public static void main(String[] args) throws FileNotFoundException, IOException {
        ParserXLS parser = new ParserXLS();
    }
}
