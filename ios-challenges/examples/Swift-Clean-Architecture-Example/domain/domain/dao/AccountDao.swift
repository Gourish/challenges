import Foundation

public protocol AccountDao {
    func getAuthToken() -> AuthToken?
    func saveAuthToken (_ token: AuthToken)
}
