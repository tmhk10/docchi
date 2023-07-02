# アプリケーション名「どっち」


## 概要
２枚の画像をペアで投稿して、どっちがいいかのアンケートを取れます。  
画像をクリックするとクリックした方の画像に票が入り,その場で票数を確認できます。

 
## デモ
<img src="https://github.com/tmhk10/docchi/assets/100889070/af205c59-8db4-47ba-ab41-65253e610990" width="50%">


## URL
- URL : http://ec2-43-207-170-48.ap-northeast-1.compute.amazonaws.com:8080/docchi
- テスト用アカウント
  - ユーザーネーム：a
  - パスワード：aaa



## 制作背景
ログイン・投稿・削除といった機能を持ったサービス、またそれをデータベースと接続させるということを職業訓練校で学んだので、それに近い物を作って、awsを使ってデプロイしてみようと思って作りました。


## 使用技術
* html
* css
* javascript
* jquery
* java
* MySQL 5.7
* Apache Tomcat 9
* AWS
  * EC2
  * RDS


## 機能一覧
<ul>
  <li>投稿画像一覧表示
  <li>ユーザー登録
  <li>ログイン
  <li>画像投稿
  <li>ユーザー別投稿画像一覧表示
  <li>投稿削除
</ul>


## 苦労した部分
画面遷移なく票数が入るようにする、票数が確認できるということを作る前にイメージしており、それを実現させることに苦労しました。


## ER図
<img src="https://github.com/tmhk10/docchi/assets/100889070/5c22cc7d-c82a-458b-b4f6-ac11287a2789" width="50%">

## 文責
- 作成者：上條智彦
- E-mail：tomohiko-kamijo@icloud.com

