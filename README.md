# tarjetasAPI
Micro servicio que se encarga de obtener una conclusion en base a las condiciones enviadas.

El estado actual de este servicio es un escenario de seleccion de tarjetas de credito en base a las elecciones o preferencias del usuario. 

En base a esta dinamica sencilla, se optó por elegir una estructura de "motor" de reglas, en donde los hechos son las elecciones que hace el usuario y las reglas para elegir que usuarios son candidatos a diferentes tarjetas de crédito son definidas por la siguiente tabla.

![image](https://user-images.githubusercontent.com/46451243/153535546-fb21a04f-33b4-4f31-bb14-48b582e207ce.png)

En este caso son 3 condiciones para tomar la decisión de ofrecer las tarjetas de credito, estas condiciones son: Preferencia (Your passion), Salario(Montly salary) y Edad(Age). Los posibles resultados son la última columna de la tabla.

<ol>
  <h1><li>Sin expansión</li></h1>
</ol>
En este caso, el API solamente tendría reglas para las tarjetas de crédito y no se implementarian nunca otras para otro tipo de servicio/produto de la éndole (pj. Seguros), por lo que no tendría sentido implementar el sistema de reglas sino dejarlo mas sencillo usando una clase de Tarjetas, como se muestra a continuacion.

![image](https://user-images.githubusercontent.com/46451243/154756975-b8479820-9b6b-46ed-82cf-25ffb785461f.png)

De esta manera, se almacenarian las tarjetas en una tabla de la base de datos que puede ser tambien alguna otra API que tenga esa informacion (pj. El banco), y el controlador solamente haría una consulta al Repository de tarjetas, o al API, que cumplan con los valores proporcionados.

<ol>
  <h1><li>Sistema de reglas</li></h1>
</ol>
Si bien, en el estado acutal solamente se cuenta con tarjetas de credito, puede darse un escenario de que ahora se eligan otro tipo de tarjetas, hipotecas, etc., por lo que usando los  principios SOLID se puede abstraer para poder extenderse de manera organizada.

Si bien, es un escenario demasiado sencillo que se podría solventar de manera rápida con Enumeradores para definir todas estas reglas y consultarlas directamente, esto no tendria tanta escalabilidad que si se usará una base de datos en donde se almacenarian todas las reglas, ya que cuando son cientos de ellas se complicaria la operacion.

Entonces, se opta por usar una base de datos en donde las tablas (Entities) no pueden ser, por ejemplo,  Persona o Usuario porque las 3 condiciones no son suficientes para denominar alguna entidad del mundo real.

Con estas razones se creó un esquema incial de relaciones usando este sistema de reglas quedaria como se muestra en la siguiente imagen.

![image](https://user-images.githubusercontent.com/46451243/154754651-b06b0959-607f-45fc-845c-75fa4c9f0f4d.png)

Donde de esta maneja se gestionaria en la base de datos todas las reglas y hechos que hagan cumplirlas, siendo que en algun caso de expandir alguna regla con mas hechos, no se tendria que modificar el codigo, siendo tambien posible llevar este esquema a reglas totalmente diferentes, implementando otra clase de tipo Reglas. Y serian los controladores los encargados de llevar las peticiones del usuario hacia los Repositorys pertinentes y solicitar asi la información, pero en dado caso de que el API solo tenga que exponer las consultas y no todo el CRUD para las reglas, se tendria que crear otro microservicio aparte, que solicite a este unicamente la validacion de la regla de tarjeta. Como se muestra en esta imagen.

![image](https://user-images.githubusercontent.com/46451243/154757411-50d1939c-6ced-4ad4-ba97-ed0e291b93dc.png)

Pero tambien se puede implementar de otra forma, en caso de que la suposicion incial, de expanderse no fuera cierta.
