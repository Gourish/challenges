import Foundation

public struct User {
    public var id: String
    public var username: String
    public var firstName: String
    public var lastName: String
    
    public init() {
        id = ""
        username = ""
        firstName = ""
        lastName = ""
    }
    
    public init(id: String, username: String, firstName: String, lastName: String) {
        self.id = id
        self.username = username
        self.firstName = firstName
        self.lastName = lastName
    }
}
