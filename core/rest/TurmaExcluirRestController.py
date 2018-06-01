from django.http import HttpResponse
import json
from core.models import Turma

def turmaExcluir(request):

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

            turma = Turma.objects.get(sigla = dicionario['sigla'])

            if not turma:
                return HttpResponse(
                    content="Turma nao encontrada.", 
                    content_type='text/plain', 
                    status=404, 
                    reason=None, 
                    charset='utf-8'
                )
            
            turma.delete()
            return HttpResponse(
                content="Turma excluida.", 
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