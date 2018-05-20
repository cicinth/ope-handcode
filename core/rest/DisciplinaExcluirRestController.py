from django.http import HttpResponse


def disciplinaExcluir(request):
    if request.is_ajax():
        if request.method == 'POST':
            print(request.body)
    return HttpResponse(200)