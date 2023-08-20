import SwiftUI
import shared

@main
struct iOSApp: App {
    private let repository: Repository = RepositoryImpl()
    
    var body: some Scene {
        WindowGroup {
            OptionsScreen(repository: repository)
        }
    }
}
