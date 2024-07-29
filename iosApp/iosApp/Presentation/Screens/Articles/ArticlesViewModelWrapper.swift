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
    
    @Published var state: ArticlesState
    
    init(state: ArticlesState) {
        self.state = state
    }
    
}

extension BaseViewModel {
    func getSomething() -> String {
        return "something"
    }
}
