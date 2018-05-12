from django.db import models
from .Usuario import Usuario

class Aluno(Usuario):
    ra = models.IntegerField("ra", unique=True)
    celular = models.CharField(max_length=11, null=True, blank=True)
    grupos = models.ManyToManyField(to='Grupo', db_table='GRUPO_ALUNO', related_name='alunos', blank=True)
    
    class Meta:
        db_table = 'ALUNO'

from .Grupo import Grupo