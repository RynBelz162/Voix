package com.belzsoftware.voix

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}