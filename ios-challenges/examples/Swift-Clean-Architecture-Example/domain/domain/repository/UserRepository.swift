import Foundation
import RxSwift

public protocol UserRepository {
    func searchUsers(query: String) -> Single<[User]>
}
