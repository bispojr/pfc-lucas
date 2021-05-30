# Comentarios

# overview[1]['playedWith'] = '20'
# finalScore[1]['rank'] = 1
# finalScore[3] = {}
# finalScore[3]['player'] = "Animal"
# questions = { 1: {'score': "", 'statement': "", 'answer': ""}}
# questions[0] = d
# questions[2] = {}
# questions[2][1]['player'] = "Lucas"

# =================================================
#       Estruturas

# overview = { 1: { 'playedOn': "", 'hostedBy': "", 'playedWith': "", 'played': "", 'CorrectAnswers' : "", 'IncorrectAnswers': "", 'Average score': ""}}
# finalScore = { 1: { 'rank': "", 'player': "", 'totalScore': "", 'correctAnswers': "", 'incorrectAnswers': ""}}
# questionSummary = { 1: { 'rank': "", 'player': "", 'totalScore': "", 1: {'score': "", 'statement': "", 'answer': ""}}}
# questions = {'statement': "",'correctAnswers': "", 'playersCorrect': "",'questionDuration': "",'ansOptTriangle': "",'ansOptLosangle': "",'ansOptCircle': "",'ansOptSquare': "",'IsAnswerCorrectTriangle': "",'IsAnswerCorrectLosangle': "",'IsAnswerCorrectCircle': "",'IsAnswerCorrectSquare': "",'NumOfAnsReceivedTriangle': "", 'NumOfAnsReceivedLosangle': "",'NumOfAnsReceivedCircle': "",'NumOfAnsReceivedSquare': "",'TimeToAnsTriangle': "", 'TimeToAnsLosangle': "", 'TimeToAnsCircle': "", 'TimeToAnsSquare': "",
#   1: {
#      'player': "", 'alias': "", 'answerIsCorrect': "", 'statement': "", 'score': "", 'acumulateScore': "", 'answerTime': ""}}

# =============================================

from openpyxl import Workbook
from openpyxl import load_workbook

kahoot_1209 = r'C:\Users\lucas\OneDrive\Documentos\UFG\9º Período - EXTRA\Projeto Final de Curso 2\data\kahoot\2018\kahoot_12_09_2018.xlsx'
kahoot_1209_processo = r'C:\Users\lucas\OneDrive\Documentos\UFG\9º Período - EXTRA\Projeto Final de Curso 2\data\kahoot\2018\kahoot_12_09_2018_processos_design_ihc.xlsx'
kahoot_0210 = r'C:\Users\lucas\OneDrive\Documentos\UFG\9º Período - EXTRA\Projeto Final de Curso 2\data\kahoot\2018\kahoot_02_10_2018.xlsx'
kahoot_2410 = r'C:\Users\lucas\OneDrive\Documentos\UFG\9º Período - EXTRA\Projeto Final de Curso 2\data\kahoot\2018\kahoot_24_10_2018.xlsx'
kahoot_2510 = r'C:\Users\lucas\OneDrive\Documentos\UFG\9º Período - EXTRA\Projeto Final de Curso 2\data\kahoot\2018\kahoot_25_10_2018.xlsx'
kahoot_2610 = r'C:\Users\lucas\OneDrive\Documentos\UFG\9º Período - EXTRA\Projeto Final de Curso 2\data\kahoot\2018\kahoot_26_10_2018.xlsx'
kahoot_3010 = r'C:\Users\lucas\OneDrive\Documentos\UFG\9º Período - EXTRA\Projeto Final de Curso 2\data\kahoot\2018\kahoot_30_10_2018.xlsx'
kahoot_3110 = r'C:\Users\lucas\OneDrive\Documentos\UFG\9º Período - EXTRA\Projeto Final de Curso 2\data\kahoot\2018\kahoot_31_10_2018.xlsx'
kahoot_1311 = r'C:\Users\lucas\OneDrive\Documentos\UFG\9º Período - EXTRA\Projeto Final de Curso 2\data\kahoot\2018\kahoot_13_11_2018.xlsx'
kahoot_1411 = r'C:\Users\lucas\OneDrive\Documentos\UFG\9º Período - EXTRA\Projeto Final de Curso 2\data\kahoot\2018\kahoot_14_10_2018.xlsx'

