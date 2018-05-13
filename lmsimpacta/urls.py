from django.conf.urls import url
from django.contrib import admin
from core.views import *
from django.contrib.auth.views import login, logout
from django.urls import path

urlpatterns = [
    path('', homeIndex, name="home"),
    path('grupo/', homeCadastroGrupo),
    path('entrar/', entrar, name="login"),
    path('painel/administrador/', painelAdministradorIndex),
    path('painel/administrador/disciplinas/', listarDisciplina),
    path('painel/administrador/disciplinas/nova', novaDisciplina),
    path('painel/administrador/disciplinas/editar/<slug:siglaDisciplina>', editarDisciplina),
    path('painel/administrador/cursos/', listarCurso),
    path('painel/administrador/cursos/novo', novoCurso),
    path('painel/administrador/cursos/editar/<slug:siglaCurso>', editarCurso),
    path('painel/administrador/perfil/', painelAdministradorPerfil),
]

