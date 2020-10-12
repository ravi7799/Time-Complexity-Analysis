# -*- coding: utf-8 -*-
"""
Created on Mon Sep 21 22:26:10 2020

@author: RS
"""


import pandas as pd
import matplotlib.pyplot as mp

df=pd.read_csv("D:\Algorithm time Complexity analysis\\min_max_comp_analysis.txt",sep="\t\t\t")

best=[]
worst=[]
avg=[]
print(df)

for i in range(df.shape[0]):
    avg.append([df.iloc[i,0],df.iloc[i,1]])
        
    
mp.plot([i[0] for i in avg],[i[1] for i in avg],'go--')
mp.xlabel("Number of Input")
mp.ylabel("Number of Comparsions")
mp.title("MIN-MAX Element")
mp.legend()
mp.grid(True,color='k')
