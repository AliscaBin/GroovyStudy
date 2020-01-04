package com.wangbin.sixth_IO


//创建文件流
def file = new File('../../../../.gitignore')
//输出文件内容
//file.eachLine {line ->
//    println line
//}

//获取文件内容
def text = file.getText()  //返回字符串  String
//println text

def result = file.readLines()  //返回列表 String[]

//读取想要的数据
//获取文件前100个字符的内容
def reader = file.withReader {reader ->
    char[] buffer = new char[100]
    reader.read(buffer)
    return buffer
}
//println reader

//获取文件输出流
def writer = file.withWriter {}


//读写结合，复制文件
def copy(String sourcePath, String destationPath) {
    try {
        //创建目标文件
        def desFile = new File(destationPath)
        if (!desFile.exists()) {
            desFile.createNewFile()
        }
        //读取源文件内容
        new File(sourcePath).withReader {reader ->
            def lines = reader.readLines()
            desFile.withWriter {writer ->
                lines.each { line ->
                    writer.append(line)
                }
            }
        }
        return true
    }catch(Exception ex){
        ex.printStackTrace()
    }
}

//def copyFlag = copy("../../../../groovydemo.iml","../../../../test_copy.txt")
//println copyFlag

def saveObject(Object obj, String path) {
    try {
        //创建目标文件对象
        def desFile = new File(path)
        if (!desFile.exists()) {
            desFile.createNewFile()
        }
        desFile.withObjectOutputStream {out ->
            out.writeObject(obj)
        }
        return true
    } catch (Exception ex) {
        ex.printStackTrace()
    }
}

def readObject(String path) {
    def obj = null
    try {
        def file = new File(path)
        if (file == null || !file.exists()) {
            println '文件不存在或为空'
            return null
        }
        file.withObjectInputStream {input ->
            obj = input.readObject()
        }
    } catch (Exception ex) {
        ex.printStackTrace()
    }
    return obj
}

class Person implements Serializable{
    String name
    int age
}

def person = new Person(name: 'wangbin',age: 18)
//保存对象到文件
//saveObject(person,'./person.bin')
//读取对象到内存
def person1 = (Person)readObject('./person.bin')
//println person1

//def file = new File(baseDir, 'test.txt')
//Person p = new Person(name:'Bob', age:76)
//// 序列化对象到文件
//file.withObjectOutputStream { out ->
//    out.writeObject(p)
//}
//// ...
//// 从文件读取数据进行反序列化
//file.withObjectInputStream { input ->
//    def p2 = input.readObject()
//    assert p2.name == p.name
//    assert p2.age == p.age
//}