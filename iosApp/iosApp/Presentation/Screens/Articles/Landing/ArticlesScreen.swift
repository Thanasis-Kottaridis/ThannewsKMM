//
//  ArticlesScreen.swift
//  iosApp
//
//  Created by a.kottaridis on 28/7/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI
import shared

struct ArticlesScreen: View {
    
    @ObservedObject private(set) var viewModel: ArticlesViewModelWrapper

    var body: some View {
        VStack {
            if viewModel.state.isLoading {
                Loader()
            }
            
            if let error = viewModel.state.error {
                ErrorView(message: error)
            }
            
            if(!viewModel.state.articles.isEmpty) {
                content
            }
            
        }
    }
    
    @ViewBuilder
    private var content: some View {
        ScrollView {
            LazyVStack(spacing: 10) {
                ForEach(viewModel.state.articles, id: \.self) { article in
                    ArticleItemView(article: article)
                }
            }
        }
    }
}

#Preview {
    ArticlesScreen(viewModel: ArticlesViewModelWrapper(viewModel: ArticlesViewModel()))
}
