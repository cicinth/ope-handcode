from django.http import HttpResponse
import json

def disciplinaExcluir(request):
    if request.is_ajax():
        if request.method == 'POST':
            print(request.body)
            requestBody = request.body.decode('utf-8')
            dicionario = json.loads(requestBody)
            print(dicionario)
            print(dicionario['sigla'])
    return HttpResponse(200)