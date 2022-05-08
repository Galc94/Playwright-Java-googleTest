# Author: Gustavo Lozano

Feature: Prueba de PLaywright

  @Smoke
  Scenario: Busqueda en google
    Given El usuario accede al buscador google
    And El usuario digita la palabra clave "Vanessa"
    When El usuario presiona el boton Buscar
    Then En el title del navegador aparece la palabra clave