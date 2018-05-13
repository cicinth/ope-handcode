from django.shortcuts import render
from core.models import Administrador
from django.http import HttpResponseRedirect

def novoAdministrador (request):
    
    return render(request,"administrador/administradores/novo.html", contexto)

def listarAdministrador (request):

    return render(request,"administrador/administradores/index.html", contexto)

def editarAdministrador (request, idAdministrador):

    return render(request,"administrador/administradores/editar.html", contexto)