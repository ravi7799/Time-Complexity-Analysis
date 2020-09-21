# -*- coding: utf-8 -*-
"""
Created on Mon Sep 21 22:26:10 2020

@author: RS
"""


import pandas as pd
import matplotlib.pyplot as mp

df=pd.read_csv("D:\Algorithm time Complexity analysis\\Radix_sort_analysis.txt",sep="\t")

best=[]
worst=[]
avg=[]

for i in range(df.shape[0]):
    if i%3==0:
        best.append([df.iloc[i,1],df.iloc[i,2]])
    if i%3==1:
        worst.append([df.iloc[i,1],df.iloc[i,2]])
    if i%3==2:
        avg.append([df.iloc[i,1],df.iloc[i,2]])
        
    
mp.plot([i[0] for i in best],[i[1] for i in best],'bs--',label="bestcase(sorted)")
mp.plot([i[0] for i in worst],[i[1] for i in worst],'m^--',label="worst case(reverse)")
mp.plot([i[0] for i in avg],[i[1] for i in avg],'go--',label="averagecase(random)")
mp.xlabel("Number of Input")
mp.ylabel("Time Taken")
mp.title("Radix Sort")
mp.legend()
mp.grid(True,color='k')
