//
//  SimpleRouterState.swift
//  iosApp
//
//  Created by Ryan on 7/31/22.
//  Copyright © 2022 orgName. All rights reserved.
//

import Shared

func simpleRouterState<T : AnyObject>(_ child: T) -> Value<RouterState<AnyObject, T>> {
    return valueOf(
        RouterState(
            activeChild: ChildCreated(
                configuration: "config" as AnyObject,
                instance: child
            ),
            backStack: []
        )
    )
}
