//
//  LoginView.swift
//  iosApp
//
//  Created by Ryan on 6/12/22.
//  Copyright © 2022 orgName. All rights reserved.
//

import SwiftUI
import Shared


struct LoginView: View {
    private var component: Login
    
    @ObservedObject
    private var models: ObservableValue<LoginModel>
    
    @State private var isSecured: Bool = true
    
    init(_ component: Login) {
        self.component = component
        self.models = ObservableValue(component.models)
    }
    
    
    var body: some View {
        let model = models.value
        
        let usernameBinding = Binding(get: { model.username }, set: component.onUsernameChanged)
        let passwordBinding = Binding(get: { model.password }, set: component.onPasswordChanged)
        
        VStack(spacing: 10) {
            
            HStack {
                Image(systemName: "person")
                TextField("Username", text: usernameBinding)
            }
            .padding(10)
            .overlay(RoundedRectangle(cornerRadius: 10)
                .strokeBorder(Color("Primary"), style: StrokeStyle(lineWidth: 1.0)))
            
            HStack {
                Image(systemName: "lock")
                if isSecured {
                    SecureField("Password", text: passwordBinding)
                } else {
                    TextField("Password", text: passwordBinding)
                }
                Button(action: { isSecured.toggle() }) {
                    Image(systemName: self.isSecured ? "eye.slash" : "eye")
                        .foregroundColor(.black)
                }
            }
            .padding(10)
            .overlay(RoundedRectangle(cornerRadius: 10)
                .strokeBorder(Color("Primary"), style: StrokeStyle(lineWidth: 1.0)))
            
            Button("Login", action: {})
            	.frame(minWidth: 0, maxWidth: .infinity)
            	.padding(10)
            	.foregroundColor(.white)
            	.background(Color("Primary"))
            	.clipShape(Capsule())
        }
        .padding(10)
    }
}

struct LoginView_Previews: PreviewProvider {
    static var previews: some View {
        LoginView(StubLogin())
    }
    
    class StubLogin: Login {
        func onLogin() {
        }
        
        func onPasswordChanged(password: String) {
        }
        
        func onUsernameChanged(username: String) {
        }
        
        let models: Value<LoginModel> =
            valueOf(
                LoginModel(
                    username: "test@test.com", password: "password123"
                )
            )
    }
}
