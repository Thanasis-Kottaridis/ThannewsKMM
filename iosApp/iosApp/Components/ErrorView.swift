//
//  ErrorView.swift
//  iosApp
//
//  Created by a.kottaridis on 28/7/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI

struct ErrorView: View {
    var message: String
    
    var body: some View {
        Text(message)
            .font(.title)
    }
}

#Preview {
    ErrorView(message: "This is an error...")
}
