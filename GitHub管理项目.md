## 使用GitHub管理本地项目流程

#### 一、将GitHub项目克隆到本地

1.进入Github首页，点击New repository新建一个项目

2.复制项目地址

3.把github上面的仓库克隆到本地

`git clone https://github.com:pure-heart/XXX.git`

#### 二、本地已有项目关联GitHub仓库

1.初始化git

`git init`

2.关联到github

`git remote add origin https://github.com:pure-heart/XXX.git`

3.把本地仓库切换到master

`git checkout master`

4.指定本地master到远程master

`git branch --set-upstream-to=origin/master master`

4.同步远程仓库

`git pull`





