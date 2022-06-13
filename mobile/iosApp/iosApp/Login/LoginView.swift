//
//  LoginView.swift
//  iosApp
//
//  Created by Ryan on 6/12/22.
//  Copyright © 2022 orgName. All rights reserved.
//

import SwiftUI


struct LoginView: View {
    
    @State private var username: String = ""
    @State private var password: String = ""
    @State private var isSecured: Bool = true
    
    var body: some View {
        VStack(spacing: 10) {
            
            HStack {
                Image(systemName: "person")
                TextField("Username", text: $username)
            }
            .padding(10)
            .overlay(RoundedRectangle(cornerRadius: 10)
                .strokeBorder(Color("Primary"), style: StrokeStyle(lineWidth: 1.0)))
            
            HStack {
                Image(systemName: "lock")
                if isSecured {
                    SecureField("Password", text: $password)
                } else {
                    TextField("Password", text: $password)
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
        LoginView()
    }
}
