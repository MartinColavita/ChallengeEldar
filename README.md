# Requerimiento:
Se ha solicitado el diseño de un sistema para procesar operaciones con tarjetas de crédito para una organizacion. Dicho sistema debe
disponer de un modulo que lo permita con las siguientes consideraciones, desarrollar un aplicativo:
	-Una tarjeta se identifica de acuerdo a la marca, numero de tarieta, cardholder (nombre y apellido) y fecha de vencimiento.
	-Una operacion es valida en el sistema si la persona que opera en el mismo consume menos de 1000 pesos.
	-Una tarjeta es valida para operar si su fecha de vencimiento es mayor al presente dia.
	-Hoy en dia, existen tres marcas de tarjeta de crédito, a saber: "VISA", "NARA", "AMEX" y es posible que en los siguientes meses existan

nuevas marcas. Cada marca tiene un modo de calcular una tasa por el servicio que es desde 0.3% hasta 5%, a saber:
	-Tasa VISA = año / mes (Ejemplo: 20/12)
	-Tasa NARA = dia del mes * '0.5 (Ejemplo: 27 * 0.5)
	-Tasa AMEX = mes * 0.l (Ejemplo: 9 * 0.1)


## Ejercicio 1:
Crear una clase ejecutable con 3 obietos que haga lo siguiente:
	- Invocar un método que devuelva toda la informacion de una tarieta.
	- Informar si una operacion es valida.
	- Informar si una tarjeta es valida para operar.
	- Identificar si una tarjeta es distinta a Otra.
	- Obtener por medio de un método la tasa de una operocion informando marca e importe IMPORTANTE: Realizar el correspondiente
manejo de excepciones en casos de error.


## Ejercicio 2:
Implementar una API REST, que responda y reciba en formato JSON, que permita consultar la tasa de una operacion, informando marca de la
tarjeta e importe.

Hostear solucion en algin cloud computing libre e indicar URL.
IMPORTANTE: Compartir cödigo en GIT con la soluciön de ambos eiercicios.
