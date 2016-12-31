# Token-Ring-Simulation
Simulación del algoritmo de Anillo de Token usado en S.S.O.O. distribuidos

Para la simulación del algoritmo, nos pondremos en el escenario en que tenemos varios jugadores alrededor de un balón, cada jugador puede dominar el balón una vez, pero está a criterio de ellos tomar el balón y hacer las dominada (patadita) o no.


- Los procesos, en este algoritmo, serán los jugadores de fútbol.
- El recurso compartido será el balón.
- El token será un "testimonio" un objeto similar al de las postas que se deben pasar entre los jugadores, quien tome el token puede dominar, si un jugador rechaza el token, pasa al siguiente.

Se contabilizarán las pataditas que se le dio al balón hasta el final del programa. El programa debe constar de un bucle que nunca acabará hasta que el usuario mismo lo termine de manera forzosa.

Cada jugador debe conocer quién está después de el, como en una lista. Esto para saber de quién recibir el token y a quien dárselo.

## Balón
### Atributos: 
- pataditas -> indica el número de pataditas que se la ha dado al balón
  **Usaremos el ReentrantLock para darle a la Clase Balón la característica de Recurso compartido**

### Métodos:
- aumentarPataditas -> aumenta en 1 el total de pataditas dadas al balón
- tomarBalon -> bloquea el recurso compartido el hilo que llame a este método
- dejarBalon -> desbloquea el recurso compartido el hilo que llame a este método


## Jugador
### Atributos:
- nombre -> identificador del jugador
- turno -> indica el turno del jugador en el anillo de token
- testimonio -> es una abstracción del token, el testimonio le autoriza usar el balón
- siguiente -> es una referencia al jugador que le continúa en el anillo de token
- anterior -> es una referencia al jugador que le antecede en el anillo de token
- balon -> es una referncia al balón, el recurso compartido

### Métodos:
- darPataditas -> llama al método aumentarPataditas del balón asignado al jugador
- recibirTestimonio -> primero verifica si se desea recibir el testimonio, de ser así, el testimonio toma valor verdadero. De lo contrario llamamos al método pasarTestimonio.
- pasarTestimonio -> asigna al testimonio un valor negativo y llama al método recibirTestimonio del jugador siguiente.
- run -> esta sobreescritura del método run permite hacer la clase ejecutable. En un bucle infinito, siempre que el objeto Jugador pase las condiciones de que su testimonio esté en verdadero y pueda bloquear el recurso compartido, debe dar pataditas al balón, liberar el recurso compartido y pasar el testimonio al siguiente. Luego de todo esto, se le consulta si desea seguir jugando. Si la respuesta es negativa, se sale del bucle infinito y el jugador sale de la ronda, asignandole al jugador que le pasó el testimonio, el siguiente del actual como su siguiente.
