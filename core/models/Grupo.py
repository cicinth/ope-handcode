from django.db import models

class Grupo(models.Model):
    sigla = models.CharField(max_length=3,unique=True,null=False)
    nome = models.CharField(max_length=50,null=False)
    turma = models.ForeignKey(to='Turma', related_name="grupos", null=False, blank=False, on_delete=models.CASCADE) #onetomany
    #alunos = models.ManyToManyField(to='Aluno')
    
    class Meta:
        db_table = 'GRUPO'

from .Turma import Turma
