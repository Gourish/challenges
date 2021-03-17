import domain
import Foundation
import ObjectMapper

extension AuthToken: Mappable {
    
    public init?(map: Map) {
        self.init()
    }
    
    public mutating func mapping(map: Map) {
        accessToken <- map["accessToken"]
        expiresIn <- map["expiresIn"]
        refreshExpiresIn <- map["refreshExpiresIn"]
        refreshToken <- map["refreshToken"]
        tokenType <- map["tokenType"]
        idToken <- map["idToken"]
        sessionState <- map["sessionState"]
        scope <- map["scope"]
    }
}
