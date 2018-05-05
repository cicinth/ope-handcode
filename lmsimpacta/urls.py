from django.conf.urls import url
from django.contrib import admin
from core.views import *
from django.contrib.auth.views import login, logout

urlpatterns = [
    url(r'^$', index, name="home"),
    url(r'^grupo/$', grupo),
    url(r'^painel/administrador/$', painelAdministrador),
]

