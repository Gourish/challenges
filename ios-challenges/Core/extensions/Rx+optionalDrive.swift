import Foundation
import RxCocoa
import RxSwift

public extension PublishSubject where Element: Any {
    
    func optionalDrive() -> Driver<Element> {
        return map { Optional($0 )}
            .asDriver(onErrorJustReturn: nil)
            .filter { $0 != nil }
            .map { $0! }
    }
}
