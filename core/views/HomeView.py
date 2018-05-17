from django.shortcuts import render
from core.models import *

def homeIndex (request):
    contexto = {}
    return render(request,"home/index.html",contexto)

def homeCadastroGrupo (request):
    contexto = {}

    print(Grupo.objects.all())
    print(Aluno.objects.all())

    alunos = []

    alunoAtual = {}

    if request.POST:
        dic = request.POST.dict()
        salvaGrupoAlunos(dic)

    return render(request,"home/grupo.html",contexto)


def salvaGrupoAlunos(dicionario):
    print(dicionario)
    i = 0
    t = len(dicionario)
    del dicionario['csrfmiddlewaretoken']
    keys = dicionario.keys()
    
    grupo = {"nome":dicionario["nome"], "tema":dicionario["tema"], "turma":dicionario["turma"]}

    grupoModel = Grupo()
    grupoModel.ativo = False
    grupoModel.nome = grupo["nome"]
    grupoModel.tema = grupo["tema"]
    print("turma",grupo["turma"])
    grupoModel.turma = Turma.objects.get(id=int(grupo["turma"]))
    grupoModel.save()
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
        if ra != '' or nome != '' or email != '' or telefone != '':
            alunos.append({"ra":ra,"nome":nome,"email":email,"telefone":telefone})

    for aluno in alunos:
        alunoModel = Aluno()
        alunoModel.ativo = False
        alunoModel.ra = aluno['ra']
        alunoModel.nome = aluno['nome']
        alunoModel.email = aluno['email']
        alunoModel.set_password('asdf1234')
        alunoModel.telefone = aluno['telefone']
        alunoModel.save()
        alunoModel.grupos.add(grupoModel)
        alunoModel.save()
        print(aluno)