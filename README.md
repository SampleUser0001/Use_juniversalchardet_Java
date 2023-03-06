# Use_juniversalchardet_Java
juniversalchardetを使用して文字コードを判定する。

- [Use\_juniversalchardet\_Java](#use_juniversalchardet_java)
  - [build.gradle](#buildgradle)
  - [ソース](#ソース)
  - [文字コードパターン](#文字コードパターン)
  - [実行](#実行)


## build.gradle

``` groovy
dependencies {
    implementation 'com.googlecode.juniversalchardet:juniversalchardet:1.0.3'
}
```

## ソース

``` java
package ittimfn.sample.juniversalchardet;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.mozilla.universalchardet.UniversalDetector;

public class Util {
    
    public static String getCharset(String path) throws FileNotFoundException, IOException {
        UniversalDetector detector = new UniversalDetector(null);

        try(FileInputStream in = new FileInputStream(path)){
            byte[] buf = new byte[4096];
            int read;
            while((read = in.read(buf)) > 0 && !detector.isDone()) {
                detector.handleData(buf, 0, read);
            }
            detector.dataEnd();
        }
        return detector.getDetectedCharset();
    }

    private Util(){}
}
```

## 文字コードパターン

- SHIFT_JIS
- UTF-8

## 実行

``` bash
gradlew test
```