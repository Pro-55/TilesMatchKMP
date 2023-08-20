//
//  OptionsScreen.swift
//  iosApp
//
//  Created by Pranit Rane on 15/08/23.
//  Copyright © 2023 orgName. All rights reserved.
//
import SwiftUI
import shared

struct OptionsScreen: View {
    private var repository: Repository
    @StateObject var viewModel = OptionsViewModel(repository: nil)
    
    init(repository: Repository) {
        self.repository = repository
    }
    
    var body: some View {
        OptionsGrid(options: viewModel.options)
            .onAppear {
                viewModel.updateRepository(repository: repository)
                viewModel.getOptions()
            }
    }
}
