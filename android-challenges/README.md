Please reach out if you need help completing any of these tasks. 

# Challenge 1 - Multi Module Clean Architecture
1. Set up a multi module gradle project using android feature module
2. Create instant feature module called "feature1" and an android library module called "data". Depend "feature1" on "data" using gradle.
3. Set up RxAndroid, RxJava, Koin DI, and Android Jetpack Components ( View Models )
4. Set up Android Jetpack Navigation 
5. Set up Jetpack Compose
6. Build a single navigation fragment for your app. Create a navigation graph using jetpack and navigate your app to feature1. Create a fragment in feature1 called SignInFragment. This should be the default navigation route for feature1.
8. Add a service to your data module named "SignInService". Give it a method called validateUser(username, password). It should verify the fields are not empty and are less than 12 characters each and return a validation state for each field.
9. Create a view model in "feature1" and inject the "SignInService". Create a method for validating the form and call the service. Expose the result with LiveData back to your view.
10. Use android jetpack compose to create a sign in UI with username, password, and submit button
11. Bind the view model to the view. Make sure the observer is lifecycle aware.
11. Make sure all validation logic of the form is located in the view model.
12. The view model tells the view if there are validation errors.
13. The view visually underlines each field that is invalid in red.
13. Create a koin module in data. Register your view model with Koin so it's injected into the your SignInFragment. Load and unload this module based on the android lifecycle. 

Bonus points:
14. If the username and password are validated with no errors, navigate the user to a blank fragment located in the feature2 module. Hint: you can use the navigation graph for this.
15. Use the provided Resource class for passing state back to the UI from the view model.