wb = load_workbook(kahoot_0210)
ws = wb.active

nOfSheets = len(wb.worksheets)

# Refatorar - Overview, FInal Score, Question Summary e Questões
wsOver = wb['Overview']
wsFinal = wb['Final Scores']
wsQS = wb['Question Summary']
wsQues = []

for q in range(0, (nOfSheets - 3)):
    n = str(q + 1)
    # print(q)
    wsQues.append(wb['Question ' + n])

title = wsOver.cell(row=1, column=1).value
date = wsOver.cell(row=2, column=2).value
teacher = wsOver.cell(row=3, column=2).value
nOfPlayers = wsOver.cell(row=4, column=2).value
nOfQuestions = wsOver.cell(row=5, column=2).value
# label_1 = wsOver.cell(row=7, column=1).value
totalCorrect = wsOver.cell(row=8, column=3).value
totalIncorrect = wsOver.cell(row=9, column=3).value
averageScore = wsOver.cell(row=10, column=3).value
# label_2 = wsOver.cell(row=12, column=1).value
howFun = wsOver.cell(row=13, column=3).value
didLearning = []
didLearning.append(wsOver.cell(row=14, column=3).value)
didLearning.append(wsOver.cell(row=14, column=5).value)
doRecommend = []
doRecommend.append(wsOver.cell(row=15, column=3).value)
doRecommend.append(wsOver.cell(row=15, column=5).value)
howFeel = []
howFeel.append(wsOver.cell(row=16, column=4).value)
howFeel.append(wsOver.cell(row=16, column=6).value)
howFeel.append(wsOver.cell(row=16, column=8).value)

overview = {
    'Basic Information': {
        "Lesson Name": title,
        "Played on": date,
        "Hosted by": teacher,
        "Played with": nOfPlayers,
        "Played": nOfQuestions
    },
    "Overall Performance": {
        "Total correct answers (%)": totalCorrect,
        "Total incorrect answers (%)": totalIncorrect,
        "Average score (points)": averageScore
    },
    "Feedback": {
        "How fun was it? (out of 5)": howFun,
        "Did you learn something?": {
            "Yes": didLearning[0],
            "No": didLearning[1]
        },
        "Do you recommend it?": {
            "Yes": doRecommend[0],
            "No": doRecommend[1]
        },
        "How do you feel?": {
            "Positive": howFeel[0],
            "Neutral": howFeel[1],
            "Negative": howFeel[2]
        }
    }
}

# print(overview)
'''
print(date)
print(teacher)
print(nOfPlayers)
print(totalCorrect*100, "%")
print(totalIncorrect*100, "%")
print(averageScore)
'''

# Lista de numeros
idAl = []
# Lista de alunos
student = []
# Lista de score
score = []
# lista de questoes certas
quesCorrect = []
# lista de questoes erradas
quesIncorrect = []

maxRowFS = wsFinal.max_row
# print(maxRowFS)

# loop 1: 4 até nOfPlayers+3
# col=1 and row = i
for ial in range(4, maxRowFS):
    idAl.append(wsFinal.cell(row=ial, column=1).value)

# loop 2: 4 até nOfPlayers+3
# col=2 and row = i
for istd in range(4, maxRowFS):
    student.append(wsFinal.cell(row=istd, column=2).value)

# loop 3: 4 até nOfPlayers+3
# col=3 and row = i
for iscor in range(4, maxRowFS):
    score.append(wsFinal.cell(row=iscor, column=3).value)

# loop 4: 4 até nOfPlayers+3
# col=4 and row = i
for iqc in range(4, maxRowFS):
    quesCorrect.append(wsFinal.cell(row=iqc, column=4).value)

# loop 5: 4 até nOfPlayers+3
# col=5 and row = i
for iqi in range(4, maxRowFS):
    quesIncorrect.append(wsFinal.cell(row=iqi, column=5).value)

