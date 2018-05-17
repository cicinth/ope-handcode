from django.db import models

class Grupo(models.Model):
    nome = models.CharField(max_length=50,null=False)
    tema = models.CharField(max_length=50,null=False)
    ativo = models.BooleanField(default=False)
    turma = models.ForeignKey(to='Turma', related_name="grupos", null=False, blank=False, on_delete=models.CASCADE) #onetomany
    #alunos = models.ManyToManyField(to='Aluno')
    
    class Meta:
        db_table = 'GRUPO'

from .Turma import Turma
