from django.shortcuts import render
from core.models.Curso import Curso

def homeIndex (request):
    contexto = {}
    return render(request,"home/index.html",contexto)

def homeCadastroGrupo (request):
    contexto = {}


    if request.POST:
        print(request.POST)
        print(request.POST.get("alunos"))
        print(request.POST.getlist("alunos"))


    return render(request,"home/grupo.html",contexto)