//
//  ArticlesViewModelWrapper.swift
//  iosApp
//
//  Created by a.kottaridis on 28/7/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import Foundation
import shared

class ArticlesViewModelWrapper: ObservableObject {
    
    @Published var state: ArticlesState = ArticlesState.companion.default()
    
    private let viewModel: ArticlesViewModel
    private var stateSubscription: KmmSubscription!
    
    // TODO: - Boilerplate code extract to template
    init(viewModel: ArticlesViewModel) {
        self.viewModel = viewModel
        subscribeState()
    }
    
    // TODO: - Boilerplate code extract to template
    deinit {
        viewModel.clear()
        stateSubscription.unsubscribe()
    }
    
    // TODO: - Boilerplate code extract to template
    func onTriggerEvent(event: ArticleEvent) {
        viewModel.onTriggerEvent(event: event)
    }
    
    // TODO: - Boilerplate code extract to template
    private func subscribeState() {
        stateSubscription = viewModel.state.subscribe(
            onEach: { state in
                self.state = state!
            },
            onError: { error, isCompletion  in
                if let error = error {
                    print(error)
                }
            }
        )
    }
}
