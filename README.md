**QaJavainterview**

Este proyecto es una prueba técnica de automatización con Java, Selenium WebDriver, Cucumber y Maven. 
Simula interacciones con la tienda demo [ToolShop](https://practicesoftwaretesting.com/) para validar 
funcionalidades clave mediante pruebas E2E escritas en Gherkin.

**Tecnologías utilizadas**

- **Java 17**
- **Selenium WebDriver**
- **Cucumber (BDD)**
- **Maven**
- **JUnit**
- **IntelliJ IDEA**

**Estructura del proyecto**

QaJavainterview/
├── src/
│ ├── main/
│ │ └── java/
│ │ └── pages/ # Clases Page Object Model
│ └── test/
│ ├── java/
│ │ ├── runners/ # Clase TestRunner
│ │ └── stepdefinitions/ # Definición de pasos Gherkin
│ └── resources/
│ └── features/ # Escenarios de prueba en Gherkin
├── screenshots/ # Capturas de pantalla generadas automáticamente (IGNORADA por Git)
├── .gitignore
├── pom.xml
└── README.md

##  Escenarios automatizados

###  Power Tools
- Añadir un producto al carrito
- Ir al checkout
- Introducir email inválido y contraseña
- Pulsar Login y verificar mensaje de error

###  Hand Tools
- Aplicar filtros por categoría y marca
- Verificar que los precios mostrados sean mayores a cero

###  Rentals
- Navegar a la categoría "Rentals"
- Verificar que se visualicen los títulos de herramientas

## ▶ Ejecución

Para ejecutar todos los tests:

```bash
mvn clean test

Los resultados se mostrarán en consola y se guardarán capturas en /screenshots.

📸 Capturas automáticas
Se toma una captura al finalizar cada escenario.

La carpeta screenshots/ está excluida del control de versiones y no se sube a GitHub (ver .gitignore).

🚧 Pendiente por implementar
Validación visual del layout con herramientas como Percy.

Integración continua (CI) con GitHub Actions.

Reportes HTML para Cucumber.

Desarrollado como parte de un proceso de selección técnica para QA Automation.

🤝 Contribuir
¡Las contribuciones son bienvenidas! Puedes abrir issues o pull requests para sugerir mejoras o arreglar errores.

📝 Licencia
Este proyecto es solo para fines de aprendizaje y no representa una aplicación de producción real.

Autor: Daniel González García
daniggcia@protonmail.com