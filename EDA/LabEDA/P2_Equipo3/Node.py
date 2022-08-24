class Node:
  def __init__(self, dato):
    self.izq = None
    self.der = None
    self.dato = dato
    self.papa = None
  """"
  def getAtributo(self, atributo):
    return self.atributo
  
  def setAtributo(self, atributo, nuevoValor):
    self.atributo = nuevoValor
  """
  def getDer(self):
    return self.der
    
  def getIzq(self):
    return self.izq

  def getPapa(self):
    return self.papa
    
  def setIzq(self,nodo):
    self.izq = nodo 

  def setDer(self, nodo):
    self.der = nodo

  def setPapa(self, nodo):
    self.papa = nodo

  def getDato(self):
    return self.dato

  def setDato(self, dato):
    self.dato=dato 

def postOrden(root):
  res = []
  return postOrdenRec(res, root)

def postOrdenRec(res, root):
  if root != None:
      postOrdenRec(res, root.getIzq())
      postOrdenRec(res, root.getDer())
      res += [root.getDato()]
  return res

