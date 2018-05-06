from django.conf.urls import url
from django.contrib import admin
from core.views import *
from django.contrib.auth.views import login, logout
from django.urls import path

urlpatterns = [
    path('', index, name="home"),
    path('grupo/', grupo),
    path('painel/administrador/', painelAdministrador),
    path('painel/administrador/disciplinas/nova', cadastrarDisciplinas),
]

