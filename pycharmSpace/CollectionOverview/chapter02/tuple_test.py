# -*- coding: utf-8 -*-
__author__ = 'mingle08'

name_tuple = ('Joey', 'Monica')
for name in name_tuple:
    print(name)

# 拆包
user_tuple = ('Rachel', 28, 165)
name, age, height = user_tuple
print(name, age, height)

name, *other = user_tuple
print(name, other)

user_info_dict = {}
user_info_dict[user_tuple] = 'Joey'
user_info_dict[['Rachel', 28, 165]] = 'Joey'
pass