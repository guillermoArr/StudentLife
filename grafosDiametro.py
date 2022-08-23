# -*- coding: utf-8 -*-
"""
Created on Wed Dec 15 08:00:01 2021

@author: memit
"""

class Grafo:
    def __init__(self):
        self.G={}
        self.visitado={}
  
    def inserta_dirigido(self,v1,v2=None,peso=None):
        if v1 not in self.G.keys():
            self.G[v1]={}
        if v2 is not None:
            self.G[v1][v2]=peso
        else:
            if v2 is not None and v2 not in self.G[v1]:
                self.G[v1][v2]=peso

    def inserta(self,v1,v2,peso=None):
        self.inserta_dirigido(v1,v2,peso)
        self.inserta_dirigido(v2,v1,peso)
    
    def diametro(self):
        distancias=[]
        for v in self.G:
            d = self.distancia(v)
            if d != -1:
                distancias.append(d)
            else:
                break
        if d == -1:
            return "infinito"
        return max(distancias)
    
    def distancia(self, actual):
        for v in self.G:
            self.visitado[v]=False
        cola=[]
        cola.append((actual,0))
        self.visitado[actual]  = True
        cont = 0
        print(self.visitado)
        while cola:
            tupla = cola.pop(0)
            nodo = tupla[0]
            cont = tupla[1]+1
            for vecino in self.G[nodo]:
                if not self.visitado[vecino]:
                    cola.append((vecino,cont))
                    self.visitado[vecino] = True
        if False in self.visitado.values():
            return -1
        return cont-1

miGrafo=Grafo()
miGrafo.inserta('v1','v2')
miGrafo.inserta('v2','v3')
miGrafo.inserta('v3','v4')
miGrafo.inserta('solito','v1')
miGrafo.inserta('solito','v4')

print(miGrafo.G)
print(miGrafo.diametro())
            
        
        