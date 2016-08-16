# SpringMVC_Study
    学习springMVC根据csnd倪升武的博客【SpringMVC学习】

### ssm整合分支
1. 在lib文件夹中添加jar包(具体已经提取出来了)
2. 整合dao层
	- 在config文件夹中添加mybatis全局配置文件、db.properties和log4j.properties
	- 配置spring配置文件，spring的配置文件我将分类写在不同的文件中，在config/spring/目录下了，这里是对dao的整合，起名applicationContext-dao.xml
	- 逆向工程生成po类及mapper [详细讲解](http://blog.csdn.net/eson_15/article/details/51694684)
		此处在mysql数据库中建一个数据库(mybatis),无数据库源码，自己建表。代码在源码中复制。
	- dao层就整合后，针对ItemsMapper接口中的SelectByPrimaryKey()方法做一个测试。成功打印出id为1的Items对象及成功整合了dao层。