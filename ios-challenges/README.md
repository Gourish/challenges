Please reach out if you need help completing these. For a sample of clean architecture, check out the examples directory.

# Challenge 1 - RxDemo
1. Create an Xcode project
2. Set up Carthage or Cocoapods
3. Install RxSwift, RxCocoa, Swinject, SnapKit, and RxFlow
4. Set up a DI container for your application
5. Set up RxFlow
6. Copy the core directory containing our helper classes into the source directory of your new project
7. Create a UIViewController extending from LabViewController
8. Implement the binder methods for setUp, setUpConstraints, and bindToViewModel
9. Add a username field, password field, and a submit button to the VC in the setUp method. Constrain them in the setUpConstraints method.
10. Create a view model with inputs: username, password, and submit signals.
11. The view model should output validation states. States can be expressed as Resource<Void>.
12. When the submit button is tapped, the username and password are validated. Make sure they are not empty.
13. All validation logic of the form is located in the view model.
14. The view model tells the VC if there are validation errors.
15. The VC visually underlines each field that is invalid in red.
16. If validation succeeds, the submit will succeed, and the VC will navigate to a MainViewController using RxFlow.
17. The VC binds to the view model in bindToViewModel
18. The view model is injected using the app's swinject container
19. The RxFlow app flow is wired into the application lifecycle and coordinates the navigation of your app. DO NOT present view controllers inside of a view controller. You must complete this challenge using RxFlow's stepper.

# Challenge 2 - RxDemo + Tests
1. Complete challenge 1
2. Write unit tests for your view model
3. Write UI automation tests for your view controller.

# Challenge 3 - Xcode frameworks + RxDemo + Tests
1. Complete steps 1-6 of Challenge 1
2. Create a separate framework called Core and copy the core folder its source directory.
3. Depend on the framework from your App
4. Build the multi framework iOS project
5. Complete steps 7-19 of Challenge 1

# Challenge 4 - Bazel Build + RxDemo + Tests
1. Download, install, and setup Bazel and Tulsi
2. Set up CocoaPods with the Bazel project
3. Create a bazel module called Core and copy the core folder into its source directory
4. Complete steps 2-19 of Challenge 1
5. Run the bazel app on the simulator