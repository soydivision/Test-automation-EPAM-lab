Feature: As a user I want to see answer to one of questions about personal development

  @critical-path
  Scenario: Answer to question should be shown
    Given the user opens Coursera Personal development page
    When the user clicks to first question about personal development
    Then answer to question is shown