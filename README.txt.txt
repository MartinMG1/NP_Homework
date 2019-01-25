-За създаване на ключа и сертификата, чрез keytool командатите:
keytool -genkey -keyalg RSA -keysize 2048 -validity 360 -alias hwkey -keystore myKeyStore.jks
keytool -export -alias hwkey -keystore myKeyStore.jks -file hwkey.cert 
keytool -import -file hwkey.cert -alias hwkey -keystore myTrustStore.jts

-Парола: "mypasswd"

Промени по кода:
-добавен е в сървъра SSLServerSocketFactory за SSLServerSocket чрез System.setProperty("javax.net.ssl.keyStore", "myKeyStore.jks"); и
System.setProperty("javax.net.ssl.keyStorePassword", "mypasswd");
-аналогично и за клиента

Няма допълнителни библиотеки, паролата е добавена в кода, стартира се първоначално сървърът, след това клиентът, въвеждайки адрес.