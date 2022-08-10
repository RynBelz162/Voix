import SwiftUI
import Shared

@main
struct iOSApp: App {
    
    init() {
        Voix.Companion().doInitNapierDebug()
    }
    
	var body: some Scene {
		WindowGroup {
			ContentView()
		}
	}
}