finalScore = {'Final Scores': {
    'rank': idAl,
    'player': student,
    'totalScore': score,
    'correctAnswers': quesCorrect,
    'incorrectAnswers': quesIncorrect
}
}

# print(finalScore)

'''
for iprint in range(0, stopCount-4):
    print(idAl[iprint], "|", student[iprint], "|", score[iprint], "|", quesCorrect[iprint], "|", quesIncorrect[iprint])
'''

qs_idAl = []
qs_student = []
qs_totalScore = []

numQuestions = nOfSheets - 3
qs_count = numQuestions
maxRowQS = wsQS.max_row
qs_score = [[] for _ in range(qs_count)]
qs_statement = [[] for _s_ in range(qs_count)]
qs_answer = [[] for __ in range(qs_count)]

for i in range(4, maxRowQS):
    qs_idAl.append(wsQS.cell(row=i, column=1).value)
    qs_student.append(wsQS.cell(row=i, column=2).value)
    qs_totalScore.append(wsQS.cell(row=i, column=3).value)
    for j in range(0, qs_count):
        col = 4 + 2 * j
        col2 = 5 + 2 * j
        qs_score[j].append(wsQS.cell(row=i, column=col).value)
        qs_statement[j].append(wsQS.cell(row=3, column=col2).value)
        qs_answer[j].append(wsQS.cell(row=i, column=col2).value)

questionSummary = {'Question Summary': {
    'rank': qs_idAl,
    'player': qs_student,
    'totalScore': qs_totalScore
},
    1: {
        'score': qs_score,
        'statement': qs_statement,
        'answer': qs_answer
    }
}

# print(questionSummary)
'''
for iprint in range(0, stopCount-4):
    print(qs_idAl[iprint], "|", qs_student[iprint], "|", qs_totalScore[iprint], "|")
    for qprint in range(0, qs_count-1):
        print(qs_score[qprint][iprint], "|", qs_answer[qprint][iprint], "|")
    print("")
'''

