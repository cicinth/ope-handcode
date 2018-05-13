from django.shortcuts import render
from core.models import Disciplina
from core.models import Curso
from core.forms import DisciplinaForm
from django.http import HttpResponseRedirect

def novaDisciplina (request):

    contexto = {}
    contexto['cursos'] = Curso.objects.all()
    
    if request.POST:
        form = DisciplinaForm(request.POST)
        
        if form.is_valid():
            form.save()
            return HttpResponseRedirect("/painel/administrador/disciplinas")
        else:
            contexto['form'] = form
    else: 
        contexto['form'] = DisciplinaForm()

    return render(request,"administrador/disciplinas/nova.html", contexto)

def listarDisciplina (request):
    contexto = {}

    contexto['disciplinas'] = Disciplina.objects.all()

    return render(request,"administrador/disciplinas/index.html", contexto)

def editarDisciplina (request, siglaDisciplina):

    disciplina = Disciplina.objects.get(sigla=siglaDisciplina)

    contexto = {}
    contexto['cursos'] = Curso.objects.all()

    if request.POST:
        form = CursoForm(request.POST, instance=disciplina)
        
        if form.is_valid():
            form.save()
            return HttpResponseRedirect("/painel/administrador/disciplinas")
        else:
            contexto['form'] = form
    else: 
        contexto['form'] = DisciplinaForm(instance=disciplina)
        contexto['disciplina'] = disciplina

    return render(request,"administrador/disciplinas/editar.html", contexto)