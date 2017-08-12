# git的常用命令
## 使用场景
1. 本地仓库与git remote仓库的关联
    * 首先要在github账户上，创建与本地仓库同名的仓库repository;
    * 进入本地仓库的根目录，开始下面一系列的操作
        1. 可以选择创建readme.md文件；　echo "# -" >> README.md
        2. 初始化该仓库；　git init
        3. 将创建的文件README.md文件放置暂存区；　git add README.md
        4. 将暂存区的修改提交; git commit -m "你的提交信息"
        5. 将本地仓库推送到github上；git remote add origin git@github.com:账户名/仓库名.git,git push -u origin master
    * 到此已经基本完成。但是还是需要将你的电脑配置一下
        1. git config --global user.name "your account name"
        2. git config --global user.email "your account email"
        3. 到此已经在当前用户配置了你的信息。下面需要生成你的ssh-key并添加到github上
        4. 生成秘钥；ssh-keygen -t rsa -C "your account email" (连续回车三次)
        5. 最后将公钥添加到git账户里，就OK啦。
    * 有时候工作环境和个人环境都需要一个秘钥，这时候可以在生成秘钥的时候，指定名字并且需要添加config文件进行指定
        1. 生成指定名称的秘钥；ssh-keygen -t rsa -C "your account email" -f ~/.ssh/指定文件名
        2. 添加特别的配置，在ssh目录下新建config文件，内容如下
            ```ruby
            Host github-aysee
            HostName github.com
            User git
            IdentityFile C:/Users/username/.ssh/aysee
            你应该可以看懂的吧－－
            ```
        
     
    