question_list = []
qtdAlunos = maxRowQS - 5
for quest in range(0, numQuestions):

    wsq_numq = []
    wsq_statement = []
    wsq_correctAnswers = []
    wsq_playersCorrect = []
    wsq_questionDuration = []
    wsq_ansOptTriangle = []
    wsq_ansOptLosangle = []
    wsq_ansOptCircle = []
    wsq_ansOptSquare = []
    wsq_IsAnswerCorrectTriangle = []
    wsq_IsAnswerCorrectLosangle = []
    wsq_IsAnswerCorrectCircle = []
    wsq_IsAnswerCorrectSquare = []
    wsq_NumOfAnsReceivedTriangle = []
    wsq_NumOfAnsReceivedLosangle = []
    wsq_NumOfAnsReceivedCircle = []
    wsq_NumOfAnsReceivedSquare = []
    wsq_TimeToAnsTriangle = []
    wsq_TimeToAnsLosangle = []
    wsq_TimeToAnsCircle = []
    wsq_TimeToAnsSquare = []

    wsq_alunos = [[] for ____ in range(qtdAlunos)]

    for k in range(0, qtdAlunos):
        for l in range(1, 11):
            wsq_alunos[k].append(wsQues[quest].cell(row=k + 15, column=l).value)

    wsq_numq.append(wsQues[quest].cell(row=2, column=1).value)
    wsq_statement.append(wsQues[quest].cell(row=2, column=2).value)
    wsq_correctAnswers.append(wsQues[quest].cell(row=3, column=3).value)
    wsq_playersCorrect.append(wsQues[quest].cell(row=4, column=3).value)
    wsq_questionDuration.append(wsQues[quest].cell(row=5, column=3).value)
    wsq_ansOptTriangle.append(wsQues[quest].cell(row=8, column=4).value)
    wsq_ansOptLosangle.append(wsQues[quest].cell(row=8, column=6).value)
    wsq_ansOptCircle.append(wsQues[quest].cell(row=8, column=8).value)
    wsq_ansOptSquare.append(wsQues[quest].cell(row=8, column=10).value)

    if (wsQues[quest].cell(row=9, column=3).value) == "✔︎":
        wsq_IsAnswerCorrectTriangle.append(True)
    else:
        wsq_IsAnswerCorrectTriangle.append(False)

    if (wsQues[quest].cell(row=9, column=5).value) == "✔︎":
        wsq_IsAnswerCorrectLosangle.append(True)
    else:
        wsq_IsAnswerCorrectLosangle.append(False)

    if (wsQues[quest].cell(row=9, column=7).value) == "✔︎":
        wsq_IsAnswerCorrectCircle.append(True)
    else:
        wsq_IsAnswerCorrectCircle.append(False)

    if (wsQues[quest].cell(row=9, column=9).value) == "✔︎":
        wsq_IsAnswerCorrectSquare.append(True)
    else:
        wsq_IsAnswerCorrectSquare.append(False)

    wsq_NumOfAnsReceivedTriangle.append(wsQues[quest].cell(row=10, column=3).value)
    wsq_NumOfAnsReceivedLosangle.append(wsQues[quest].cell(row=10, column=5).value)
    wsq_NumOfAnsReceivedCircle.append(wsQues[quest].cell(row=10, column=7).value)
    wsq_NumOfAnsReceivedSquare.append(wsQues[quest].cell(row=10, column=9).value)
    wsq_TimeToAnsTriangle.append(wsQues[quest].cell(row=11, column=3).value)
    wsq_TimeToAnsLosangle.append(wsQues[quest].cell(row=11, column=5).value)
    wsq_TimeToAnsCircle.append(wsQues[quest].cell(row=11, column=7).value)
    wsq_TimeToAnsSquare.append(wsQues[quest].cell(row=11, column=9).value)

    if wsq_alunos[0][2] == "✔︎":
        wsq_alunos[0][2] = True
    else:
        wsq_alunos[0][2] = False

    questions = {'Basic informations': {
        'numOfQuestion': wsq_numq,
        'statement': wsq_statement,
        'correctAnswers': wsq_correctAnswers,
        'playersCorrect': wsq_playersCorrect,
        'questionDuration': wsq_questionDuration
    },
        "Answare Summary": {
            'ansOptTriangle': wsq_ansOptTriangle,
            'ansOptLosangle': wsq_ansOptLosangle,
            'ansOptCircle': wsq_ansOptCircle,
            'ansOptSquare': wsq_ansOptSquare,
            'IsAnswerCorrectTriangle': wsq_IsAnswerCorrectTriangle,
            'IsAnswerCorrectLosangle': wsq_IsAnswerCorrectLosangle,
            'IsAnswerCorrectCircle': wsq_IsAnswerCorrectCircle,
            'IsAnswerCorrectSquare': wsq_IsAnswerCorrectSquare,
            'NumOfAnsReceivedTriangle': wsq_NumOfAnsReceivedTriangle,
            'NumOfAnsReceivedLosangle': wsq_NumOfAnsReceivedLosangle,
            'NumOfAnsReceivedCircle': wsq_NumOfAnsReceivedCircle,
            'NumOfAnsReceivedSquare': wsq_NumOfAnsReceivedSquare,
            'TimeToAnsTriangle': wsq_TimeToAnsTriangle,
            'TimeToAnsLosangle': wsq_TimeToAnsLosangle,
            'TimeToAnsCircle': wsq_TimeToAnsCircle,
            'TimeToAnsSquare': wsq_TimeToAnsSquare,
        },
        'Answer Details': {
            1: {
                'player': wsq_alunos[0][0],
                'alias': wsq_alunos[0][1],
                'answerIsCorrect': wsq_alunos[0][2],
                'statement': wsq_alunos[0][3],
                'score': wsq_alunos[0][4],
                'acumulateScore': wsq_alunos[0][6],
                'answerTime': wsq_alunos[0][8]
            }
        }
    }
    for alunos in range(1, qtdAlunos+1):
        questions[alunos] = {}
        _alunos = alunos - 1
        questions[alunos]['player'] = wsq_alunos[_alunos][0]
        questions[alunos]['alias'] = wsq_alunos[_alunos][1]
        if wsq_alunos[_alunos][2] == "✔︎":
            wsq_alunos[_alunos][2] = True
        else:
            wsq_alunos[_alunos][2] = False
        questions[alunos]['answerIsCorrect'] = wsq_alunos[_alunos][2]
        questions[alunos]['statement'] = wsq_alunos[_alunos][3]
        questions[alunos]['score'] = wsq_alunos[_alunos][4]
        questions[alunos]['acumulateScore'] = wsq_alunos[_alunos][6]
        questions[alunos]['answerTime'] = wsq_alunos[_alunos][8]

    question_list.append(questions)
    #print(questions)

