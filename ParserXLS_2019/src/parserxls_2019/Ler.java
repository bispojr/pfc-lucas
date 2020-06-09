package parserxls_2019;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Ler {

    ArrayList<XSSFWorkbook> aulas_Planilhas = new ArrayList<>();
    private List<String> alunosLidos;
    private List<Character> alternativasCorretas = new ArrayList<>();

    public Ler(List<String> nomesAlunos) {

        nomesAlunos.forEach(nomeALuno -> {
            DadosAluno dadosAluno = new DadosAluno();
            dadosAluno.setNome(nomeALuno);
            this.mapAlunos.put(nomeALuno, dadosAluno);
        });
    }

    private final Map<String, DadosAluno> mapAlunos = new HashMap<>();

    public void ler(String caminhoArquivo, DadosAula aula) throws IOException {
        aulas_Planilhas.add(new XSSFWorkbook(new FileInputStream(caminhoArquivo)));
        this.alunosLidos = new ArrayList<>();

        XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(caminhoArquivo));

        int posAtual = aulas_Planilhas.size() - 1;
        int qtdQuestoes = workbook.getNumberOfSheets() - 3;
        aula.setQuestoes(qtdQuestoes);

        XSSFSheet over = workbook.getSheetAt(0);
        XSSFSheet q[] = new XSSFSheet[qtdQuestoes];

        for (int j = 0; j < qtdQuestoes; j++) {
            q[j] = workbook.getSheetAt(j + 3);
        }

        this.extrairDadosS(aula, over);
        int n = aula.getJogadores();

        for (int k = 0; k < qtdQuestoes - 1; k++) {
            this.extrairDadosQ(q[k], k, aula, true, false);
        }
        this.extrairDadosQ(q[qtdQuestoes - 1], qtdQuestoes - 1, aula, true, true);

        alternativasCorretas.addAll(aula.getAlternativasCorretas());

        Set<String> keySet = this.mapAlunos.keySet();

        keySet.forEach((nomeALuno) -> {

            if (!this.alunosLidos.contains(nomeALuno)) {

                DadosAluno dadosAluno = this.mapAlunos.get(nomeALuno);

                for (int i = 0; i < qtdQuestoes; i++) {

                    dadosAluno.setAlternativa('#');
                    dadosAluno.setTempo(0.0F);
                }
                dadosAluno.setScore(0);
            }
        });

        //if(notas == true) this.lerNotas();
    }

    public void extrairDadosS(DadosAula dateAula, XSSFSheet planilha) {
        XSSFRow linhaNome = planilha.getRow(1);
        dateAula.setAula(linhaNome.getCell(1).getStringCellValue());

        XSSFRow linhaPlyr = planilha.getRow(3);
        dateAula.setJogadores((int) linhaPlyr.getCell(1).getNumericCellValue());

        XSSFRow linhaAcerto = planilha.getRow(7);
        dateAula.setAcertosTotal((float) linhaAcerto.getCell(2).getNumericCellValue());

        XSSFRow linhaErro = planilha.getRow(8);
        dateAula.setErrosTotal((float) linhaErro.getCell(2).getNumericCellValue());

        XSSFRow linhaMedia = planilha.getRow(9);
        dateAula.setMédiaScore((float) linhaMedia.getCell(2).getNumericCellValue());
    }

    public void extrairDadosQ(XSSFSheet planilha, int index,
            DadosAula date, boolean check, boolean checkScore) {

        XSSFRow respAlt = planilha.getRow(9);
        XSSFRow mediaTmp = planilha.getRow(10);

        XSSFRow rowCorr = planilha.getRow(8);

        if ((int) rowCorr.getCell(2).getStringCellValue().charAt(0) == 10004) {
            date.setAlternativaCorreta('A');
        } else if ((int) rowCorr.getCell(4).getStringCellValue().charAt(0) == 10004) {
            date.setAlternativaCorreta('B');
        } else if ((int) rowCorr.getCell(6).getStringCellValue().charAt(0) == 10004) {
            date.setAlternativaCorreta('C');
        } else if ((int) rowCorr.getCell(8).getStringCellValue().charAt(0) == 10004) {
            date.setAlternativaCorreta('D');
        }

        date.setRespostas((int) respAlt.getCell(3).getNumericCellValue());
        date.setTempoMedioRes((float) mediaTmp.getCell(3).getNumericCellValue());

        date.setRespostas((int) respAlt.getCell(5).getNumericCellValue());
        date.setTempoMedioRes((float) mediaTmp.getCell(5).getNumericCellValue());

        date.setRespostas((int) respAlt.getCell(7).getNumericCellValue());
        date.setTempoMedioRes((float) mediaTmp.getCell(7).getNumericCellValue());

        date.setRespostas((int) respAlt.getCell(9).getNumericCellValue());
        date.setTempoMedioRes((float) mediaTmp.getCell(9).getNumericCellValue());

        for (int i = 0; i < date.getJogadores(); i++) {
            XSSFRow row = planilha.getRow(i + 14);
            XSSFRow rowComp = planilha.getRow(7);

            DadosAluno dadosAluno;
            String id = "";

            //Pegar nome
            if (check == true) {
                if(row.getCell(1).getStringCellValue().equals("ProfaAna")) continue;
                id = row.getCell(1).getStringCellValue();
            }

            if (mapAlunos.containsKey(id.trim())) {

                dadosAluno = mapAlunos.get(id);

            } else {
                dadosAluno = new DadosAluno();
                dadosAluno.setNome(id.trim());
                mapAlunos.put(id, dadosAluno);
            }

            this.alunosLidos.add(id);

            //System.out.println(this.mapAlunos.size());
            //Pegar tempo de resposta
            //dados[i].setTempoResposta((float)row.getCell(4).getNumericCellValue(), index);
            //date.vetorAluno[i].setTempo((float) row.getCell(8).getNumericCellValue(), index);
            float tempo = (float) row.getCell(8).getNumericCellValue();
            dadosAluno.setTempo(tempo);

            if (checkScore == true) {
                dadosAluno.setScore((int) row.getCell(6).getNumericCellValue());
            }

            //Pegar resposta
            if (row.getCell(3).getStringCellValue() == null ? rowComp.getCell(3).getStringCellValue() == null : row.getCell(3).getStringCellValue().equals(rowComp.getCell(3).getStringCellValue())) {
                dadosAluno.setAlternativa('A');
            } else if (row.getCell(3).getStringCellValue() == null ? rowComp.getCell(5).getStringCellValue() == null : row.getCell(3).getStringCellValue().equals(rowComp.getCell(5).getStringCellValue())) {
                dadosAluno.setAlternativa('B');
            } else if (row.getCell(3).getStringCellValue() == null ? rowComp.getCell(7).getStringCellValue() == null : row.getCell(3).getStringCellValue().equals(rowComp.getCell(7).getStringCellValue())) {
                dadosAluno.setAlternativa('C');
            } else if (row.getCell(3).getStringCellValue() == null ? rowComp.getCell(9).getStringCellValue() == null : row.getCell(3).getStringCellValue().equals(rowComp.getCell(9).getStringCellValue())) {
                dadosAluno.setAlternativa('D');
            } else {
                dadosAluno.setAlternativa('#');
            }
        }
    }

    public void questoesAcertadas(ArrayList<DadosAluno> date, int total) {
        int questoesAcertadas = 0, totalQuestoes = total, acertos = 0;
        float percentualNormalizado;
        ArrayList vetorSituacao = new ArrayList();
        
        //System.out.println(date.get(0).getAlternativa(0));
        //System.out.println(this.getAlternativasCorretas().get(0));
        for (int all = 0; all < date.size(); all++) {
            //System.out.println("Aluno: "+ date.get(all).getNome() +": " + date.get(all).alternativa + "\t" + this.getAlternativasCorretas().get(0));
            questoesAcertadas = 0;
            for (int c = 0; c < totalQuestoes; c++) {
                if (date.get(all).getAlternativa(c) == this.getAlternativasCorretas().get(c)) {
                    questoesAcertadas++;
                }
            }
            date.get(all).setCorretasResp(questoesAcertadas);
            //System.out.println("Aluno: "+ date.get(all).getNome() +": " + date.get(all).alternativa + "\t" + questoesAcertadas);
        }

        int maior = 0;
        for (int more = 0; more < date.size(); more++) {
            if (date.get(more).getCorretasResp() > maior) {
                maior = date.get(more).getCorretasResp();
            }
        }

//        System.out.println(maior);
        for (int set = 0; set < date.size(); set++) {
            acertos = date.get(set).getCorretasResp();
            //System.out.println(acertos);
            percentualNormalizado = (float) acertos / maior;
            //System.out.println(percentualNormalizado + "\t" + totalQuestoes + "\t" + questoesAcertadas);
//            if (percentualNormalizado < 0.3) {
//                date.get(set).setSituacao("fortemente_reprovado");
//                date.get(set).setNumSituacao(0);
//            } else if (percentualNormalizado < 0.6) {
//                date.get(set).setSituacao("provavelmente_reprovado");
//                date.get(set).setNumSituacao(1);
//            } else if (percentualNormalizado < 0.8) {
//                date.get(set).setSituacao("provavelmente_aprovado");
//                date.get(set).setNumSituacao(2);
//            } //if(percentualNormalizado >= 0.8 && percentualNormalizado <= 1.0)
//            else {
//                date.get(set).setSituacao("fortemente_aprovado");
//                date.get(set).setNumSituacao(3);
//            }

            if (percentualNormalizado < 0.6) {
                date.get(set).setSituacao("reprovado");
                date.get(set).setNumSituacao(0);
            } else {
                date.get(set).setSituacao("aprovado");
                date.get(set).setNumSituacao(1);
            }
        }
        date.get(0).getNumSituacao();
    }

    public void lerNotas(String caminho, ArrayList<DadosAluno> date) throws FileNotFoundException, IOException {
        XSSFWorkbook workNotas = new XSSFWorkbook(new FileInputStream(caminho));
        XSSFSheet planilha = workNotas.getSheetAt(0);

        XSSFRow linha;
        
        ArrayList vetorSitu = new ArrayList();

        for (int i = 1; i < date.size(); i++) {
            linha = planilha.getRow(i);

            final String nome = linha.getCell(0).getStringCellValue();
            
            /*if(nome.equals("ProfAna")){ 
                date.get(i).setNumSituacao(5);
                        continue;
            }*/
            //System.out.println("Aluno "+(i)+" = "+nome);
            //System.out.println("Aluno "+(i)+" = "+date.get(i).getNome());
            
            DadosAluno  aluno = date.stream().filter(al -> al.getNome().equals(nome)).findFirst().get();
            
            aluno.setNotaFinal((float) linha.getCell(1).getNumericCellValue());

            if (aluno.getNome().equals("ProfaAna")){
                aluno.setSituacao("null");
                aluno.setNumSituacao(-1);
            } else if (aluno.getNotaFinal() < 3) {
                aluno.setSituacao("fortemente_reprovado");
                aluno.setNumSituacao(0);
            } else if (aluno.getNotaFinal() < 6) {
                aluno.setSituacao("provavelmente_reprovado");
                aluno.setNumSituacao(1);
            } else if (aluno.getNotaFinal() < 8) {
                aluno.setSituacao("provavelmente_aprovado");
                aluno.setNumSituacao(2);
            } //if(percentualNormalizado >= 0.8 && percentualNormalizado <= 1.0)
            else{
                aluno.setSituacao("fortemente_aprovado");
                aluno.setNumSituacao(3);
            }
        }
    }

    public void imprimir(ArrayList<DadosAluno> date) {
        //System.out.println(date.get(19).toString());
        for (int j = 0; j < date.size(); j++) {
            System.out.println("Aluno " + (j + 1) + ": \n");
            System.out.println(date.get(j).toString());
        }
    }

    public void imprimirAula(DadosAula date) {
        System.out.println("||============= " + date.getAula() + " =============||");
        System.out.println("||\t\t  Alunos = " + date.getJogadores() + "\t\t||");
        System.out.println("||\t\t  Questões = " + date.getQuestoes() + "\t\t||");
        System.out.println("||\t Total de acertos = " + Math.round(date.getAcertosTotal() * 100) + "%\t\t||");
        System.out.println("||\t Total de erros = " + Math.round(date.getErrosTotal() * 100) + "%\t\t||");
        System.out.println("||\t Média de pontos = " + date.getMédiaScore() + "\t||");
        //System.out.println("|| Questões corretas = " +date.alternativaCorreta); 
        //for(int cont=0;cont<date.getQuestoes();cont++){ System.out.println(date.getAlternativaCorreta(cont)); }
        //System.out.println("]\n");
        /*System.out.println("|| Número de resposta = [A = " + date.getRespostas(0)
                           +", B = " +date.getRespostas(1) + ", C = " 
                           +date.getRespostas(2) + ", D = " + date.getRespostas(3)+ "] ||");
        System.out.println("|| Média de tempo das respostas = [A = " + date.getTempoMedioRes(0)
                           +", B = " +date.getTempoMedioRes(1) + ", C = " +date.getTempoMedioRes(2)
                           + ", D = " + date.getTempoMedioRes(3)+ "] ||");
         */
        System.out.println("||======================================||\n");
    }

    public int maior(List<DadosAula> a, List<DadosAula> b) {
        if (a.size() > b.size()) {
            return a.size();
        } else {
            return b.size();
        }
    }

    public ArrayList<DadosAluno> getAlunos() {

        //cria lista com os valores do map
        return new ArrayList<>(this.mapAlunos.values());
    }

    public List<Character> getAlternativasCorretas() {
        return this.alternativasCorretas;
    }
}
