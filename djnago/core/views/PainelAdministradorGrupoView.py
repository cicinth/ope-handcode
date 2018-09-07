from django.shortcuts import render
from core.models import Grupo
from core.models import Aluno

def listarGrupo (request):

    contexto = {}

    if ('ativo' in request.GET.keys() and request.GET['ativo'] == 'true'):
        contexto['grupos'] = Grupo.objects.filter(ativo=True)
    elif ('ativo' in request.GET.keys() and request.GET['ativo'] == 'false'):
        contexto['grupos'] = Grupo.objects.filter(ativo=False)
    else:
        contexto['grupos'] = Grupo.objects.all()
    

    

    return render(request,"administrador/grupos/index.html", contexto)

def detalheGrupo (request, id):
    g = Grupo.objects.get(id=id)
    contexto = {}
    contexto['grupo'] = g
    contexto['integrantes'] = Aluno.objects.filter(grupos=g)
    return render(request,"administrador/grupos/detalhe.html", contexto)
