//
//  AboutRowView.swift
//  iosApp
//
//  Created by a.kottaridis on 28/7/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI

struct AboutRowView: View {
    let title: String
    let subtitle: String

    var body: some View {
        VStack(alignment: .leading, spacing: 8) {
            Text(title)
                .font(.caption)
                .foregroundColor(.gray)
            Text(subtitle)
                .font(.body)
                .foregroundColor(.gray)
        }
        .padding(8)
    }
}

#Preview {
    AboutRowView(title: "Test title 1", subtitle: "Test subtitle 1")
}
