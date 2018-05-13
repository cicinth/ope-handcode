from django.shortcuts import render
from core.models import Administrador
from django.http import HttpResponseRedirect
from core.forms import AdministradorForm

def novoAdministrador (request): 
    contexto = {}

    if request.POST:
        form = AdministradorForm(request.POST)
        
        if form.is_valid():
            form.save()
            return HttpResponseRedirect("/painel/administrador/administradores")
        else:
            contexto['form'] = form
            contexto['administrador'] = Administrador(form)
    else: 
        contexto['form'] = AdministradorForm()

    return render(request,"administrador/administradores/novo.html", contexto)

def listarAdministrador (request):
    contexto = {}
    contexto['administradores'] = Administrador.objects.all()
    return render(request,"administrador/administradores/index.html", contexto)

def editarAdministrador (request, idAdministrador):
    contexto = {}

    administrador = Administrador.objects.get(id=idAdministrador)

    if request.POST:
        form = AdministradorForm(request.POST, instance=administrador)
        
        if form.is_valid():
            form.save()
            return HttpResponseRedirect("/painel/administrador/administradores")
        else:
            contexto['form'] = form
            contexto['administrador'] = Administrador(form)
    else: 
        contexto['form'] = AdministradorForm(instance=administrador)
        contexto['administrador'] = administrador

    return render(request,"administrador/administradores/editar.html", contexto)