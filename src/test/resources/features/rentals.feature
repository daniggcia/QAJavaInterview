Feature: Verificación de títulos en la sección Rentals

  Scenario: Verificar títulos visibles de herramientas en Rentals
    Given el usuario abre la página principal para Rentals
    When navega al menú Categories y selecciona Rentals
    Then se visualizan los títulos de todas las herramientas disponibles