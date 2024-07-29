//
//  ArticleItemView.swift
//  iosApp
//
//  Created by a.kottaridis on 29/7/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI
import shared

struct ArticleItemView: View {
    var article: Article
    
    var body: some View {
        VStack(alignment: .leading, spacing: 8) {
            imageView
            content
        }
        .padding(16)
    }
    
    private var imageView: some View {
        AsyncImage(url: URL(string: article.imageUrl)) { phase in
            if let image = phase.image {
                image.resizable()
                    .aspectRatio(contentMode: .fit)
            } else if let error = phase.error {
                Text("Image Load Error")
            } else {
                ProgressView()
            }
        }
    }
    
    @ViewBuilder
    private var content: some View {
        Text(article.title)
            .font(.title)
            .fontWeight(.bold)
        Text(article.description)
        Text(article.date).frame(maxWidth: .infinity, alignment: .trailing).foregroundStyle(.gray)
    }
}

#Preview {
    ArticleItemView(article: Article.Companion().mock(index: 1))
}
