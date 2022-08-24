#import random
import Node
nodo = Node.Node(8)
nodo2= Node.Node(9)
nodo3=Node.Node(10)
nodo4=Node.Node(11)
nodo5=Node.Node(12)
nodo.setIzq(nodo2)
nodo.setDer(nodo3)
nodo2.setIzq(nodo4)
nodo2.setDer(nodo5)

print(Node.postOrden(nodo))
"""
def diseñaExpresiones():
  n = random.randint(5,20)
  expresion = ""
  elige = ["Num", "Operador"]
  for i in range(n):
    if random.choice(elige) == "Num":
      expresion += str(random.randint(0,4516)+random.uniform(0,1))
    else:
      expresion += random.choice(["+","-","*","/",".", "(", ")"])
  return expresion
"""

import Algoritmos
"""
prueba=Algoritmos.getTokens("3(5)")
print(prueba)

#Algoritmos.limpiaTokens(prueba)
print(prueba)

arbol=Algoritmos.creaArbol(prueba)
#arr=Node.postOrden(arbol)
#print(arr)
resultado=Algoritmos.evaluaRec(arbol)
print (resultado)
"""
resultado=Algoritmos.evalua("----5(4-3.5)-8") # checar caso 5(3)
print(resultado)
"""
for i in range(10):
  expresion = diseñaExpresiones()
  print(expresion)
  resultado = Algoritmos.evalua(expresion)
  print(resultado)
"""

resultado = Algoritmos.evalua("(6+2)(5-3)")
print("resultado esperado: 16 ,", resultado)

resultado = Algoritmos.evalua("(5+3/2)(7+2)")
print("resultado esperado: 58.5 ,",resultado)

resultado = Algoritmos.evalua("5+3-10")
print("resultado esperado: -2 ,",resultado)

resultado = Algoritmos.evalua("8/2*(2+2)")
print("resultado esperado: 16 ,",resultado)

resultado = Algoritmos.evalua("6/2*(1+2)")
print("resultado esperado: 9 ,",resultado)

resultado = Algoritmos.evalua("9-3/1/3+1")
print("resultado esperado: 9 ,",resultado)

resultado = Algoritmos.evalua("9*-5+++++89/-75+(38)-2*5")
print("este ya está bien; res esperado: -18.1866 ,",resultado)

resultado = Algoritmos.evalua("(89)-5")
print("este ya está bien; res esperado: 84 ,",resultado)

#checar ()+5   ()-2  no funcionan, los multiplica: solucionado 
resultado = Algoritmos.evalua("(3.14+((4+8)/3))(15.1-3(3/2+1))")
print("res esperado: 54.264 ,",resultado)
#print(Algoritmos.getTokens("5*6-(-4/3-1)(45-56/34)+1"))

resultado =Algoritmos.evalua("5*6-((-4/3-1)45-56/34)+1")
print("res esperado: 137.647059 ,",resultado)

resultado = Algoritmos.evalua("1")
print("res esperado: 1 ,",resultado)

resultado = Algoritmos.evalua("()")
print("res esperado: SE ,",resultado)

resultado = Algoritmos.evalua("(2)")
print("res esperado: 2 ,",resultado)

resultado = Algoritmos.evalua("(")
print("res esperado: SE ,",resultado)

resultado = Algoritmos.evalua("((5+8-9)(84)(-35+54/9)")
print("res esperado: SE ,",resultado)

resultado = Algoritmos.evalua("38-9/15*+85+*17")
print("res esperado: SE ,",resultado)

resultado = Algoritmos.evalua("38-9/15*+85*17")
print("res esperado: -829 ",resultado)

resultado = Algoritmos.evalua("5*8/0")
print("res esperado div/0: Math ERROR ,",resultado)

resultado = Algoritmos.evalua("84-8*54**5")
print("res esperado: SE ,",resultado)

resultado = Algoritmos.evalua("0/5")
print("res esperado: 0 ,", resultado)

resultado = Algoritmos.evalua("38-9/(15-15)*+85*17")
print("res esperado: MATH ERROR ,",resultado)

resultado = Algoritmos.evalua("38-9/15*+85+*17)")
print("res esperado: SE ,",resultado)

resultado = Algoritmos.evalua("105-84*.2+(87/11)/5+(-8*9/(5-(-3)))")
print("res esperado: 80.781818 ,",resultado)

resultado = Algoritmos.evalua("35-(88+55(17-(15*32-(88/79))/9+17*19/66))")
print("res esperado: 1669.35935302 ,",resultado)

resultado = Algoritmos.evalua("35-(88+55(17-(15.9*32-(88.5/79)))/9+17*19.892/66)")
print("res esperado: 2940.474756 ,",resultado)

resultado = Algoritmos.evalua("0/0")
print("res esperado: Math ERROR ,",resultado)

resultado = Algoritmos.evalua("(-15+15)/(15-15)")
print("res esperado: Math ERROR ,",resultado)

resultado = Algoritmos.evalua("0//0")
print("res esperado: Syntax Error ,",resultado)

resultado = Algoritmos.evalua("+000005/---------1")
print("res esperado: -5 ,",resultado)

resultado = Algoritmos.evalua("5+b")
print("res esperado: SE ,",resultado)

resultado = Algoritmos.evalua("")
print("res esperado: SE ,",resultado)

resultado = Algoritmos.evalua("5+")
print("res esperado: SE ,",resultado)

resultado = Algoritmos.evalua("/")
print("res esperado: SE ,",resultado)