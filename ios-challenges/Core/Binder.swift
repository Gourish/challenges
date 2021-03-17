import Foundation

public protocol Binder {
    func setUp()
    func setUpConstraints()
    func bindToViewModel()
}

public extension Binder {
    
    func bindToViewModel() {
        
    }
}
