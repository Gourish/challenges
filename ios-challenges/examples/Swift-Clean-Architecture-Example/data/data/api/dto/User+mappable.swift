import domain
import Foundation
import ObjectMapper

extension User: Mappable {
    
    public init?(map: Map) {
        self.init()
    }
    
    public mutating func mapping(map: Map) {
        id <- map["id"]
        username <- map["username"]
        firstName <- map["firstName"]
        lastName <- map["lastName"]
    }
}
