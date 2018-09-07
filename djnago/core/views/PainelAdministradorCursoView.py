from django.shortcuts import render
from core.models import Curso
from core.forms import CursoForm
from django.http import HttpResponseRedirect

def novoCurso (request):

    contexto = {}

    if request.POST:
        form = CursoForm(request.POST)
        
        if form.is_valid():
            form.save()
            return HttpResponseRedirect("/painel/administrador/cursos")
        else:
            contexto['form'] = form
    else: 
        contexto['form'] = CursoForm()
    
    return render(request,"administrador/cursos/novo.html", contexto)

def listarCurso (request):

    contexto = {}

    contexto['cursos'] = Curso.objects.all()

    return render(request,"administrador/cursos/index.html", contexto)

def editarCurso (request, siglaCurso):

    curso = Curso.objects.get(sigla=siglaCurso)

    contexto = {}

    if request.POST:
        form = CursoForm(request.POST, instance=curso)
        
        if form.is_valid():
            form.save()
            return HttpResponseRedirect("/painel/administrador/cursos")
        else:
            contexto['form'] = form
    else: 
        contexto['form'] = CursoForm(instance=curso)
        contexto['curso'] = curso

    return render(request,"administrador/cursos/editar.html", contexto)