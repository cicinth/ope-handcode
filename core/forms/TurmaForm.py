from django import forms
from core.models import Turma

class TurmaForm(forms.ModelForm):
    class Meta:
        model = Turma
        fields = "__all__"
