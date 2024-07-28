//
//  AboutScreen.swift
//  iosApp
//
//  Created by a.kottaridis on 28/7/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI
import shared

struct AboutScreen: View {
    var body: some View {
        VStack {
            contentView
        }
        .navigationTitle("About Device")
    }
    
    private var contentView: some View {
        
        List(Platform().toItemsList(), id: \.id) { row in
            AboutRowView(title: row.title, subtitle: row.subtitle)
        }
        .listStyle(PlainListStyle())
    }
}

#Preview {
    AboutScreen()
}
