from django.db import models
from .Usuario import Usuario

class Professor(Usuario):
    celular = models.CharField(max_length =  11)

    class Meta:
        db_table = 'PROFESSOR'