# rulesAPI
Micro servicio que se encarga de obtener una conclusion en base a las condiciones enviadas.

El estado actual de este servicio esta construido en un escenario de seleccion de tarjetas de credito en base a las elecciones del usuario. En base a esta dinamica sencilla, se optó por elegir una estructura de motor de reglas, en donde los hechos son las elecciones que hace el usuario y las reglas son definidas por la siguiente tabla.

![image](https://user-images.githubusercontent.com/46451243/153535546-fb21a04f-33b4-4f31-bb14-48b582e207ce.png)

En este caso son 3 condiciones para tomar la decisión de ofrecer las tarjetas de credito, estas condiciones son: Preferencia (Your passion), Salario(Montly salary) y Edad(Age). Los posibles resultados son la última columna de la tabla.

<h2>¿Porque un motor de reglas?</h2>
Para consruir este micro servicio se busca aplicar principios SOLID, y dado que es un escenario demasiado sencillo se podría ocupar Enumeradores para definir todas estas reglas, pero para buscar una escalabilidad se usará una base de datos en donde se almacenarian todos los datos.

Siendo una base de datos entonces hay que definir las tablas (Entities), las cuales no pueden ser Persona o Usuario, pues las 3 condiciones no son suficientes para almacenarse dentro de una entidad de ese estilo, por lo que el esquema de relaciones usando un motor de reglas quedaria como se muestra en la siguiente imagen.

![image](https://user-images.githubusercontent.com/46451243/153544629-5f6c9cd1-bca8-4f4d-946b-3e3e79db3e5e.png)


De esta maneja se gestionaria en la base de datos todas las reglas y hechos que hagan cumplirlas, siendo que en algun caso de expandir alguna regla con mas hechos, no se tendria que modificar el codigo, siendo tambien posible llevar este esquema a reglas totalmente diferentes reutilizando el codigo. Y el evaluador seria necesario para que haya una clase que se encargue de llevar las entradas del usuario hacia los Repositorys pertinentes y solicitar asi la informacion.
