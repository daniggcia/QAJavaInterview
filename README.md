**QaJavainterview**

Proyecto de automatización de pruebas funcionales UI con Java, Selenium WebDriver, Cucumber y Maven.Desarrollado como prueba técnica para el rol de QA Automation.

**Tecnologías utilizadas**

Java 17

Maven

Selenium WebDriver

Cucumber (Gherkin)

JUnit

IntelliJ IDEA

**Estructura del proyecto**

src
├── main
│   └── java
│       └── com.qainterview
│           ├── utils              # DriverFactory, ScreenshotUtil
│           ├── hooks              # Hooks para setup/teardown
│           └── pages              # Page Object Model
├── test
│   └── java
│       ├── runners                # Clase TestRunner
│       └── stepdefinitions        # Definiciones de pasos de Cucumber
└── test
└── resources
└── features               # Escenarios Gherkin

**Ejecución de pruebas**

Desde la raíz del proyecto:

mvn clean test

Esto:

Ejecuta todos los escenarios .feature.

Inicializa el navegador.

Toma capturas de pantalla en caso de fallo (almacenadas en /screenshots).

Cierra el navegador al finalizar.

**Hooks**

Se limpian capturas de pantalla previas antes de ejecutar nuevos tests.

Se realiza captura automática en caso de fallo.

**Capturas de pantalla**

Se almacenan en:

/screenshots/

Esta carpeta está excluida del repositorio mediante .gitignore.

**Pendientes por implementar**

Integración con Jenkins

Soporte para ejecución paralela

Reporte HTML personalizado