from django.shortcuts import render
from core.models.Curso import Curso
from core.forms import GrupoForm

def homeIndex (request):
    contexto = {}
    return render(request,"home/index.html",contexto)

def homeCadastroGrupo (request):
    contexto = {}

    alunos = []

    alunoAtual = {}

    if request.POST:
        dic = request.POST.dict()
        print(dic)
        possuiAlunos = True
        i = 0
        while possuiAlunos:
            ra = ''
            nome = ''
            email = ''
            telefone = ''
            for key in dic:
                pass

            possuiAlunos = False


    return render(request,"home/grupo.html",contexto)