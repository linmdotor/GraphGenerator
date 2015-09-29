# GraphGenerator
Generador de grafos según los modelos de red aleatoria y red libre de escala.

Introducción
------------
La interfaz de la aplicación está claramente diferenciada en dos partes: una para generar un grafo según el modelo de red aleatoria (según Erdos-Renyi) y otra para generar un grafo libre de escala (según el modelo de Barabasi-Albert).


Red Aleatoria (Erdos-Renyi)
---------------------------
Una red aleatoria es una red en la que cada uno de los enlaces entre dos nodos se ha creado siguiendo un proceso completamente aleatorio. Hay varias formas de implementar este modelo, y la más conocida es la de Erdos-Renyi. Según este modelo, se seleccionan cada par de nodos, y se enlazan (o no) con una probabilidad p, que es la misma para toda la red.

Para generar un grafo según este modelo son necesarios 2 parámetros: 
- Nº de nodos total del grafo. Debe ser un valor mayor que 0.
- La probabilidad de que se genere un enlace entre dos nodos cualesquiera. Debe ser un valor entre 0.0 y 1.0.


Red libre de escala (Barabasi-Albert)
-------------------------------------
Una red libre de escala es una red cuya distribución de grados sigue una ley potencial. Su principal diferencia frente a la aleatoria es que este modelo contempla la existencia de hubs (nodos con grado muy superior al grado medio).

Según Barabasi-Albert, las redes libres de escala tienen dos propiedades muy características: crecen a lo largo del tiempo, y los nodos nuevos "prefieren" conectarse a los nodos más conectados.

Para generar un grafo según este modelo son necesarios 3 parámetros:
- Número de nodos iniciales (m0). Debe ser un valor mayor que 0. Estos nodos formarán un grafo 
- Número de enlaces de cada nuevo nodo introducido (m). Debe ser un valor entre 0 y m0.
- Número de nuevos nodos a añadir a la red inicial, o número de iteraciones. Debe ser un valor mayor que 0.


Uso
---
En cualquiera de los dos modelos, y tras introducir los parámetros correspondientes, al pulsar el botón "Generar Fichero" se generará un fichero .gdf con el grafo correspondiente. Este fichero es importable de forma automática a Gephi, arrastrando y soltando en la ventana de "Vista General".