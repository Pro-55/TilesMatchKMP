//
//  OptionsViewModel.swift
//  iosApp
//
//  Created by Pranit Rane on 15/08/23.
//  Copyright © 2023 orgName. All rights reserved.
//
import Foundation
import shared

extension OptionsScreen {
    @MainActor class OptionsViewModel: ObservableObject {
        
        // Global
        private let TAG = "OptionsViewModel"
        private var repository: Repository? = nil
        @Published private(set) var options: [Option] = []
        
        init(repository: Repository? = nil) {
            self.repository = repository
        }
        
        func updateRepository(repository: Repository) {
            self.repository = repository
        }
        
        func getOptions() {
            repository?.getOptions()
                .onEach(onLoading: {
                    print("TestLog: onLoading")
                }, onSuccess: { options in
                    self.options = options as? [Option] ?? []
                }, onError: { msg in
                    print("TestLog: onError => \(msg ?? "" )")
                })
        }
    }
}
