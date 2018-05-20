from django.http import HttpResponse
import json

def disciplinaExcluir(request):
    if request.is_ajax():
        if request.method == 'POST':
            print(request.body)
            body_unicode = request.body.decode('utf-8')
            body = json.loads(body_unicode)
            content = body['content']
            print(content)
    return HttpResponse(200)