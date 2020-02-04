#First feature


@Test1



Feature: Test Recherche mot clés "TV"

  Scenario: LDLC testing
    Given Je suis sur la page "https://www.google.com/"
    And Naviguer a la page "https://www.ldlc.com/"
    Then Valider l affichage de la page d acceuil LDLC
    And Effectuer une recherche de "TV"
    Then Valider la recherche