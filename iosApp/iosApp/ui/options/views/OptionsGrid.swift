//
//  OptionsGrid.swift
//  iosApp
//
//  Created by Pranit Rane on 20/08/23.
//  Copyright © 2023 orgName. All rights reserved.
//
import SwiftUI
import shared

struct OptionsGrid: View {
    private var options = [Option]()
    
    init(options: [Option]) {
        self.options = options
    }
    
    var body: some View {
        ScrollView {
            LazyVGrid(columns: Array(repeating: .init(.flexible()), count: 2)) {
                ForEach(options, id: \.self) { option in
                    let url = getUrlFor(option)
                    if(option._id < 4) {
                        Image(url)
                            .resizable()
                            .scaledToFit()
                            .frame(minWidth: 0, maxWidth: .infinity, minHeight: 0, maxHeight: .infinity)
                            .aspectRatio(CGSize(width: 1, height: 1), contentMode: .fit)
                            .cornerRadius(8)
                    } else {
                        Glide(url: url) { phase in
                            if let image = phase.image {
                                image.resizable()
                                    .scaledToFit()
                                    .cornerRadius(8)
                            } else {
                                Color.gray
                                    .frame(minWidth: 0, maxWidth: .infinity, minHeight: 0, maxHeight: .infinity)
                                    .aspectRatio(CGSize(width: 1, height: 1), contentMode: .fit)
                                    .cornerRadius(8)
                            }
                        }
                    }
                }
            }
            .padding(8)
        }
    }
    
    private func getUrlFor(_ option: Option) -> String {
        switch(option._id) {
        case 0:
            return "Slytherin"
        case 1:
            return "Gryffindor"
        case 2:
            return "Hufflepuff"
        case 3:
            return "Ravenclaw"
        default:
            return option.url
        }
    }
}
