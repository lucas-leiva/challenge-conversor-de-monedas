# Challenge Conversor de Monedas

Este proyecto es un **convertidor de monedas** que utiliza la API de **ExchangeRate-API** para realizar conversiones entre diferentes divisas. Actualmente, el conversor es capaz de realizar conversiones entre las siguientes monedas:

- Dólar (USD) a Peso Argentino (ARS)
- Peso Argentino (ARS) a Dólar (USD)
- Dólar (USD) a Real Brasileño (BRL)
- Real Brasileño (BRL) a Dólar (USD)
- Dólar (USD) a Peso Colombiano (COP)
- Peso Colombiano (COP) a Dólar (USD)

### Requisitos

Para ejecutar este proyecto en tu máquina local, asegúrate de tener instalados los siguientes requisitos:

- **Java 11 o superior**
- **Gson** para la deserialización de JSON
- **HttpClient** para hacer peticiones HTTP a la API
- Una conexión a internet para hacer las peticiones a la API de ExchangeRate.

### Instalación

1. Clona el repositorio en tu máquina local:
    ```bash
    git clone https://github.com/tu_usuario/nombre_del_repositorio.git
    ```
2. Asegúrate de tener configurado Java 11 o superior en tu entorno.
3. Instala las dependencias necesarias, si estás usando un sistema de gestión de dependencias como Maven o Gradle, asegúrate de tener la dependencia de **Gson** incluida:
    - **Para Maven**:
      ```xml
      <dependency>
          <groupId>com.google.code.gson</groupId>
          <artifactId>gson</artifactId>
          <version>2.8.8</version>
      </dependency>
      ```

### Uso

1. Ejecuta la clase `MenuDeOpciones` para iniciar el programa.
2. Se te pedirá que elijas una de las opciones disponibles para realizar una conversión de moneda.
3. Ingresa el valor que deseas convertir y el programa te proporcionará el resultado final en la moneda correspondiente.

### Ejemplo de salida:
Elige una opción válida:

1) Dólar a Peso Argentino
2) Peso Argentino a Dólar
3) Dólar a Real Brasileño
4) Real Brasileño a Dólar
5) Dólar a Peso Colombiano
6) Peso Colombiano a Dólar
7) Salir
   
1

Ingrese el valor que desea convertir:

100

El valor de 100.0 [USD] corresponde al valor final de: 441083410.0 [COP]
