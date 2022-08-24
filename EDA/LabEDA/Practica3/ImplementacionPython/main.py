import pandas as pd
import openpyxl
import HashTable
import string
import random
import time
import matplotlib.pyplot as plt

number_of_strings = 5
length_of_string = 8




#df = pd.read_excel(open('Coaches.xlsx'))
#print(df)
  
def regresaTiempo(table,t,metodo):
  if metodo=="insert":
    tiempoIn = time.time()
    table.insert(t)
    tiempoFin = time.time()
  elif metodo == "find":
    tiempoIn = time.time()
    table.find(t)
    tiempoFin = time.time()
  else:
    tiempoIn = time.time()
    table.delete(t)
    tiempoFin = time.time()
  return tiempoFin-tiempoIn


def creaDataFrame():    
  dataFrame=pd.read_csv("Athletes.csv",names=["Name","NOC","Discipline"])
  return dataFrame

def randomChoice(datos):
  atleta = random.choice(datos)
  return atleta

d = creaDataFrame()
datos= d["Name"].tolist()

def promedioLista(lista):
  suma=float(0)
  for elem in lista:
    suma+=elem
  return suma/len(lista)
  
# comienza el experimento 
tamanios=[500, 1000, 2000, 10000, 11000, 12000, 18000, 25000, 30000]
operaciones=[HashTable.HashTable.insert, HashTable.HashTable.find, HashTable.HashTable.delete]

busqueda = []
inserta = []
elimina = []
promedio=[]

for tam in tamanios:
  busqueda1 = []
  inserta1 = []
  elimina1 = []
  for rep in range(30):
    table = HashTable.HashTable(tam)
    tiemposBusqueda =[]
    tiemposBorrado=[]
    dt = datos[:int(tam*.3)]# slicind de renglones
    tiemposInserta=[regresaTiempo(table,i,"insert") for i in dt]
    for dt in datos:
      medio = datos[int(tam*.3):9000]  
    for i in medio:
      table.insert(i)
    tiemposFinales=[regresaTiempo(table,j,"insert") for j in datos[9000:]]
    if rep == 1:
      promedio.append(table.promedioColisiones())
    for i in range(3):
      dt=randomChoice(datos)
      aux = regresaTiempo(table,dt,"find")
      tiemposBusqueda.append(aux)
      tiemposBorrado.append(regresaTiempo(table,dt,"delete"))
    promedioIn=(promedioLista(tiemposInserta)+promedioLista(tiemposFinales))/2
    inserta1.append(promedioIn)
    busqueda1.append(promedioLista(tiemposBusqueda))
    elimina1.append(promedioLista(tiemposBorrado))
  inserta.append(inserta1)
  busqueda.append(busqueda1)
  elimina.append(elimina1)
#print(busqueda)
#print(elimina)
print(promedio)

dfBusqueda=pd.DataFrame({"500":busqueda[0],"1000":busqueda[1],"2000":busqueda[2],"10000":busqueda[3],"11000":busqueda[4],"12000":busqueda[5],"18000":busqueda[6],"25000":busqueda[7],"30000":busqueda[8]})
dfInserta=pd.DataFrame({"500":inserta[0],"1000":inserta[1],"2000":inserta[2],"10000":inserta[3],"11000":inserta[4],"12000":inserta[5],"18000":inserta[6],"25000":inserta[7],"30000":inserta[8]})
#creaDF(dfInserta,inserta,45,tamanios)
dfElimina=pd.DataFrame({"500":elimina[0],"1000":elimina[1],"2000":elimina[2],"10000":elimina[3],"11000":elimina[4],"12000":elimina[5],"18000":elimina[6],"25000":elimina[7],"30000":elimina[8]})
dfPromedio=pd.DataFrame(promedio, index = tamanios)

with pd.option_context('display.max_columns',None):
  print(dfInserta)
  print(dfElimina)
  print(dfBusqueda)
  print(dfPromedio)
def promListaDeListas(lista_de_listas):
  length=len(lista_de_listas)
  lista_res=[]
  for i in range(0,length):
    lista_res.append(promedioLista(lista_de_listas[i]))
  return lista_res


plt.scatter(tamanios,promListaDeListas(inserta))
plt.plot(tamanios,promListaDeListas(inserta))
#plt.scatter(tamanios,promListaDeListas(busqueda))
#plt.plot(tamanios,promListaDeListas(busqueda))
#plt.scatter(tamanios,promListaDeListas(elimina))
#plt.plot(tamanios,promListaDeListas(elimina))
#plt.scatter(tamanios,promedio)
#plt.plot(tamanios,promedio)
plt.show()







