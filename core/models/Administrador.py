
from django.db import models
from .Usuario import Usuario

class Administrador(Usuario):

    class Meta:
        db_table = 'ADMINISTRADOR'