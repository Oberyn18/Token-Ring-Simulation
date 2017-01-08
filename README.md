# Token-Ring-Simulation
Simulación del algoritmo de Anillo de Token usado en S.S.O.O. distribuidos

Para la simulación del algoritmo, nos pondremos en el escenario en que tenemos varios jugadores alrededor de un balón, cada jugador puede dominar el balón una vez, pero está a criterio de ellos tomar el balón y hacer las dominada (patadita) o no.


- Los procesos, en este algoritmo, serán los jugadores de fútbol.
- El recurso compartido será el balón.
- El token será un "testimonio" un objeto similar al de las postas que se deben pasar entre los jugadores, quien tome el token puede dominar, si un jugador rechaza el token, pasa al siguiente.

Se contabilizarán las pataditas que se le dio al balón hasta el final del programa. El programa debe constar de un bucle que nunca acabará hasta que el usuario mismo lo termine de manera forzosa.

Cada jugador debe conocer quién está después de el, como en una lista. Esto para saber de quién recibir el token y a quien dárselo.
