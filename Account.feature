Feature: Login into salesforce Application

 
Scenario: Login into sales app
 
Given launch the Browser and launch the url
When Enter the Username as dilip@testleaf.com
And Enter the Password as testleaf@2024
And Click on LoginButton
And Click on toggle menu button from the left corner
And Click view All 
And click Sales from App Launcher
And Click on Accounts tab
And Click on New button
And Enter 'your name' as account name
And Select Ownership as Public
And Click save 
Then verify Account name 