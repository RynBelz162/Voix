//
//  MutableStateBuilder.swift
//  iosApp
//
//  Created by Ryan on 7/31/22.
//  Copyright © 2022 orgName. All rights reserved.
//

import Shared

func valueOf<T: AnyObject>(_ value: T) -> Value<T> {
    return MutableValueBuilderKt.MutableValue(initialValue: value) as! MutableValue<T>
}
