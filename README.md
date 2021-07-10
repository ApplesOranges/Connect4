# Connect4
A java connect 4 game with an alpha-beta prunning AI oponent

## Arancibia Escobar, David Rafael


```
Reglas del juego

El conecta 4 se juega en una rejilla vertical de 6 filas y 7
columnas. Las filas están numeradas de abajo a arriba del 1 al
6, y las columnas de izquierda a derecha de 1 al 7. El objetivo
es alinear 4 fichas de su color, horizontalmente, verticalmente
o en diagonal.

Cada jugador a su turno juega una ficha de su color en la
columna de su elección.

Físicamente, la rejilla está dispuesta de forma vertical, de forma
que las fichas son insertadas en una ranura desde arriba y caen
hasta la fila más baja no ocupada aún. Así, se elige la columna
donde se pone, pero no la fila; la ficha que se acaba de insertar
cae hasta la fila más baja aún disponible. Desde luego, no puede
jugarse en una columna llena conteniendo ya 6 fichas.

El primer jugador que consigue alinear 4 fichas de su color,
horizontalmente, verticalmente o en diagonal gana la partida.
Su fin es por lo tanto construir este alineamiento impidiendo
hacerlo a sus adversarios.

Si la rejilla se llena completamente sin que ningún jugador
logre alinear 4 fichas de su color, la partida es declarada nula.

Funciones de evaluación

Para encontrar el valor de un tablero se utilizaron dos funciones
heurísticas. h1 se describe como la cantidad de líneas,
columnas o diagonales en las cuales un jugador ha juntado 3
fichas en cada conjunto de 4 casillas, en el caso de que el
jugador haya juntado 4 fichas consiguientes la evaluación de
esa posición es infinita.

Cabe señalar que dichas fichas no necesariamente son
contínuas por ejemplo:

{xoxx} donde “x” representa una ficha y “o” representa un
espacio vacío, es una combinación tomada en cuenta por h1.

```
Figura 1 : Esta posición evalúa h1= 1 , para el jugador blanco ya que
tiene 3 fichas en un conjunto de 4 casillas contínuas.
```
```
h2, por su parte evalúa los conjuntos de 4 casillas contínuas
donde aún es posible lograr un connect- 4 en direcciones
horizontal, vertical o diagonal.
```
```
Figura 2 : La evaluación de h2 para blancas es más alta que para
negras, ya que al existir una pieza blanca en el tablero, las
posibilidades de negras se reducen.
```
```
Para el presente ejercicio ambas funciones se toman en cuenta
en la función de evaluación “f”, y el valor obtenido de las piezas
jugadas se resta al valor de las piezas rivales.
```

Estas funciones de evaluación no recibieron una normalización
ya que cuentan con el mismo espacio de búsqueda, sin embargo
el comportamiento del algoritmo se ve altamente influenciado
por los pesos que se asignen a las funciones de evaluación h. Si
se asigna un mayor peso a las evaluaciones negativas el
algoritmo tendrá un comportamiento defensivo, priorizando
bloquear los movimientos del oponente. Por el contrario si se
asigna mayor peso a las evaluaciones positivas el algoritmo
tendrá un comportamiento agresivo, Priorizando obtener una
combinación ganadora, pero a su vez permitiendo al usuario
tener algunas posibilidades de ganar.

Para propósitos de este ejercicio optamos por una conducta
agresiva.

Generación de Árbol

La generación del árbol se realizó de forma recursiva tomando
en cuenta los casos donde el nodo muestra un tablero con una
posición ganadora tanto para el jugador como para el algoritmo.

El horizonte limitado se controla a través del ciclo que genera
los hijos de los nodos hoja asegurando que la profundidad del
árbol es igual al número de iteraciones que realiza este ciclo
controlado por la variable contador “cont”, haciendo posible
modificar el horizonte de forma sencilla.

```
Figura 3 : Implementación de generación del árbol.
```
Poda alpha-beta

El pseudocódigo utilizado para la implementación del
algoritmo poda alpha-beta es el siguiente, existen diferentes
implementaciones, que funcionan de forma equivalente.

Al implementar este algoritmo, y poder hacer uso de él Se
hizo uso de una función que nos permite obtener el nodo con
mejor evaluación de la primera capa de hijos.

```
La estructura de datos utilizada es “ArrayList” la
implementada en java, es decir un arreglo de tamaño
modificable, lo que le da la flexibilidad de una lista ligada.
```
```
Figura 4 : Pseudocódigo utilizado para la poda alpha-beta
```
## Pruebas de ejecución

```
Figura 5 : Gana el jugador humano
```
```
En la figura 5 se observa un tablero en el que gana el jugador
humano, juntando 4 piezas negras en una diagonal.
```
```
Aunque son pocos los casos en los que la inteligencia no logra
bloquear el movimiento humano, esta combinación de jugadas
```
## es una de ellos, La evaluación de este tablero es -infinito.


```
Figura 6 : Tablero en el cual el algoritmo ha ganado.
```
En la figura 6 se observa un caso en el cual gana la inteligencia
debido a un error por parte del jugador humano. En la mayoría
de los casos la inteligencia logra el objetivo, que es ganar, la

## evaluación de este tablero es infinito.

```
Figura 7 : Ejemplo de un empate.
```
En la figura 7 se muestra uno de los pocos casos en los cuales
la combinación de jugadas nos lleva a un empate, el empate
solamente ocurre cuando no existe más casillas en las cuales
es posible tirar.

```
Figura 8 : El algoritmo asegura la victoria.
```
```
En la figura 8 se ve un estado en el cual el algoritmo ha
dejado sin opciones al jugador humano, ya que
independientemente de la pieza que se juegue, el algoritmo
ganará en el siguiente turno.
```
```
Figura 9 : El algoritmo bloquea después de haber sido bloqueado
```
```
En todos estos ejemplos se observa un comportamiento común,
de ser posible el algoritmo jugara en el centro, esto es debido a
la heurística h2, que se basa en posibilidades, al jugar en el
centro el algoritmo minimiza las posibilidades que tendrá su
oponente, dominar la columna central es una de las estrategias
más importantes en connect- 4.
```
```
Conclusión
```
```
Al realizar este algoritmo se vuelve evidente que podemos tener
un buen contrincante de juego, sin embargo no totalmente
infalible abriendo la posibilidad de ganar como usuario no
obstante, con un alto grado de dificultad.
```



