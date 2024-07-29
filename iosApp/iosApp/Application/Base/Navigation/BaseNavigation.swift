//
//  BaseNavigation.swift
//  iosApp
//
//  Created by a.kottaridis on 29/7/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import Foundation
import shared

/** # BaseActionHandler Default Implementation
 Set up default implementation of `BaseActionHandler` where it has been conformed by
 a `Coordinator`
 */
extension Coordinator: BaseActionHandler {
    
    public func popAction() {
        navigationController.popViewController(animated: true)
    }
    
    public func popToRootScreenAction(animated: Bool) {
        navigationController.popToRootViewController(animated: animated)
    }
    
    public func popToScreenAction(targetScreenType: Any, animated: Bool) {
        navigationController.viewControllers.forEach({ vc in
            if let type = targetScreenType as? AnyClass,
                   vc.isKind(of: type) {
                       navigationController.popToViewController(vc, animated: animated)
                       return
                   }
        })
    }
    
    public func popWithReloadToVCAction(targetScreenType: Any) {
        // TODO: - Implement this method
    }
    
    public func presentFeedback() {
        // TODO: - Implement this method
    }
    
    public func showLoaderAction() {
        // TODO: - Implement this method
    }
    
    public func hideLoaderAction() {
        // TODO: - Implement this method
    }
    
    public func dismissAction() {
        navigationController.presentedViewController?.dismiss(animated: true, completion: nil)
    }
}