# ======================  20/05/2021 ==================================

nomes = wb.sheetnames

# ==================  OVERVIEW ==================
txt_overview = ('{"' + nomes[0] + '": {' + "\n"
                + "\t" + '"' + overview['Basic Information']["Lesson Name"] + '": {' + "\n"
                + "\t\t" + '"' + "Played on" + '": "' + str(overview['Basic Information']["Played on"]) + '", ' + "\n"
                + "\t\t" + '"' + "Hosted by" + '": "' + str(overview['Basic Information']["Hosted by"]) + '", ' + "\n"
                + "\t\t" + '"' + "Played with" + '": "' + str(overview['Basic Information']["Played with"]) + '", ' + "\n"
                + "\t\t" + '"' + "Played" + '": "' + str(overview['Basic Information']["Played"]) + '"' + "\n"
                + "\t" + "}, " + "\n"
                + "\t" + '"' + "Overall Performance" + '": {' + "\n"
                + "\t\t" + '"' + "Total correct answers (%)" + '": "' + str(overview['Overall Performance']["Total correct answers (%)"]) + '", ' + "\n"
                + "\t\t" + '"' + "Total incorrect answers (%)" + '": "' + str(overview['Overall Performance']["Total incorrect answers (%)"]) + '", ' + "\n"
                + "\t\t" + '"' + "Average score (points)" + '": "' + str(overview['Overall Performance']["Average score (points)"]) + '"' + "\n"
                + "\t" + "}," + "\n"
                + "\t" + '"' + "Feedback" + '": {' + "\n"
                + "\t\t" + '"' + "How fun was it? (out of 5)" + '": "' + str(overview['Feedback']["How fun was it? (out of 5)"]) + '", ' + "\n"
                + "\t\t" + '"' + "Did you learn something?" + '": {' + "\n"
                + "\t\t\t" + '"' + "Yes" + '": "' + str(overview['Feedback']["Did you learn something?"]["Yes"]) + '", ' + "\n"
                + "\t\t\t" + '"' + "No" + '": "' + str(overview['Feedback']["Did you learn something?"]["No"]) + '"' + "\n"
                + "\t\t" + "}," + "\n"
                + "\t\t" + '"' + "Do you recommend it?" + '": {' + "\n"
                + "\t\t\t" + '"' + "Yes" + '": "' + str(overview['Feedback']["Do you recommend it?"]["Yes"]) + '", ' + "\n"
                + "\t\t\t" + '"' + "No" + '": "' + str(overview['Feedback']["Do you recommend it?"]["No"]) + '"' + "\n"
                + "\t\t" + "}," + "\n"
                + "\t\t" + '"' + "How do you feel?" + '": {' + "\n"
                + "\t\t\t" + '"' + "Positive" + '": "' + str(overview['Feedback']["How do you feel?"]["Positive"]) + '", ' + "\n"
                + "\t\t\t" + '"' + "Neutral" + '": "' + str(overview['Feedback']["How do you feel?"]["Neutral"]) + '", ' + "\n"
                + "\t\t\t" + '"' + "Negative" + '": "' + str(overview['Feedback']["How do you feel?"]["Negative"]) + '"' "\n"
                + "\t\t" + "}" + "\n"
                + "\t" + "}\n" + "}, \n")

