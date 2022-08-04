//
//  ContentView.swift
//  iosApp
//
//  Created by Ryan on 7/31/22.
//  Copyright © 2022 orgName. All rights reserved.
//

import SwiftUI
import Shared

struct ContentView: View {
    @State
    private var componentHolder =
        ComponentHolder {
            RootComponent(
                componentContext: $0,
                storeFactory: DefaultStoreFactory()
            )
        }
    
    var body: some View {
        RootView(componentHolder.component)
                .onAppear { LifecycleRegistryExtKt.resume(self.componentHolder.lifecycle) }
                .onDisappear { LifecycleRegistryExtKt.stop(self.componentHolder.lifecycle) }
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
