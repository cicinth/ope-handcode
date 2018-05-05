from django.shortcuts import render

def painelAdministrador (request):
    return render(request,"administrador/index.html")