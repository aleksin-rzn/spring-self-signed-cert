# Import not trusted certificate to JDK cacerts
Download *.cer in Base64 with your browser.

`keytool -import -trustcacerts -file "path_to_cer\bad.ssl.cer" -alias BAD_SSL_COM -keystore "path_to_jdk\Java\jdk-15\lib\security\cacerts"`

# Generate keystore with self-signed certificate

`keytool -genkeypair -alias my_self_signed -keyalg RSA -keysize 2048 -storetype PKCS12 -keystore "path_to_keystore\my_self_signed.p12" -validity 3650 -ext san=dns:localhost`

If you don't specify dns, you will get an error.

# Add external certificate to keystore

`keytool -import -trustcacerts -file "path_to_cer\bad.ssl.cer" -alias bad_ssl_com -keystore "path_to_keystore\my_self_signed.p12"`

# Check certificates in keystore

`keytool -list -v -keystore "path_to_keystore\my_self_signed.p12"`