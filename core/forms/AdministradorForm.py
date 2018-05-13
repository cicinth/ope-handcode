from core.models import *
from django import forms

class AdministradorForm(forms.ModelForm):
    class Meta:
        model = Administrador
        fields = ('nome','email')

    def save(self, commit=True):
        user = super(AdministradorForm, self).save(commit=False)
        user.set_password('123456')
        user.ativo = True
        if commit:
            user.save()
        return user