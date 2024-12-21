# springboot-sampleapp

at RHEL8

## java install
```
yum -y update
yum install java-21-openjdk java-21-openjdk-devel unzip
```

## Instana Agentインストール
Instana Agent > `エージェントのインストール` > エージェントのデプロイメント > `Linux 自動インストール（ワンライナー）` から curlコマンドを取得、実行

## サンプルアプリの雛形取得
Spring initializr (https://start.spring.io) にてテンプレートWebアプリケーションをダウンロード

ダウンロードして `unzip` で展開
```
unzip cpuusage.zip
cd cpuusage
```

### アプリ準備
#### アプリを編集
リクエストを受けると、1秒〜3秒のランダムタイムでCPU負荷が10％となるように処理を実行します。
`cpuusage/src` 配下のソースコードを確認してください。

#### Instana用設定の追加
Instana で Spring Boot を監視するためには、以下のドキュメントにある アクチュエーター の依存関係を追加します。

https://www.ibm.com/docs/ja/instana-observability/current?topic=technologies-monitoring-spring-boot#configuring-spring-boot-actuator

```
<dependencies>
                <dependency>
                        <groupId>org.springframework.boot</groupId>
                        <artifactId>spring-boot-starter-web</artifactId>
                </dependency>

                <dependency>
                        <groupId>org.springframework.boot</groupId>
                        <artifactId>spring-boot-starter-test</artifactId>
                        <scope>test</scope>
                </dependency>
<!-- ↓ここを追加 -->
                <dependency>
                        <groupId>org.springframework.boot</groupId>
                        <artifactId>spring-boot-starter-actuator</artifactId>
                </dependency>
<!-- ↑ここまで -->
        </dependencies>
```

#### アプリ実行
maven で springを実行します。
```
./mvnw spring-boot:run
```

引数の指定方法は　https://www.baeldung.com/spring-boot-command-line-arguments　参照
