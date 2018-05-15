from django.shortcuts import render
from core.models.Curso import Curso

def homeIndex (request):
    contexto = {}
    return render(request,"home/index.html",contexto)

def homeCadastroGrupo (request):
    contexto = {}

    alunos = []

    alunoAtual = {}

    if request.POST:
        dic = request.POST.dict()
        salvaGrupoAlunos(dic)

    return render(request,"home/grupo.html",contexto)


def salvaGrupoAlunos(dicionario):
    i = 0
    t = len(dicionario)
    del dicionario['csrfmiddlewaretoken']
    keys = dicionario.keys()
    
    grupo = {"nome":dicionario["nome"], "tema":dicionario["tema"], "curso":dicionario["curso"]}

    print("grupo ",grupo)

    alunos = []


    while i != t:
        ra = ''
        nome = ''
        email = ''
        telefone = ''
        
        for key in keys:
            if key == 'alunos['+str(i)+'].ra':
                ra = dicionario[key]
            if key == 'alunos['+str(i)+'].nome':
                nome = dicionario[key]
            if key == 'alunos['+str(i)+'].email':
                email = dicionario[key]
            if key == 'alunos['+str(i)+'].telefone':
                telefone = dicionario[key]
        i = i + 1
        if ra != '' and nome != '' and email != '' and telefone != '':
            alunos.append({"ra":ra,"nome":nome,"email":email,"telefole":telefone})

    for aluno in alunos:
        print(aluno)