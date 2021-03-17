import domain
import Foundation
import Swinject

public class SearchAssembly: Assembly {
    
    public init() {
    }
    
    public func assemble(container: Container) {
        container.register(SearchViewModel.self) { r in
            SearchViewModel(userRepository: r.resolve(UserRepository.self)!)
        }
        
        container.register(SearchViewController.self) { r in
            SearchViewController(r.resolve(SearchViewModel.self)!)
        }
    }
}
