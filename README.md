# ONE Currency API

Este es un proyecto de conversión de monedas que permite a los usuarios convertir valores entre diferentes divisas utilizando la API de [ExchangeRate-API](https://www.exchangerate-api.com) para obtener los tipos de cambio en tiempo real. La aplicación tiene una interfaz sencilla que facilita la selección de monedas base y destino, así como la entrada de cantidades a convertir.

## Demo del Proyecto

Puedes ver una breve demostración de la interfaz y sus validaciones en el siguiente video:

[![Demo del Proyecto](https://img.youtube.com/vi/U6BxQSERRDM/0.jpg)](https://youtu.be/U6BxQSERRDM)


## Estructura 

El proyecto está organizado en varias clases Java que cumplen funciones específicas:

### Clases Principales

- **ApiCredentials.java**: Contiene la clave de API necesaria para acceder a la API de tasas de cambio. Proporciona métodos para consultar el tipo de cambio entre diferentes monedas.

- **Moneda.java**: Representa una moneda con su código y nombre. Incluye métodos para obtener información sobre la moneda y para convertirla a otra moneda utilizando la API.

- **RegistrosDeLogs.java**: Maneja el registro de las conversiones realizadas, almacenando información relevante como la cantidad convertida, las monedas utilizadas y el resultado de la conversión.

- **RespuestaTasaDeCambio.java**: Clase auxiliar que representa la respuesta de la API al consultar las tasas de cambio. Facilita el acceso a la información de tasas de conversión.

- **Principal.java**: Clase principal que contiene la lógica de la interfaz de usuario. Permite a los usuarios seleccionar las monedas, ingresar cantidades y ver los resultados de la conversión en una interfaz gráfica.

### Flujo de Trabajo

1. **Selección de Monedas**: El usuario elige una moneda base y una moneda de destino desde un menú desplegable.
  
2. **Entrada de Cantidad**: El usuario ingresa la cantidad a convertir en un campo de texto.

3. **Conversión**: Al presionar el botón "Convertir", se consulta a la API para obtener la tasa de cambio y se realiza la conversión.

4. **Resultado**: El resultado se muestra en la interfaz, y se registra la conversión para futuros análisis.

## Requisitos

- Java 11 o superior
- Dependencias: [Gson](https://github.com/google/gson) y [JavaFX](https://openjfx.io/) para la interfaz gráfica.

## Instalación

1. Clona el repositorio:
   ```bash
   git clone https://github.com/LynZxGerard/challenge-api-monedas.git
    ```
2. Navega a la carpeta del proyecto:
  ```bash
    cd challenge-api-monedas  
  ```

3. Asegúrate de tener las dependencias necesarias en tu entorno de desarrollo (Gson y JavaFX).
   - [Importar JavaFX](https://www.youtube.com/watch?v=udigo_qSp_k)
   - [Importar GSON](https://www.youtube.com/watch?v=IstAH4_8aO0)
   - [Cómo agregar archivos Jar a IntelliJ](https://www.youtube.com/watch?v=yAivHMoLR7o)


5. Configura tu clave de API en ApiCredentials.java.

6. Compila y ejecuta el proyecto.

## Referencias

- API utilizada: [ExchangeRate-API](https://www.exchangerate-api.com)

## Contribuciones
Las contribuciones son bienvenidas. Si deseas mejorar el proyecto, por favor crea un fork y envía un pull request.
