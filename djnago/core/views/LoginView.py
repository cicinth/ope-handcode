from django.shortcuts import render

def entrar (request):
    contexto = {}
    return render(request,"login/entrar.html",contexto)