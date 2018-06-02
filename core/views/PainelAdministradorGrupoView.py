from django.shortcuts import render
from core.models import Grupo

def listarGrupo (request):

    contexto = {}

    if ('ativo' in request.GET.keys() and request.GET['ativo'] == 'true'):
        contexto['grupos'] = Grupo.objects.filter(ativo=True)
    elif ('ativo' in request.GET.keys() and request.GET['ativo'] == 'false'):
        contexto['grupos'] = Grupo.objects.filter(ativo=False)
    else:
        contexto['grupos'] = Grupo.objects.all()
    

    

    return render(request,"administrador/grupos/index.html", contexto)
