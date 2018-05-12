
from django.db import models

class Turma(models.Model):
    turno = models.CharField(max_length=15)
    sigla = models.CharField(max_length=1)
    curso = models.ForeignKey(to='Curso', related_name="turmas", null=False, blank=False, on_delete=models.CASCADE) #onetomany

    class Meta:
        db_table = 'TURMA'

from .Curso import Curso