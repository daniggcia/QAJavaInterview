Feature: Verificación de títulos en la sección Rentals

  Scenario: Verificar títulos visibles de herramientas en Rentals
    Given el usuario accede a la página principal
    When navega al menú Categories y selecciona Rentals
    Then se visualizan los títulos de todas las herramientas disponibles