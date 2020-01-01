package com.wangbin.sixth_IO

//创建文件流
def file = new File('../../../../groovydemo.iml')
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

def copyFlag = copy("../../../../groovydemo.iml","../../../../test_copy.txt")
println copyFlag


