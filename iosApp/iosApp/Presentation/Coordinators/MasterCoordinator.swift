//
//  MasterCoordinator.swift
//  iosApp
//
//  Created by a.kottaridis on 28/7/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import UIKit
import shared

class MasterCoordinator: Coordinator {
    
    override func start() {
        super.start()
        goToMainApp()
    }
    
    private func goToMainApp() {
        // 1. clear child coordinator stack before enter MainApp
        childCoordinators.removeAll()
        
        // 2. set up articles Coordinator.
        let articlesCoordinator = ArticlesCoordinator(
            navigationController: self.navigationController,
            parentCoordinator: self,
            doStart: true
        )
        
        // 3. keep child coordinator reference
        self.addChild(
            coordinator: articlesCoordinator,
            with: articlesCoordinator.coordinatorKey
        )
    }
}
