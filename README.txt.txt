-�� ��������� �� ����� � �����������, ���� keytool �����������:
keytool -genkey -keyalg RSA -keysize 2048 -validity 360 -alias hwkey -keystore myKeyStore.jks
keytool -export -alias hwkey -keystore myKeyStore.jks -file hwkey.cert 
keytool -import -file hwkey.cert -alias hwkey -keystore myTrustStore.jts

-������: "mypasswd"

������� �� ����:
-������� � � ������� SSLServerSocketFactory �� SSLServerSocket ���� System.setProperty("javax.net.ssl.keyStore", "myKeyStore.jks"); �
System.setProperty("javax.net.ssl.keyStorePassword", "mypasswd");
-���������� � �� �������

���� ������������ ����������, �������� � �������� � ����, �������� �� ������������ ��������, ���� ���� ��������, ���������� �����.