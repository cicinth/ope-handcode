
from django.db import models

class Disciplina(models.Model):
    nome = models.CharField(max_length=240)
    sigla = models.CharField(max_length=5,unique=True,null=False)
    cursos = models.ManyToManyField(to='Curso', db_table='CURSO_DISICPLINAS', related_name='disciplinas', blank=True)

    class Meta:
        db_table = 'DISCIPLINA'

    def getCursosIds(self):
        ids = []
        for curso in self.cursos.all():
            ids.append(curso.id)
        return ids
