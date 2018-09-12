#### 使用技术
- Spring
- SpringMVC
- Mybatis


#### 项目结构
**三层架构**

- 持久层--Mybatis
- 表现层--Spring MVC
- 业务层--JavaBean

**基于MVC模式**

- 视图--Jsp
- 模型--JavaBean
- 控制器--Controller




我们强烈建议所有的git仓库都有一个`README`, `LICENSE`, `.gitignore`文件

Git入门？查看 [帮助](https://gitee.com/oschina/git-osc/wikis/%E5%B8%AE%E5%8A%A9) , [Visual Studio](http://my.oschina.net/gal/blog/141442) / [TortoiseGit](http://my.oschina.net/longxuu/blog/141699) / [Eclipse](http://my.oschina.net/songxinqiang/blog/192567) / [Xcode](http://my.oschina.net/zxs/blog/142544) 下如何连接本站, [如何导入项目](http://www.oschina.net/question/82993_133520)

#### 简易的命令行入门教程:

Git 全局设置:
```
git config --global user.name "WE666"
git config --global user.email "123456@qq.com"
```

创建 git 仓库:
```
mkdir moxi
cd moxi
git init
touch README.md
git add README.md
git commit -m "first commit"
git remote add origin https://github.com/WE666/oa.git
git push -u origin master
```

已有项目?
```
cd existing_git_repo
git remote add origin https://github.com/WE666/oa.git
git push -u origin master
```