import domain
import Foundation
import Moya
import Swinject

class ApiAssembly: Assembly {
    
    func assemble(container: Container) {
        container.register(NetworkLoggerPlugin.self) { r in
              let plugin = NetworkLoggerPlugin()
              plugin.configuration.logOptions = .verbose
              return plugin
          }
        
        container.register(ApiProvider<SearchApi>.self) { r in
            let provider = ApiProvider<SearchApi>()
            
            provider.provider = MoyaProvider<SearchApi>(
            endpointClosure: provider.endpointClosure,
            plugins: [r.resolve(NetworkLoggerPlugin.self)!])
            
            provider.setAccountDao(r.resolve(AccountDao.self)!)
            
            return provider
        }
    }
}
