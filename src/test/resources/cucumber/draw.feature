# language: es
Característica: Gestion de sorteos

Escenario: Mostrar el contenido de la pagina sorteos
    Dado un usuario esta en la pagina sorteos
    Entonces se muestra el titulo
    Y se muestra el boton de crear sorteo
    Y se muestra la tabla

Escenario: Mostrar todos los sorteos
    Dado un usuario esta en la pagina inicial
    Cuando el usuario hace click sobre el botón de Sorteos
    Entonces se muestran todos los sorteos del sistema
    