# SaludPerfecta
## Abdías Martínez
## Roberto Rodriguez

Aplicación móvil desarrollada en **Kotlin con Jetpack Compose**, cuyo objetivo es gestionar el registro de usuarios y la programación de citas de manera sencilla y validada.


## Funcionalidades principales

### 1. Registro de usuario
- Validación de **nombre y apellido**: deben contener al menos dos palabras, con un mínimo de un carácter cada una.  
- Validación de **teléfono**: debe tener exactamente **10 dígitos numéricos**.

### 2. Selección de fecha y hora
- **Fecha**: solo se permite seleccionar fechas futuras (no se pueden elegir días anteriores al actual).  
- **Hora**: no se permite seleccionar una hora anterior a la hora actual del mismo día.  

El usuario puede revisar y modificar la selección de fecha y hora antes de confirmar.

### 3. Confirmación de cita
- Muestra un **resumen final** con la fecha y la hora seleccionadas.  
- Confirma que la cita ha sido registrada exitosamente.


## Tecnologías utilizadas
- Kotlin  
- Jetpack Compose  
- Material 3  
- Android Navigation Component  


## Estructura del proyecto
<img width="471" height="325" alt="Image" src="https://github.com/user-attachments/assets/f0f59886-ffcd-4930-9de5-0c8877238104" />

