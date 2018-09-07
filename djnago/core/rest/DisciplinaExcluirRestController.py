from django.http import HttpResponse
import json
from core.models import Disciplina

def disciplinaExcluir(request):

    if request.is_ajax():
        if request.method == 'POST':
            print(request.body)
            requestBody = request.body.decode('utf-8')
            dicionario = json.loads(requestBody)
            if not 'sigla' in dicionario.keys():
                return HttpResponse(
                    content="Sigla nao enviada.",
                    content_type='text/plain', 
                    status=400,
                    reason=None, 
                    charset='utf-8'
                )  
            print(dicionario)
            print(dicionario['sigla'])

            disciplina = Disciplina.objects.get(sigla = dicionario['sigla'])

            if not disciplina:
                return HttpResponse(
                    content="Disciplina nao encontrada.", 
                    content_type='text/plain', 
                    status=404, 
                    reason=None, 
                    charset='utf-8'
                )
            
            disciplina.delete()
            return HttpResponse(
                content="Disciplina excluida.", 
                content_type='text/plain', 
                status=200, 
                reason=None, 
                charset='utf-8'
            )

    return HttpResponse(
        content="Erro interno no servidor.", 
        content_type='text/plain', 
        status=500, 
        reason=None, 
        charset='utf-8'
    )