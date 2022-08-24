class Pila:
  def __init__(self):
    self.datos = []

  def estaVacia(self):
    return self.datos == []

  def push(self, nuevo):
    self.datos.append(nuevo)

  def extrae(self):
    return self.datos.pop() 
    
  def peek(self):
    return self.datos[len(self.datos)-1]

  def size(self):
    return len(self.datos)
