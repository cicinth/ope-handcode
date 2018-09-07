dicionario = {
'alunos[1].ra': '2342335', 
'alunos[0].ra': '234234', 
'alunos[0].email': '1@4.com', 
'alunos[0].telefone': '23423423', 
'alunos[2].telefone': '213123', 
'csrfmiddlewaretoken': 'BdbMyI6hZsZoIoWaVYKV85NKZQFDXmyO4M80YyGi0iu9gpX2NgAa6A51AbxzKKJP', 
'alunos[2].email': '2@3.com', 
'alunos[1].nome': '1231231', 
'alunos[0].nome': '234234', 
'alunos[2].ra': '2412', 
'alunos[2].nome': '23', 
'alunos[1].email': '3@1.com', 
'alunos[1].telefone': '1231231'
}

i = 0
t = len(dicionario)
del dicionario['csrfmiddlewaretoken']

alunos = []

while i != t:
    ra = ''
    nome = ''
    email = ''
    telefone = ''
    keys = dicionario.keys()
    for key in keys:
        if key == 'alunos['+str(i)+'].ra':
            ra = dicionario[key]
        if key == 'alunos['+str(i)+'].nome':
            nome = dicionario[key]
        if key == 'alunos['+str(i)+'].email':
            email = dicionario[key]
        if key == 'alunos['+str(i)+'].telefone':
            telefone = dicionario[key]
    i = i + 1
    if ra != '' and nome != '' and email != '' and telefone != '':
        alunos.append({"ra":ra,"nome":nome,"email":email,"telefole":telefone})



for aluno in alunos:
    print(aluno)