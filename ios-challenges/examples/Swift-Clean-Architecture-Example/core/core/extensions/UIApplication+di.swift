import Foundation
import Swinject
import UIKit

extension UIApplication {
    
    public static func container() -> Resolver {
        return labDelegate().assembler.resolver
    }
    
    public static func labDelegate() -> LabAppDelegate {
        return (UIApplication.shared.delegate as! LabAppDelegate)
    }
}
