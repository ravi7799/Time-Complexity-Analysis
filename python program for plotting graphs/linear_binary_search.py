# -*- coding: utf-8 -*-
"""
Created on Thu Aug 27 17:40:14 2020

@author: RS
"""

import matplotlib.pyplot as mp
import pandas as pd

df=pd.read_csv("D:\\java file handling\\linear_search_analysis.txt",sep="\t\t\t")
print(df)

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
        
mp.plot([i[0] for i in best],[i[1] for i in best],'bs--',label="Element at First Position")
mp.plot([i[0] for i in worst],[i[1] for i in worst],'m^--',label="Element at Last Position")
mp.plot([i[0] for i in avg],[i[1] for i in avg],'go--',label="Element at any Random position")
mp.xlabel("Number of Input")
mp.ylabel("Number of comparisions")
mp.title("Linear Search")
mp.legend()
mp.grid(True,color='k')