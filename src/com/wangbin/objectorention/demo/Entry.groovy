package com.wangbin.objectorention.demo

class Entry {
    static void main(def args) {
        println "应用程序启动"
        //初始化
        ApplicationManager.init()
        println "应用程序初始化完成"
        def person = PersonManager.createPerson("wangbin",18)
        println "this person's name is ${person.name}, age is ${person.age}"
    }
}
