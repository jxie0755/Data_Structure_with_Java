class Javac_GBK {
    // 编译带有中文注释的java文件可能出错 (IDE可能不会,但是console里直接JDK是会的)
    // 解决方案:
    // 执行 javac -encoding utf-8 XXX.java 以取代 javac XXX.java
    // 运行时直接 java XXX, 不需要再转编码
}
