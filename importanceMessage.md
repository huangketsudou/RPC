### POJO类
POJO（Plain Ordinary Java Object）简单的Java对象，不继承或者实现任何类或接口，实际就是普通JavaBeans，是为了避免和EJB混淆所创造的简称。
使用POJO名称是为了避免和EJB混淆起来, 而且简称比较直接. 其中有一些属性及其getter setter方法的类,没有业务逻辑，

例如下面这一个实现就是一个简单的POJO类
```java
public class User {
private long id;
private String name;
public void setId(long id) {
this. id = id;
}
public void setName(String name) {
this. name=name;
}
public long getId() {
return id;
}
public String getName() {
return name;
}
}
```

### javaBean
JavaBean 是一种JAVA语言写成的可重用组件。它的方法命名，构造及行为必须符合特定的约定：

1. 这个类必须有一个公共的缺省构造函数。
2. 这个类的属性使用getter和setter来访问，其他方法遵从标准命名规范。
3. 这个类应是可序列化的。 


### lombok插件
查考博客——[十分钟搞懂Lombok使用与原理](https://juejin.im/post/5a6eceb8f265da3e467555fe) 有关注解的一些知识



### 数组的toArray重载方法
```java
int[] = new int[2];
String[] array =new String[list.size()];
list.toArray(array);
```