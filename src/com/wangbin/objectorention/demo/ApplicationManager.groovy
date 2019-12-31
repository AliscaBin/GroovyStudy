package com.wangbin.objectorention.demo


/**
 * 应用管理类
 */
class ApplicationManager {

    static void init() {
        println "应用初始化开始执行"
        ExpandoMetaClass.enableGlobally()
        //为第三方类添加方法
        Person.metaClass.static.createPerson = {String name,int age -> new Person(name:name,age:age)}
    }
}
