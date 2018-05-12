
from django.db import models

class Disciplina(models.Model):
    nome = models.CharField(max_length=240)
    sigla = models.CharField(max_length=3,unique=True,null=False)

    class Meta:
        db_table = 'DISCIPLINA'

