# Argument
 
通过 Kotlin 委托属性获取 Activity/Fragment  的参数。

支持数据类型： `Int/Long/Float/String/Boolean/Parcelable`

获取时会偿试转换，转换失败时返回指定的默认值

## Gradle

``` groovy
repositories { 
    maven { url "https://gitee.com/ezy/repo/raw/android_public/"}
} 
dependencies {
    implementation "me.reezy.jetpack:argument:0.4.0" 
}
```
 

## 使用

```kotlin  
class MainActivity : AppCompatActivity() {  
  val a by ArgumentString()  
   
  val b by ArgumentInt()   
  
  val c by ArgumentLong()  
  
  val d by ArgumentFloat() 

  val e by ArgumentBoolean()  
}
``` 


## LICENSE

The Component is open-sourced software licensed under the [Apache license](LICENSE).
