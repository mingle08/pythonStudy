# Generated by Django 2.0.3 on 2018-04-01 16:39

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('blogDemo', '0002_article_pub_time'),
    ]

    operations = [
        migrations.AlterField(
            model_name='article',
            name='pub_time',
            field=models.DateTimeField(null=True),
        ),
    ]
