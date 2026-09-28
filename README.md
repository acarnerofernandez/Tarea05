
# Niveles usasdos


| Niveles | Usado |
| --- | --- |
| 1 | Si |
| 2 | Si | 
| 3 | No |
| 4 | Si |


# Tabla de comprobaciones


| Valor | Salida de factor | Código de salida |
| --- | --- | --- |
| **360** | 360: 2 2 2 3 3 5 | 0 |
| **1** | 1: | 0 |
| **17** | 17: 17 (Es primo) | 0 |
| **hola** | factor: «hola» no es un entero positivo | 1 |
| **-5** | factor: opción no válida -- '5' | 1 |


# Explicación del codigo

## Método Interfaz

Lo que hace este método es  crear un bucle while,
que pide un numero al usuario o que escriba 'salir',
si escribe el usuario escribe 'salir' el programa termina,
en caso de escribir otra cosa se ejecutara el programa Lanzador.


## Método Lazador

Lo primero que hacemos es declarar 3 variables
Una que sera para indicar el código de error que sera 1,
La segunda variable sera un StringBuilder que lo llamaremos outputBuffer,
ya que se encargara de registrar el mensaje de salida 
y la tercera sera si el numero es primo o no. 

Luego creamos un proceso y lo iniciaremos
el proceso sera el comando 'factor' de la terminal.

Una vez iniciado el BufferedReader reader que recoge el resultado del proceso,  lo lee y lo guarda,
una vez guardado se fija en si el resultado es el mismo numero que paso el usuario, si es así esPrimo es igual a true,
si da error recoge el mensaje de error, lo lee y lo guarda.

Despues de esto ponemos que el codigoSalida espere hasta que el programa termine,
si falla devuelve 1 si todo va bien devuelve 0.

En caso de que el comando no se llegue a ejecutar salta el error del catch.

Al final el programa hace una comprobación usando el código de salida

Si no da error con código 0 muestra el mensaje OK junto al resultado de la terminal y si además detecta que el número es primo mostrará debajo el mensaje de que es primo

Si da error con código distinto de 0 muestra el mensaje ERROR junto al fallo de la terminal que normalmente avisará de que el valor introducido no es un entero positivo

Al terminar independientemente de si dio error o no el programa imprimirá siempre el mensaje Operación completada Código de salida seguido de 0 o 1 según corresponda
