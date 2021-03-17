import Foundation

enum Resource<T> {
    case success (data: T)
    case error (code: ResourceError)
    case loading
}

enum ResourceError {
    case networkFailure
    case internalError
    case notFound
    case notAuthorized
}
