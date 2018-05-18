from django.contrib.auth.models import AbstractBaseUser, UserManager, BaseUserManager
from django.db import models
from .managers.UsuarioManager import UsuarioManager


class Usuario(AbstractBaseUser):
    
    nome = models.CharField("nome", max_length=100, blank=False)
    email = models.EmailField("email", unique=True, blank=False)
    ativo = models.BooleanField("ativo", default=True) 
    password = models.CharField(max_length=150)

    USERNAME_FIELD = 'email'

    objects = UsuarioManager()


    def has_perm(self, perm, obj=None):
	    return True
        
    def has_module_perms(self, app_label):
	    return True

    def get_short_name(self):
        return self.nome

    def get_full_name(self):
        return self.nome

    def getIniciais(self):
        xs = (self.nome)
        name_list = xs.split()

        initials = ""

        for name in name_list:  # go through each name
            initials += name[0].upper()  # append the initial

        return initials

    def __str__(self):
        return str(self.id)

    class Meta:
        db_table = 'USUARIO'