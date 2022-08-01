//
//  ComponentHolder.swift
//  iosApp
//
//  Created by Ryan on 7/31/22.
//  Copyright © 2022 orgName. All rights reserved.
//
import Shared

class ComponentHolder<T> {
    let lifecycle: LifecycleRegistry
    let component: T

    init(factory: (ComponentContext) -> T) {
        let lifecycle = LifecycleRegistryKt.LifecycleRegistry()
        let component = factory(DefaultComponentContext(lifecycle: lifecycle))
        
        self.component = component
        self.lifecycle = lifecycle
        
        lifecycle.onCreate()
    }
    
    deinit {
        lifecycle.onDestroy()
    }
}
