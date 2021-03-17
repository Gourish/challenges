import Foundation
import SnapKit
import UIKit

public extension UIView {
    
    func pinToSuperview() {
        guard let `superview` = superview else {
            return
        }
        
        snp.makeConstraints { m in
            m.top.equalTo(superview.snp.top)
            m.bottom.equalTo(superview.snp.bottom)
            m.left.equalTo(superview.snp.left)
            m.right.equalTo(superview.snp.right)
        }
    }
    
    func pinLeftAbove(_ other: UIView) {
        snp.makeConstraints { m in
            m.bottom.equalTo(other.snp.top).offset(Margin.X2N)
            
            if let superview = superview {
                m.right.equalTo(superview.snp.right).offset(Margin.X2N)
            }

            m.left.equalTo(other.snp.left)
        }
     }

    func pinTop() {
        guard let `superview` = superview else {
            return
        }
               
        snp.makeConstraints { m in
            m.top.equalTo(superview.safeArea.top)
            m.left.equalTo(superview.snp.left)
            m.right.equalTo(superview.snp.right)
        }
    }

    func pinTopRight() {
        guard let `superview` = superview else {
            return
        }
               
        snp.makeConstraints { m in
            m.top.equalTo(superview.snp.top)
            m.right.equalTo(superview.snp.right)
        }
    }

    func pinBottomRight() {
         guard let `superview` = superview else {
             return
         }
                
         snp.makeConstraints { m in
             m.bottom.equalTo(superview.snp.bottom).offset(Margin.X2N)
             m.right.equalTo(superview.snp.right).offset(Margin.X2N)
         }
    }
    
    func pinBottomLeft() {
        guard let `superview` = superview else {
            return
        }
               
        snp.makeConstraints { m in
            m.bottom.equalTo(superview.snp.bottom).offset(Margin.X2N)
            m.left.equalTo(superview.snp.left).offset(Margin.X2)
        }
    }

}
