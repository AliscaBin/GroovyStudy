package com.wangbin.fourth_json

import groovy.json.JsonOutput
import groovy.json.JsonSlurper

def list = [new Person(name:"John",age:25),new Person(name: 'Major',age: 18)]
def jsonStr = JsonOutput.toJson(list)
println jsonStr
println JsonOutput.prettyPrint(jsonStr)

def jsonSlurper = new JsonSlurper()
def jsonObject = jsonSlurper.parseText(jsonStr)
println jsonObject.toString()  //[[age:25, name:John], [age:18, name:Major]]

//请求网络数据json转为Object
def getNetworkData(String url) {
    //发送http请求
    def connection = new URL(url).openConnection()
    connection.setRequestMethod('GET')
    connection.connect()
    def response = connection.content.text

    //将json 转换为实体对象
    def jsonsplurper = new JsonSlurper()
    return jsonsplurper.parseText(response)
}

def response = getNetworkData("http://xuexibo.top/yxbApp/home_data.json")
println response
