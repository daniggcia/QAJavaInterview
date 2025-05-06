Feature: Validación de login con credenciales inválidas en Power Tools

  Scenario: Verificar mensaje de error al intentar loguearse con email inválido tras añadir producto al carrito
    Given el usuario accede a la página principal
    When navega al menú Categories y selecciona "Power Tools"
    And hace clic en un producto y lo añade al carrito
    And accede al carrito y procede al checkout
    And introduce el email "daniggcia@hotmail.com" y contraseña "123456"
    And pulsa el botón Login
    Then se muestra el mensaje de error "Invalid email or password"