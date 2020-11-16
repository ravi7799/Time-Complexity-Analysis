# -*- coding: utf-8 -*-
"""
Created on Mon Nov 16 21:18:32 2020

@author: RS
"""


import pandas as pd
import matplotlib.pyplot as mp

df=pd.read_csv("D:\Algorithm time Complexity analysis\\LCS_analysis.txt",sep="\t")

avg=[]
print(df)

for i in range(df.shape[0]):
    avg.append([df.iloc[i,1],df.iloc[i,2]])
        
    
mp.plot([i[0] for i in avg],[i[1] for i in avg],'go--')
mp.xlabel("Number of Input")
mp.ylabel("Time Taken")
mp.title("Longest Common Subsequence")
mp.legend()
mp.grid(True,color='k')