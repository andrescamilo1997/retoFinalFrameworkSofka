# language: es
Característica: compra de vestido
  Como cliente en línea
  necesito comprar un articulo
  para poder usarlo

  Escenario: Selecciona articulo
    Dado el cliente despues despues de haberse registrado
    Cuando el cliente compra selecciona un vestido de la seccion Women escoje un vestido, cantidad, colo y agrega al carrito.
    Entonces redirije a la seccion de SHOPPING-CART SUMMARY


  Escenario: Comprar articulo
    Dado el cliente hizo la seleccion de su vestido
    Cuando se ubica en comprar el articulo, verifica su descripcion de compra, verfica su direccion, acepta terminos y condiciones
    Y       Escoge una forma de pago, confirma su orden
    Entonces se redirige a una seccion donde lee un mensaje, sobre su orden esta completa.

