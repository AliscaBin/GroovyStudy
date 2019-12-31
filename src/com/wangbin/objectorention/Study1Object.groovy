package com.wangbin.objectorention

import com.wangbin.variable.Person

/**
 * groovy中默认都是public
 */
class  Person1 implements Action{
    String name
    Integer age

    def increaseAge(Integer years) {
        this.age += years
    }

    @Override
    void eat() {

    }

    @Override
    void drink() {

    }

    @Override
    void play() {

    }

    def invokeMethod(String name, Object args) {
        return "the method is ${name}, the param is ${args}"
    }

    def methodMissing(String name, Object args) {
        return "the methodMissing is ${name}, the param is ${args}"
    }
}

def person = new Person1(name:'wangbin',age: 18)
println "the person's name is ${person.name}, age is ${person.age}"

/**
 * 类中没有某个方法调用时会报怎样的错
 *
 * 类中是否有此方法 -> 否 MetaClass中是否有此方法 -> 否 是否重写了methodMissing()方法 -> 否 是否重写了InvokeMethod()方法 -> 否 Throw MissingMethodException异常
 * 是，调此方法        是，调此方法                 是，调此methodMissing()方法         是，调此InvokeMethod()方法
 */

//person.say()  //Caught: groovy.lang.MissingMethodException: No signature of method

//添加方法invokeMethod()方法
//println person.say()  //the method is say, the param is []

//添加方法methodMissing()方法
//println person.say()  //the methodMissing is say, the param is []

//通过metaClass给类添加属性
Person1.metaClass.sex = 'male'
def person1 = new Person1(name:"Android",age:23)
println person1.sex  //male
person1.sex = 'female'
println person1.sex  //female

//通过metaClass给类添加方法
Person1.metaClass.sexUpperCase = {sex.toUpperCase()}
def person2 = new Person1(name:'Android',age: 18)
println person2.sexUpperCase()  //MALE

//通过metaClass给类添加静态方法
Person1.metaClass.static.createPerson = {
    String name,Integer age -> new Person1(name: name,age: age)
}
def person3 = Person1.createPerson("haha",12)
println "the static person name is ${person3.name}, age is ${person3.age}"  //the static person name is haha, age is 12




