# ==================  FINAL SCORE ==================

txt_final = '"' + nomes[1] + '": {' + "\n" + "\t" + '"' + overview['Basic Information']["Lesson Name"] + '": \n' + "\t" + "["
txt_final_students = []

for t in range(0, maxRowFS - 5):
    txt_final_students.append("\t\t{\n"
                              + "\t\t\t" + '"' + "Rank" + '": "' + str(finalScore['Final Scores']['rank'][t]) + '", ' + "\n"
                              + "\t\t\t" + '"' + 'Player' + '": "' + str(finalScore['Final Scores']['player'][t]) + '", ' + "\n"
                              + "\t\t\t" + '"' + 'Total Score' + '": "' + str(finalScore['Final Scores']['totalScore'][t]) + '", ' + "\n"
                              + "\t\t\t" + '"' + 'Correct Answers' + '": "' + str(finalScore['Final Scores']['correctAnswers'][t]) + '", ' + "\n"
                              + "\t\t\t" + '"' + 'Incorrect Answers' + '": "' + str(finalScore['Final Scores']['incorrectAnswers'][t]) + '"' + "\n")
    if t == maxRowFS - 6:
        txt_final_students[t] = txt_final_students[t] + "\t\t" + "}" + "\n"
    else:
        txt_final_students[t] = txt_final_students[t] + "\t\t" + "}," + "\n"

txt_final_students[maxRowFS-6] = txt_final_students[maxRowFS-6] + "\t]\n},"
# ==================  QUESTION SUMMARY ==================

txt_questionSummary_students = []
txt_questionSummary_students_questions = []
concate = []

txt_questionSummary = '"' + nomes[2] + '": {' + "\n" + "\t" + '"' + overview['Basic Information']["Lesson Name"] + '": {' \
                      + "\n" + "\t\t" + '"' + nomes[2] + '": ' + "\n" + "\t\t" + "["

n = 1

#questionSummary["Alunos"]['score'][0][1]
#questionSummary["Alunos"][_CAMPO_][_QUESTÃO_][_ALUNO_]

for q in range(0, maxRowQS - 5):
    txt_questionSummary_students.append("\t\t\t" + "{\n"
                                    + "\t\t\t\t" + '"' + 'Rank' + '": "' + str(questionSummary['Question Summary']['rank'][q]) + '", ' + "\n"
                                    + "\t\t\t\t" + '"' + 'Player' + '": "' + str(questionSummary['Question Summary']['player'][q]) + '", ' + "\n"
                                    + "\t\t\t\t" + '"' + 'Total Score' + '": "' + str(questionSummary['Question Summary']['totalScore'][q]) + '", ' + "\n")
    concatenar = txt_questionSummary_students[q]
    #print(concatenar)
    for s in range(0, qs_count):
        txt_questionSummary_students_questions.append("\t\t\t\t" + '"' + 'Q' + str(s+1) + '": {' + "\n"
                                    + "\t\t\t\t\t\t" + '"' + "Score" + '": "' + str(questionSummary[1]['score'][s][q]) + '", ' + "\n"
                                    + "\t\t\t\t\t\t" + '"' + "Statement" + '": "' + str(questionSummary[1]['statement'][s][q]) + '", ' + "\n"
                                    + "\t\t\t\t\t\t" + '"' + "Answer" + '": "' + str(questionSummary[1]['answer'][s][q]) + '"' + "\n")
        if s == qs_count-1:
            txt_questionSummary_students_questions[s] = txt_questionSummary_students_questions[s] + ("\t\t\t\t" + "}" + "\n")
        else:
            txt_questionSummary_students_questions[s] = txt_questionSummary_students_questions[s] + "\t\t\t\t" + "}, " + "\n"

        concatenar = concatenar + txt_questionSummary_students_questions[s]
    txt_questionSummary_students_questions = []
    if q == maxRowQS - 6:
        concatenar = concatenar + "\t\t\t" + "}" + "\n"
    else:
        concatenar = concatenar + "\t\t\t" + "}, " + "\n"
    concate.append(concatenar)

