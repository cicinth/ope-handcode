from django.shortcuts import render

def painelAdministradorPerfil (request):
    contexto = {}
    return render(request,"administrador/perfil/index.html",contexto)