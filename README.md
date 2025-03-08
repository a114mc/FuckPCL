# 爱PCL

一个用来检测PCL的库

# FuckPCL

A library to detect PCL(Plain Craft Launcher)

# 为什么尝试拦截它
他只是个简单的Minecraft启动器，并且需要给作者打钱来获得全部功能！
但是作者把给他打钱的人称为“赞助者”，但是我们认为这并不是简简单单的赞助者，这只是打钱。
我的朋友逆向了PCL2正式版并发现了“silentUpdate”字符串以及长得像更新启动器的函数，这代表着启动器可以在没有获得您的同意的情况下静默更新。


# Why trying to block it
It was just a Minecraft launcher, and it EVEN needs to pay to be able to use all features!  
But they called "sponsor" but we think this NOT simple sponsor it JUST pay.  
This the reason of we're creating this lib
My friend dumped PCL2 non-opensource version and found some string that contains "silentUpdate" and some update-self-like function, 
 it means the launcher can update silently without your agree.


# Use
Java:
~~~java
import com.guimc.fuckpcl.PCLChecker;
public class YourClassName{
    public static void yourVoidName(){
        System.out.print(PCLChecker.fullCheck(Minecraft.getMinecraft().mcDataDir ,true)?"PCL2 Detected":"");
    }
}
~~~

# 使用
Java:
~~~java
import com.guimc.fuckpcl.PCLChecker;
public class YourClassName{
    public static void yourVoidName(){
        System.out.print(PCLChecker.fullCheck(Minecraft.getMinecraft().mcDataDir ,true)?"检测到PCL2":"");
    }
}
~~~