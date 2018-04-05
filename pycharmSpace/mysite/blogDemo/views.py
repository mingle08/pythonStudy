from django.shortcuts import render
from django.http import HttpResponse

from . import models

def index(request):

    # return HttpResponse('Hello, world!')
    #return render(request, 'blogDemo/index.html', {'hello' : 'First Demo !'})

    #article = models.Article.objects.get(pk=1)
    #return render(request, 'blogDemo/index.html', {'article': article})

    articles = models.Article.objects.all()
    return render(request, 'blogDemo/index.html', {'articles': articles})

def article_page(request, article_id):
    article = models.Article.objects.get(id=article_id)
    return render(request, 'blogDemo/article_page.html', {'article': article})

def edit_page(request, article_id):
    if str(article_id) == '0':
        return render(request, 'blogDemo/edit_page.html')
    article = models.Article.objects.get(pk=article_id)
    return render(request, 'blogDemo/edit_page.html', {'article': article})

def edit_action(request):
    title = request.POST.get('title', 'TITLE')
    content = request.POST.get('content', 'CONTENT')
    article_id = request.POST.get('article_id', '0')

    if article_id == '0':
        models.Article.objects.create(title=title, content=content)
        articles = models.Article.objects.all()
        return render(request, 'blogDemo/index.html', {'articles': articles})

    article = models.Article.objects.get(pk=article_id)
    article.title = title
    article.content = content
    article.save()
    return render(request, 'blogDemo/article_page.html', {'article': article})

