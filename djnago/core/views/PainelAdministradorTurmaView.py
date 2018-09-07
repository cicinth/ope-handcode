from django.shortcuts import render
from core.models import Turma
from core.models import Curso
from core.forms import TurmaForm
from django.http import HttpResponseRedirect

def novoTurma (request):

    contexto = {}
    contexto['cursos'] = Curso.objects.all()
    
    if request.POST:
        form = TurmaForm(request.POST)
        
        if form.is_valid():
            form.save()
            return HttpResponseRedirect("/painel/administrador/turmas")
        else:
            contexto['form'] = form
            contexto['turma'] = Turma(form)
    else: 
        contexto['form'] = TurmaForm()

    return render(request,"administrador/turmas/novo.html", contexto)

def listarTurma (request):
    contexto = {}

    contexto['turmas'] = Turma.objects.all()

    return render(request,"administrador/turmas/index.html", contexto)

def editarTurma (request, idTurma):

    turma = Turma.objects.get(id=idTurma)

    contexto = {}
    contexto['cursos'] = Curso.objects.all()


    if request.POST:
        form = TurmaForm(request.POST, instance=turma)
        
        if form.is_valid():
            form.save()
            return HttpResponseRedirect("/painel/administrador/turmas")
        else:
            contexto['form'] = form
            contexto['turma'] = Turma(form)
    else: 
        contexto['form'] = TurmaForm(instance=turma)
        contexto['turma'] = turma

    return render(request,"administrador/turmas/editar.html", contexto)