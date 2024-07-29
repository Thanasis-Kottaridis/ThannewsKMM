//
//  UINavigationController_Ext.swift
//  iosApp
//
//  Created by a.kottaridis on 29/7/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import UIKit

extension UINavigationController {
    public func addTransition(transitionType type: CATransitionType = CATransitionType.push, duration: CFTimeInterval = 0.5) {
        let transition = CATransition()
        transition.duration = duration
        transition.timingFunction = CAMediaTimingFunction(name: CAMediaTimingFunctionName.easeInEaseOut)
        transition.type = CATransitionType(rawValue: type.rawValue)
        self.view.layer.add(transition, forKey: nil)
    }
}
