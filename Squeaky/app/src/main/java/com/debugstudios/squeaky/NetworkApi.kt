package com.debugstudios.squeaky

class NetworkApi {
    fun validateuser(username:String?, password:String?):Boolean{
        if(username == null || password == null){
            return false
        }
        return true
    }
}