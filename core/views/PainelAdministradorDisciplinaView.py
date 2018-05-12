from django.shortcuts import render

def novaDisciplina (request):
    return render(request,"administrador/disciplinas/nova.html")

def listarDisciplina (request):
    return render(request,"administrador/disciplinas/index.html")

def editarDisciplina (request):
    return render(request,"administrador/disciplinas/editar.html")