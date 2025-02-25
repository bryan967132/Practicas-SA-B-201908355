*Universidad de San Carlos de Guatemala*  
*Facultad de Ingenieria*  
*Escuela de Ciencias y Sistemas*  
*Software Avanzado*  
*Primer Semestre 2025*  
___
**201908355 - Danny Hugo Bryan Tejaxún Pichiyá**  
___
## **Práctica 2**  

### 1. Herramientas Utilizadas
#### 1.1. NodeJS
Node.js es un entorno de ejecución de JavaScript basado en el motor V8 de Google Chrome. Permite ejecutar JavaScript en el lado del servidor, lo que facilita el desarrollo de aplicaciones web escalables y de alto rendimiento.

* Ventajas  
✅ Asincronía y no bloqueo: Maneja múltiples solicitudes simultáneamente sin bloquear el hilo principal.  
✅ Gran ecosistema de paquetes: Gracias a npm, existen miles de bibliotecas que facilitan el desarrollo.  
✅ Escalabilidad: Ideal para aplicaciones en tiempo real como chats, streaming y APIs REST.  
✅ Mismo lenguaje en frontend y backend: Permite un desarrollo más fluido con JavaScript en toda la aplicación.  
✅ Comunidad activa: Amplio soporte y actualizaciones frecuentes.  
* Desventajas  
❌ No es ideal para aplicaciones con alta carga de CPU: Al ser monohilo, puede no ser eficiente en tareas intensivas de procesamiento.  
❌ Callbacks y promesas anidadas: Aunque se ha mejorado con async/await, el código puede volverse difícil de mantener.  
❌ Frecuentes cambios en dependencias: La velocidad de actualización en el ecosistema de npm puede generar problemas de compatibilidad.  

#### 1.2. React + Vite
React es una biblioteca de JavaScript para construir interfaces de usuario dinámicas y eficientes. Vite es un entorno de desarrollo que optimiza la compilación y ejecución de aplicaciones React, ofreciendo una experiencia más rápida y fluida en comparación con Webpack.

* Ventajas  
✅ Rendimiento optimizado con Vite: Recarga instantánea y compilación ultrarrápida.  
✅ Componentización: React permite dividir la interfaz en componentes reutilizables y modulares.  
✅ Virtual DOM: Mejora la eficiencia al actualizar solo los cambios necesarios en la interfaz.  
✅ Gran ecosistema y comunidad: Soporte amplio, múltiples herramientas y bibliotecas adicionales como React Router, Redux, etc.  
✅ Soporte para SSR y SPA: Puede usarse tanto para aplicaciones de una sola página (SPA) como para renderizado en el servidor (SSR) con Next.js.  
* Desventajas  
❌ Curva de aprendizaje: JSX, hooks y el estado pueden ser difíciles para principiantes.  
❌ Mayor consumo de memoria: React puede ser menos eficiente en términos de rendimiento en comparación con frameworks más ligeros.  
❌ Configuración adicional para SEO: React por sí solo no es óptimo para SEO; se requiere SSR o pre-renderizado con herramientas como Next.js.  

#### 1.3. MySQL
MySQL es un sistema de gestión de bases de datos relacionales (RDBMS) ampliamente utilizado en aplicaciones web. Utiliza SQL para manejar y manipular datos.

* Ventajas  
✅ Popularidad y soporte: Tiene una comunidad grande y mucha documentación.  
✅ Alto rendimiento en lecturas: Es eficiente para aplicaciones con muchas consultas de solo lectura.  
✅ Integración sencilla: Compatible con múltiples lenguajes de programación y herramientas.  
✅ Seguridad y robustez: Soporta autenticación y cifrado de datos.  
✅ Replicación y clustering: Permite alta disponibilidad con opciones como MySQL Cluster.  
* Desventajas  
❌ Escalabilidad limitada: No es la mejor opción para sistemas de alto volumen de escritura en comparación con NoSQL.  
❌ Menos eficiente en consultas complejas: Puede volverse lento con grandes volúmenes de datos si no está bien optimizado.  
❌ Pocas opciones de escalabilidad horizontal: Escalar MySQL puede requerir configuraciones adicionales como sharding o réplicas.  

### 2. Cookies Y AES
#### 2.1. HTTP
HTTP (HyperText Transfer Protocol) es un protocolo de comunicación utilizado para la transferencia de datos entre un cliente (navegador) y un servidor web. Es la base de la comunicación en la web, permitiendo la solicitud y entrega de páginas web, imágenes, videos, y otros recursos.

* Es un protocolo sin estado, lo que significa que no almacena información entre solicitudes.
* Opera a través del puerto 80 de forma predeterminada.
* No cifra la información transmitida, lo que lo hace vulnerable a ataques como Man-in-the-Middle (MitM).

#### 2.2. HTTPS Only
HTTPS (HyperText Transfer Protocol Secure) es la versión segura de HTTP, que utiliza TLS (Transport Layer Security) o SSL (Secure Sockets Layer) para cifrar la comunicación entre el cliente y el servidor. La opción "HTTPS Only" significa que una cookie o recurso solo se enviará si la conexión es segura.

* HTTPS usa cifrado para proteger los datos transmitidos, evitando el espionaje y modificaciones por atacantes.
* Opera en el puerto 443 por defecto.
* Las cookies marcadas con "Secure" solo se envían si la conexión es HTTPS, evitando su exposición en conexiones HTTP no seguras.
* Mejora la privacidad y seguridad, siendo fundamental para aplicaciones web que manejan datos sensibles, como contraseñas o información bancaria.

#### 2.3. Algoritmo AES
AES (Advanced Encryption Standard) es un algoritmo de cifrado simétrico ampliamente utilizado para proteger datos. Fue adoptado como estándar por el NIST (National Institute of Standards and Technology) en 2001 y es utilizado por gobiernos, bancos y empresas.

* Un algoritmo de cifrado simétrico, lo que significa que usa la misma clave para cifrar y descifrar datos.
* Soporta tamaños de clave de 128, 192 y 256 bits, con el de 256 bits siendo el más seguro.
* Utiliza el método de Sustitución-Permutación, que mezcla los datos en varias rondas de transformación.
* Se usa en HTTPS, VPNs, almacenamiento de datos, y cifrado de contraseñas para garantizar la confidencialidad de la información.

### 3. JWT (JSON Web Token)
JWT (JSON Web Token) es un estándar de autenticación y autorización que permite el intercambio seguro de información entre un cliente y un servidor en formato JSON.

1. El usuario inicia sesión y el servidor genera un JWT firmado con una clave secreta.
2. El cliente almacena el token (usualmente en localStorage o cookies).
3. En cada solicitud, el cliente envía el JWT en el encabezado `Authorization: Bearer <token>`.
4. El servidor valida el token y, si es válido, concede acceso al recurso solicitado.

Es mucho más seguro si se usa con HTTPS y con tiempo de expiración.

### 4. Diagrama De Secuencia
![Diagrama](./Img/[SA]Practica2%20Diagrama%20Secuencia.jpg)