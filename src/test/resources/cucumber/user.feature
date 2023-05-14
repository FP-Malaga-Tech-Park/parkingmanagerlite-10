# language: es
Característica: Gestion de usuarios

Escenario: Mostrar el contenido de la pagina users
    Dado un usuario esta en la pagina users
    Entonces se muestra el titulo de users
    Y se muestra el boton de crear usuario
    Y se muestra la tabla de users

Escenario: Mostrar todos los usuarios
    Dado un usuario esta en la pagina inicial
    Cuando el usuario hace click sobre el botón de Usuarios
    Entonces se muestran todos los usuarios del sistema