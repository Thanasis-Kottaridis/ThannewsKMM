//
//  ArticlesCoordinator.swift
//  iosApp
//
//  Created by a.kottaridis on 29/7/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import UIKit
import shared

public class ArticlesCoordinator: Coordinator {
    
    public override func start() {
        super.start()
        goToArticlesLanding()
    }
}

extension ArticlesCoordinator: ArticlesActionHandler {
    
    public func goToArticlesLanding() {
        let viewModel = ArticlesViewModelWrapper(viewModel: ArticlesViewModel())
        let screen = ArticlesScreen(viewModel: viewModel)
        navigate(
            to: screen,
            with: .push,
            hideNavigationBar: true,
            hideTabBar: false,
            isSwipeBackEnable: true
        )
    }
    
    public func goToAboutScreen() {
        let screen = AboutScreen()
        navigate(
            to: screen,
            with: .push,
            hideNavigationBar: true,
            hideTabBar: false,
            isSwipeBackEnable: true
        )
    }
    
    public func goToArticleDetails(articleId: String) {
        // TODO: - Add Screen Implementation
    }
}
