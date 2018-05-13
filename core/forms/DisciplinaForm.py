from django import forms
from core.models import Disciplina

class DisciplinaForm(forms.ModelForm):
    class Meta:
        model = Disciplina
        fields = "__all__"
