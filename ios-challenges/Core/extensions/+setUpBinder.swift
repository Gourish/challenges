import Foundation
import UIKit

extension UIViewController {
        
    func setUpBinder() {
        if let binder = self as? Binder {
            binder.setUp()
            binder.setUpConstraints()
            binder.bindToViewModel()
        }
    }
    
}

extension UIView {
        
    func setUpBinder() {
        if let binder = self as? Binder {
            binder.setUp()
            binder.setUpConstraints()
            binder.bindToViewModel()
        }
    }
    
}
