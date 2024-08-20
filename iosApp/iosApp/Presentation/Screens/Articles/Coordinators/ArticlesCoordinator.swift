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
    
    private func testKtor() {
        let screen = ContentView(viewModel: ContentView.ViewModel())
        navigate(
            to: screen,
            with: .push,
            hideNavigationBar: true,
            hideTabBar: false,
            isSwipeBackEnable: true
        )
    }
    
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

// TODO: - Remove Test IMPL.
import SwiftUI

struct ContentView: View {
    @ObservedObject private(set) var viewModel: ViewModel

    var body: some View {
        Text(viewModel.text)
    }
}

extension ContentView {
    class ViewModel: ObservableObject {
        @Published var text = "Loading..."
        init() {
            TestKtor().greeting { greeting, error in
                DispatchQueue.main.async {
                    if let greeting = greeting {
                        self.text = greeting
                    } else {
                        self.text = error?.localizedDescription ?? "error"
                    }
                }
            }
        }
    }
}
