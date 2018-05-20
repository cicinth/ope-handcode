from django.conf.urls import url
from django.contrib import admin
from core.views import *
from django.contrib.auth.views import login, logout
from django.urls import path
from core.rest import *

urlpatterns = [
    path('', homeIndex, name="home"),
    path('grupo/', homeCadastroGrupo),
    path('entrar/', entrar, name="login"),
    path('painel/administrador/', painelAdministradorIndex),
    path('painel/administrador/disciplinas/', listarDisciplina),
    path('painel/administrador/disciplinas/novo', novoDisciplina),
    path('painel/administrador/disciplinas/editar/<slug:siglaDisciplina>', editarDisciplina),
    path('painel/administrador/cursos/', listarCurso),
    path('painel/administrador/cursos/novo', novoCurso),
    path('painel/administrador/cursos/editar/<slug:siglaCurso>', editarCurso),
    path('painel/administrador/perfil/', painelAdministradorPerfil),
    path('painel/administrador/turmas/', listarTurma),
    path('painel/administrador/turmas/novo', novoTurma),
    path('painel/administrador/turmas/editar/<int:idTurma>', editarTurma),
    path('painel/administrador/administradores/', listarAdministrador),
    path('painel/administrador/administradores/novo', novoAdministrador),
    path('painel/administrador/administradores/editar/<int:idAdministrador>', editarAdministrador),
    path("login/", login, {"template_name":"login/entrar.html"}), 
    path("logout/", logout, {'next_page': 'home'}),
    path("painel/administrador/disciplinas/remover/", disciplinaExcluir)
]

