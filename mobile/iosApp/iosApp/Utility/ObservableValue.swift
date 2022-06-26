//
//  ObservableValue.swift
//  iosApp
//
//  Created by Ryan on 6/26/22.
//  Copyright © 2022 orgName. All rights reserved.
//

import SwiftUI
import Shared

public class ObservableValue<T : AnyObject> : ObservableObject {
    private let observableValue: Value<T>

    @Published
    var value: T

    private var observer: ((T) -> Void)?
    
    init(_ value: Value<T>) {
        observableValue = value
        self.value = observableValue.value
        observer = { [weak self] value in self?.value = value }
        observableValue.subscribe(observer: observer!)
    }

    deinit {
        observableValue.unsubscribe(observer: self.observer!)
    }
}
