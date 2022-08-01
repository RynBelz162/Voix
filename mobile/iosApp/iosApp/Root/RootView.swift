//
//  RootView.swift
//  iosApp
//
//  Created by Ryan on 6/26/22.
//  Copyright © 2022 orgName. All rights reserved.
//

import SwiftUI
import Shared

struct RootView: View {
    @ObservedObject
        private var routerStates: ObservableValue<RouterState<AnyObject, RootChild>>
    
    init(_ component: Root) {
        self.routerStates = ObservableValue(component.routerState)
    }
    
    var body: some View {
        let child = self.routerStates.value.activeChild.instance
        
        switch child {
            
        	case let login as RootChild.Login:
            	LoginView(login.component)
            
        	default: EmptyView()
        }
    }
}

struct RootView_Previews: PreviewProvider {
    static var previews: some View {
        RootView(StubRoot())
    }
    
    class StubRoot : Root {
            let routerState: Value<RouterState<AnyObject, RootChild>> =
        simpleRouterState(RootChild.Login(component: LoginView_Previews.StubLogin()))
    }
}
