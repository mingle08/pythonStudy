from django.shortcuts import render

def index(request):
    # return HttpResponse('Hello, world!')
    return render(request, 'blog2/index.html', {'hello' : 'second Demo !'})
