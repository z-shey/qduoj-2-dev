# Generated by Django 3.2.25 on 2024-10-17 15:08

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('account', '0012_userprofile_language'),
    ]

    operations = [
        migrations.AlterField(
            model_name='user',
            name='session_keys',
            field=models.JSONField(default=list),
        ),
        migrations.AlterField(
            model_name='userprofile',
            name='acm_problems_status',
            field=models.JSONField(default=dict),
        ),
        migrations.AlterField(
            model_name='userprofile',
            name='oi_problems_status',
            field=models.JSONField(default=dict),
        ),
    ]
