Feature: Filtrado y verificación de precios en Hand Tools

  Scenario: Verificar que los precios sean mayores a cero tras aplicar filtros
    Given el usuario accede a la página principal
    When navega al menú Categories y selecciona Hand Tools
    And aplica los filtros por categoría "Hammer" y marca "ForgeFlex Tools"
    Then el precio de cada herramienta mostrada es mayor a cero