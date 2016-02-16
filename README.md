# CFMX_Compat

[![Travis branch](https://img.shields.io/travis/tommywo/cfmx_compat/master.svg)](https://travis-ci.org/tommywo/cfmx_compat)
[![Codecov branch](https://img.shields.io/codecov/c/github/tommywo/cfmx_compat/master.svg)](https://codecov.io/github/tommywo/CFMXCompat) [![Maven Central](https://img.shields.io/maven-central/v/pl.wojtun/cfmxcompat.svg)](http://search.maven.org/#artifactdetails|pl.wojtun|cfmxcompat|0.0.1|jar) [![VersionEye](https://img.shields.io/versioneye/d/user/projects/56c2ee2318b271003b391842.svg)](https://www.versioneye.com/user/projects/56c2ee2318b271003b391842) [![LGPLv3](https://img.shields.io/badge/license-LGPLv3-blue.svg)](http://www.gnu.org/licenses/lgpl-3.0.txt)


Java library for encoding and decoding using cfmx_compat algorithm.

Algorithm is taken from [railo](https://github.com/getrailo/railo) source.

```xml
<dependency>
    <groupId>pl.wojtun</groupId>
    <artifactId>cfmxcompat</artifactId>
    <version>0.0.1</version>
</dependency>
```


Usage:
```java
String key = "secretkey"
String plain = "plain text value"

encrypted = CFMXCompat.encrypt(plain, key)
decrypted = CFMXCompat.decrypt(encrypted, key)

encrypted = CFMXCompat.encrypt(plain, key, "uu")
decrypted = CFMXCompat.decrypt(encrypted, key, "uu")

encrypted = CFMXCompat.encrypt(plain, key, "hex")
decrypted = CFMXCompat.decrypt(encrypted, key, "hex")

encrypted = CFMXCompat.encrypt(plain, key, "base64")
decrypted = CFMXCompat.decrypt(encrypted, key, "base64")
```
