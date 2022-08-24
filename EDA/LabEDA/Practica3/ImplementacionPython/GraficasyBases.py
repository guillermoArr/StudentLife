import numpy as np
import pandas as pd
import matplotlib.pyplot as plt

def creaDataFrame():    
    dataFrame=pd.read_csv("Athletes.csv",names=["Name","NOC","Discipline"])
    return dataFrame

    
def creaTabla(tipo, x, y, Tx, Ty, Titulo, clr):
    if tipo =="barras":
        plt.bar(x,y,color=clr)
    elif tipo == "default":
        plt.plot(x,y, color=clr)
    elif tipo == "disp":
        plt.plot(x, y, 'o', color=clr)
    
    plt.xlabel(Tx)
    plt.ylabel(Ty)
    plt.title(Titulo)
    return plt

def creaHistograma(X,intervalos,clr,Tx,Ty):
    plt.hist(x=X, bins=intervalos, color=clr, rwidth=0.85)
    plt.xlabel(Tx)
    plt.ylabel(Ty)
    plt.xticks(intervalos)
    return plt

datos = creaDataFrame()
print(datos)