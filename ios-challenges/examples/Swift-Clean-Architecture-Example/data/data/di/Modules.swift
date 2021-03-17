import Foundation
import Swinject

public let dataModules: [Assembly] = [
    ApiAssembly(),
    RepositoryAssembly()
]
