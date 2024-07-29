//
//  Coordinator.swift
//  iosApp
//
//  Created by a.kottaridis on 29/7/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import UIKit
import SwiftUI
import shared

public enum NavigationStyle {
    case present
    case push
    case resetStack
    case bottomSheet
    case overCurrentContext
    case overFullScreen
    case pop
    case reversePush
    case fade
}

public typealias CoordinatorKey = String

open class Coordinator {
    // MARK: - Vars
    var parentCoordinator: (Coordinator)? //{ get set }
    var childCoordinators: [String: Coordinator] //{ get set }
    var navigationController: UINavigationController //{ get set }
    var coordinatorKey: CoordinatorKey {
        return String.init(describing: self)
    }
   
    public init(
        navigationController: UINavigationController? = nil,
        childCoordinators: [String: Coordinator] = [:],
        parentCoordinator: (Coordinator)? = nil,
        doStart: Bool = false
    ) {
        self.navigationController = navigationController ?? UINavigationController()
        self.parentCoordinator = parentCoordinator
        self.childCoordinators = childCoordinators
        if doStart {
            start()
        }
    }
    
    // MARK: - Funcs
    open func start() {}
    
    open func addChild(
        coordinator: Coordinator,
        with key: CoordinatorKey,
        fromDeepLink: Bool = false
    ) {
        childCoordinators[key] = coordinator
    }
    
    open func removeChild(coordinator: Coordinator) {
        childCoordinators = childCoordinators.filter {
            $0.value !== coordinator
        }
    }
    
    open func removeChild(key: CoordinatorKey) {
        if let coord = childCoordinators[key] {
            removeChild(coordinator: coord)
            print("Coordinator with key: \(key) removed")
        }
    }
    
    open func getCoordingator(_ key: CoordinatorKey) -> (Coordinator)? {
        return childCoordinators[key]
    }
    
    open func stop(completion: (() -> Void)? = nil) {
        self.parentCoordinator?.removeChild(coordinator: self)
        completion?()
    }
    
    open func dismiss(animated: Bool = true, completion: (() -> Void)? = nil) {
        navigationController.dismiss(animated: animated) { [weak self] in
            guard let self = self else { return }
            self.stop(completion: completion)
        }
    }
}

// MARK: - Navigation EXT
extension Coordinator {
    
    public func navigate(
        to view: some View,
        with navigationStyle: NavigationStyle,
        animated: Bool = true,
        resetingStack: Bool = false,
        hideNavigationBar: Bool = true,
        hideTabBar: Bool = true,
        isSwipeBackEnable: Bool = true,
        completion: (() -> Void)? = nil
    ) {
        
        let viewController = SwiftUIBaseVC(
            rootView: view,
            hideNavigationBar: hideNavigationBar,
            hideTabBar: hideTabBar,
            isSwipeBackEnable: isSwipeBackEnable
        )
        
        navigate(
            to: viewController,
            with: navigationStyle,
            animated: animated,
            resetingStack: resetingStack,
            completion: completion
        )
    }
    
    public func navigate(
        to viewController: UIViewController,
        with navigationStyle: NavigationStyle,
        animated: Bool = true,
        resetingStack: Bool = false,
        completion: (() -> Void)? = nil
    ) {
        switch navigationStyle {
        case .push:
            navigationController.pushViewController(viewController, animated: animated)
        case .present:
            viewController.modalPresentationStyle = .fullScreen
            viewController.definesPresentationContext = true
            navigationController.present(viewController, animated: animated, completion: completion)
        case .resetStack:
            navigationController.setViewControllers([viewController], animated: animated)
        case .bottomSheet:
            // FIXME: - NOT YET IMPLEMENTED
            break
        case .overCurrentContext:
            viewController.modalPresentationStyle = .overCurrentContext
            navigationController.present(viewController, animated: animated, completion: completion)
        case .overFullScreen:
            viewController.modalPresentationStyle = .overFullScreen
            navigationController.present(viewController, animated: animated, completion: completion)
        case .pop:
            navigationController.popViewController(animated: animated)
        case .reversePush:
            navigationController.addTransition()
            navigationController.pushViewController(viewController, animated: false)
        case .fade:
            navigationController.addTransition(transitionType: .fade)
            navigationController.pushViewController(viewController, animated: false)
        }
    }
}