ind = maxRowQS - 6
concate[ind] = concate[ind] + "\t\t]\n" + "\t" + "}\n" + "},\n"
# ==================  QUESTIONS ==================

txt_question = []
txt_question_alunos = []
concate_question = []

for qn in range(0, numQuestions):
    txt_question.append('"' + nomes[qn+3] + '": {' + "\n" + "\t"
                    + '"' + overview['Basic Information']["Lesson Name"] + '": {' + "\n"
                    + "\t\t" + '"' + question_list[qn]['Basic informations']['numOfQuestion'][0] + '": {' + "\n"
                    + "\t\t\t" + '"' + "Statement" + '": "' + question_list[qn]['Basic informations']['statement'][0] + '", ' + "\n"
                    + "\t\t\t" + '"' + "Correct Answer" + '": "' + str(question_list[qn]['Basic informations']['correctAnswers'][0]) + '", ' + "\n"
                    + "\t\t\t" + '"' + "Players Correct" + '": "' + str(question_list[qn]['Basic informations']['playersCorrect'][0]) + '", ' + "\n"
                    + "\t\t\t" + '"' + "Question Duration" + '": "' + str(question_list[qn]['Basic informations']['questionDuration'][0]) + '"' + "\n"
                    + "\t\t" + "},\n"
                    + "\t\t" + '"' + "Answare Summary" + '": {' + "\n"
                    + "\t\t\t" + '"' + "Answer options" + '": {' + "\n"
                    + "\t\t\t\t\t" + '"' + "Triangle" + '": "' + str(question_list[qn]['Answare Summary']['ansOptTriangle'][0]) + '", ' + "\n"
                    + "\t\t\t\t\t" + '"' + "Losangle" + '": "' + str(question_list[qn]['Answare Summary']['ansOptLosangle'][0]) + '", ' + "\n"
                    + "\t\t\t\t\t" + '"' + "Circle" + '": "' + str(question_list[qn]['Answare Summary']['ansOptCircle'][0]) + '", ' + "\n"
                    + "\t\t\t\t\t" + '"' + "Square" + '": "' + str(question_list[qn]['Answare Summary']['ansOptSquare'][0]) + '"' + "\n"
                    + "\t\t\t" + "},\n"
                    + "\t\t\t" + '"' + "Is answer correct?" + '": {' + "\n"
                    + "\t\t\t\t\t" + '"' + "Triangle" + '": "' + str(question_list[qn]['Answare Summary']['IsAnswerCorrectTriangle'][0]) + '", ' + "\n"
                    + "\t\t\t\t\t" + '"' + "Losangle" + '": "' + str(question_list[qn]['Answare Summary']['IsAnswerCorrectLosangle'][0]) + '", ' + "\n"
                    + "\t\t\t\t\t" + '"' + "Circle" + '": "' + str(question_list[qn]['Answare Summary']['IsAnswerCorrectCircle'][0]) + '", ' + "\n"
                    + "\t\t\t\t\t" + '"' + "Square" + '": "' + str(question_list[qn]['Answare Summary']['IsAnswerCorrectSquare'][0]) + '"' + "\n"
                    + "\t\t\t" + "},\n"
                    + "\t\t\t" + '"' + "Number of answers received" + '": {' + "\n"
                    + "\t\t\t\t\t" + '"' + "Triangle" + '": "' + str(question_list[qn]['Answare Summary']['NumOfAnsReceivedTriangle'][0]) + '", ' + "\n"
                    + "\t\t\t\t\t" + '"' + "Losangle" + '": "' + str(question_list[qn]['Answare Summary']['NumOfAnsReceivedLosangle'][0]) + '", ' + "\n"
                    + "\t\t\t\t\t" + '"' + "Circle" + '": "' + str(question_list[qn]['Answare Summary']['NumOfAnsReceivedCircle'][0]) + '", ' + "\n"
                    + "\t\t\t\t\t" + '"' + "Square" + '": "' + str(question_list[qn]['Answare Summary']['NumOfAnsReceivedSquare'][0]) + '"' + "\n"
                    + "\t\t\t" + "},\n"
                    + "\t\t\t" + '"' + "Average time taken to answer (seconds)" + '": {' + "\n"
                    + "\t\t\t\t\t" + '"' + "Triangle" + '": "' + str(question_list[qn]['Answare Summary']['TimeToAnsTriangle'][0]) + '", ' + "\n"
                    + "\t\t\t\t\t" + '"' + "Losangle" + '": "' + str(question_list[qn]['Answare Summary']['TimeToAnsLosangle'][0]) + '", ' + "\n"
                    + "\t\t\t\t\t" + '"' + "Circle" + '": "' + str(question_list[qn]['Answare Summary']['TimeToAnsCircle'][0]) + '", ' + "\n"
                    + "\t\t\t\t\t" + '"' + "Square" + '": "' + str(question_list[qn]['Answare Summary']['TimeToAnsSquare'][0]) + '"' + "\n"
                    + "\t\t\t" + "},\n"
                    + "\t\t" + "},\n"
                    + "\t\t" + '"' + "Answer Details" + '": ' + "\n" + "\t\t[\n")
    concatenar_Question = txt_question[qn]
    for qnn in range(0, qtdAlunos):
        qn_n = qnn + 1
        txt_question_alunos.append("\t\t\t" + "{\n"
                    + "\t\t\t\t" + '"' + "Player" + '": "' + str(questions[qn_n]['player']) + '", ' + "\n"
                    + "\t\t\t\t" + '"' + "Alias" + '": "' + str(questions[qn_n]['alias']) + '", ' + "\n"
                    + "\t\t\t\t" + '"' + "Answer" + '": {' + "\n"
                    + "\t\t\t\t\t\t" + '"' + "Correct?" + '": "' + str(questions[qn_n]['answerIsCorrect']) + '", ' + "\n"
                    + "\t\t\t\t\t\t" + '"' + "Statement" + '": "' + str(questions[qn_n]['statement']) + '", ' + "\n"
                    + "\t\t\t\t" + "}," + "\n"
                    + "\t\t\t\t" + '"' + "Score (points)" + '": "' + str(questions[qn_n]['score']) + '", ' + "\n"
                    + "\t\t\t\t" + '"' + "Current Total Score (points)" + '": "' + str(questions[qn_n]['acumulateScore']) + '", ' + "\n"
                    + "\t\t\t\t" + '"' + "Answer time (seconds)" + '": "' + str(questions[qn_n]['answerTime']) + '"' + "\n")
        if qnn == qtdAlunos - 1:
            txt_question_alunos[qnn] = txt_question_alunos[qnn] + "\t\t\t" + "}\n"
        else:
            txt_question_alunos[qnn] = txt_question_alunos[qnn] + "\t\t\t" + "},\n"
        concatenar_Question = concatenar_Question + txt_question_alunos[qnn]
    txt_question_alunos = []
    concatenar_Question = concatenar_Question + "\t\t" + "]\n" + "\t" + "}\n"
    if qn == numQuestions - 1:
        concatenar_Question = concatenar_Question + "}\n}"
    else:
        concatenar_Question = concatenar_Question + "},\n"
    concate_question.append(concatenar_Question)

#print(txt_overview)
#print(txt_final)
#print(*txt_final_students)
#print(txt_questionSummary)
#print(*concate)
#print(question_list[1])
#print(*txt_question)
#print(*concate_question)

arquivo = open("data_structe.json", 'w')
arquivo.write(txt_overview)
arquivo.write("\n")
arquivo.write(txt_final)
arquivo.write(''.join(txt_final_students))
arquivo.write("\n")
arquivo.write(''.join(txt_questionSummary))
arquivo.write(''.join(concate))
arquivo.write("\n")
arquivo.write(''.join(concate_question))
arquivo.close()

#========================================================