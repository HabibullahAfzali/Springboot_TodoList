# ToDoList

ToDoList ha sido creado para mejorar la vida de los desarrolladores, facilitando la organización de sus Tasks. Su interfaz sencilla y facil de entender es crucial para dar una primera imagen de lo que queremos que sea una herramienta comoda y segura.




## Equipo

- [@Kevin Panjón](https://github.com/KevinPanjon)

- [@Habibullah Afzali](https://github.com/HabibullahAfzali)

- [@David Quero](https://github.com/keroplas)

- [@Carlos](https://github.com/dosdedoce)



## Features

- Crear/Editar/Eliminar Tareas
- Actualizar Tareas
- Seguimiento de usuarios
- Marcar tareas completadas


## Clone and Installation

Clonar el Repositorio: Clona este repositorio en tu máquina local usando el siguiente comando:

git clone https://github.com/HabibullahAfzali/Springboot_TodoList.git

Install the project with npm

```bash

    Para el FrontEnd:

  cd "Carpetadelproyecto"
  npm install (Para las dependencias)
  npm run dev

    Para el BackEnd:
  
Base de Datos: Configura una base de datos MySQL en tu servidor local. Crea una base de datos llamada todolist_db.

Configuración de la Base de Datos: Abre el archivo src/main/resources/application.properties y configura las propiedades de la base de datos de acuerdo a tu entorno:
---------------------------------------------------
spring.datasource.url=jdbc:mysql://localhost:3306/todolist_db
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

-------------------------------------
Compilar y Ejecutar: Desde la línea de comandos, ve a la carpeta raíz del proyecto y ejecuta el siguiente comando para compilar y ejecutar la aplicación:

mvn spring-boot: run
Acceder a la Aplicación: Abre tu navegador web y accede a http://localhost:8080 para utilizar la aplicación ToDoList.
```
    
## Screenshots

![App Screenshot]([https://via.placeholder.com/468x300?text=App+Screenshot+Here](https://github.com/HabibullahAfzali/Springboot_TodoList/blob/development/frontend/src/assets/ScreenShots/SingUp.png)https://github.com/HabibullahAfzali/Springboot_TodoList/blob/development/frontend/src/assets/ScreenShots/SingUp.png)


## Tech Stack

**Client:** Vue, VueRouter, Bootstrap

**Server:** Java, SpringBoot
