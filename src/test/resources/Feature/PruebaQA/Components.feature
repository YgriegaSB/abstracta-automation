Feature: Navigate Between menus

  @Components @AutomationAbstracta
  Scenario: Navegar a componentes/monitores
    Given Carga sitio web de "ABSTRACTA"
    When despliego el menu de "Components"
    And selecciono la opcion "Monitors"
    Then visualizo la pagina de "Monitors"
