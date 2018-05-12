from django.shortcuts import render
from core.models.Curso import Curso

def homeIndex (request):
    contexto = {}
    return render(request,"home/index.html",contexto)

def homeCadastroGrupo (request):
    contexto = {}
    return render(request,"home/grupo.html",contexto)