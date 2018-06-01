from django.shortcuts import render
from core.models import Grupo

def listarGrupo (request):

    contexto = {}

    contexto['grupos'] = Grupo.objects.all()

    return render(request,"administrador/grupos/index.html", contexto)
