
from django.db import models

class Turma(models.Model):
    turno = models.CharField(max_length=15)
    sigla = models.CharField(max_length=1)
    ano = models.PositiveSmallIntegerField()
    semestre = models.PositiveSmallIntegerField()
    curso = models.ForeignKey(to='Curso', related_name="turmas", null=False, blank=False, on_delete=models.CASCADE) #onetomany

    class Meta:
        db_table = 'TURMA'

    def getCursoId(self):
        return self.curso.id
    
    def toJson(self):
        return {
            "id":self.id,
            "turno":self.turno,
            "sigla":self.sigla,
            "ano":self.ano,
            "semestre":self.semestre,
            "curso":self.curso.id
        }


from .Curso import Curso