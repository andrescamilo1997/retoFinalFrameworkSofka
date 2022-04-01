# language: es
Característica: Comicarse con nosotros
  Como cliente nuevo
  necesito contactarme
  para poder recibir informacion

  Escenario: contactarme
    Dado que el cliente busca alguna informacion en particular
    Cuando el cliente envia sus datos en linea y un mensaje para solicitar informacion
    Entonces como resultado el usuario recibirà un mensaje diciendole que el mensaje fue enviado con exito


  Escenario: contactarme sin poner un correo
    Dado que el cliente busca un canal de cominucacion
    Cuando el cliente envia los datos necesarios pero no email
    Entonces como resultado el usuario recibirà There is 1 error Invalid email address.

