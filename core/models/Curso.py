from django.db import models

class Curso(models.Model):
    sigla = models.CharField(max_length=3,unique=True,null=False)
    nome = models.CharField(max_length=50,unique=True,null=False)
    semestres = models.IntegerField()

    class Meta:
        db_table = 'CURSO'
