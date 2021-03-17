import Foundation
import UIKit

open class LabView: UIView {
    
    public override init(frame: CGRect) {
        super.init(frame: frame)
        setUpBinder()
    }
    
    public required init?(coder: NSCoder) {
        super.init(coder: coder)
        setUpBinder()
    }
    
    init() {
        super.init(frame: CGRect())
        setUpBinder()
    }
}
