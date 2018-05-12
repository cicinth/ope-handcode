from django.shortcuts import render

def novoCurso (request):
    return render(request,"administrador/cursos/novo.html")

def listarCurso (request):
    return render(request,"administrador/cursos/index.html")

def editarCurso (request):
    return render(request,"administrador/cursos/editar.html")