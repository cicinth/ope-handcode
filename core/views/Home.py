from django.shortcuts import render
from core.models.Curso import Curso

def index (request):
    contexto = {}
    return render(request,"home/index.html",contexto)

def grupo (request):
    contexto = {}
    return render(request,"home/grupo.html",contexto)